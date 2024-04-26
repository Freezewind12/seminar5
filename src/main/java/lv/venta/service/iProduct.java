package lv.venta.service;

import java.util.ArrayList;

import lv.venta.model.Product;

public interface iProduct {
	public abstract void create(String title, String description, float price, int quantity) throws Exception;
	public abstract ArrayList<Product> retirveAll() throws Exception;
	public abstract Product retrieveById(int id) throws Exception;
	public abstract void updateById(int id, String title, String description, float price, int quantity) throws Exception;
	public abstract void deleteById(int id) throws Exception;
	
}
