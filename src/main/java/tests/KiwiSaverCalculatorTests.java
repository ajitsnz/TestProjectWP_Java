package tests;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Iterator;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.automation.remarks.video.annotations.Video;

import dictionaries.EmploymentStatus;
import dictionaries.Frequency;
import dictionaries.KiwiMemberContribution;
import dictionaries.RiskProfile;
import helpers.CsvReader;
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
	
	//I want that the KiwiSaver Retirement Calculator  users are able to calculate what their KiwiSaver projected balance would be at retirement 

	@DataProvider(name = "KSTestData")
	public Object[][] provideData() {
		return new Object[][] {
				{ new User(30, EmploymentStatus.Employed, 820000, KiwiMemberContribution.FourPercent,0, 0,Frequency.None, RiskProfile.Defensive, 0,  436365)}
				,{ new User(45, EmploymentStatus.SelfEmployed, 0, KiwiMemberContribution.None,100000, 90, Frequency.Fortnightly, RiskProfile.Conservative, 290000, 259581)}
				,{ new User(55, EmploymentStatus.NotEmployed, 0, KiwiMemberContribution.None, 140000, 10, Frequency.Annually, RiskProfile.Balanced, 200000, 197679)} 
				};
		}

	
	
	@Video
	@Test(description = "Data Driven - Kiwisaver projected balance for user", dataProvider = "csvDataProvider")
	public void CsvExampleTestWithExpectedResult(String _currentAge, String _empStatus,  String _salary,  String _kiwiMemberContribution, String _currentKiwisaverBalance, String _voluntaryContributions, 
			String _vcfrequency, String _riskProfile, String _savingsGoalAtRetirement,String _projection) throws Exception {
		
		EmploymentStatus employmentStatus = _empStatus.isEmpty() ? EmploymentStatus.None : EmploymentStatus.valueOf(_empStatus);
		Frequency voluntaryContributionsFrequency = _vcfrequency.isEmpty() ? Frequency.None : Frequency.valueOf(_vcfrequency);
		RiskProfile riskProfile = _riskProfile.isEmpty() ? RiskProfile.None : RiskProfile.valueOf(_riskProfile);
		KiwiMemberContribution kiwiMemberContribution = _kiwiMemberContribution.isEmpty() ? KiwiMemberContribution.None : KiwiMemberContribution.valueOf(_kiwiMemberContribution);

		int currentAge = _currentAge.isEmpty() ? 0 : Integer.parseInt(_currentAge);
		int currentKiwisaverBalance = _currentKiwisaverBalance.isEmpty() ? 0 : Integer.parseInt(_currentKiwisaverBalance);
		int voluntaryContributions = _voluntaryContributions.isEmpty() ? 0 : Integer.parseInt(_voluntaryContributions);
		int savingsGoalAtRetirement = _savingsGoalAtRetirement.isEmpty() ? 0 : Integer.parseInt(_savingsGoalAtRetirement);
		int salary = _salary.isEmpty() ? 0 : Integer.parseInt(_salary);
		int projection = _projection =="" ? 0 : Integer.parseInt(_projection);
		
		var user =  new User(currentAge, employmentStatus, salary, kiwiMemberContribution, currentKiwisaverBalance, voluntaryContributions, voluntaryContributionsFrequency, riskProfile, savingsGoalAtRetirement, projection);
	
		var kiwisaverCalculatorPage = new KiwisaverCalculatorPage(driver);
		kiwisaverCalculatorPage.FillKiwisaverRetirementCalculator(user);
		kiwisaverCalculatorPage.Submit();
		kiwisaverCalculatorPage.IsValidProjection(user.projection);
	}
	
	
	@DataProvider(name = "csvDataProvider")
	public Iterator<Object[]> testData() throws IOException {
		return CsvReader.parseCsvData(Paths.get("").toAbsolutePath().toString() + "\\src\\main\\java\\testData\\KS_TestData.csv");
	}
	
}