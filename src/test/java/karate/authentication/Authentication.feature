Feature: Authenticaion Test

# endpoints
# GET /user/login: Accepts username, password in the body response
# POST /user/: Creates a new user based off of a JSON response.


	Background:
	* url baseUrl
	* def authBase = '/user/'
	
	
	Scenario: Create a new Account based off of user information
		Given path authBase
		And request {'username':'andrew', 'password':'test','isTechAgent':'false'}
		And header Accept = 'application/json'
		When method post
		Then Status 201
		And match response == {'username':'andrew', 'password':'test','isTechAgent':'false'}
		
	Scenario: Create another Account
		Given path authBase
		And request {'username':'LanChi', 'password':'test2','isTechAgent':'true'}
		And header Accept = 'application/json'
		When method post
		Then Status 201
		And match response == {'username':'LanChi', 'password':'test2','isTechAgent':'true'}
	
	Scenario: Login to an account with correct information
		Given path authBase + 'login'
		And request {'username':'LanChi', 'password':'test2'}
		When method GET
		Then status 200
		And match response == {'username':'LanChi', 'password':'test2','isTechAgent':'true'}
		
	Scenario: Login to an account with incorrect username
		Given path authBase + 'login'
		And request {'username':'Andrew', 'password':'test'}
		When method GET
		Then status 404
		
	Scenario: Login to an account with incorrect password
		Given path authBase + 'login'
		And request {'username':'andrew', 'password':'test2'}
		When method GET
		Then status 404