package edu.uiowa.cs.team5

data class LoginResponse(val text: String, var patron: Patron?)
data class CreateResponse(val text: String, var patron: Patron?)
data class SurveyResponse(val text: String, var patron: Patron?)
data class SubmitResponse(val text: String, var patron: Patron?)