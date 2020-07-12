Feature: SignIn Test Cases

Scenario Outline: SignIn page validation
Given User is on Sign In page
When user clicks on Language drop down
Then user should be dispalyed with English and Dutch
And  user enters "<username>" and "<organization>" 
Then user input "<emailAddress>"
Then user clicks on terms and conditions checkbox
And user clicks on sign up button
Then user will login with "<emailAddress>" and "<password>" to check email received

Examples:
       | username | organization | emailAddress | password |
       | Rajni    | Rajni        | rajni2193verma@gmail.com | Yuvraj123# |

