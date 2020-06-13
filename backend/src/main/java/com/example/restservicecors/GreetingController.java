package com.example.restservicecors;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

	private static final String template = "%s";
	private final AtomicLong counter = new AtomicLong();

	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/accountbalance")
	public Greeting greeting(@RequestParam("id") long id) {
		System.out.println("==== Bank Account ID ====" + id);
		if (id == 123456789)
		{
				return new Greeting(String.format(template, 100));
		}
		else if (id == 789456123)
		{
			
				return new Greeting(String.format(template, 200));
		}	
		else if (id == 111111111)
		{
			return new Greeting(String.format(template, 8000));
		}
		else if (id == 222222222)
		{
			return new Greeting(String.format(template, 10000 ));
		}
	return new Greeting(String.format(template, 0));
	}
	


	@GetMapping("/greeting-javaconfig")
	public Greeting greetingWithJavaconfig(@RequestParam(required=false, defaultValue="World") String name) {
		System.out.println("==== in greeting ====");
		return new Greeting(String.format(template, name));
	}

}
