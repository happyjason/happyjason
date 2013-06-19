package com.ammob.communication.unicom.xmlUtil;

public class AcceptPurchase {

	private String ProductID;
	private String FeeNumber;
	private String CustFeeType;
	private String  CustIsFree;
	private String EffectTime;
	
	private ProductAttribute[] productAttributes;

	public String getProductID() {
		return ProductID;
	}

	public void setProductID(String productID) {
		ProductID = productID;
	}

	public String getFeeNumber() {
		return FeeNumber;
	}

	public void setFeeNumber(String feeNumber) {
		FeeNumber = feeNumber;
	}

	public String getCustFeeType() {
		return CustFeeType;
	}

	public void setCustFeeType(String custFeeType) {
		CustFeeType = custFeeType;
	}

	public String getCustIsFree() {
		return CustIsFree;
	}

	public void setCustIsFree(String custIsFree) {
		CustIsFree = custIsFree;
	}

	public String getEffectTime() {
		return EffectTime;
	}

	public void setEffectTime(String effectTime) {
		EffectTime = effectTime;
	}

	public ProductAttribute[] getProductAttributes() {
		return productAttributes;
	}

	public void setProductAttributes(ProductAttribute[] productAttributes) {
		this.productAttributes = productAttributes;
	}
	
	
}
