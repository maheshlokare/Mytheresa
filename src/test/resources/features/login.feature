Feature: Validate Home Screen 

Scenario Outline: Verify home screen element 
Given user navigates to website and accepts cookies
When user performs login with username "<username>" and "<password>"
Then verify user is logged in successfully 

Examples:
	| username                       | password  |
	| mahesh.lokare@maildrop.cc      | Test@1234 | 

	