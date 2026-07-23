package com.ceva.digilib.test.framework.page;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import com.ceva.selenium.framework.driver.Driver;
import com.ceva.selenium.framework.page.AbstractPage;
import com.sun.source.tree.WhileLoopTree;


import net.sourceforge.htmlunit.corejs.javascript.ast.WhileLoop;


/**
 * LoginPage Used for LoginPage test.
 */
public  class KaizenDatabasePage extends AbstractPage {


  public static final KaizenDatabasePage INSTANCE = new KaizenDatabasePage();

private static final String Toolkit = null;

  private String url = BASE_URL + "/digilib/index.xhtml";
  private String title = "CJF-TEMPLATE";
  JavascriptExecutor js = (JavascriptExecutor)Driver.getWebDriver();
  // ----- PRIVATE WEBELEMENT AND METHODS FOR EACH BUSINESS ELEMENT IN THIS PAGE ------ //
  @FindBy( xpath = "//span[text()='Doctor Kaizen']")
  private WebElement kaizenmenu;
  @Override
  public String getTitle() {
    // TODO Auto-generated method stub
    return null;
  }
  @Override
  public String getUrl() {
    // TODO Auto-generated method stub
    return null;
  }
}