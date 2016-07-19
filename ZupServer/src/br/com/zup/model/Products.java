package br.com.zup.model;

import java.io.Serializable;

public class Products implements Serializable{

    private static final long serialVersionUID = 2985142146950027849L;
    private int id;
    private String name;
    private String description;
    private Double price;
    private String category;
       
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
       
 
}