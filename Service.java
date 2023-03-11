package com.fmt;

public class Service extends Item implements Invoiceable{
	private String code;
	private transient String type;
	private String name;
	private double hourlyRate;
	private double hours;
	
	
	public double getHourlyRate() {
		return hourlyRate;
	}

	public Service(String code, String type, String name, double hourlyRate, double hours) {
		super(code,type,name,hourlyRate, "S");
		this.code=code;
		this.type=type;
		this.name=name;
		this.hourlyRate=hourlyRate;
		this.hours=hours;
			}
	
	public double getTaxes() {
		double result =  hourlyRate * hours *.0345;
		result = Math.round(result * 100.0) / 100.0;
		return result;
	}


	public double getTotalPay() {
		double result = getSubTotalPay()+getTaxes();
		result = Math.round(result * 100.0) / 100.0;
		return result;
	}

	public double getSubTotalPay() {
		double result = hourlyRate* hours;
		result = Math.round(result * 100.0) / 100.0;
		return result;
		
	}

	public String getCode() {
		return code;
	}

	public String getType() {
		return type;
	}

	public String getName() {
		return name;
	}

	@Override
	public double getTotal() {
		double result = getSubTotalPay()+getTaxes();
		result = Math.round(result * 100.0) / 100.0;
		return result;
	}
	

}