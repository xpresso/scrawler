import java.net.URL

import scala.io.Source
import scala.util.matching.Regex


val source = Source.fromURL(new URL("http://www.scala-lang.org/docu/files/api/index.html"))

/*
println(source.getLine(3))
val content = source.mkString
val VersionRegEx = """[\D\S]+scaladoc\s+\(version\s+(.+)\)[\D\S]+""".r

content match {
	case VersionRegEx(version) => println("Scala doc for version: " + version)
}
*/


val htmlMarkup = Source.fromURL(new URL("http://192.168.1.105/~rynmrtn/"))
val regex = """[\D\S]+href=\"(.*)\"[\D\S]+""".r
val markup = htmlMarkup.mkString

markup match {
	case regex(uri) => println("uri:" + uri)
	case _ => println("nothing")
}

//println(markup)
