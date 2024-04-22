package lv.venta.controller;

import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class FirstController {
	@GetMapping("/hello")
	public String getHello() {
		System.out.println("The first controller is working");
		return "hello-page";
	}
	Random rand = new Random();
	@GetMapping("/hello/msg")
	public String getHelloMsg(Model model) {
		System.out.println("Second controller is working");
		model.addAttribute("mypackage", "Hello from JAVA: " + rand.nextInt(0, 100));
		return "hello-msg-page";
	}
	
}
