package com.ceva.digilib.test.framework.page;

import java.awt.Robot;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.ceva.selenium.framework.driver.Driver;
import com.ceva.selenium.framework.page.AbstractPage;


/**
 * LoginPage Used for LoginPage test.
 */
public class KaizenSubmissionPage extends AbstractPage {


  public static final KaizenSubmissionPage INSTANCE = new KaizenSubmissionPage();

  private static final String Toolkit = null;

  private String url = BASE_URL + "/digilib/index.xhtml";
  private String title = "CJF-TEMPLATE";
  JavascriptExecutor js = (JavascriptExecutor) Driver.getWebDriver();
  // ----- PRIVATE WEBELEMENT AND METHODS FOR EACH BUSINESS ELEMENT IN THIS PAGE ------ //
  @FindBy(xpath = "//span[text()='Doctor Kaizen']")
  private WebElement kaizenmenu;

  @FindBy(xpath = "//*[@id='menuform:kaizen_create']/a/span")
  private WebElement kaizensubmissionmenu;

  @FindBy(id = "frm_kaizen_submit:jde_bu_input")
  private WebElement jdebutextbox;

  @FindBy(id = "frm_kaizen_submit:productLine_label")
  private WebElement productline;

  @FindBy(id = "frm_kaizen_submit:range_label")
  private WebElement kaizenrange;

  @FindBy(id = "frm_kaizen_submit:kaizenLeader_input")
  private WebElement kaizenLeader;


  @FindBy(id = "frm_kaizen_submit:leaderProfile_label")
  private WebElement leaderprofile;

  @FindBy(id = "frm_kaizen_submit:kaizenCoach_input")
  private WebElement kaizencoach;

  @FindBy(id = "frm_kaizen_submit:coachProfile_label")
  private WebElement coachprofile;

  @FindBy(id = "frm_kaizen_submit:kaizen_name")
  private WebElement kaizenname;

  @FindBy(id = "frm_kaizen_submit:kaizenType_label")
  private WebElement kaizentype;

  @FindBy(id = "frm_kaizen_submit:kaizenLanguage_label")
  private WebElement kaizenlanguage;

  @FindBy(id = "frm_kaizen_submit:team_name")
  private WebElement teamname;

  @FindBy(id = "frm_kaizen_submit:involved_fte_input")
  private WebElement involvedfte;

  @FindBy(id = "frm_kaizen_submit:greenIimpact_label")
  private WebElement greenimpact;

  @FindBy(xpath = "//*[@id='frm_kaizen_submit:sdate']/button")
  private WebElement startdate;

  @FindBy(xpath = "//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[1]/td[7]/a")
  private WebElement pickstartdate;

  @FindBy(xpath = "//*[@id=\"frm_kaizen_submit:implementation_date\"]/button")
  private WebElement implementationdate;

  @FindBy(xpath = "//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[2]/td[3]/a")
  private WebElement pickimplementationdate;

  @FindBy(id = "frm_kaizen_submit:WMS_System")
  private WebElement wmssystem;

  @FindBy(id = "frm_kaizen_submit:symptomType1_label")
  private WebElement symptomtype1;

  @FindBy(id = "frm_kaizen_submit:symptom1_label")
  private WebElement symptom1;

  @FindBy(id = "frm_kaizen_submit:symptom1_1")
  private WebElement absenteeism;

  @FindBy(id = "frm_kaizen_submit:symptomArea1_label")
  private WebElement symptomarea1;


  @FindBy(id = "frm_kaizen_submit:problemArea_label")
  private WebElement problemarea;

  @FindBy(id = "frm_kaizen_submit:problemArea_2")
  private WebElement inventorystock;

  @FindBy(id = "frm_kaizen_submit:systemicRootCause")
  private WebElement sysrootcause;

  @FindBy(id = "frm_kaizen_submit:systemicRootCause_1")
  private WebElement compliance;

  @FindBy(id = "frm_kaizen_submit:solitionArea_label")
  private WebElement solarea;

  @FindBy(id = "frm_kaizen_submit:solitionArea_3")
  private WebElement officenooperation;

  @FindBy(id = "frm_kaizen_submit:systemicProblem_label")
  private WebElement sysproblem;

  @FindBy(id = "frm_kaizen_submit:systemicProblem_1")
  private WebElement dataproblem;

  @FindBy(id = "frm_kaizen_submit:genericProblem")
  private WebElement genproblem;

  @FindBy(id = "frm_kaizen_submit:genericProblem_3")
  private WebElement cost;

  @FindBy(id = "frm_kaizen_submit:genericRootcause_label")
  private WebElement genrc;

  @FindBy(id = "frm_kaizen_submit:genericRootcause_2")
  private WebElement allocation;

  @FindBy(id = "frm_kaizen_submit:solitionArea")
  private WebElement solnarea;

  @FindBy(id = "frm_kaizen_submit:solitionArea_5")
  private WebElement quality;

  @FindBy(id = "frm_kaizen_submit:systemicSolution_label")
  private WebElement syssol;

  @FindBy(id = "frm_kaizen_submit:systemicSolution_2")
  private WebElement data;

  @FindBy(id = "frm_kaizen_submit:genericSolution_label")
  private WebElement gensol;

  @FindBy(id = "frm_kaizen_submit:genericSolution_1")
  private WebElement changepackngprocess;

  @FindBy(id = "frm_kaizen_submit:overall_problem")
  private WebElement overallprblm;

  @FindBy(id = "frm_kaizen_submit:specific_problem")
  private WebElement specificproblem;

  @FindBy(id = "frm_kaizen_submit:specific_root_cause")
  private WebElement SpecificRootcause;

  @FindBy(id = "frm_kaizen_submit:specific_solution")
  private WebElement specificsol;

  @FindBy(id = "frm_kaizen_submit:ontributionToCustomerExperience")
  private WebElement contbncustexp;

  @FindBy(id = "frm_kaizen_submit:CoReductionYear_input")
  private WebElement CO2reduction;

  @FindBy(id = "frm_kaizen_submit:KpiASIS_input")
  private WebElement kpiasis;

  @FindBy(id = "frm_kaizen_submit:KpiToBE_input")
  private WebElement kpitobe;

  @FindBy(id = "frm_kaizen_submit:globalKPImetric")
  private WebElement GlobalKPImetric;

  @FindBy(id = "frm_kaizen_submit:monthlycevaSavingsUS_input")
  private WebElement monthlycevasvngs;

  @FindBy(id = "frm_kaizen_submit:monthlyCustomerSavingsUS_input")
  private WebElement monthlycustsvngs;

  @FindBy(id = "frm_kaizen_submit:savedWorkingHours_input")
  private WebElement savedworkinghrs;

  @FindBy(id = "frm_kaizen_submit:cevaSavingsDurationMmonths_input")
  private WebElement cevasavingsdur;

  @FindBy(id = "frm_kaizen_submit:customerSavingsDrationMonths_input")
  private WebElement customersavngsdur;

  @FindBy(id = "frm_kaizen_submit:att1_label")
  private WebElement browsefile;

  @FindBy(id = "frm_kaizen_submit:submitForm")
  private WebElement submittbutton;

  @FindBy(xpath = "//*[@id=\"frm_kaizen_submit:messages3_container\"]/div/div/div[2]/span")
  private WebElement actualmessage;

  @FindBy(xpath = "//*[@id=\"frm_kaizen_submit:messages3_container\"]")
  private WebElement actualmessage1;

  @FindBy(id = "frm_kaizen_submit:cancel")
  private WebElement cancelbutton;

  @FindBy(xpath = "//span[normalize-space()='Yes']")
  private WebElement cancelbuttonyes;

  @FindBy(xpath = "//span[normalize-space()='No']")
  private WebElement cancelbuttonno;

  // -------- PUBLIC METHODS FOR USER ACTIONS -------- //

  /**
   * To click on kaizen menu.
   */

  public void clickOnKaizenmenu() {
    kaizenmenu.click();
    wait(1.0);
    // waitForAjaxToComplete();
  }

  /**
   * 
   */
  public void clickOnKaizensubmissionmenu() {
    kaizensubmissionmenu.click();
  }

  public void clickOnjdebu(String option) {
    wait(1.0);
    jdebutextbox.click();
    wait(1.0);
    jdebutextbox.sendKeys(option);
    wait(1.0);
    jdebutextbox.sendKeys(Keys.ARROW_DOWN);
    wait(1.0);
    jdebutextbox.sendKeys(Keys.ENTER);
    wait(1.0);
  }

  public void clickOnproductline() {
    wait(1.0);
    productline.click();
  }

  public void clickOnProductlineair(String option) {
    wait(1.0);
    Driver.getWebDriver().findElement(By.xpath("//li[text() ='" + option + "']")).click();
  }


  public void clickOnKaizenrange() {
    kaizenrange.click();
  }

  public void clickOnKaizenrangehik(String option) {
    wait(1.0);
    Driver.getWebDriver().findElement(By.xpath("//li[text() ='" + option + "']")).click();

  }

  public void clickOnKaizenleader(String option) {
    wait(1.0);
    kaizenLeader.sendKeys(option);
    wait(1.0);
    kaizenLeader.sendKeys(Keys.ARROW_DOWN);
    wait(1.0);
    kaizenLeader.sendKeys(Keys.ENTER);
    wait(1.0);
  }

  public void clickOnleaderprofile() {
    wait(1.0);
    js.executeScript("window.scrollBy(0,250)", "");
    wait(1.0);
    leaderprofile.click();
  }

  public void clickOnleaderprofilebpe(String option) {
    wait(1.0);
    

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
  }

  public void clickOnKaizencoach(String option) {
    wait(1.0);
    kaizencoach.sendKeys(option);
    wait(1.0);
    kaizencoach.sendKeys(Keys.ARROW_DOWN);
    wait(1.0);
    kaizencoach.sendKeys(Keys.ENTER);

  }

  public void clickOncoachprofile() {
    wait(1.0);
    coachprofile.click();
  }

  public void clickOncoachprofilebpe(String option) {
    wait(1.0);
    Driver.getWebDriver()
        .findElement(
            By.xpath("//li[@id='frm_kaizen_submit:coachProfile_1' and text()='" + option + "']"))
        .click();
  }

  public KaizenSubmissionPage enterkaizenname(String Kaizenname) {
    clearAndEnterTextAndWaitForAjaxComplete(kaizenname, Kaizenname);
    return this;
  }

  public void clickOnKaizentype() {
    wait(1.0);
    kaizentype.click();
  }

  public void clickOnKaizentypeA3(String option) {
    wait(1.0);
    Driver.getWebDriver().findElement(By.xpath("//li[text() ='" + option + "']")).click();
  }

  public void clickOnkaizenlanguage() {
    wait(1.0);
    kaizenlanguage.click();
  }

  public void clickOnKaizenlangenglish(String option) {
    wait(1.0);
    Driver.getWebDriver().findElement(By.xpath("//li[text() ='" + option + "']")).click();
  }

  public KaizenSubmissionPage enterteamname(String teamName) {
    clearAndEnterTextAndWaitForAjaxComplete(teamname, teamName);
    return this;
  }

  public KaizenSubmissionPage enterinvolvedfte(String text2) {
    clearAndEnterTextAndWaitForAjaxComplete(involvedfte, text2);
    return this;
  }

  public void clickOngreenimpact() {
    wait(1.0);
    greenimpact.click();

  }

  public void clickOngreenimpact(String option) {
    wait(1.0);
    Driver.getWebDriver().findElement(By.xpath("//li[text() ='" + option + "']")).click();
  }



  public void clickOnstartdate() {
    js.executeScript("window.scrollBy(0,-250)", "");
    wait(1.0);
    startdate.click();
  }

  public void clickOnpickstartdate() {
    pickstartdate.click();
    wait(1.0);
  }

  public void clickOnimplementationdate() {
    wait(1.0);
    implementationdate.click();
    wait(1.0);
  }

  public void clickOnpickimplementationdate() {
    wait(1.0);
    pickimplementationdate.click();
    wait(1.0);
  }

  public void clickOnwmssystem() {


    wait(1.0);
    wmssystem.click();
  }

  public void clickOnwmssystemmatrix(String option) {
    wait(1.0);
    Driver.getWebDriver().findElement(By.xpath("//li[text() ='" + option + "']")).click();
  }


  public void clickOnsymptomtype1() {
    js.executeScript("window.scrollBy(0,250)", "");
    wait(1.0);
    symptomtype1.click();
  }

  public void clickOnsymptomtype1culture(String option) {
    wait(1.0);
    Driver.getWebDriver().findElement(By.xpath("//li[text() ='" + option + "']")).click();
  }

  public void clickOnsymptom1() {
    wait(2.0);
    symptom1.click();
    wait(2.0);
  }

  public void clickOnsymptom1absenteeism(String option) {
    wait(2.0);
    Driver.getWebDriver()
        .findElement(
            By.xpath("//ul[@id='frm_kaizen_submit:symptom1_items']//li[text()='" + option + "']"))
        .click();
  }

  public void clickOnsymptomarea1() {
    js.executeScript("window.scrollBy(0,250)", "");
    symptomarea1.click();
    waitForAjaxToComplete();
  }

  public void clickOnsymptomarea1customsbrokerage(String option) {
    wait(1.0);
    Driver.getWebDriver()
        .findElement(By
            .xpath("//ul[@id='frm_kaizen_submit:symptomArea1_items']//li[text()='" + option + "']"))
        .click();
  }

  public void clickOnproblemarea() {
    wait(1.0);
    problemarea.click();
  }

  public void clickOnproblemareaoption(String option) {
    wait(1.0);
    Driver.getWebDriver()
        .findElement(By
            .xpath("//ul[@id='frm_kaizen_submit:problemArea_items']//li[text() ='" + option + "']"))
        .click();
  }

  public void clickOnsysrootcause() {
    wait(1.0);
    sysrootcause.click();
  }

  public void clickOnsysrootcauseoption(String option) {
    wait(1.0);
    Driver.getWebDriver()
        .findElement(By.xpath(
            "//ul[@id='frm_kaizen_submit:systemicRootCause_items']//li[text() ='" + option + "']"))
        .click();
  }

  public void clickOnsolarea() {
    wait(1.0);
    solarea.click();
  }

  public void clickOnOnsolareaoption(String option) {
    wait(1.0);
    Driver.getWebDriver()
        .findElement(By.xpath(
            "//ul[@id='frm_kaizen_submit:solitionArea_items']//li[text() ='" + option + "']"))
        .click();
  }

  public void clickOnsysproblem() {
    wait(1.0);
    sysproblem.click();
  }

  public void clickOnsysproblemoption(String option) {
    wait(1.0);
    Driver.getWebDriver()
        .findElement(By.xpath(
            "//ul[@id='frm_kaizen_submit:systemicProblem_items']//li[text() ='" + option + "']"))
        .click();
  }

  public void clickOngenproblem() {
    wait(1.0);
    genproblem.click();
  }

  public void clickgenproblemoption(String option) {
    wait(1.0);
    Driver.getWebDriver()
        .findElement(By.xpath(
            "//ul[@id='frm_kaizen_submit:genericProblem_items']//li[text() ='" + option + "']"))
        .click();
  }

  public void clickOngenrc() {
    wait(1.0);
    genrc.click();
  }

  public void clickOngenrcoption(String option) {
    wait(1.0);
    Driver.getWebDriver()
        .findElement(By.xpath(
            "//ul[@id='frm_kaizen_submit:genericRootcause_items']//li[text() ='" + option + "']"))
        .click();
  }

  public void clickOnsolnarea() {
    wait(1.0);
    solnarea.click();
  }

  public void clickOnsolnarea(String option) {
    wait(1.0);
    Driver.getWebDriver()
        .findElement(By.xpath(
            "//ul[@id='frm_kaizen_submit:solitionArea_items']//li[text() ='" + option + "']"))
        .click();
  }

  public void clickOnsyssol() {
    wait(1.0);
    syssol.click();
  }

  public void clickOnsyssoloption(String option) {
    wait(1.0);
    Driver.getWebDriver()
        .findElement(By.xpath(
            "//ul[@id='frm_kaizen_submit:systemicSolution_items']//li[text() ='" + option + "']"))
        .click();
  }

  public void clickOngensol() {
    wait(1.0);
    gensol.click();
  }

  public void clickOngensoloption(String option) {
    wait(1.0);
    Driver.getWebDriver()
        .findElement(By.xpath(
            "//ul[@id='frm_kaizen_submit:genericSolution_items']//li[text() ='" + option + "']"))
        .click();
  }


  public void enteroverallprblm(String option) {
    js.executeScript("window.scrollBy(0,250)", "");
    clearAndEnterTextAndWaitForAjaxComplete(overallprblm, option);
    waitForAjaxToComplete();
  }

  public void enterspecificproblem(String option) {
    clearAndEnterTextAndWaitForAjaxComplete(specificproblem, option);
    waitForAjaxToComplete();
  }

  public void enterspecificrc(String option) {
    clearAndEnterTextAndWaitForAjaxComplete(SpecificRootcause, option);
    waitForAjaxToComplete();
  }

  public void enterspecificsol(String option) {
    clearAndEnterTextAndWaitForAjaxComplete(specificsol, option);
    waitForAjaxToComplete();
  }

  public void clickOncontbncustexp() {
    wait(1.0);
    contbncustexp.click();
  }

  public void clickOncontbncustexp(String option) {
    wait(1.0);
    Driver.getWebDriver().findElement(By.xpath("//li[text() ='" + option + "']")).click();
  }

  public void enterCO2reduction(String option) {
    clearAndEnterTextAndWaitForAjaxComplete(CO2reduction, option);
    waitForAjaxToComplete();
  }

  public void enterkpiasis(String option) {
    clearAndEnterTextAndWaitForAjaxComplete(kpiasis, option);
    waitForAjaxToComplete();
  }

  public void enterkpitobe(String option) {
    clearAndEnterTextAndWaitForAjaxComplete(kpitobe, option);
    waitForAjaxToComplete();
  }

  public void clickOnGlobalKPImetric() {
    GlobalKPImetric.click();
    waitForAjaxToComplete();
  }

  public void clickOnGlobalKPImetric(String option) {
    wait(1.0);
    Driver.getWebDriver().findElement(By.xpath("//li[text() ='" + option + "']")).click();
  }

  public void entermonthlycevasvngs(String option) {
    clearAndEnterTextAndWaitForAjaxComplete(monthlycevasvngs, option);
    waitForAjaxToComplete();
  }

  public void entermonthlycustsvngs(String option) {
    clearAndEnterTextAndWaitForAjaxComplete(monthlycustsvngs, option);
    waitForAjaxToComplete();
  }

  public void entersavedworkinghrs(String option) {
    clearAndEnterTextAndWaitForAjaxComplete(savedworkinghrs, option);
    waitForAjaxToComplete();
  }

  public void entercevasavingsdur(String option) {
    clearAndEnterTextAndWaitForAjaxComplete(cevasavingsdur, option);
    waitForAjaxToComplete();
  }

  public void entercustomersavngsdur(String option) {
    clearAndEnterTextAndWaitForAjaxComplete(customersavngsdur, option);
    waitForAjaxToComplete();
  }

  public void browsefile(String filepath) throws Exception {
    browsefile.click();
    waitForAjaxToComplete();
    Robot rb = new Robot();
    File file = new File(filepath);
    wait(1.0);
    StringSelection st = new StringSelection(file.getAbsolutePath());
    java.awt.Toolkit.getDefaultToolkit().getSystemClipboard().setContents(st, null);
    wait(1.0);
    // Copy file path Ctrl+c
    rb.keyPress(KeyEvent.VK_CONTROL);
    rb.keyPress(KeyEvent.VK_V);

    // Paste file path Ctrl+v
    rb.keyRelease(KeyEvent.VK_CONTROL);
    rb.keyRelease(KeyEvent.VK_V);

    rb.keyPress(KeyEvent.VK_ENTER);
    waitForAjaxToComplete();
    js.executeScript("window.scrollBy(0,300)", "");
  }

  public void clickOnsubmittbutton() {
    scrollToViewElement(submittbutton);
    wait(1.0);
    submittbutton.click();
    wait(1.0);
  }

  public void getactualmessage(String option1, String option2) {
    String actual = actualmessage.getText();
    wait(1.0);
    if (option1.contains(actual)) {
      System.out.println(option1);

    }

    else if (option2.contains(actual)) {
      System.out.println(option2);

    } else {
      System.out.println("test case failed");
    }


  }

  public void getactualmessagea() {
    String x = actualmessage1.getText();
    System.out.println(x);
  }

  public void clickOncancelbutton(String expected) {
    scrollToViewElement(cancelbutton);

    cancelbutton.click();
    wait(1.0);
    cancelbuttonyes.click();
    wait(1.0);
    String actual = Driver.getWebDriver().getCurrentUrl();
    System.out.println(actual);

    if (actual.contentEquals(expected)) {
      System.out.println("Test Successfull");
    }

    else {
      System.out.println("test case failed");
    }

  }

  public void clickOncancelbutton1(String expected1) {
    scrollToViewElement(cancelbutton);
    wait(1.0);
    cancelbutton.click();
    wait(1.0);
    cancelbuttonno.click();
    String actual = Driver.getWebDriver().getCurrentUrl();
    System.out.println(actual);

    if (actual.contentEquals(expected1)) {
      System.out.println("Test Successfull");
    }

    else {
      System.out.println("test case failed");
    }

  }

  /**
   * To click the contract edit option.
   */
  // public KaizenSubmissionPage enterNewContractValue(String contractNumber) {
  // clearAndEnterTextAndWaitForAjaxComplete(editContractNumber, contractNumber);
  // return this;
  // }

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

  public void clickOnteamname(String text1) {
    // TODO Auto-generated method stub

  }

  public static void get(String version1) {
    // TODO Auto-generated method stub
    
  }



}

