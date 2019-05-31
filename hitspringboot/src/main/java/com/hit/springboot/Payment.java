package com.hit.springboot;

public class Payment {
	
	private String creditCardNumber;
	private String expiryDate;
	private String cvvNumber;
	private String paymentAddress;
	
	
	public String getCreditCardNumber() {
		return creditCardNumber;
	}

	public void setCreditCardNumber(String creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}

  public String getExpiryDate() {
  return expiryDate;}

  public void setExpiryDate(String expiryDate) {
  this.expiryDate = expiryDate;}

  public String getCvvNumber() {
  return cvvNumber;}

  public void setCvvNumber(String cvvNumber) {
  this.cvvNumber = cvvNumber;}

  public String getPaymentAddress() {
  return paymentAddress;}

  public void setPaymentAddress(String paymentAddress) {
  this.paymentAddress = paymentAddress;}
	
}
