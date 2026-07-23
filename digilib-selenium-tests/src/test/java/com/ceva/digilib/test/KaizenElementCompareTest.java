
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
import com.ceva.digilib.test.framework.page.KaizenElementComparePage;
import com.ceva.digilib.test.framework.page.KaizenSubmissionPage;
	import com.ceva.selenium.framework.driver.Driver;
	import com.ceva.selenium.framework.page.AbstractPage;
	import com.ceva.selenium.test.SeleniumBaseTest;
	import com.ceva.selenium.test.SeleniumTestTags;

	import io.github.bonigarcia.wdm.WebDriverManager;


	/**
	 * Ascending the method name in execution.
	 */
	@RunWith(JUnitPlatform.class)
	@TestMethodOrder(Alphanumeric.class)
	@TestInstance(TestInstance.Lifecycle.PER_CLASS)
	@Tag(TestTags.SELENIUM)
	public class KaizenElementCompareTest extends SeleniumBaseTest {
		//public static final String version1Url = "https://digilib-dev.kdc.logistics.corp/digilib/login.xhtml";
		 // public static final String version2Url = "https://digilib-dev.kdc.logistics.corp/digilib/login.xhtml";
	    private LoginPage loginPage;
	    private SsoLoginPage ssoLoginPage;
	    private KaizenElementComparePage kaizenElementComparePage;

	    @BeforeAll
	    void setupBeforeClass() throws InterruptedException {
	        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Downloads\\chromedriver-win64\\chromedriver.exe");
	        openBrowser(this.getClass().getName());
	        
	        loginPage = new LoginPage();
	        ssoLoginPage = new SsoLoginPage();
	        kaizenElementComparePage = KaizenElementComparePage.INSTANCE; // Assuming singleton pattern

	        loginPage.reInitializePageElementsForCurrentBrowser();
	        ssoLoginPage.reInitializePageElementsForCurrentBrowser();
	        kaizenElementComparePage.reInitializePageElementsForCurrentBrowser();
	        loginPage.goTo();
	        ssoLoginPage.clickLoginWithSso();
	        ssoLoginPage.ssoLoginWithInternal1();
	    }

//	    @AfterAll
//	    void setupAfterClass() {
//	        closeBrowser();
//	    }

	    @Tag("Owner")
	    @Test
	    @Timeout(value = 100, unit = TimeUnit.SECONDS)
	    void a01_createKaizen() throws Exception {
	        kaizenElementComparePage.clickOnKaizenmenu();
	        kaizenElementComparePage.clickOnKaizensubmissionmenu(); 
	        kaizenElementComparePage.compareJdebuTextboxSize();
	        //kaizenElementComparePage.check_jdebutextbox_existence(version1Url, version2Url);
	    }
	}