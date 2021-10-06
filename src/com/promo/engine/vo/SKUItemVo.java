package com.promo.engine.vo;

import java.math.BigDecimal;

public class SKUItemVo {

	private String id;
	private BigDecimal unitPrice;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public BigDecimal getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}

}
