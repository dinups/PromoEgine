package com.promo.engine.service.impl;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;

import com.promo.engine.service.PromotionService;
import com.promo.engine.vo.CartItemVo;
import com.promo.engine.vo.FixedPriceVo;

public class PromotionServiceImpl extends PromotionService {

	@Override
	public boolean promoApplicable(List<CartItemVo> cartVo, FixedPriceVo vo) {
		if (cartVo != null && cartVo.size() > 0) {
			cartVo.stream().anyMatch(c -> !c.isAppliedPromo() && vo.getSku().equalsIgnoreCase(c.getItemVo().getId()));
		}
		return false;
	}

	@Override
	public List<CartItemVo> applyPromo(List<CartItemVo> cartVo, FixedPriceVo vo) {

		int discountPrice = vo.getPrice() / vo.getItemsNo();

		if (promoApplicable(cartVo, vo)) {
			int finalPrice = vo.getPrice() - (vo.getItemsNo() * discountPrice);

			Iterator<CartItemVo> it = cartVo.iterator();
			while (it.hasNext()) {
				CartItemVo cartItemVo = (CartItemVo) it.next();
				if (!cartItemVo.isAppliedPromo() && vo.getSku().equalsIgnoreCase(cartItemVo.getItemVo().getId())) {
					cartItemVo.setFinalPrice(new BigDecimal(discountPrice + finalPrice));
					cartItemVo.setAppliedPromo(true);
				}

			}

		}
	  return cartVo;
	}
	@Override
	public boolean checkCartEmpty(List<CartItemVo> cartVo) {
		if(cartVo == null || cartVo.isEmpty())
			return true;
		return false;
	}
	
	@Override
	public boolean checkSkuItems(List<CartItemVo> cartVo) {
		if(cartVo != null && cartVo.size() > 0)
		return true;
		
		if(cartVo != null) {
			cartVo.stream().anyMatch(vo -> vo.getItemVo() != null);
		}
		
		return false;
	}
}
