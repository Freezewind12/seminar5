package lv.venta.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.venta.model.Product;
import lv.venta.repo.IProductRepo;
import lv.venta.service.IProductCRUDService;
import lv.venta.service.iProductFiltering;

@Service
public class productServiceImplementation implements IProductCRUDService, iProductFiltering{

	@Autowired
	private IProductRepo productRepo;
	
	@Override
	public void create(String title, String description, float price, int quantity) throws Exception {
		if(title == null || description == null || price < 0 || quantity < 0)
			throw new Exception("Problems with input param");
		Product ProductFromDB = productRepo.findByTitleAndDescriptionAndPrice(title, description, price);
			if(ProductFromDB != null) {
				ProductFromDB.setQuantity(ProductFromDB.getQuantity() + quantity);
				productRepo.save(ProductFromDB);
			}
			else {
			Product newP = new Product(title, description, price, quantity);
			productRepo.save(newP);
			}
			
	}

	@Override
	public ArrayList<Product> retrieveAll() throws Exception {
		if(productRepo.count() == 0)throw new Exception("Product table is empty");
		ArrayList<Product> result = (ArrayList<Product>) productRepo.findAll();
		return result;
	}

	@Override
	public Product retrieveById(int id) throws Exception {
		if(id <= 0) throw new Exception("Id should be positive");
		if(productRepo.existsById(id)) 
			return productRepo.findById(id).get();
		throw new Exception("Product with id (" + id + ") is not in the table");
	}

	@Override
	public void updateById(int id, String title, String description, float price, int quantity) throws Exception {
		if(title == null || description == null || price < 0 || quantity <0) throw new Exception("Problem with input");
		Product productForUpdating = retrieveById(id);
		productForUpdating.setTitle(title);
		productForUpdating.setDescription(description);
		productForUpdating.setPrice(price);
		productForUpdating.setQuantity(quantity);
		productRepo.save(productForUpdating);
	}

	@Override
	public void deleteById(int id) throws Exception {
		Product productForDeleting = retrieveById(id);
		productRepo.delete(productForDeleting);
	}
	
	@Override
	public ArrayList<Product> filterByQuantityThreshold(int threshold) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Product> filterByPriceBetween(float minPrice, float maxPrice) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
