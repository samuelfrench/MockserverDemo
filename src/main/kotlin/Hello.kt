package hello
import khttp.get
import java.io.FileInputStream
import java.util.*

fun main(args : Array<String>) {
    println(getCurrentUnixTime())
}

fun getCurrentUnixTime(): Long {
    val props = Properties()
    props.load(FileInputStream("mockserver.properties"))
    return get(props.getProperty("timeApiUrl")).jsonObject.getLong("unixtime")
}

