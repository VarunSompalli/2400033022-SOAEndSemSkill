package com.klu.springmvc;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackController {
	
	@GetMapping("/fallback/ms1")
	public String ms1fallback() {
		return "MS1 service is down....Try Later....";
	}
	
	@GetMapping("/fallback/ms2")
	public String ms2fallback() {
		return "MS2 service is down....Try Later....";
	}

}
