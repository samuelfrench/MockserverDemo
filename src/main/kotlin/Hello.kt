package hello
import khttp.get
import java.io.FileInputStream
import java.util.*

//TODO NEXT STEP: Add in mockserver container to work with current docker flow
//https://www.mock-server.com/mock_server/running_mock_server.html#docker_container

fun main(args : Array<String>) {
    println(getCurrentUnixTime())
}

fun getCurrentUnixTime(): Long {
    val props = Properties()
    props.load(FileInputStream("mockserver.properties"))
    return get(props.getProperty("timeApiUrl")).jsonObject.getLong("unixtime")
}

