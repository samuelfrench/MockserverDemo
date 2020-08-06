package hello
import io.javalin.Javalin
import khttp.get
import java.io.FileInputStream
import java.util.*

fun main(args : Array<String>) {
    val props = Properties()
    props.load(FileInputStream("mockserverdemo.properties"))

    startWebServer(props)
}

private fun startWebServer(props: Properties) {
    val app = Javalin.create().start(8080)
    app.get("/test") { ctx -> ctx.result(getCurrentUnixTime(props.getProperty("test.timeApiUrl")).toString()) }
    app.get("/prod") { ctx -> ctx.result(getCurrentUnixTime(props.getProperty("prod.timeApiUrl")).toString()) }
}

private fun getCurrentUnixTime(queryUri: String): Long {
    return get(queryUri).jsonObject.getLong("unixtime")
}

