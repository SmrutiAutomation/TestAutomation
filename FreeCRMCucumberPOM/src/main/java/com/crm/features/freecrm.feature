Feature: Free CRM Application Test

@SmokeTest
Scenario: Validate Free CRM Home Page Test
Given user opens browser
When user is on login screen
Then user logged in Successfully
Then validate home page title
Then validate logged in username
Then validate user successfully logged out


@RegressionTest
Scenario: Create A New Calendar And Verify In The Table
Given user opens browser
When user is on login screen
Then user logged in Successfully
Then validate home page title
Then validate logged in username
Then validate calendar tab and click on that
Then Create A New Calendar From Calendar Tab
|New Calendar|Smruti Ranjan Sahoo|Meeting|Test CRM|Create New Calendar|India|New CRM|Discussion|Mutual Agreement|30 Minutes|Email|15|Smruti Ranjan Sahoo|My Brother|Syntel Pvt. Ltd.|Manager of the Company|










