Feature: Login into Application

Scenario Outline: positive test validating login

Given Initialize the browser with chrome
And Navigate to "https://qaclickacademy.com" site
And Click on Login link in home page to loand on secure sign in page
When user enter <username> and <password> and logs in
Then verify that user is successfully logged in
And close browsers

Examples:
|username                  |password  |
|test99@gmail.com          |123456    |
|test123@gmail.com         |1234      |

