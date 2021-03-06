package Pages.Campaigns;


import Framework.BrowserManager;
import Framework.CommonActions;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Miguel.Pari on 6/24/2015.
 */
public class CampaignProfile {

    WebDriver Driver;
    WebDriverWait wait;

    //region Locators

    @FindBy(className = "pageDescription")
    @CacheLookup
    WebElement CampaingNameLabel;

    @FindBy(name = "del")
    @CacheLookup
    WebElement DeleteButton;
    //endregion

    public CampaignProfile(WebDriver driver)
    {
        Driver = driver;
        wait = BrowserManager.getInstance().Waiter;
        PageFactory.initElements(driver, this);
    }

    public String getCampaingNameLabel() {
        return CampaingNameLabel.getText();
    }

    public CampaignsHome clickDeleteButton()
    {
        CommonActions.click(DeleteButton);
        Alert alert = Driver.switchTo().alert();
        alert.accept();
        Driver.switchTo().defaultContent();
        return new CampaignsHome(Driver);
    }

    public String getUrl()
    {
        return Driver.getCurrentUrl();
    }

}
