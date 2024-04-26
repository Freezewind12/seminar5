package lv.venta.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lv.venta.model.Product;



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
	@GetMapping("/product")
	public String getProductTest(Model model) {
		System.out.println("Product controller is working");
		Product p = new Product("Apple", "Red", 0.99f, 4);
		model.addAttribute("mypackage", p);
		return "product-page";
	}
	@GetMapping("/product/list")
	public String getProductList(Model model) {
		System.out.println("Product list is working");
		Product p1 = new Product("Banana","Yellow",1.99f,3);
		Product p2 = new Product("Orange","Orange",0.69f,2);
		Product p3 = new Product("Onion","Brown-ish",1.99f,7);
		List<Product> pl = new ArrayList<Product>();
		pl.addAll(Arrays.asList(p1,p2,p3));
		model.addAttribute("mypackage", pl);
		return "product-list";
	}
}
