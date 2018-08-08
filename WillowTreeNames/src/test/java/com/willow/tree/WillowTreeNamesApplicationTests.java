package com.willow.tree;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.google.gson.Gson;
import com.willow.tree.controller.NameGameDemoController;
import com.willow.tree.model.CoWorker;
import com.willow.tree.model.Stats;

@RunWith(SpringRunner.class)
@SpringBootTest
//@ContextConfiguration(classes=WillowTreeNamesApplication.class)
//@WebMvcTest(controllers = NameGameDemoController.class)




public class WillowTreeNamesApplicationTests {
	private Map<String,CoWorker> map = null;
	private Stats stat = new Stats();
	@Before
	 public void setData(){
		File initialFile = new File("data/willowTree.txt");
		InputStreamReader inReader = null;
		try {
			inReader = new InputStreamReader(new FileInputStream(initialFile));
		} catch (IOException e) {
			e.printStackTrace();
		}
			Gson gson = new Gson();

		CoWorker[] array =  gson.fromJson(inReader, CoWorker[].class);
        System.out.println("Size " + array.length);
        map = Arrays.asList(array).stream().collect(Collectors.toMap(CoWorker::getId ,string -> string));
	}
	
	
	@Test
	public void contextLoads() {
	}

}
