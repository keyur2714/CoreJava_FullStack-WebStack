package com.demo.service;

import java.text.ParseException;
import java.util.List;

import com.demo.dto.ProductDTO;

public interface ProductService {

	List<ProductDTO> list() throws ParseException;

}
