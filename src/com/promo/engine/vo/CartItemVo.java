package com.promo.engine.vo;

import java.math.BigDecimal;

public class CartItemVo {

	private SKUItemVo itemVo;
	private boolean appliedPromo;
	private BigDecimal finalPrice;

	public SKUItemVo getItemVo() {
		return itemVo;
	}

	public void setItemVo(SKUItemVo itemVo) {
		this.itemVo = itemVo;
	}

	public boolean isAppliedPromo() {
		return appliedPromo;
	}

	public void setAppliedPromo(boolean appliedPromo) {
		this.appliedPromo = appliedPromo;
	}

	public BigDecimal getFinalPrice() {
		return finalPrice;
	}

	public void setFinalPrice(BigDecimal finalPrice) {
		this.finalPrice = finalPrice;
	}

}
