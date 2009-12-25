package action

import scala.io.Source
import scala.util.matching.Regex
import scala.xml._

import domain.Link

/**
 *  Singleton parser designed to take a Source and pull all
 *  links from the text of the url.
 *
 *  This is rather simplistic and finds any html anchor references
 *  with an href. 
 */
object LinkParser {

    val hrefRegex = """(\<a.*?href=\"(.*?)\".*?\>.*?\</a>)""".r

    def parse(sourceUrl: String, source: Source) : List[Link] = {
        var links : List[Link] = Nil

        hrefRegex.findAllIn(source.mkString).foreach { link : String =>
            link match {
                case hrefRegex(x, url) => {
                    links = new Link(sourceUrl, url, "") :: links
                    println(x)
                }
                case _ => { println("blank") }
            }
        }

        links
    }
}
