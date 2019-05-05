package com.webstack.service.impl;

import com.webstack.service.QuestionService;

public class SpringQuestionServiceImpl implements QuestionService{

	@Override
	public String askQuestion() {
		// TODO Auto-generated method stub
		return "What is Spring?";
	}

	public void init() {
		System.out.println("Spring Question Service Impl Init...!");
	}
	
	public void destroy() {
		System.out.println("Spring Question Service Impl Destroy...!");
	}
}
