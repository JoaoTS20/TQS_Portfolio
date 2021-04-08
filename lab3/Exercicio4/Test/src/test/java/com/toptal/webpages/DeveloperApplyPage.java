package com.toptal.webpages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class DeveloperApplyPage {
    private WebDriver driver;

    @FindBy(tagName = "h1")
    WebElement heading;

    @FindBy(id="talent_create_applicant_email")
    WebElement developer_email;

    @FindBy(id = "talent_create_applicant_password")
    WebElement developer_password;

    @FindBy(id = "talent_create_applicant_password_confirmation")
    WebElement developer_password_confirmation;

    @FindBy(id = "talent_create_applicant_full_name")
    WebElement developer_full_name;

    @FindBy(css = ".has-default_value")
    WebElement talent_kind;

    @FindBy(css = ".is-active > .custom_select-options_item_title")
    WebElement developer_option;


    @FindBy(id ="save_new_talent_create_applicant")
    WebElement join_toptal_button;


    //Constructor
    public DeveloperApplyPage(WebDriver driver){
        this.driver=driver;
        driver.manage().window().fullscreen();
        //Initialise Elements
        PageFactory.initElements(driver, this);
    }

    public void setDeveloper_email(String email){
        developer_email.clear();
        developer_email.sendKeys(email);
    }

    public void setDeveloper_password(String password){
        developer_password.clear();
        developer_password.sendKeys(password);
    }

    public void  setDeveloper_password_confirmation(String password_confirmation){
        developer_password_confirmation.clear();
        developer_password_confirmation.sendKeys(password_confirmation);
    }

    public void setDeveloper_full_name (String fullname){
        developer_full_name.clear();
        developer_full_name.sendKeys(fullname);
    }

    public void setTalent_kind(){
        talent_kind.click();
    }

    public void setDeveloper_option(){
        developer_option.click();
    }


    public void clickOnJoin(){
        join_toptal_button.click();
    }
    public boolean isPageOpened(){
        //Assertion
        return heading.getText().toString().contains("Apply to Join"+ "\n" + "the World's Top Talent Network");
    }
}
