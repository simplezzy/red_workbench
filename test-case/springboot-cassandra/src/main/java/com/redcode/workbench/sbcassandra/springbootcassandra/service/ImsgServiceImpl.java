package com.redcode.workbench.sbcassandra.springbootcassandra.service;

import com.datastax.driver.core.querybuilder.QueryBuilder;
import com.datastax.driver.core.querybuilder.Select;
import com.redcode.workbench.sbcassandra.springbootcassandra.domain.Imessage;
import com.redcode.workbench.sbcassandra.springbootcassandra.repository.ImsgRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraTemplate;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImsgServiceImpl implements ImsgService{

    @Autowired
    private ImsgRepository imsgRepository;

    @Autowired
    private CassandraTemplate cassandraTemplate;


    @Override
    public Imessage findById(String id) {
        return imsgRepository.findOne(id);
    }

    @Override
    public Iterable<Imessage> findAllMsg() {
        return imsgRepository.findAll();
    }

    @Override
    public void save(Imessage imessage) {
        imsgRepository.save(imessage);
    }

//    @Override
//    public List<Imessage> cassandratemplateSelect() {
//        Select select = QueryBuilder.select().from("imessage");
//        try {
//            return cassandraTemplate.select(select,Imessage.class);
//        } finally {
//            cassandraTemplate.getSession().close();
//        }
//
//    }
}
