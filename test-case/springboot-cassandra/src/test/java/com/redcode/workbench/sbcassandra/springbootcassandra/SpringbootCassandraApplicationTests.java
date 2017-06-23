package com.redcode.workbench.sbcassandra.springbootcassandra;

import com.redcode.workbench.sbcassandra.springbootcassandra.domain.Imessage;
import com.redcode.workbench.sbcassandra.springbootcassandra.repository.ImsgRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Iterator;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootCassandraApplicationTests {

	@Test
	public void contextLoads() {
	}


	@Autowired
	private ImsgRepository imsgRepository;

	@Test
	public void findById() throws Exception {
		imsgRepository.findOne("");
	}

	@Test
	public void findAll() throws Exception {
		Iterable<Imessage> iterable = imsgRepository.findAll();
		Iterator<Imessage> it = iterable.iterator();
		while(it.hasNext()) {
			Imessage imessage = it.next();
			System.out.println(imessage.toString());
		}
	}

	@Test
	public void save() throws Exception {
		for(int i = 5; i < 10; i++) {
			Imessage imessage = new Imessage();
			imessage.setAge(20+i);
			imessage.setId("id" + i);
			imessage.setLastName("redcode"+i);
			imsgRepository.save(imessage);
		}

	}


}
