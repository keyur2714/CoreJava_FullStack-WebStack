package com.demo.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.demo.dto.ProductDTO;
import com.demo.service.ProductService;

public class ProductServiceImpl implements ProductService {

	@Override
	public List<ProductDTO> list() throws ParseException {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

		ProductDTO product1 = new ProductDTO();
		product1.setProductId(121);
		product1.setCode("TEA");
		product1.setDescription("Mashala Tea");
		product1.setUnitPrice(10);
		product1.setExpiryDate(simpleDateFormat.parse("09/12/2018"));

		ProductDTO product2 = new ProductDTO();
		product2.setProductId(122);
		product2.setCode("COFFE");
		product2.setDescription("Black Tea");
		product2.setUnitPrice(25);
		product2.setExpiryDate(simpleDateFormat.parse("10/12/2018"));		

		ProductDTO product3 = new ProductDTO();
		product3.setProductId(123);
		product3.setCode("BM");
		product3.setDescription("Butter Milk");
		product3.setUnitPrice(15);
		product3.setExpiryDate(simpleDateFormat.parse("13/12/2018"));
		
		List<ProductDTO> list = new ArrayList<>();
		list.add(product1);
		list.add(product2);
		list.add(product3);
		
		return list;
	}

}
