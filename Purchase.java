package com.fmt;

public class Purchase extends Equipment implements Invoiceable{
	private String name;
	private String model;
	public Purchase(String itemCode,double price,String name,String model) {
		super(price,itemCode);
		this.name=name;
		this.model=model;
		

	}
	public double getSubTotalPay() {
		double result = super.getPrice();
		result = Math.round(result) / 100.0;
		return result;
	}
	public double getTotalPay() {
		double result = super.getPrice()+getTaxes();
		result = Math.round(result) / 100.0;
		return result;
	}
	
	public double getTaxes() {
		return 0;
	}
	public String getItemCode() {
		return super.getCode();
	}
	
	public double getTotal() {
		double result = super.getPrice();
		result = Math.round(result * 100.0) / 100.0;
		return result;
	}
	public String getModel() {
		return model;
	}
	public String getName() {
		return name;
	}
	
	

}