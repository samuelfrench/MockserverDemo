package hello
import khttp.get
import java.io.FileInputStream
import java.util.*

fun main(args : Array<String>) {getTimeJsonString()
}

fun getTimeJsonString(): String {
    val props = Properties()
    props.load(FileInputStream("mockserver.properties"))
    return get(props.getProperty("timeApiUrl")).text
}

