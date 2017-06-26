package com.redcode.workbench.sbcassandra.springbootcassandra.repository;

import com.redcode.workbench.sbcassandra.springbootcassandra.domain.Imessage;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImsgRepository extends CrudRepository<Imessage,String>{

//    @Query("select * from imessage where lastName like %?1%")
//    List<Imessage> findByLastNameLike(String lastName);
}
