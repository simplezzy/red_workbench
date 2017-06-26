package com.redcode.workbench.sbcassandra.springbootcassandra.service;

import com.datastax.driver.core.querybuilder.QueryBuilder;
import com.datastax.driver.core.querybuilder.Select;
import com.redcode.workbench.sbcassandra.springbootcassandra.domain.Imessage;
import com.redcode.workbench.sbcassandra.springbootcassandra.repository.ImsgRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.cassandra.core.CassandraTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class ImsgServiceImplTest {


    @Autowired
    private ImsgRepository imsgRepository;

    @Autowired
    private CassandraTemplate cassandraTemplate;

    @Test
    public void findById() throws Exception {
        imsgRepository.findOne("");
    }

    @Test
    public void findAll() throws Exception {
        long satrt = System.currentTimeMillis();
        Iterable<Imessage> iterable = imsgRepository.findAll();
        System.out.println("runtime:"+ (System.currentTimeMillis()-satrt));
        /*Iterator<Imessage> it = iterable.iterator();
        while(it.hasNext()) {
            Imessage imessage = it.next();
            System.out.println(imessage);
        }*/
    }

//    @Test
//    public void findByLastNameLike() throws Exception{
//        long satrt = System.currentTimeMillis();
//        List<Imessage>imessages = imsgRepository.findByLastNameLike("eric");
//        System.out.println("imessages:" + imessages.size());
//        System.out.println("runtime:"+ (System.currentTimeMillis()-satrt));
//    }

//    @Test
//    public List<Imessage> cassandratemplateSelect() {
//        Select select = QueryBuilder.select().from("imessage");
//        long satrt = System.currentTimeMillis();
//        try {
//            List<Imessage> imessages= cassandraTemplate.select(select,Imessage.class);
//            System.out.println("runtime:"+ (System.currentTimeMillis()-satrt));
//            return imessages;
//        } finally {
//            cassandraTemplate.getSession().close();
//        }
//    }

    @Test
    public void save() throws Exception {
        long satrt = System.currentTimeMillis();
        for(int i = 100; i < 200; i++) {
            Imessage imessage = new Imessage();
            imessage.setAge(20+i);
            imessage.setId("id" + i);
            imessage.setLastName("redcode"+i);
            imsgRepository.save(imessage);
        }
        System.out.println("runtime:"+ (System.currentTimeMillis()-satrt));
    }

}