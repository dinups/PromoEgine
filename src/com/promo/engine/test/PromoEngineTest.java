package com.promo.engine.test;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.promo.engine.service.PromotionService;
import com.promo.engine.service.impl.PromotionServiceImpl;
import com.promo.engine.vo.CartItemVo;
import com.promo.engine.vo.FixedPriceVo;
import com.promo.engine.vo.SKUItemVo;

public class PromoEngineTest {

	@Test
	public void checkCartEmpty() {
		PromotionService service = new PromotionServiceImpl();
		assertTrue(service.checkCartEmpty(null));
	}
	
	@Test
	public void checkSkuItems() {
		PromotionService service = new PromotionServiceImpl();
		List<CartItemVo> cart = new ArrayList<CartItemVo>();
		
		CartItemVo cart1 = new CartItemVo();
		SKUItemVo skuVo1 = new SKUItemVo();
		skuVo1.setId("100");
		skuVo1.setUnitPrice(new BigDecimal(120));
		cart1.setItemVo(skuVo1);
		cart.add(cart1);
		
		CartItemVo cart2 = new CartItemVo();
		SKUItemVo skuVo2 = new SKUItemVo();
		skuVo1.setId("101");
		skuVo1.setUnitPrice(new BigDecimal(121));
		cart1.setItemVo(skuVo2);
		cart.add(cart2);
		
		CartItemVo cart3 = new CartItemVo();
		SKUItemVo skuVo3 = new SKUItemVo();
		skuVo1.setId("103");
		skuVo1.setUnitPrice(new BigDecimal(123));
		cart1.setItemVo(skuVo3);
		cart.add(cart3);
		
		assertTrue(service.checkSkuItems(cart));
	}
	
	@Test
	public void applyPromo() {
		PromotionService service = new PromotionServiceImpl();
		List<CartItemVo> cart = new ArrayList<CartItemVo>();
		
		CartItemVo cart1 = new CartItemVo();
		SKUItemVo skuVo1 = new SKUItemVo();
		skuVo1.setId("100");
		skuVo1.setUnitPrice(new BigDecimal(120));
		cart1.setItemVo(skuVo1);
		cart.add(cart1);
		
		CartItemVo cart2 = new CartItemVo();
		SKUItemVo skuVo2 = new SKUItemVo();
		skuVo1.setId("101");
		skuVo1.setUnitPrice(new BigDecimal(121));
		cart1.setItemVo(skuVo2);
		cart.add(cart2);
		
		CartItemVo cart3 = new CartItemVo();
		SKUItemVo skuVo3 = new SKUItemVo();
		skuVo1.setId("103");
		skuVo1.setUnitPrice(new BigDecimal(123));
		cart1.setItemVo(skuVo3);
		cart.add(cart3);
		
		FixedPriceVo vo = new FixedPriceVo();
		vo.setItemsNo(120);
		vo.setPrice(2000);
		vo.setSku("100");
		
		assertTrue(service.applyPromo(cart,vo).size() > 0);
	}

}
