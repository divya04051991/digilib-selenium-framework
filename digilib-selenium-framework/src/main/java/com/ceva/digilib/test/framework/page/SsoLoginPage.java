package com.ceva.digilib.test.framework.page;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.ceva.selenium.framework.driver.Driver;
import com.ceva.selenium.framework.page.AbstractPage;

/**
 * LoginPage Used for LoginPage test.
 */
public class SsoLoginPage extends AbstractPage {

  private static final Logger LOGGER = LoggerFactory.getLogger(SsoLoginPage.class);
  public static final SsoLoginPage INSTANCE = new SsoLoginPage();
  private static final String LOGIN_WITH_SSO = "LOGIN WITH SSO";
  private static final String LOGIN_WITH_EMPLOYEE = "LOGIN AS EMPLOYEE";

  private String url = BASE_URL + "/";
  private String title = "CJF-TEMPLATE";

  private static final String externalUserNme = "three.automation";
  private static final String externalPassword = "CJFAdmin1$";
  private static final String internal1UserNme = "US-SVC-CJF-ONE-TEST";
  private static final String internal1Password = "uM4bFP9V";
  private static final String internal2UserNme = "US-SVC-CJF-TWO-TEST";
  private static final String internal2Password = "uM4bFP9V";

  // ----- PRIVATE WEBELEMENT AND METHODS FOR EACH BUSINESS ELEMENT IN THIS PAGE ------ //

  @FindBy(xpath = "//*[@id='aaf_login:frm_login:lnk_sso_login']")
  private WebElement loginWithSsoButton;

  @FindBy(xpath = "//*[@id='aaf_login:frm_login:rep_idps:0:lnk_login_as_employee_']")
  private WebElement loginWithEmployeeButton;

  @FindBy(xpath = "//*[@id='authorizeForm']/div[1]/div/h3[2]/p")
  private WebElement consentPage;

  @FindBy(xpath = "//*[@id='authorizeForm:doNotAllowButton']")
  private WebElement consentPageNotAllowLink;

  @FindBy(xpath = "//*[@id='authorizeForm:allowButton']")
  private WebElement consentPageAllowLink;

  @FindBy(xpath = "//*[@id='loginForm:username']")
  private WebElement gluuLoginText;

  @FindBy(xpath = "//*[@id='loginForm:password']")
  private WebElement gluuPasswordText;

  @FindBy(
      xpath = "//*[@id='aaf_login_link:frm_user_signup:panel_main:lbl_user_add_email:txt_login_loginid']")
  private WebElement appLoginText;

  @FindBy(
      xpath = "//*[@id='aaf_login_link:frm_user_signup:panel_main:lbl_user_add_firstname:pwd_login_password']")
  private WebElement appLoginPasswordText;

  @FindBy(xpath = "//*[@id='aaf_login:frm_login:lnk_continue_with_ceva']/div")
  private WebElement loginWithCevaButton;

  @FindBy(xpath = "//*[@id='loginForm:loginButton']")
  private WebElement gluuLoginButton;

  @FindBy(xpath = "//*[@id='topbar-profile-menu-button-logout']")
  private WebElement ssoLogoutLink;

  @FindBy(xpath = "//*[@id='aaf_login:frm_login:topbar-profile-menu-button-signUp']")
  private WebElement ssoSignupLink;

  @FindBy(xpath = "//*[@id='aaf_login:frm_login:lnk_signup_wih_sso']")
  private WebElement signupLink;

  @FindBy(xpath = "//*[@id='aaf_login_link:frm_user_signup:panel_main:info_msgs']/div/ul/li/span")
  private WebElement linkAccountMessages;

  @FindBy(xpath = "//*[@id=\"frm_broadcastmessage\"]/div/div")
  private List<WebElement> topBarMessagesList;

  @FindBy(xpath = "//*[@id=\"frm_broadcastmessage\"]/div/div")
  private WebElement broadcastMessagesOnTopBar;

  private WebElement cancelOfBroadcastMessagesOnTop(int messageNo) {
    return Driver.getWebDriver()
        .findElement(By.xpath("//*[@id='frm_broadcastmessage']/div/div[" + messageNo + "]/a"));
  }


  // -------- PUBLIC METHODS FOR USER ACTIONS -------- //

  /**
   * To click the SSO Login.
   */
  public void ssoLogin(String userName, String password) {
    wait(3.0 * WAIT_FACTOR_IN_SECONDS);
    waitUntilLoaded();
    // if (userType.equalsIgnoreCase(LOGIN_WITH_SSO)) {
    // loginWithSsoButton.click();
    // } else if (userType.equalsIgnoreCase(LOGIN_WITH_SSO)) {
    // loginWithEmployeeButton.click();
    // }
    // Every xhtml page calls iframeInit which internally calls gluu authorize API. During login
    // process, user first enters the user name and clicks next.
    // In the background the iframe gets triggered which makes a call to authorize endpoint. However
    // in UI, application is directed to gluu
    // login page where the user enters username, password and click login button. This calls login
    // API from Gluu.
    // As there is a probability for these two calls to intercept, we are getting error saying
    // INVALID_REQUEST.
    // To avoid these calls to collide, we are adding wait time
    waitUntilLoaded();
    gluuLogin(userName, password);
    glueAuthAllow();
    checkAndCancelTopBarsIfAny();
  }

  /**
   * To click the SSO Login.
   */
  public void gluuLogin(String userName, String password) {
    waitUntilLoaded();
    if (gluuLoginText.isDisplayed() && gluuPasswordText.isDisplayed()
        && gluuLoginButton.isEnabled()) {
      enterGluuLoginId(userName);
      enterGluuPasswordId(password);
      gluuLoginButtonClick();
      waitUntilLoaded();
    } else {
      throw new RuntimeException();
    }
  }


  /**
   * To click the Allow Link.
   */
  public void glueAuthAllow() {
    try {
      if (consentPageAllowLink.isEnabled()) {
        allowLinkClick();
        waitUntilLoaded();
      }
    } catch (NoSuchElementException e) {
      LOGGER.info("Consent page already allowed to the user.");
    }
  }

  /**
   * To click the Not Allow Link.
   */
  public void notAllowLinkClick() {
    consentPageNotAllowLink.click();
    wait(2.0 * WAIT_FACTOR_IN_SECONDS);
    waitForAjaxToComplete();
  }

  /**
   * To click the Allow Link.
   */
  public void allowLinkClick() {
    consentPageAllowLink.click();
    wait(1.0 * WAIT_FACTOR_IN_SECONDS);
    waitForAjaxToComplete();
  }

  /**
   * To click the gluu login button.
   */
  public void gluuLoginButtonClick() {
    gluuLoginButton.click();
    wait(1.0 * WAIT_FACTOR_IN_SECONDS);
    waitForAjaxToComplete();
  }

  /**
   * To click the SSO Logout Link.
   */
  public void logoutLinkClick() {
    ssoLogoutLink.click();
    wait(4.0 * WAIT_FACTOR_IN_SECONDS);
    waitForAjaxToComplete();
  }

  /**
   * To click the SSO Signup Link.
   */
  public void signupLinkClick() {
    waitUntilLoaded();
    signupLink.click();
    wait(4.0 * WAIT_FACTOR_IN_SECONDS);
    waitForAjaxToComplete();
  }

  /**
   * Click to go to login with sso.
   */
  public void clickLoginWithSso() {
    loginWithSsoButton.click();
    waitUntilLoaded();
  }

  /**
   * Click to go to login with employee.
   */
  public void clickLoginWithEmployee() {
    loginWithEmployeeButton.click();
    waitUntilLoaded();
  }
  // ----- PUBLIC METHODS FOR HELPER ------ //

  @Override
  public String getUrl() {
    return this.url;
  }

  @Override
  public String getTitle() {
    return this.title;
  }

  /**
   * To SSO Login with External three.automation.
   */
  public void ssoLoginWithExternal() {
    ssoLogin(externalUserNme, externalPassword);

  }

  /**
   * To SSO Login with Internal US-SVC-CJF-TWO-TEST@cevalogistics.com.
   */
  public void ssoLoginWithInternal1() {
    ssoLogin(internal1UserNme, internal1Password);
  }

  /**
   * To SSO Login with Internal US-SVC-CJF-TWO-TEST@cevalogistics.com without closing active
   * messages.
   */
  public void ssoLoginToBroadcastMessagePageWithInternal1() {
    loginToBroadcastMsgPage(internal1UserNme, internal1Password);
  }


  /**
   * To SSO Login with Internal US-SVC-CJF-ONE-TEST@cevalogistics.com.
   */
  public void ssoLoginWithInternal2() {
    ssoLogin(internal2UserNme, internal2Password);
  }

  /**
   * To SSO Login with Internal US-SVC-CJF-ONE-TEST@cevalogistics.com without closing active
   * messages.
   */
  public void ssoLoginToBroadcastMessagePageWithInternal2() {
    loginToBroadcastMsgPage(internal2UserNme, internal2Password);
  }

  /**
   * Enter login Id in SSO Gluu.
   * 
   * @param loginText SSO gluu login text.
   * @return this
   */
  public SsoLoginPage enterGluuLoginId(String loginText) {
    clearAndEnterTextAndWaitForAjaxComplete(gluuLoginText, loginText);
    return this;
  }

  /**
   * Enter password in SSO Gluu.
   * 
   * @param passwordText SSO gluu password text.
   * @return this
   */
  public SsoLoginPage enterGluuPasswordId(String passwordText) {
    clearAndEnterTextAndWaitForAjaxComplete(gluuPasswordText, passwordText);
    return this;
  }


  /**
   * Enter login Id in application Link page.
   * 
   * @param loginText link account login text.
   * @return this
   */
  public SsoLoginPage enterApplicationLoginId(String loginText) {
    clearAndEnterTextAndWaitForAjaxComplete(appLoginText, loginText);
    return this;
  }

  /**
   * Enter password in application Link page.
   * 
   * @param passwordText link account password.
   * @return this
   */
  public SsoLoginPage enterApplicationPasswordId(String passwordText) {
    clearAndEnterTextAndWaitForAjaxComplete(appLoginPasswordText, passwordText);
    return this;
  }

  /**
   * Get consent page message.
   */
  public String getConsentPageMessage() {
    return consentPage.getText();
  }

  /**
   * Checks if the browser is in the sso page provided by the parameter.
   * 
   * @param urlPath path of page. I.E. if page is the login page, urlPath would be login.xhtml.
   * @return boolean indicating whether page is currently being displayed or not.
   */
  public boolean isAt(String urlPath) {
    String currentUrl = Driver.getWebDriver().getCurrentUrl();
    if (currentUrl.endsWith(urlPath)) {
      return true;
    }
    return false;
  }


  /**
   * Get link account page message.
   */
  public String getLinkAccountMessages() {
    return linkAccountMessages.getText();
  }

  /**
   * Check Logout link is displayed.
   */
  public boolean isDisplayedLogout() {
    try {
      return ssoLogoutLink.isDisplayed();
    } catch (NoSuchElementException e) {
      LOGGER.info("Doesn't show the Logout link.");
    }
    return false;
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

  /**
   * login to broadcast messages without closing active message.
   * 
   * @param userName login user name.
   * @param password password.
   */
  public void loginToBroadcastMsgPage(String userName, String password) {
    waitUntilLoaded();
    gluuLogin(userName, password);
    glueAuthAllow();
  }
}
