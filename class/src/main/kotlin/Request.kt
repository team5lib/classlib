package edu.uiowa.cs.team5

data class LoginRequest(val username: String, val password: String)
data class CreateRequest(val username: String, val password: String)
data class SurveyRequest(val username: String, val password: String)
data class SubmitRequest(val username: String, val surveylist: SurveyList)

