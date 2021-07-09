// This is our POJO class
package com.higradius;

// We want there should be some object that can store the multiple entries from multiple columns

public class Response {
	private String name_customer;
	private String cust_number;
	private String predicted_clear_date;
	private String invoice_id;
	private float total_open_amount;
	private String due_in_date;
	private String notes;
	private String FIELD1;
	//These are global variables for the columns that we need to work with 
	
	//We are defining the getters and setters for each and every field
	public String getField1() {
		return FIELD1;
	}
	public void setField1(String FIELD1) {
		this.FIELD1= FIELD1;
	}
	public String getCustNumber() {
		return cust_number;
	}
	public void setCustNumber(String cust_number) {
		this.cust_number = cust_number;
	}
	
	public String getNameCustomer() {
		return name_customer;
	}
	public void setNameCustomer(String name_customer) {
		this.name_customer = name_customer;
	}
	
	public String getPredictedClearDate() {
		return predicted_clear_date;
	}
	public void setPredictedClearDate(String clear_date) {
		this.predicted_clear_date = clear_date;
	}
	
	public String getInvoiceID() {
		return invoice_id;
	}
	public void setInvoiceID(String invoice_id) {
		this.invoice_id = invoice_id;
	}
	
	public String getDueInDate() {
		return due_in_date;
	}
	public void setDueInDate(String due_in_date) {
		this.due_in_date = due_in_date;
	}

	public float getTotalOpenAmount() {
		return total_open_amount;
	}
	public void setTotalOpenAmount(float total_open_amount) {
		this.total_open_amount = total_open_amount;
	}
	

	
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
}
