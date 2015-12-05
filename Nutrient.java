package com.company;

public class Nutrient{
	
	private String name;
	private String value;
	// private String type; // binary / amount
	
	public Nutrient(String name)
	{
		this.name = name;
		this.value = null;
	}
	
	public Nutrient(String name, String val)
	{
		this.name = name;
		this.value = val;
	}
	
	public boolean Name(String name)
	{
		return this.name.equals(name);
	}
	
	public boolean Value(String val)
	{
		return this.value.equals(val);
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getValue()
	{
		return value;
	}
}
