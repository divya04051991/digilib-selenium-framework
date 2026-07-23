package com.ceva.digilib.test.framework.page;

import java.awt.Robot;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.ceva.selenium.framework.driver.Driver;
import com.ceva.selenium.framework.page.AbstractPage;


/**
 * LoginPage Used for LoginPage test.
 */
public class KaizenElementComparePage extends AbstractPage {

  public static final KaizenElementComparePage INSTANCE = new KaizenElementComparePage();
  private static final String BASE_URL = "https://digilib-dev.kdc.logistics.corp"; // Define your
                                                                                   // BASE_URL
  public static boolean exists_version_1;
  public static boolean exists_version_2;
  private String url = BASE_URL + "/digilib/index.xhtml";
  public static String version1Url = BASE_URL + "/digilib/version1.xhtml";
  static String version2Url = BASE_URL + "/digilib/version2.xhtml";
  private String title = "CJF-TEMPLATE";
  private JavascriptExecutor js = (JavascriptExecutor) Driver.getWebDriver();

  // ----- PRIVATE WEBELEMENTS AND METHODS FOR EACH BUSINESS ELEMENT IN THIS PAGE ------ //
  @FindBy(xpath = "//span[text()='Doctor Kaizen']")
  private WebElement kaizenmenu;

  @FindBy(xpath = "//*[@id='menuform:kaizen_create']/a/span")
  private WebElement kaizensubmissionmenu;

  @FindBy(id = "frm_kaizen_submit:jde_bu_input")
  private static WebElement jdebutextbox;


  public void compareJdebuTextboxSize() {
    WebDriver driver = new ChromeDriver();
    // Navigate to Version 1 URL

    driver.get(version1Url);
    System.out.println(driver.getCurrentUrl());

    // Locate the 'jdebutextbox' element in Version 1
    WebElement textboxVersion1 = jdebutextbox;

    // Get the size of the textbox in Version 1
    Dimension sizeVersion1 = textboxVersion1.getSize();
    int widthVersion1 = sizeVersion1.getWidth();
    int heightVersion1 = sizeVersion1.getHeight();
    System.out.println("Version 1 Textbox Size: " + widthVersion1 + "x" + heightVersion1);
    driver.get(version2Url);

    // Locate the 'jdebutextbox' element in Version 2
    WebElement textboxVersion2 = jdebutextbox;

    // Get the size of the textbox in Version 2
    Dimension sizeVersion2 = textboxVersion2.getSize();
    int widthVersion2 = sizeVersion2.getWidth();
    int heightVersion2 = sizeVersion2.getHeight();
    System.out.println("Version 2 Textbox Size: " + widthVersion2 + "x" + heightVersion2);

    // Compare the sizes of both textboxes
    if (widthVersion1 == widthVersion2 && heightVersion1 == heightVersion2) {
      System.out.println("The textboxes in both versions are of the same size.");
    } else {
      System.out.println("The textboxes in both versions have different sizes.");
      if (widthVersion1 != widthVersion2) {
        System.out.println("The width is different: Version 1 = " + widthVersion1 + ", Version 2 = "
            + widthVersion2);
      }
      if (heightVersion1 != heightVersion2) {
        System.out.println("The height is different: Version 1 = " + heightVersion1
            + ", Version 2 = " + heightVersion2);
      }
    }
  }

  public void check_jdebutextbox_existence(String version1Url, String version2Url) {
    // Check existence of 'jdebutextbox' on the first page/version
    WebElement jdebutextbox = new WebDriverWait(Driver.getWebDriver(), 10).until(
        ExpectedConditions.visibilityOfElementLocated(By.id("frm_kaizen_submit:jde_bu_input")));
    exists_version_1 = redirctUrl(version1Url, "Page Not Found");

    // Check existence of 'jdebutextbox' on the second page/version
    exists_version_2 = redirctUrl(version2Url, "Page Not Found");
    // Compare the results

    if (exists_version_1 && exists_version_2) {
      System.out.println("The element 'jdebutextbox' exists on both versions.");
    } else if (exists_version_1) {
      System.out
          .println("The element 'jdebutextbox' exists on the first version but not on the second.");
    } else if (exists_version_2) {
      System.out
          .println("The element 'jdebutextbox' exists on the second version but not on the first.");
    } else {
      System.out.println("Both URLs not exits");
    }
  }

  // -------- PUBLIC METHODS FOR USER ACTIONS -------- //

  private boolean redirctUrl(String versionUrl, String sufixString) {
    WebDriver driver = getWebDriver();
    driver.navigate().to(versionUrl);
    WebElement h1Element = driver.findElement(By.tagName("h1"));

    if (!sufixString.contains(h1Element.getText())) {
      return true;
    }
    return false;
  }

  public void clickOnKaizenmenu() {
    wait(1.0);
    kaizenmenu.click();
    wait(1.0);
  }

  public void clickOnKaizensubmissionmenu() {
    kaizensubmissionmenu.click();
  }

  @Override
  public String getTitle() {
    return title;
  }

  @Override
  public String getUrl() {
    return BASE_URL + "/digilib/index.xhtml"; // Adjust as necessary
  }
}

