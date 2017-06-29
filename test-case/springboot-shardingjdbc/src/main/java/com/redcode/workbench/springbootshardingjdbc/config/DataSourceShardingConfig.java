package com.redcode.workbench.springbootshardingjdbc.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.dangdang.ddframe.rdb.sharding.api.MasterSlaveDataSourceFactory;
import com.dangdang.ddframe.rdb.sharding.api.rule.DataSourceRule;
import com.dangdang.ddframe.rdb.sharding.api.rule.ShardingRule;
import com.dangdang.ddframe.rdb.sharding.api.rule.TableRule;
import com.dangdang.ddframe.rdb.sharding.api.strategy.database.DatabaseShardingStrategy;
import com.dangdang.ddframe.rdb.sharding.api.strategy.table.TableShardingStrategy;
import com.dangdang.ddframe.rdb.sharding.id.generator.IdGenerator;
import com.dangdang.ddframe.rdb.sharding.id.generator.self.CommonSelfIdGenerator;
import com.dangdang.ddframe.rdb.sharding.jdbc.ShardingDataSource;
import com.redcode.workbench.springbootshardingjdbc.common.shadingStategy.MessageSingleKeyDBShardingAlgorithm;
import com.redcode.workbench.springbootshardingjdbc.common.shadingStategy.MessageSingleKeyTableShardingAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhiyu.zhou on 2017/6/26.
 */
@Slf4j
@Configuration
@PropertySource(value = "classpath:/application.properties", ignoreResourceNotFound = true)
@MapperScan(basePackages = DataSourceShardingConfig.DATA_PACKAGE, sqlSessionFactoryRef = DataSourceShardingConfig.SQL_SESSION_FACTORY_DATA)
public class DataSourceShardingConfig {

    static final String DATA_PACKAGE = "com.redcode.workbench.springbootshardingjdbc.dao";

    static final String SQL_SESSION_FACTORY_DATA = "shardingSqlSessionFactory";

    private static final String DATA_SOURCE_DATA = "shardingDataSource";

    public static final String SHARDING_DATASOURCE_TRANSACTIONAL_MANAGER_NAME = "shardingTransactionManager";

    @Value("${spring.datasource.username}")
    private String username;
    @Value("${spring.datasource.password}")
    private String password;

    private DataSource createDataSource(final String dataSourceName) {

        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl(String.format("jdbc:mysql://localhost:3306/%s", dataSourceName));
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setInitialSize(5);
        dataSource.setMinIdle(5);
        dataSource.setMaxActive(15);
        dataSource.setRemoveAbandoned(true);
        dataSource.setRemoveAbandonedTimeout(280);
        dataSource.setValidationQuery("SELECT 1 FROM DUAL");
        dataSource.setTestOnBorrow(true);

        return dataSource;
    }

    @Bean(name = SQL_SESSION_FACTORY_DATA)
    public SqlSessionFactory sqlSessionFactoryBeanData(@Qualifier(DATA_SOURCE_DATA) DataSource dataSource) {
        try {
            SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
            sessionFactory.setDataSource(dataSource);
            Resource[] mapperResources = new PathMatchingResourcePatternResolver().getResources("classpath*:mapper/*Mapper.xml");
            sessionFactory.setMapperLocations(mapperResources);
            return sessionFactory.getObject();
        } catch (Exception e) {
            log.error("faile to create data sql session", e);
            throw new RuntimeException(e);
        }
    }

    /**
     *  配置好dataSourceRulue,即对数据源进行管理
     * @return
     */
    @Bean
    public DataSourceRule dataSourceRule(){

        //构建读写分离数据源
        DataSource masterDS = createDataSource("db_inmsg");
        DataSource slaveDS = createDataSource("db_inmsg_slave");
        DataSource masterSlaveDS = MasterSlaveDataSourceFactory.createDataSource("ms",masterDS, slaveDS);

        //设置分库映射
        Map<String, DataSource> dataSourceMap = new HashMap<>(1);
        //添加两个数据库ds_0,ds_1到map里
//        dataSourceMap.put("sharding_0", createDataSource("sharding_0"));
//        dataSourceMap.put("sharding_1", createDataSource("sharding_1"));
       // dataSourceMap.put("db_inmsg", createDataSource("db_inmsg"));
        dataSourceMap.put("ms", masterSlaveDS);
        return new DataSourceRule(dataSourceMap);
    }

    /**
     * 分库策略
     * @return
     */
    @Bean
    public DatabaseShardingStrategy messageDatabaseShardingStrategy() {

        return new DatabaseShardingStrategy("message_id", new MessageSingleKeyDBShardingAlgorithm());
    }

    /**
     * 分表策略
     * @return
     */
    @Bean
    public TableShardingStrategy messageTableShardingStrategy() {

        return new TableShardingStrategy("message_id", new MessageSingleKeyTableShardingAlgorithm());
    }

    @Bean
    public TableRule messageTableRule(@Qualifier("dataSourceRule") DataSourceRule dataSourceRule, DatabaseShardingStrategy messageDatabaseShardingStrategy, TableShardingStrategy messageTableShardingStrategy) {

        List<String> actualTables = Arrays.asList("t_message_0", "t_message_1","t_message_2","t_message_3", "t_message_4",
                "t_message_5", "t_message_6", "t_message_7","t_message_8","t_message_9");
        return TableRule.builder("t_message")
                .actualTables(actualTables)
                .dataSourceRule(dataSourceRule)
                .databaseShardingStrategy(messageDatabaseShardingStrategy)
                .tableShardingStrategy(messageTableShardingStrategy)
                .build();
    }
    /**
     * 构成分库分表的规则 传入数据源集合和每个表的分库分表的具体规则
     * @param dataSourceRule
    //* @param userTableRule
     * @param messageTableRule
     * @return
     */
    @Bean
    public ShardingRule shardingRule(DataSourceRule dataSourceRule, TableRule messageTableRule) {
        return ShardingRule.builder()
                .dataSourceRule(dataSourceRule)
                .tableRules(Arrays.asList(messageTableRule))
                .build();
    }

    /**
     * 对datasource进行封装
     * @param shardingRule
     * @return
     */
    @Bean(name = DATA_SOURCE_DATA)
    public DataSource shardingDataSource(ShardingRule shardingRule) {

        return new ShardingDataSource(shardingRule);
    }

    /**
     * 事务
     * @param shardingDataSource
     * @return
     */
    @Bean(name = SHARDING_DATASOURCE_TRANSACTIONAL_MANAGER_NAME)
    public DataSourceTransactionManager shardingTransactionManager(@Qualifier(DATA_SOURCE_DATA) DataSource shardingDataSource) {

        return new DataSourceTransactionManager(shardingDataSource);
    }

    @Bean
    public IdGenerator getIdGenerator() {
        return new CommonSelfIdGenerator();
    }
}
