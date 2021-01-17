$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("C:/Selenium Setup/FreeCRMCucumberPOM/src/main/java/com/crm/features/freecrm.feature");
formatter.feature({
  "line": 1,
  "name": "Free CRM Application Test",
  "description": "",
  "id": "free-crm-application-test",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 14,
  "name": "Create A New Calendar And Verify In The Table",
  "description": "",
  "id": "free-crm-application-test;create-a-new-calendar-and-verify-in-the-table",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 13,
      "name": "@RegressionTest"
    }
  ]
});
formatter.step({
  "line": 15,
  "name": "user opens browser",
  "keyword": "Given "
});
formatter.step({
  "line": 16,
  "name": "user is on login screen",
  "keyword": "When "
});
formatter.step({
  "line": 17,
  "name": "user logged in Successfully",
  "keyword": "Then "
});
formatter.step({
  "line": 18,
  "name": "validate home page title",
  "keyword": "Then "
});
formatter.step({
  "line": 19,
  "name": "validate logged in username",
  "keyword": "Then "
});
formatter.step({
  "line": 20,
  "name": "validate calendar tab and click on that",
  "keyword": "Then "
});
formatter.step({
  "line": 21,
  "name": "Create A New Calendar From Calendar Tab",
  "rows": [
    {
      "cells": [
        "New Calendar",
        "Smruti Ranjan Sahoo",
        "Meeting",
        "Test CRM",
        "Create New Calendar",
        "India",
        "New CRM",
        "Discussion",
        "Mutual Agreement",
        "30 Minutes",
        "Email",
        "15",
        "Smruti Ranjan Sahoo",
        "My Brother",
        "Syntel Pvt. Ltd.",
        "Manager of the Company"
      ],
      "line": 22
    }
  ],
  "keyword": "Then "
});
formatter.match({
  "location": "HomePageSteps.user_opens_browser()"
});
formatter.result({
  "duration": 60742700033,
  "status": "passed"
});
formatter.match({
  "location": "HomePageSteps.user_is_on_login_screen()"
});
formatter.result({
  "duration": 54039454752,
  "status": "passed"
});
formatter.match({
  "location": "HomePageSteps.user_logged_in_Successfully()"
});
formatter.result({
  "duration": 11025155798,
  "status": "passed"
});
formatter.match({
  "location": "HomePageSteps.validate_home_page_title()"
});
formatter.result({
  "duration": 15025315,
  "status": "passed"
});
formatter.match({
  "location": "HomePageSteps.validate_logged_in_username()"
});
formatter.result({
  "duration": 688555130,
  "status": "passed"
});
formatter.match({
  "location": "CalenderCreationSteps.validate_calendar_tab_and_click_on_that()"
});
formatter.result({
  "duration": 2120716058,
  "status": "passed"
});
formatter.match({
  "location": "CalenderCreationSteps.Create_A_New_Calendar_From_Calendar_Tab(DataTable)"
});
formatter.result({
  "duration": 6877857440,
  "status": "passed"
});
});