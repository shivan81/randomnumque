# randomnumque
Random number question repository

Web service which can identify difference between human and bot.(As of now only client side check is made, future improvements will be to add server side 
check using public private key using recaptcha by google).

You can run the application by running RandomNumberQuestion.bat from command prompt or from eclipse or any other IDE.

You can access the application by accessing URL :"http://localhost:8080/randomNumQue.html"

If you enter the correct captacha and correct answer to the question, on submit you will get message "Correct Answer".

If you enter the correct captacha and wrong answer to the question, on submit you will get message "Wrong Answer".

If you enter wrong captcha you will get a javascript alert.

Port number for running the tomcat server can be configured in application.properties file. As of now its the default value given as 8080.

Application can be started by right clicking on the project in Eclipse and selecting the context menu and selecting run as spring boot app/java application 

Assumptions made:
Assumption made is JRE is installed on the system

Pending items:
Add server side check for bots.
Adding unit test and integration test cases.
client side validation for the text boxes.
Encrytion and decryption of request and responses.

 



