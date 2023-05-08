package com.devskiller.selenium;

public interface Executor {

	void SetLoginAndClickNext(String login);
	String OpenCodePageAndReturnCode();
	void SetCodeAndClickNext(String code);
	void FillMaskedPasswordAndClickLogin(String password);
	String GetLoggedInText();

	default String GetCodeToAssert(){
		return "87342546";
	}

	default String GetTextToAssert(){
		return "You're logged IN!!";
	}

}
