package com.company;

public class Product {
	
	private String name;
	private boolean meat;
	private boolean gluten;
	private boolean lactose;
	
	public Product(String name, boolean meat)//, boolean gluten, boolean lactose)
	{
		this.name = name;
		this.meat = meat;
		this.gluten = false;
		this.lactose = false;
	}
	
	public String Name()
	{
		return name;
	}
	
	public boolean isMeat()
	{
		return meat;
	}
	
	public boolean hasGluten()
	{
		return gluten;
	}
	
	public boolean hasLactose()
	{
		return lactose;
	}
}
