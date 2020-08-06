package hello
import io.javalin.Javalin
import khttp.get
import java.io.FileInputStream
import java.util.*

fun main(args : Array<String>) {
    val app = Javalin.create().start(8080)
    app.get("/") { ctx -> ctx.result(getCurrentUnixTime().toString()) }
}

private fun getCurrentUnixTime(): Long {
    val props = Properties()
    props.load(FileInputStream("mockserverdemo.properties"))
    println("debug: property file used: " + props.getProperty("timeApiUrl"))
    return get(props.getProperty("timeApiUrl")).jsonObject.getLong("unixtime")
}

