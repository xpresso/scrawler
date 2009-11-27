import java.net.URL

import scala.io.Source
import scala.util.matching.Regex

/**
 *	An object representing a link
 */
class Link (val link: String, val description: String) {
	override def toString = {
		"Link: " + link + ", Description: " + description
	}
}

/**
 *	A simple parser. 
 *
 * This is likely not efficient nor does it perform
 * 	any tasks elegantly. 
 */
object LinkParser {
	val Regex = """.*\<a.+href=\"(.*)\".*\>(.*)\<\/a\>.*""".r
	
	def parse(source: Source) : List[Link] = {
		val markup = source.mkString;
		var lst: List[Link] = Nil
		Regex.findAllIn(markup).foreach { htmlLink:String => 
			htmlLink match {
				case Regex(url, desc) =>  {
					val link = new Link(url, desc)
					lst = link :: lst
				} 
				case _ => lst
			}
		}
		lst
	}
}

/**
*	main function to kickoff the web crawler. 
*/
val source = Source.fromURL(new URL("http://192.168.1.105/~rynmrtn/"))
val lst = LinkParser.parse(source)
lst.foreach { link => println(link.toString) }

/*for(l <- lst) {
	l.toString
}
*/