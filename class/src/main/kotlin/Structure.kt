package edu.uiowa.cs.team5

import java.util.*
import kotlin.collections.HashMap


//Patron class
open class Patron {
    var username: String
    var password: String
    var surveyList: SurveyList

    constructor(username: String, password: String, isAdmin: Boolean) {
        this.username = username
        this.password = password
        this.surveyList = SurveyList()
        if (username.trim().length < 4) throw Error("Length must >= 4")
        if (username.trim().length < username.length) throw Error("Can't start or end with space")
        if (patronList.containsKey(username)) throw Error("Username already existed")
        patronList+=this
        if (isAdmin) adminList+=this
    }

    companion object {
        var patronList = PatronList()
        var adminList = AdminList()
    }
}


//Patron helper classes and functions
inline operator fun PatronList.plusAssign(data:Patron){this[data.username] = data}
inline operator fun AdminList.plusAssign(data:Patron){this[data.username] = data}
fun patronListOf(vararg data:Patron)= hashMapOf(*(data.map { p -> Pair(p.username,p)}.toTypedArray())) as PatronList
class PatronList:HashMap<String,Patron>()
class AdminList:HashMap<String,Patron>()


//Question class
open class Question(var question: String, var answer: String = "null", var stage: Int)


//Survey object
class Survey{
    var title:String = "null"
    var questionList = ArrayList<Question>()

    constructor(title:String):super(){
        this.title = title
    }
    companion object {
        var surveyList = SurveyList()
    }
}

//Helper classes and functions for Survey
class SurveyList:ArrayList<Survey>()





