package edu.uiowa.cs.team5


import com.google.gson.Gson;
import java.io.*
import com.google.gson.reflect.TypeToken
import edu.uiowa.cs.team5.Patron.Companion.patronList
import edu.uiowa.cs.team5.Survey.Companion.surveyList
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle


class FileHandler {


    // all the  address
    private val patronFile = File("Data/patronFile.txt")
    private val logFile = File("Data/logFile.txt")

    init{
        if (!patronFile.exists()) patronFile.parentFile.mkdirs();patronFile.createNewFile()
        if (!logFile.exists()) logFile.parentFile.mkdirs();logFile.createNewFile()
    }

    //gson object
    val gson = Gson()

    //helper function for gson
    inline fun <reified T> Gson.fromJson(json: String) = this.fromJson<T>(json, object: TypeToken<T>() {}.type)


    //get current time
    fun getTime(): String{
        val current = LocalDateTime.now()
        val formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT)
        return current.format(formatter)
    }

    //writer method
    fun writeLoginHistory(data: String, succeed: Boolean){
        if (!succeed) {
            logFile.appendText("${getTime()} Login attempt: $data\n")
        }
        else logFile.appendText("${getTime()} Login succeed: $data\n")
    }

    fun writeCreateHistory(data: String, succeed: Boolean){
        if (!succeed) {
            logFile.appendText("${getTime()} Create attempt: $data\n")
        }
        else logFile.appendText("${getTime()} Create succeed: $data\n")
    }

    fun writePatrons(){
        patronFile.writeText(gson.toJson(patronList))
    }

    //reader method
    fun readPatrons(): PatronList {
        val jsonText = patronFile.readText()
        if (jsonText.length > Integer(0).toLong()){
            return gson.fromJson<PatronList>(jsonText)
        }
        return PatronList()
    }

    fun readLog():String{
        return logFile.readText()
    }

}
