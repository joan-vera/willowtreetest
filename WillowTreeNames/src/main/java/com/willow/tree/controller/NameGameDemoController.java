package com.willow.tree.controller;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.willow.tree.model.CoWorker;
import com.willow.tree.model.Headshot;
import com.willow.tree.model.Stats;

@RestController
public class NameGameDemoController {
	private  Map<String,CoWorker> map = null;
	private  Stats stat = new Stats();
	
	
 		public void load(){
 			InputStreamReader inReader = null;
			try {
				inReader = new InputStreamReader(new URL("https://www.willowtreeapps.com/api/v1.0/profiles").openStream());
			} catch (IOException e) {
				e.printStackTrace();
			}
 			Gson gson = new Gson();

 			CoWorker[] array =  gson.fromJson(inReader, CoWorker[].class);
	        System.out.println("Size " + array.length);
	        map = Arrays.asList(array).stream().collect(Collectors.toMap(CoWorker::getId ,string -> string));
        }
 
	    @RequestMapping("/list")
	    public Map<String, CoWorker> list() {
	    	if(map == null) {
	    		this.load();
	    	}
	        return map;
	    }

	    @RequestMapping("/stats")
	    public Stats stats() {
	    	
	        return stat;
	    }
	    
	    @RequestMapping("/start")
	    public Map <String, Headshot> start() {
	    	if(map == null) {
	    		this.load();
	    	}
	    	Random random = new Random();
	    	Map <String, Headshot>results = new HashMap <String, Headshot>();
	    	String[] keys = map.keySet().toArray(new String[0]);
	    	for(int i = 0 ; i< 6; i++) {
	    		int index = random.nextInt(keys.length);
	    		CoWorker c = map.get(keys[index]);
	    		results.put(keys[index],c.getHeadshot());
	    	}
	
	    	int r = random.nextInt(5);
	    	keys = results.keySet().toArray(new String[0]);
	    	Headshot h = results.get(keys[r]);
	    	h.setSelected(true);

	        return results;
	    }
	    
	    @RequestMapping("/guess")
	    public boolean guess(@RequestParam(value="name") String name, @RequestParam(value="guessId") String guessId) {
	    	boolean correct = false;
	    	
	    	if(map.containsKey(guessId)) {
	    		CoWorker c = map.get(guessId);
	    		if(name.contains(" ")) name = name.split(" ")[0];
	    		if(c.getFirstName().toLowerCase().contains(name.toLowerCase())) {
	    			correct = true;
	    		}
	    	}
	    	
	    	if(correct) {
	    		stat.addCorrect();
	    	} else {
	    		stat.addWrong();
	    	}
	    	
	    	
	        return correct;
	    }
	    
	    
	    @RequestMapping("/searchByFirstName")
	    public List <CoWorker> searchByFirstName(@RequestParam(value="name") String name) {
	    	if(map == null) {
	    		this.load();
	    	}
	    	
	    	List <CoWorker> results = new ArrayList <CoWorker>();
	    	
	    	for(String id : map.keySet()) {
	    		CoWorker c = map.get(id);
	    		if (c.getFirstName().toLowerCase().contains(name.toLowerCase())) {
	    			results.add(c);
	    		}
	    	}
	    	
	        return results;
	    }
	    


	    
}
