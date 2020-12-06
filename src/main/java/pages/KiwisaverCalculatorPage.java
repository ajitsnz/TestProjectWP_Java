package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import dictionaries.EmploymentStatus;
import dictionaries.Frequency;
import dictionaries.KiwiMemberContribution;
import dictionaries.RiskProfile;
import models.User;
import org.testng.asserts.SoftAssert;

public class KiwisaverCalculatorPage extends BasePage {

	public KiwisaverCalculatorPage(WebDriver driver) {
		super(driver);
		driver.navigate().to("http://westpac.co.nz/kiwisaver/calculators/kiwisaver-calculator/");
		this.SwitchTo();
	}

	public final KiwisaverCalculatorPage FillCurrentAge(int age) {
		currentAge().sendKeys(String.valueOf(age));
		return this;
	}

	public final KiwisaverCalculatorPage FillKiwisaverRetirementCalculator(User user) {
		currentAge().sendKeys(String.valueOf(user.currentAge));
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		SetEmploymentStatus(user.employmentStatus);
		if (user.employmentStatus.equals(EmploymentStatus.Employed))
			salary().sendKeys(String.valueOf(user.salary));
		SetKiwimemberContribution(user.kiwiMemberContribution);
		currentKiwisaverBalance().sendKeys(String.valueOf(user.currentKiwiBalance));
		voluntaryContributions().sendKeys(String.valueOf(user.voluntaryContributions));
		SetRiskProfile(user.riskProfile);
		savingsGoalAtRetirement().sendKeys(String.valueOf(user.savingsGoalAtRetirement));
		SetFrequency(user.vcFrequency);
		return this;
	}

	public final void Submit() {
		submit().click();
	}

	public final void SwitchTo() {
		driver.switchTo().frame(0);
	}

	protected final WebElement currentAge() {
		return driver
				.findElement(By.xpath("//div[contains(@model,'ctrl.data.CurrentAge')]//input[contains(@type,'text')]"));
	}

	protected final WebElement employmentStatus() {
		return driver.findElement(By.xpath(
				"//div[contains(@ng-model,'ctrl.data.EmploymentStatus')]//div[contains(@class,'well-value ng-binding')]"));
	};

	protected final WebElement salary() {
		return driver.findElement(By.xpath("//div[contains(@model,'ctrl.data.AnnualIncome')]//input[@type='text']"));
	}

	protected final WebElement currentKiwisaverBalance() {
		return driver.findElement(By.xpath(
				"//div[contains(@model,'ctrl.data.KiwiSaverBalance')]//input[contains(@placeholder,'Optional')]"));
	}

	protected final WebElement voluntaryContributions() {
		return driver.findElement(By.xpath(
				"//div[contains(@class,'control-with-period control-with-prefix currency-control')]//input[contains(@placeholder,'Optional')]"));
	}

	protected final WebElement voluntaryContributionsFrequency() {
		return driver.findElement(By.xpath(
				"//div[@class='wpnib-field-voluntary-contributions field-group ng-isolate-scope']//div[@class='ng-scope ng-isolate-scope ng-pristine ng-valid wpnib-drop-down']//div[1]//div[1]//div[1]"));
	}

	protected final WebElement savingsGoalAtRetirement() {
		return driver.findElement(
				By.xpath("//div[contains(@model,'ctrl.data.SavingsGoal')]//input[contains(@placeholder,'Optional')]"));
	}

	protected final WebElement submit() {
		return driver.findElement(By.xpath("//span[normalize-space()='View your KiwiSaver retirement projections']"));
	}

	protected final WebElement currentAgeInfo() {
		return driver.findElement(By.xpath("//div[contains(@help-id,'CurrentAge')]//i[contains(@class,'icon')]"));
	}

	public final void clickCurrentAgeInfo() {
		currentAgeInfo().click();
	}

	public final WebElement currentAgeInfoHelp() {
		return driver.findElement(
				By.xpath("//*[@id='widget']/div/div[1]/div/div[1]/div/div[1]/div/div/div/div[2]/div[1]/div[2]/div/p"));
	}

	public String _currentAgeInfoHelpText = "This calculator has an age limit of 64 years old as you need to be under the age of 65 to join KiwiSaver.";
	//public String _currentAgeInfoHelpText = "This calculator has an age limit of 18 to 64 years old.";

	public final void IsValidCurrentAgeHelpTextDisplayed() {
		Assert.assertEquals(currentAgeInfoHelp().getText(), _currentAgeInfoHelpText);
	}

	public final void IsValidProjection(int expectedValue) {
		String actualValue = projection().getText().replaceAll("[^0-9]", "");
		SoftAssert softAssertion = new SoftAssert();
		softAssertion.assertEquals(actualValue, expectedValue);
	}

	protected final WebElement projection() {
		return driver.findElement(By.xpath("//span[@class='result-value result-currency ng-binding']"));
	}

	public final void SetFrequency(Frequency value) {
		if (value != Frequency.None) {
			voluntaryContributionsFrequency().click();
		}

		switch (value) {
		case Weekly:
			driver.findElement(By.xpath(String.format("//li[contains(@value,'week')]//div[contains(@class,'label')]")))
					.click();
			break;
		case Fortnightly:
			driver.findElement(By.xpath(String.format("//span[normalize-space()='Fortnightly']"))).click();
			break;
		case Monthly:
			driver.findElement(By.xpath(String.format("//span[normalize-space()='Monthly']"))).click();
			break;
		case Annually:
			driver.findElement(By.xpath(String.format("//span[normalize-space()='Annually']"))).click();
			break;
		}
	}

	public final void SetEmploymentStatus(EmploymentStatus value) {
		if (value != EmploymentStatus.None) {
			employmentStatus().click();
		}
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		String path = "//span[normalize-space()=";
		switch (value) {
		case Employed:
			driver.findElement(By.xpath(path + "'Employed']")).click();
			break;
		case SelfEmployed:
			driver.findElement(By.xpath(path + "'Self-employed']")).click();
			break;
		case NotEmployed:
			driver.findElement(By.xpath(path + "'Not employed']")).click();
			break;
		}
	}

	public final void SetKiwimemberContribution(KiwiMemberContribution value) {
		var path = "radio-option-04";
		switch (value) {
		case ThreePercent:
			driver.findElement(By.id(path + "C")).click();
			break;
		case FourPercent:
			driver.findElement(By.id(path + "F")).click();
			break;
		case SixPercent:
			driver.findElement(By.id(path + "I")).click();
			break;
		case EightPercent:
			driver.findElement(By.id(path + "L")).click();
			break;
		case TenPercent:
			driver.findElement(By.id(path + "O")).click();
			break;

		}
	}

	public final void SetRiskProfile(RiskProfile value) {
		var path = "//*[@id='radio-option";
		switch (value) {
		case Defensive:
			driver.findElement(By.xpath(path + "-013']")).click();
			break;
		case Conservative:
			driver.findElement(By.xpath(path + "-016']")).click();
			break;
		case Balanced:
			driver.findElement(By.xpath(path + "-019']")).click();
			break;
		case Growth:
			driver.findElement(By.xpath(path + "-01C']")).click();
			break;
		}
	}

}