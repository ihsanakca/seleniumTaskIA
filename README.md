# Introduction
Multifactor authentication  
You have received a request to automate a platform authentication process. The platform has a multifactor authentication mechanism and this mechanism requires providing:
- an email address,
- a code from an external page,
- a masked password.
The steps on the test page have already been prepared by a manual QA. Your job is to implement a few methods in the SeleniumExecutor class, which should use the Selenium WebDriver to perform the below tasks on the page from the src/test/resources/__files/index.html page. 

# Problem Statement
1. In the `SetLoginAndClickNext(String login)` method: pass a variable to the login field and click the `Next` button.
2. In the `OpenCodePageAndReturnCode()` method: open another page using the 'open page' link. Get the code from the opened page and return it.
3. In the `SetCodeAndClickNext(String code)`method: pass the taken code to the code field and click the `Next` button.
4. In the `FillMaskedPasswordAndClickLogin(String password)` method: fill in the masked password fields and click the ‘Log in’ button.
5. In the `GetLoggedInText()`method: get the text displayed upon positive logging in.

# Hints
- If you are using an in-browser editor, download the code in order to open the page locally. The files are in the src/test/resources/__files folder.
- Do not try to break/unblock/bypass the steps by changing the javascript.
- Be aware that the fields on the masked password page are randomly masked.

# Setup
- You can assume that the page has already been loaded by the driver.
