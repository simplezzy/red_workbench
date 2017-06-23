package com.redcode.workbench.sbcassandra.springbootcassandra.service;

import com.redcode.workbench.sbcassandra.springbootcassandra.domain.Imessage;

public interface ImsgService {

    //springdata
    Imessage findById(String id);

    Iterable<Imessage> findAllMsg();

    void save(Imessage imessage);

    //List<Imessage> findByLastNameLike(String lastName);

    //List<Imessage> cassandratemplateSelect();
    //CassandraOprations


}
