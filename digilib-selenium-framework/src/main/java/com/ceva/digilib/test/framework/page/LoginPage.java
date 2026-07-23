package com.ceva.digilib.test.framework.page;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.ceva.selenium.framework.driver.Driver;
import com.ceva.selenium.framework.page.AbstractPage;

/**
 * LoginPage Used for LoginPage test.
 */
public class LoginPage extends AbstractPage {


  public static final LoginPage INSTANCE = new LoginPage();

  private String url = BASE_URL + "/login.xhtml";
  private String title = "CJF-TEMPLATE";

  // ----- PRIVATE WEBELEMENT AND METHODS FOR EACH BUSINESS ELEMENT IN THIS PAGE ------ //
  @FindBy(xpath = "//*[@id='topbar-profile-menu-button-login']")
  private WebElement loginLink;

  @FindBy(xpath = "//*[@id='aaf_login:frm_login:txt_login_loginid']")
  private WebElement loginIdText;

  @FindBy(xpath = "//*[@id='aaf_login:frm_login:pwd_login_password']")
  private WebElement passwordText;

  @FindBy(xpath = "//*[@id='aaf_login:frm_login:btn_login_loginbutton']")
  private WebElement loginButton;

  @FindBy(xpath = "//*[@id='topbar-profile-menu-button-logout']")
  private WebElement logoutLink;

  @FindBy(xpath = "//*[@id='topbar-profile-menu-button-logout']/span")
  private WebElement logoutLinkText;

  @FindBy(xpath = "//*[@id='aaf_login:frm_login:info_msgs_sso']/div/ul/li/span")
  private WebElement message;

  @FindBy(xpath = "//*[@id=\"frm_broadcastmessage\"]/div/div")
  private WebElement broadcastMessagesOnTopBar;

  @FindBy(xpath = "//*[@id=\"frm_broadcastmessage\"]/div/div")
  private List<WebElement> topBarMessagesList;

  private WebElement cancelOfBroadcastMessagesOnTop(int messageNo) {
    return Driver.getWebDriver()
        .findElement(By.xpath("//*[@id='frm_broadcastmessage']/div/div[" + messageNo + "]/a"));
  }

  @FindBy(xpath = "//*[@id='aaf_login:frm_login:lnk_continue_with_ceva']/div")
  private WebElement loginWithCevaButton;

  @FindBy(xpath = "//*[@id='aaf_login:frm_login:topbar-profile-menu-button-signUp']/span[2]")
  private WebElement ssoSignupLink;

  // -------- PUBLIC METHODS FOR USER ACTIONS -------- //

  /**
   * To click the login.
   */
  public void loginClick(boolean closeBroadCastMessage) {
    loginButton.click();
    wait(3.0);
    waitForAjaxToComplete();
    if (closeBroadCastMessage) {
      checkAndCancelTopBarsIfAny();
    }
  }

  /**
   * To click the login with SSO.
   */
  public void loginWithCevaClick() {
    loginWithCevaButton.click();
    wait(2.0);
    waitForAjaxToComplete();
  }

  /**
   * To click the logout.
   */
  public void logout() {
    logoutLink.click();
    wait(2.0 * WAIT_FACTOR_IN_SECONDS);
    waitForAjaxToComplete();
  }

  /**
   * To click the login link.
   */
  public void loginLinkClick() {
    loginLink.click();
    wait(4.0);
    waitForAjaxToComplete();
  }

  /**
   * To click the SSO Signup link.
   */
  public void ssoSignupLinkClick() {
    ssoSignupLink.click();
    wait(4.0 * WAIT_FACTOR_IN_SECONDS);
    waitForAjaxToComplete();
  }

  // ----- PUBLIC METHODS FOR HELPER ------ //

  /**
   * Initialize the static variable for Login.
   */
  public class LoginPageInfo {
    public static final String DEFAULT_LOGIN = "bethalad";
    public static final String DEFAULT_PASSWORD = "DRAgonfly23";
    String loginText;
    String password;

    /**
     * Default Constructor.
     */
    public LoginPageInfo() {
      /**
       * zero parameter Constructor.
       */
    }

    /**
     * Create the constructor LoginPageInfo.
     * 
     * @param loginText Login Id Text
     * @param password Password Text
     */
    public LoginPageInfo(String loginText, String password) {
      super();
      this.loginText = loginText;
      this.password = password;
    }

    public LoginPageInfo withloginText(String loginText) {
      this.loginText = loginText;
      return this;
    }

    public LoginPageInfo withPasswordText(String password) {
      this.password = password;
      return this;
    }

    /**
     * Get the default values for login page.
     */
    public LoginPageInfo withDefaultValues() {
      this.loginText = DEFAULT_LOGIN;
      this.password = DEFAULT_PASSWORD;
      return this;
    }

    /**
     * Get the default values for login page.
     */
    public LoginPageInfo withInternalUser() {
      this.loginText = "US-SVC-CJF-TWO-TEST@cevalogistics.com";
      this.password = "uM4bFP9V";
      return this;
    }

    /**
     * Get the default values for login page using internal one user .
     */
    public LoginPageInfo withInternal1User() {
      this.loginText = "US-SVC-CJF-ONE-TEST@cevalogistics.com";
      this.password = "uM4bFP9V";
      return this;
    }

    /**
     * Enter the login id and password then click login button.
     */
    public void login() {
      fillLoginDetails();
      loginClick(true);
    }

    private void fillLoginDetails() {
      loginIdText.sendKeys(this.loginText + Keys.TAB);
      waitForAjaxToComplete();
      passwordText.sendKeys(this.password + Keys.TAB);
    }

    /**
     * Login to Broadcast messages page.
     */
    public void loginToBroadcastMsgPage() {
      fillLoginDetails();
      loginClick(false);
    }

    /**
     * Enter the login id and password then click login with SSO button.
     */
    public void loginWithCeva() {
      fillLoginDetails();
      loginWithCevaClick();
    }
  }

  public String logoutLinkText() {
    return logoutLinkText.getText();
  }

  public LoginPageInfo fillForm() {
    return new LoginPageInfo();
  }

  public LoginPageInfo fillFormWith(String username, String password) {
    return new LoginPageInfo(username, password);
  }

  @Override
  public String getUrl() {
    return this.url;
  }

  @Override
  public String getTitle() {
    return this.title;
  }

  /**
   * To get the info messages.
   */
  public String getMessage() {
    return message.getText();
  }

  /**
   * cancels the messages on top bar.
   */
  public void cancelBcMessagesOnTopBar() {
    for (int i = 1; i <= topBarMessagesList.size(); i++) {
      cancelOfBroadcastMessagesOnTop(i).click();
    }
  }

  /**
   * check top bar presence.
   */
  public boolean checkPresenceOfTopBarAfterCancel() {
    try {
      return broadcastMessagesOnTopBar.isDisplayed();
    } catch (NoSuchElementException e) {
      return false;
    }

  }

  /**
   * Check and cancels top bar if any.
   */
  public void checkAndCancelTopBarsIfAny() {
    if (checkPresenceOfTopBarAfterCancel()) {
      cancelBcMessagesOnTopBar();
    }
  }

}
