import InfoProcessing._
import DataObtaining._
import org.jsoup.Jsoup
import org.jsoup.nodes.{Document}
import org.jsoup.select.Elements

import scala.collection.JavaConversions.asScalaBuffer
import scala.collection.mutable.ListBuffer

object ParseHTML {
  def main(args: Array[String]): Unit = {
    // --- Получение списка, включащего URL каждого президента. / Getting a list with presidents URL. --- //
    val url: String = "https://www.worldpresidentsdb.com/list/"

    val doc: Document = Jsoup.connect(url).get()
    val links: Elements = doc.select("div.list-group").select("a[href]")

    val linksBuff = new ListBuffer[String]()
    for (link <- links) {
      {
        linksBuff += url.dropRight(6) + link.attr("href")
      }
    }
    val linksList = linksBuff.toList

    // --- Получение, обработка и сохранение информации о каждом президенте. / Receiving, processing and storing information about each president. --- //
    var personInfo: String = ""
    var i = 0

    for (link <- linksList) {

      val docP: Document = Jsoup.connect(link).get()
      val info: Elements = docP.select("div.col-md-8")
      personInfo = info.text() + " END"
      println(personInfo)

      val name = getFullName(personInfo)
      val gender = getGender(personInfo)
      val country = getCountry(personInfo)
      val terms = getTerms(personInfo)
      val party = getParty(personInfo)
      val birth = getBirth(personInfo)
      val education = getEducation(personInfo)

      val president = President(name, gender, country, terms, party, birth, education)
      i += 1
      parseDataClass(president, i)
    }
  }
}
