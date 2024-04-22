package lv.venta.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
//@RequiredArgsConstructor
@ToString

public class Product {
	@Setter(value = AccessLevel.NONE)
	private int id;
	private String title;
	private String description;
	private float price;
	private int quantity;
	
	private static int counter = 1;
	public void setID() {
		this.id = counter++;
	}
	public Product(String title, String decription, float price, int quantity) {
		setID();
		setTitle(title);
		setDescription(decription);
		setPrice(price);
		setQuantity(quantity);
	}
}
