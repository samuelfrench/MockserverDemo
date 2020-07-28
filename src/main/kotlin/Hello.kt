package hello
import khttp.get

fun getHelloString() : String {
    return "Hello, world!"
}

fun main(args : Array<String>) {
    println(getHelloString())

    val r = get("http://worldtimeapi.org/api/ip")
    println(r.text)
}

