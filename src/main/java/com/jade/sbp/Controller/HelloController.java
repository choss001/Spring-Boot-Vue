package com.jade.sbp.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jade.sbp.domain.User;
import com.jade.sbp.mapper.UserMapper;

@RestController
public class HelloController {
	@Autowired
	private UserMapper mapper;
	
	@RequestMapping("/hello")
	public String hello() {
		return "Hello 스프링 부트!!";
		
	}
	@RequestMapping(value = "/helloUser/{id}", method = RequestMethod.GET)
	public ResponseEntity<User> helloJson(@PathVariable String id) {
		try {
			User user = mapper.getLoginInfo(id);
			List<User> list = new ArrayList<>();
			list.add(user);
			return new ResponseEntity<User>(user, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
		}
	}
	@RequestMapping(value = "/helloUser", method = RequestMethod.GET)
	public ResponseEntity<List<User>> helloJson() {
		try {
			List<User> user = mapper.getAllBoard();
			
			
			return new ResponseEntity<List<User>>(user, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<List<User>>(HttpStatus.BAD_REQUEST);
		}
	}
	@RequestMapping(value = "/create", method = RequestMethod.POST,
			consumes = "application/json", 
			produces = "application/json")
	public String createJson(@RequestBody User user){
		System.out.println("User가 어떻게 들어올까? : "+user);
		mapper.createJson(user);
		return "OK";
	}
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public String delete(@PathVariable("id") String id) {
		System.out.println("id : "+id);
		mapper.delete(id);
		return "OK";
	}
}
