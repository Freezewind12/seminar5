package lv.venta;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import lv.venta.model.Product;
import lv.venta.repo.IProductRepo;

@SpringBootApplication
public class Seminar5Application {

	public static void main(String[] args) {
		SpringApplication.run(Seminar5Application.class, args);
	}
	@Bean
	public CommandLineRunner testDatabase(IProductRepo productRepo) {
		return new CommandLineRunner() {
			
			@Override
			public void run(String... args) throws Exception {
				Product p1 = new Product("Banana","Yellow",1.99f,3);
				Product p2 = new Product("Orange","Orange",0.69f,2);
				Product p3 = new Product("Onion","Brown-ish",1.99f,7);
				productRepo.save(p1);
				productRepo.save(p2);
				productRepo.save(p3);
				System.out.println("How many: " + productRepo.count());
				System.out.println("All products: " + productRepo.findAll());
				System.out.println("Find by id(2): " + productRepo.findById(2).get());
				
			}
		};
	}
}
