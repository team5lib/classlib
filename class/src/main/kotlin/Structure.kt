package edu.uiowa.cs.team5

import java.util.*
import kotlin.collections.HashMap


//Patron class
open class Patron {
    var username: String
    var password: String
    var isAdmin: Boolean
    var surveyList: SurveyList

    constructor(username: String, password: String, isAdmin: Boolean) {
        this.username = username
        this.password = password
        this.isAdmin = isAdmin
        this.surveyList = SurveyList()
        if (username.trim().length < 4) throw Error("Length must >= 4")
        if (username.trim().length < username.length) throw Error("Can't start or end with space")
        if (patronList.containsKey(username)) throw Error("Username already existed")
        patronList+=this
    }

    companion object {
        var patronList = PatronList()
    }
}


//Patron helper classes and functions
inline operator fun PatronList.plusAssign(data:Patron){this[data.username] = data}
inline operator fun AdminList.plusAssign(data:Patron){this[data.username] = data}
fun patronListOf(vararg data:Patron)= hashMapOf(*(data.map { p -> Pair(p.username,p)}.toTypedArray())) as PatronList
class PatronList:HashMap<String,Patron>()
class AdminList:HashMap<String,Patron>()


//Question class
open class Question(val question: String)

//Subclasses and its helper classes of Question
class MultAnswer:HashMap<Char, String>()
class MultChoiceQuestion:Question{
    var multAnswer:MultAnswer? = null
    constructor(question: String, multAnswer: MultAnswer?=null):super(question){
        this.multAnswer = multAnswer
    }
}

class LongAnswerQuestion:Question{
    var stringAnswer:String? = null
    constructor(question: String,stringAnswer:String?=null):super(question){
        this.stringAnswer = stringAnswer
    }
}

class ScaleAnswerQuestion:Question{
    var intAnswer:Int? = null
    constructor(question: String,intAnswer: Int?=null):super(question){
        this.intAnswer = intAnswer
    }
}




//Survey object
class Survey:ArrayList<Question>{
    var id:Int
    var title:String
    constructor(title:String):super(){
        this.title = title
        this.id = title.hashCode()
        surveyList.add(this)
    }
    companion object {
        var surveyList = SurveyList()
    }
}

//Helper classes and functions for Survey
class SurveyList:ArrayList<Survey>()





