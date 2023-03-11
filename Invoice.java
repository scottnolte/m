package com.fmt;

import java.util.ArrayList;

public class Invoice {
	
	private Store s;
	private String invoice;
	private Person customer;
	private Person salesPerson;
	private String date;
	private ArrayList<InvoiceItem> it;
	private String s1;
	
	public Invoice(String invoiceCode) {
		this.invoice=invoiceCode;
	}


	public Invoice(String invoice, Store c, Person customer, Person salesPerson, String date, ArrayList<InvoiceItem> it) {
		this.invoice = invoice;
		this.s=c;
		this.customer=customer;
		this.salesPerson=salesPerson;
		this.date=date;
		this.it= it;
	}


	public Invoice(String invoiceCode, String s1) {
		this.invoice=invoiceCode;
		this.s1=s1;
	}


	public Store getS() {
		return s;
	}
	public int numSales() {
		return it.size();
	}


	public String getInvoice() {
		return invoice;
	}


	public Person getCustomer() {
		return customer;
	}


	public Person getSalesPerson() {
		return salesPerson;
	}


	public String getDate() {
		return date;
	}
	public double getTotalPrice() {
		double total=0;
		for(int i =0;i<it.size();i++) {
			
		}
		return total;
	}
	
	


	public ArrayList<InvoiceItem> getIt() {
		return it;
	}

	
	
	
	public String toString() {
		return invoice + "\t\t" + s.getCode() + "\t\t" + customer.getLastName() + ", " + customer.getFirstName() +"\t\t"+ salesPerson.getLastName() + ", " + salesPerson.getFirstName() + "\t\t" + getTotalPrice();
	}


	public void getInfo() {
		System.out.println("Invoice: " + invoice);
		System.out.println("Store: " + s.getCode());
		System.out.println("Date: " + date);
		System.out.println("Customer: ");
		System.out.print(customer.getLastName()+ ", " + customer.getFirstName());
		System.out.println("    (" + customer.getCode() + ": " + customer.getEmails() + ")");
		System.out.println(customer.getAddress());
		System.out.println("\n");
		System.out.println("Sales Person: ");
		System.out.print(salesPerson.getLastName()+ ", " + salesPerson.getFirstName());
		System.out.println("    (" + salesPerson.getCode() + ": " + salesPerson.getEmails() + ")");
		System.out.println(salesPerson.getAddress());
		System.out.println("\nItems:");
		System.out.println("******************************************************************************");
		double total=0;
		double tax=0;
		for(int i =0; i<it.size();i++) {
			System.out.print(it.get(i).getI().getCode() + "     ");
			if(it.get(i).getI().getType().equals("Equipment")) {
				if(it.get(i).getL()!=null) {
					System.out.print("  Lease    " + it.get(i).getL().getName() + " , "+ it.get(i).getL().getModel()+ " Taxes: $" +it.get(i).getL().getTaxes()+ "   Total: $" + it.get(i).getL().getPrice());
					total+=it.get(i).getL().getTotal();
					total = Math.round(total * 100.0) / 100.0;
					tax+=it.get(i).getL().getTaxes();
					tax = Math.round(tax * 100.0) / 100.0;
				}
				if(it.get(i).getP()!=null) {
					System.out.print("  Purchase   " + it.get(i).getP().getName() +" , "+ it.get(i).getP().getModel()+ " Taxes: $" + it.get(i).getP().getTaxes() + "   Total: $" + it.get(i).getP().getPrice());
					total+=it.get(i).getP().getTotal();
					total = Math.round(total * 100.0) / 100.0;
					tax+=it.get(i).getP().getTaxes();
					tax = Math.round(tax * 100.0) / 100.0;
				}
			}
			if(it.get(i).getI().getType().equals("Product")) {
				System.out.print("   Product   " + it.get(i).getProduct().getName()+ " " +it.get(i).getProduct().getUnit() + "(" + (int)it.get(i).getProduct().getQuantity() + ")   Price:$"  + it.get(i).getProduct().getUnitPrice() + "   Taxes:$" + it.get(i).getProduct().getTaxes());
				total+=it.get(i).getProduct().getTotal();
				total = Math.round(total * 100.0) / 100.0;
				tax+=it.get(i).getProduct().getTaxes();
				tax = Math.round(tax * 100.0) / 100.0;
		
			}
			if(it.get(i).getI().getType().equals("S")) {
				System.out.print("   Service   " + it.get(i).getService().getName() + " Rate: " + it.get(i).getService().getHourlyRate()+ "    Taxes: $" + it.get(i).getService().getTaxes() + "   Total: $" + it.get(i).getService().getTotal());
				total+=it.get(i).getService().getTotal();
				total = Math.round(total * 100.0) / 100.0;
				tax+=it.get(i).getService().getTaxes();
				tax = Math.round(tax * 100.0) / 100.0;
			}
			
			System.out.println();
			
					}
		System.out.println("\t\t\t\t\t\t\t\tTaxes: " + tax);
		System.out.println("\t\t\t\t\t\t\t\tTotal: " + total);
		
	}
	

	}




	
	
	
