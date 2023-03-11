package com.fmt;

public class Product extends Item implements Invoiceable{
	private String code;
	private double unitPrice;
	private String name;
	private String unit;
	private double quantity;
	

	public Product(String code,  String name, String unit, String unitPrice, Double quantity) {
		super(code,name,unit,Double.parseDouble(unitPrice),"P");
		this.name=name;
		this.unit=unit;
		this.code=code;
		this.unitPrice=Double.parseDouble(unitPrice); 
		this.quantity=quantity;

	
	}
	

	public double getSubTotalPay() {
		double result =  unitPrice* quantity;
		result = Math.round(result * 100.0) / 100.0;
		return result;
	}
	public double getTotalPay() {
		double result =  getSubTotalPay()+getTaxes();
		result = Math.round(result * 100.0) / 100.0;
		return result;
	}
	
	public double getTaxes() {
		double result =  0.0715*getSubTotalPay();
		result = Math.round(result * 100.0) / 100.0;
		return result;
	}


	public String getCode() {
		return code;
	}


	public String getUnit() {
		return unit;
	}


	
	public double getTotal() {
		double result = getSubTotalPay()+getTaxes();
		result = Math.round(result * 100.0) / 100.0;
		return result;
	}


	public String getName() {
		return name;
	}
	public double getQuantity() {
		return quantity;
	}
	
	

}