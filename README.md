# Java
language Java 

Used TestNG 

IDE - Eclipse and VsCode can be used. 

Features : 
0) Less Abstract framework & can used for API & Website Testing

1) Data driven 
 a) from data file
 
 b) Inline 
eg  User whose Current age is 30 is Employed @ a Salary 82000 p/a, contributes to KiwiSaver @ 4% and chooses a Defensive risk profile can calculate his projected balances at retirement.

==> new User(_currentAge, _employmentStatus, _currentKiwisaverBalance, _voluntaryContributions, _voluntaryContributionsFrequency, _RiskProfile, _savingsGoalAtRetirement, _kiwiMemberContribution, _salary, Expected _projection) 

Example ==> new User(30, EmploymentStatus.Employed, 0, 0, Frequency.None, RiskProfile.Defensive, 0, KiwiMemberContribution.FourPercent, 82000, 436365)


2) Cross Browser 
- Chrome, firefox, Edge etc.. 
-- examples 
    - testngAllBrowsers.xml 
    - testngChrome.xml
    - testngEdge.xml
    - testngFirefox.xml
    - testngPhantomJs.xml

3) Screeshots 

4) Video Recording  @video (tag) 

5) Detailed logging & Allure reporting 
- with screenshots etc.. 

