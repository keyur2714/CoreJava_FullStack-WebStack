package com.webstack.service.impl;

import com.webstack.service.QuestionService;

public class ExamServiceImpl {
	private QuestionService questionService;

	public ExamServiceImpl() {}
	
	public ExamServiceImpl(QuestionService questionService) {
		this.questionService = questionService;
	}
	
	

	public void setQuestionService(QuestionService questionService) {
		this.questionService = questionService;
	}



	public void startExam() {
		System.out.println(questionService.askQuestion());
	}
}
