package models;

import dictionaries.*;

public class User
{
	public int currentAge;
	public EmploymentStatus employmentStatus = EmploymentStatus.None;
	public int currentKiwiBalance;
	public int voluntaryContributions;
	public Frequency vcFrequency = Frequency.None;
	public RiskProfile riskProfile = RiskProfile.None;
	public int savingsGoalAtRetirement;
	public KiwiMemberContribution kiwiMemberContribution = KiwiMemberContribution.None;
	public int salary;
	public int projection;

	public User(int _currentAge, EmploymentStatus _employmentStatus,int _salary, KiwiMemberContribution _kiwiMemberContribution, int _currentKiwisaverBalance, int _voluntaryContributions, Frequency _voluntaryContributionsFrequency, RiskProfile _RiskProfile, int _savingsGoalAtRetirement, int _projection)
	{
		currentAge = _currentAge;
		employmentStatus = _employmentStatus;
		if (_employmentStatus == EmploymentStatus.Employed)
		{
			salary = _salary;
			kiwiMemberContribution = _kiwiMemberContribution;
		}
		currentKiwiBalance = _currentKiwisaverBalance;
		voluntaryContributions = _voluntaryContributions;
		vcFrequency = _voluntaryContributionsFrequency;
		riskProfile = _RiskProfile;
		savingsGoalAtRetirement = _savingsGoalAtRetirement;
		projection = _projection;
	}

	public final void CreateRandomIndividual(int _currentAge, EmploymentStatus _employmentStatus, int _currentKiwisaverBalance, int _voluntaryContributions, Frequency _voluntaryContributionsFrequency, RiskProfile _RiskProfile, int _savingsGoalAtRetirement, KiwiMemberContribution _kiwiMemberContribution, int _salary)
	{
		/*CurrentAge = _currentAge != 0 ? _currentAge : TestContext.CurrentContext.Random.NextUInt(18, 64);
		EmploymentStatus = _employmentStatus != EmploymentStatus.None ? _employmentStatus : EmploymentStatus.Employed;
		CurrentKiwiBalance = _currentKiwisaverBalance != 0 ? _currentKiwisaverBalance : TestContext.CurrentContext.Random.NextUInt();
		VoluntaryContributions = _voluntaryContributions != 0 ? _voluntaryContributions : TestContext.CurrentContext.Random.NextUInt(1000);
		VCFrequency = _voluntaryContributionsFrequency != Frequency.None ? _voluntaryContributionsFrequency : Frequency.Fortnightly;
		RiskProfile = _RiskProfile != RiskProfile.None ? _RiskProfile : RiskProfile.Growth;
		SavingsGoalAtRetirement = _savingsGoalAtRetirement != 0 ? _savingsGoalAtRetirement : TestContext.CurrentContext.Random.NextUInt();

		if (_employmentStatus == EmploymentStatus.Employed)
		{
			Salary = _salary != 0 ? _salary : TestContext.CurrentContext.Random.NextUInt();
			KiwiMemberContribution = _kiwiMemberContribution != KiwiMemberContribution.None ? _kiwiMemberContribution : KiwiMemberContribution.ThreePercent;
        }
        */
	}
}