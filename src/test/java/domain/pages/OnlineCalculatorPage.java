package domain.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import utilities.BasePage;

public class OnlineCalculatorPage extends BasePage<OnlineCalculatorPage> {

    public static OnlineCalculatorPage open() {
        new OnlineCalculatorPage().get("https://www.online-calculator.com/full-screen-calculator/");
        return PageFactory.initElements(driver, OnlineCalculatorPage.class);
    }

    public void enterInput(String a, String b, String operator) {
        Actions actions = new Actions(driver);
        actions.sendKeys(a).sendKeys(operator).sendKeys(b).sendKeys("=").perform();
    }

    public String getResult() {
        WebElement iFrame = driver.findElements(By.tagName("iframe")).get(0);
        driver.switchTo().frame(iFrame);
        JavascriptExecutor js = (JavascriptExecutor)driver;
        return (String) js.executeScript("return exportRoot.showscreen_txt.text;", "" );
    }

    public void closePage() {
        this.close();
    }
}
