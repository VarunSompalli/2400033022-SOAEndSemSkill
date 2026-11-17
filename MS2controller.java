package com.klu.springmvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.klu.springmvc.model.Task;
import com.klu.springmvc.service.Taskservice;

@RestController
@RequestMapping("/ms2")
public class MS2controller {
	@Autowired
	Taskservice ts;
	
	@GetMapping("/mul")
   public String multiply(@RequestParam("a") int a , @RequestParam("b") int b) {
	   int result = a * b;
	   return "MS2.1 multiply : " +result;
   }
	
	
	 @PostMapping("/createtask")
	  public Object createTask(@RequestBody Task task,
	      @RequestHeader("Token") String token) {
	    
	    return ts.createTask(task,token);
}
}
