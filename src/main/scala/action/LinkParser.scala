package action

import scala.io.Source
import scala.util.matching.Regex
import scala.xml._

import domain.Link

/**
 *
 */
object LinkParser {
 
	def parse(sourceUrl: String, source: Source) : List[Link] = {
		var lst: List[Link] = Nil
		val data = XML.loadString(source.mkString)
  
		for(val entry <- data \\ "a") {
			val href = (entry \\ "@href").text
			println(href)
		}
		lst
	}
}
