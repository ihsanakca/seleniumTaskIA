package com.devskiller.selenium;

import org.openqa.selenium.WebDriver;

public class SeleniumExecutor implements Executor {

  private final WebDriver driver;

  public SeleniumExecutor(WebDriver driver) {
    this.driver = driver;
  }

  /// Page 1
  @Override
  public void SetLoginAndClickNext(String login){
    throw new org.apache.commons.lang3.NotImplementedException("Implement this method");
  }

  /// Page 2
  @Override
  public String OpenCodePageAndReturnCode(){
    return null;
  }

  @Override
  public void SetCodeAndClickNext(String code){
    throw new org.apache.commons.lang3.NotImplementedException("Implement this method");
  }

  /// Page 3
  @Override
  public void FillMaskedPasswordAndClickLogin(String password){
    throw new org.apache.commons.lang3.NotImplementedException("Implement this method");
  }

  @Override
  public String GetLoggedInText(){
    throw new org.apache.commons.lang3.NotImplementedException("Implement this method");
  }

}
