package com.promo.engine.service;

import java.util.List;

import com.promo.engine.vo.CartItemVo;
import com.promo.engine.vo.FixedPriceVo;

public abstract class PromotionService {
	
	public abstract boolean checkCartEmpty(List<CartItemVo> cartVo);
	public abstract boolean checkSkuItems(List<CartItemVo> cartVo);
	public abstract boolean promoApplicable(List<CartItemVo> cartVo, FixedPriceVo vo);
	public abstract List<CartItemVo> applyPromo(List<CartItemVo> carVo, FixedPriceVo vo);
	
	
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
