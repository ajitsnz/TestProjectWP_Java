package tests;

import com.automation.remarks.video.annotations.Video;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import dictionaries.EmploymentStatus;
import dictionaries.Frequency;
import dictionaries.KiwiMemberContribution;
import dictionaries.RiskProfile;
import models.User;
import pages.KiwisaverCalculatorPage;

public class KiwiSaverCalculatorTests extends BaseTest
{

	@BeforeMethod
	public void SetUp() {}
    
	@Test
	public final void VerifyCurrentAgeHelpText()
	{
		KiwisaverCalculatorPage kiwiSaverCalculator = new KiwisaverCalculatorPage(driver);
		kiwiSaverCalculator.clickCurrentAgeInfo();
		kiwiSaverCalculator.IsValidCurrentAgeHelpTextDisplayed();
	}

	@Video
	@Test(description = "Kiwisaver projected balance for user", dataProvider = "KSTestData")
	public void SubmitFormWithAllParametersTest(User user) throws Exception {
		var kiwisaverCalculator = new KiwisaverCalculatorPage(driver);
		kiwisaverCalculator.FillKiwisaverRetirementCalculator(user);
		kiwisaverCalculator.Submit();
		kiwisaverCalculator.IsValidProjection(user.projection);
	}
	
	/*I want that the KiwiSaver Retirement Calculator 
	 * users are able to calculate what their KiwiSaver projected balance would be at retirement */

	@DataProvider(name = "KSTestData")
	public Object[][] provideData() {
		return new Object[][] {
				{ new User(30, EmploymentStatus.Employed, 0, 0, Frequency.None, RiskProfile.Defensive, 0, KiwiMemberContribution.FourPercent, 82000, 436365)}
				,{ new User(45, EmploymentStatus.SelfEmployed, 100000, 90, Frequency.Fortnightly, RiskProfile.Conservative, 290000, KiwiMemberContribution.None, 0, 259581)}
				,{ new User(55, EmploymentStatus.NotEmployed, 140000, 10, Frequency.Annually, RiskProfile.Balanced, 200000, KiwiMemberContribution.None, 0, 197679)} 
				};
		}
}