import java.net.URL
import scala.io.Source

import action.LinkParser

/**
 * A main function that boostraps crawling efforts
 */
object Scrawler {
    def main(args : Array[String]) : Unit = {
        //val sourceUrl = "http://192.168.1.105/~rynmrtn/"
        val sourceUrl = "http://www.google.com/"
        val source = Source.fromURL(new URL(sourceUrl))
        val lst = LinkParser.parse(sourceUrl, source)

        println("\n" + lst.size + " links were found.\n")
        lst.foreach { link => println(link.toString) }
    }
}
