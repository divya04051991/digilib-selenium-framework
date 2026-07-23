package com.ceva.digilib.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.Alphanumeric;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.Timeout;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;

import com.ceva.cjf.base.selenium.framework.page.BaseHomePage;
import com.ceva.cjf.base.selenium.framework.page.LoginPage;
import com.ceva.cjf.base.selenium.framework.page.SsoLoginPage;
import com.ceva.cjf.base.selenium.framework.page.UserInfo;
import com.ceva.cjf.base.selenium.framework.page.UserMaintenancePage;
import com.ceva.cjf.base.selenium.framework.page.UserSignupInfo;
import com.ceva.cjf.base.selenium.framework.page.UserSignupPage;
import com.ceva.common.test.Owner;
import com.ceva.common.test.TestTags;
import com.ceva.common.test.extension.DatabaseConnectionExtension;
import com.ceva.digilib.test.framework.page.KaizenSubmissionPage;
import com.ceva.selenium.framework.driver.Driver;
import com.ceva.selenium.framework.page.AbstractPage;
import com.ceva.selenium.test.SeleniumBaseTest;
import com.ceva.selenium.test.SeleniumTestTags;


/**
 * Ascending the method name in execution.
 */
@RunWith(JUnitPlatform.class)
@TestMethodOrder(Alphanumeric.class)
@TestInstance(Lifecycle.PER_CLASS)
@Tag(TestTags.SELENIUM)
@Tag(SeleniumTestTags.CHROME)
@Tag(SeleniumTestTags.RESOLUTION_1366X768)
public class KaizenDatabaseTest extends SeleniumBaseTest {

  LoginPage loginPage;
  SsoLoginPage ssoLoginPage;
  KaizenSubmissionPage kaizenSubmissionPage;

  String getClassName() {
    return KaizenDatabaseTest.class.getName();
  }

@BeforeAll
  void setupBeforeClass() {
    System.setProperty("webdriver.chrome.driver",
        "C:\\Users\\Admin\\Downloads\\chromedriver-win64\\chromedriver.exe");
    openBrowser(this.getClass().getName());
    loginPage = new LoginPage();
    ssoLoginPage = new SsoLoginPage();
    kaizenSubmissionPage = new KaizenSubmissionPage();
    loginPage.reInitializePageElementsForCurrentBrowser();
    ssoLoginPage.reInitializePageElementsForCurrentBrowser();
    kaizenSubmissionPage.reInitializePageElementsForCurrentBrowser();
    loginPage.goTo();
    ssoLoginPage.clickLoginWithSso();
    ssoLoginPage.ssoLoginWithInternal1();
  }

  @BeforeEach
  void setupBefore() {

  }

  // @AfterAll
  // void setupAfterClass() {
  // closeBrowser();
  // }

  @Owner(name = "bethalad", email = "divya.bethala@cevalogistics.com")
  @Test
  @Timeout(value = 100, unit = TimeUnit.SECONDS)
  void a01_createBookmark() throws Exception {
    kaizenSubmissionPage.clickOnKaizenmenu();
  }
}
