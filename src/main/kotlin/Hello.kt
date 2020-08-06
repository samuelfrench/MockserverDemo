package hello
import khttp.get
import java.io.FileInputStream
import java.util.*

//TODO NEXT STEP: convert docker to be using docker compose
//https://www.mock-server.com/mock_server/running_mock_server.html#docker_container

fun main(args : Array<String>) {
    waitForMockserverToStartUp()
    println(getCurrentUnixTime())
}

private fun waitForMockserverToStartUp() {
    Thread.sleep(5000);
}

fun getCurrentUnixTime(): Long {
    val props = Properties()
    props.load(FileInputStream("mockserverdemo.properties"))
    println("debug: property file used: " + props.getProperty("timeApiUrl"))
    return get(props.getProperty("timeApiUrl")).jsonObject.getLong("unixtime")
}

