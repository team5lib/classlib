package edu.uiowa.cs.team5

data class LoginResponse(val textResponse: String, var userObject: Patron?)
data class CreateResponse(val textResponse: String, var userObject: Patron?)
data class SurveyResponse(val textResponse: String, var userObject: Patron?)
data class SubmitResponse(val textResponse: String, var userObject: Patron?)