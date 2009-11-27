package action

import scala.io.Source
import scala.util.matching.Regex

import domain.Link

/**
 *
 */
object LinkParser {
	val Regex = """.*\<a.+href=\"(.*)\".*\>(.*)\<\/a\>.*""".r

	def parse(sourceUrl: String, source: Source) : List[Link] = {
		val markup = source.mkString;
		var lst: List[Link] = Nil
		Regex.findAllIn(markup).foreach { htmlLink:String => 
			htmlLink match {
				case Regex(url, desc) =>  {
					val link = new Link(sourceUrl, url, desc)
					lst = link :: lst
				} 
				case _ => lst
			}
		}
		lst
	}
}
