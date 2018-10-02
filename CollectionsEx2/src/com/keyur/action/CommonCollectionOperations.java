package com.keyur.action;

import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class CommonCollectionOperations {

	public static void main(String[] args) {

		String emailAddress = "keyurjava27@gmail.com;denish_hp_6383@gmail.com;vinit2cute@gmail.com;darsh4u@gmail.com";
		String emailAddrArr [] = emailAddress.split(";");		
		System.out.println(emailAddrArr.length);
		System.out.println("String Array:::");
		for (String string : emailAddrArr) {
			System.out.println(string);
		}
		System.out.println("Converted in Collections:::");
		List<String> emailList = Arrays.asList(emailAddrArr);
		for (String string : emailList) {
			System.out.println(string);
		}
		System.out.println("Converted List to Array:::");
		Object[] emails = emailList.toArray();
		for (Object object : emails) {
			System.out.println(object);
		}
		
		System.out.println("String Tokenizer:::");
		StringTokenizer tokens = new StringTokenizer(emailAddress, ";");
		System.out.println(tokens.countTokens());
		while(tokens.hasMoreTokens()) {
			System.out.println(tokens.nextToken());
		}
	}

}
