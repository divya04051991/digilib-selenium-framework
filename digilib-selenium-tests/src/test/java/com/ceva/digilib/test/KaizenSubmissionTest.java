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

import io.github.bonigarcia.wdm.WebDriverManager;


/**
 * Ascending the method name in execution.
 */
@RunWith(JUnitPlatform.class)
@TestMethodOrder(Alphanumeric.class)
@TestInstance(Lifecycle.PER_CLASS)
@Tag(TestTags.SELENIUM)
@Tag(SeleniumTestTags.CHROME)
@Tag(SeleniumTestTags.RESOLUTION_1366X768)
public class KaizenSubmissionTest extends SeleniumBaseTest {

  LoginPage loginPage;
  SsoLoginPage ssoLoginPage;
  KaizenSubmissionPage kaizenSubmissionPage;

  String getClassName() {
    return KaizenSubmissionTest.class.getName();
  }

  public static final String Kaizenname = "UKIN";
  public static final String teamName = "drkiaz";
  public static final String involvefte = "5";
  public static final String overallprblm = "test";
  public static final String airOption = "Air";
  public static final String jdebuoption = "3";
  public static final String hikOption = "High-Impact Kaizen (HIK)";
  public static final String kaizenleaderoption = "bethalad";
  public static final String kaizentypeoption = "A3 Kaizen";
  public static final String Kaizenlangoption = "English";
  public static final String startdatemonth = "June";
  public static final int startdateyear = 2023;
  public static final int day = 5;
  public static final String impdatemonth = "July";
  public static final int impdateyear = 2023;
  public static final int day1 = 7;
  public static final String greenimpactoption = "MHE Efficiency";
  public static final String leaderprofileoption = "BPE";
  public static final String Kaizencoachoption = "bethalad";
  public static final String coachprofileoption = "BPE";
  public static final String wmssystemoption = "Matrix";
  public static final String symptomtype1option = "Culture";
  public static final String symptom1option = "Absenteeism";
  public static final String symptomarea1option = "Customs Brokerage";
  public static final String problemareaoption = "Inventory / Stock Placement";
  public static final String sysrootcauseoption = "Compliance";
  public static final String solareaoption = "Customs Brokerage";
  public static final String sysproblemoption = "Data problem";
  public static final String genproblemoption = "Compliance";
  public static final String genrcoption = "Allocation";
  public static final String solnareaoption = "Customs Brokerage";
  public static final String syssoloption = "Compliance";
  public static final String gensoloption = "Change packing process";
  public static final String specificproblem = "test";
  public static final String specificrc = "test";
  public static final String specificsol = "test";
  public static final String CO2reduction = "2";
  public static final String enterkpiasis = "1";
  public static final String enterkpitobe = "2";
  public static final String GlobalKPImetric = "DOE per Line";
  public static final String monthlycevasvngs = "8";
  public static final String monthlycustsvngs = "7";
  public static final String savedworkinghrs = "4";
  public static final String cevasavingsdur = "6";
  public static final String customersavngsdur = "7";
  public static final String contcustexp = "Yes";
  public static final String filepath = "C:\\Users\\Admin\\Desktop\\ktest attchment.xlsx";
  public static final String message1 = "kaizen id created successfully";
  public static final String message2 =
      "The combination of name, team_name, jde_business_unit, start_date already exists.";
  public static final String expected = "https://digilib-test.keu.logistics.corp/digilib/kaizenStandardDashboard.xhtml";
  public static final String expected1 ="https://digilib-test.keu.logistics.corp/digilib/kaizen_submit.xhtml";
  /**
 * @throws InterruptedException
 */
@BeforeAll


  void setupBeforeClass() throws InterruptedException {
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
  void a01_createKaizen() throws Exception {
    kaizenSubmissionPage.clickOnKaizenmenu();
    kaizenSubmissionPage.clickOnKaizensubmissionmenu();
    kaizenSubmissionPage.clickOnjdebu(jdebuoption);
    kaizenSubmissionPage.clickOnproductline();
    kaizenSubmissionPage.clickOnProductlineair(airOption);
    kaizenSubmissionPage.clickOnKaizenrange();
    kaizenSubmissionPage.clickOnKaizenrangehik(hikOption);
    kaizenSubmissionPage.clickOnKaizenleader(kaizenleaderoption);
    kaizenSubmissionPage.clickOnleaderprofile();
    kaizenSubmissionPage.clickOnleaderprofilebpe(leaderprofileoption);
    kaizenSubmissionPage.clickOnKaizencoach(Kaizencoachoption);
    kaizenSubmissionPage.clickOncoachprofile();
    kaizenSubmissionPage.clickOncoachprofilebpe(coachprofileoption);
    kaizenSubmissionPage.enterkaizenname(Kaizenname);
    kaizenSubmissionPage.clickOnKaizentype();
    kaizenSubmissionPage.clickOnKaizentypeA3(kaizentypeoption);
    kaizenSubmissionPage.clickOnkaizenlanguage();
    kaizenSubmissionPage.clickOnKaizenlangenglish(Kaizenlangoption);
    kaizenSubmissionPage.enterteamname(teamName);
    kaizenSubmissionPage.enterinvolvedfte(involvefte);
    kaizenSubmissionPage.clickOngreenimpact();
    kaizenSubmissionPage.clickOngreenimpact(greenimpactoption);
    kaizenSubmissionPage.clickOnstartdate();
    kaizenSubmissionPage.clickOnpickstartdate();
    kaizenSubmissionPage.clickOnimplementationdate();
    kaizenSubmissionPage.clickOnpickimplementationdate();
    kaizenSubmissionPage.clickOnwmssystem();
    kaizenSubmissionPage.clickOnwmssystemmatrix(wmssystemoption);
    kaizenSubmissionPage.clickOnsymptomtype1();
    kaizenSubmissionPage.clickOnsymptomtype1culture(symptomtype1option);
    kaizenSubmissionPage.clickOnsymptom1();
    kaizenSubmissionPage.clickOnsymptom1absenteeism(symptom1option);
    kaizenSubmissionPage.clickOnsymptomarea1();
    kaizenSubmissionPage.clickOnsymptomarea1customsbrokerage(symptomarea1option);
    kaizenSubmissionPage.clickOnproblemarea();
    kaizenSubmissionPage.clickOnproblemareaoption(problemareaoption);
    kaizenSubmissionPage.clickOnsysrootcause();
    kaizenSubmissionPage.clickOnsysrootcauseoption(sysrootcauseoption);
    kaizenSubmissionPage.clickOnsolarea();
    kaizenSubmissionPage.clickOnOnsolareaoption(solareaoption);
    kaizenSubmissionPage.clickOnsysproblem();
    kaizenSubmissionPage.clickOnsysproblemoption(sysproblemoption);
    kaizenSubmissionPage.clickOngenproblem();
    kaizenSubmissionPage.clickgenproblemoption(genproblemoption);
    kaizenSubmissionPage.clickOngenrc();
    kaizenSubmissionPage.clickOngenrcoption(genrcoption);
    kaizenSubmissionPage.clickOnsolnarea();
    kaizenSubmissionPage.clickOnsolnarea(solnareaoption);
    kaizenSubmissionPage.clickOnsyssol();
    kaizenSubmissionPage.clickOnsyssoloption(syssoloption);
    kaizenSubmissionPage.clickOngensol();
    kaizenSubmissionPage.clickOngensoloption(gensoloption);
    kaizenSubmissionPage.enteroverallprblm(overallprblm);
    kaizenSubmissionPage.enterspecificproblem(specificproblem);
    kaizenSubmissionPage.enterspecificrc(specificrc);
    kaizenSubmissionPage.enterspecificsol(specificsol);
    kaizenSubmissionPage.clickOncontbncustexp();
    kaizenSubmissionPage.clickOncontbncustexp(contcustexp);
    kaizenSubmissionPage.enterCO2reduction(CO2reduction);
    kaizenSubmissionPage.enterkpiasis(CO2reduction);
    kaizenSubmissionPage.enterkpitobe(CO2reduction);
    kaizenSubmissionPage.clickOnGlobalKPImetric();
    kaizenSubmissionPage.clickOnGlobalKPImetric(GlobalKPImetric);
    kaizenSubmissionPage.entermonthlycevasvngs(monthlycevasvngs);
    kaizenSubmissionPage.entermonthlycevasvngs(monthlycustsvngs);
    kaizenSubmissionPage.entersavedworkinghrs(savedworkinghrs);
    kaizenSubmissionPage.entercevasavingsdur(cevasavingsdur);
    kaizenSubmissionPage.entercustomersavngsdur(customersavngsdur);
    kaizenSubmissionPage.browsefile(filepath);
    kaizenSubmissionPage.clickOnsubmittbutton();
    kaizenSubmissionPage.getactualmessage(message1, message2);
  }

  @Test
  @Timeout(value = 100, unit = TimeUnit.SECONDS)
  void a02_submitkaizenbymissingbymandatorydata() {
    kaizenSubmissionPage.clickOnKaizenmenu();
    kaizenSubmissionPage.clickOnKaizensubmissionmenu();
    kaizenSubmissionPage.clickOnjdebu(jdebuoption);
    kaizenSubmissionPage.clickOnproductline();
    kaizenSubmissionPage.clickOnProductlineair(airOption);
    kaizenSubmissionPage.clickOnKaizenrange();
    kaizenSubmissionPage.clickOnKaizenrangehik(hikOption);
    kaizenSubmissionPage.clickOnKaizenleader(kaizenleaderoption);
    kaizenSubmissionPage.clickOnleaderprofile();
    kaizenSubmissionPage.clickOnleaderprofilebpe(leaderprofileoption);
    kaizenSubmissionPage.clickOnsubmittbutton();
    kaizenSubmissionPage.getactualmessagea();
  }

  @Test
  @Timeout(value = 100, unit = TimeUnit.SECONDS)
  void a03_Cancelkaizenyes() {
    kaizenSubmissionPage.clickOnKaizenmenu();
    kaizenSubmissionPage.clickOnKaizensubmissionmenu();
    kaizenSubmissionPage.clickOnjdebu(jdebuoption);
    kaizenSubmissionPage.clickOnproductline();
    kaizenSubmissionPage.clickOnProductlineair(airOption);
    kaizenSubmissionPage.clickOnKaizenrange();
    kaizenSubmissionPage.clickOnKaizenrangehik(hikOption);
    kaizenSubmissionPage.clickOnKaizenleader(kaizenleaderoption);
    kaizenSubmissionPage.clickOnleaderprofile();
    kaizenSubmissionPage.clickOnleaderprofilebpe(leaderprofileoption);
    kaizenSubmissionPage.clickOncancelbutton(expected);
    
  }


  @Test
  @Timeout(value = 100, unit = TimeUnit.SECONDS)
  void a04_Cancelkaizenno() {
    kaizenSubmissionPage.clickOnKaizenmenu();
    kaizenSubmissionPage.clickOnKaizensubmissionmenu();
    kaizenSubmissionPage.clickOnjdebu(jdebuoption);
    kaizenSubmissionPage.clickOnproductline();
    kaizenSubmissionPage.clickOnProductlineair(airOption);
    kaizenSubmissionPage.clickOnKaizenrange();
    kaizenSubmissionPage.clickOnKaizenrangehik(hikOption);
    kaizenSubmissionPage.clickOnKaizenleader(kaizenleaderoption);
    kaizenSubmissionPage.clickOnleaderprofile();
    kaizenSubmissionPage.clickOnleaderprofilebpe(leaderprofileoption);
    kaizenSubmissionPage.clickOncancelbutton1(expected1);
  }
}
