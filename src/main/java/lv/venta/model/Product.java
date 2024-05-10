package lv.venta.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
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
@Table(name = "ProductTable")
@Entity

public class Product {
	@Setter(value = AccessLevel.NONE)
	@Column(name = "ID")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@NotNull
	@Pattern(regexp = "[A-Za-z ]+", message = "Only letters allowed!")
	@Size(min = 3, max = 20)
	@Column(name = "TITLE")
	private String title;
	@NotNull
	@Pattern(regexp = "[A-Za-z0-9 ,.;-]+", message = "Only letters, numbers and ,.;+ allowed!")
	@Size(min = 1, max = 64)
	@Column(name = "DESCRIPTION")
	private String description;
	@Min(0)
	@Max(1000)
	@Column(name = "PRICE")
	private float price;
	@Min(0)
	@Max(1000)
	@Column(name = "QUANTITY")
	private int quantity;
	
	public Product(String title, String decription, float price, int quantity) {
		setTitle(title);
		setDescription(decription);
		setPrice(price);
		setQuantity(quantity);
	}
}
