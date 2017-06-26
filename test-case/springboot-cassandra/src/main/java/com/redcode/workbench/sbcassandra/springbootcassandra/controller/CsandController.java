package com.redcode.workbench.sbcassandra.springbootcassandra.controller;

import com.redcode.workbench.sbcassandra.springbootcassandra.domain.Imessage;
import com.redcode.workbench.sbcassandra.springbootcassandra.service.ImsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.lang.Iterable;


@RestController
@RequestMapping("csd")
public class CsandController {

    @Autowired
    private ImsgService imsgService;

    @GetMapping("/index")
    public String indexTest() {
        return "cassandra index success!";
    }

    @GetMapping("/save")
    public String casSave() {
        Date date = new Date();
        Imessage imessage = new Imessage(date.toString(),"eric4",19);
        imsgService.save(imessage);
        return  "save success!";
    }

    @GetMapping("/select/{id}")
    public Imessage casSelect(@PathVariable("id") String id) {
        Imessage imessage = imsgService.findById(id);
        System.out.println("imessage:"+imessage.getId() +imessage.getLastName()+imessage.getAge());
        return imessage;
    }

    @GetMapping("/find")
    public Iterable<Imessage> casFindAll() {
        return imsgService.findAllMsg();
    }

}
