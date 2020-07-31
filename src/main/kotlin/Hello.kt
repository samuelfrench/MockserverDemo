package hello
import khttp.get
import java.io.FileInputStream
import java.util.*

fun getHelloString() : String {
    return "Hello, world!"
}

fun main(args : Array<String>) {
    println(getHelloString())

    getTimeJsonString()
}

fun getTimeJsonString(): String {
    val props = Properties()
    props.load(FileInputStream("mockserver.properties"))
    return get(props.getProperty("timeApiUrl")).text
}

