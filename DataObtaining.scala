import InfoProcessing.{writeFile}
import org.json4s._
import org.json4s.jackson.JsonMethods._
import org.json4s.JsonDSL._

object DataObtaining {
  def parseDataClass(president: President, i: Int): Unit = {

    val jsonObject = ("fullName" -> president.fullName) ~
      ("gender" -> president.gender) ~
      ("country" -> president.getCountry()) ~
      ("post" -> president.getPost()) ~
      ("terms" -> president.terms) ~
      ("politicalParty" -> president.politicalParty) ~
      ("birthDate" ->
        ("month" -> president.getBirthMonth()) ~
          ("day" -> president.getBirthDay()) ~
          ("year" -> president.getBirthYear())) ~
      ("education" -> president.education)

    writeFile(compact(render(jsonObject)), "E://JsonFiles/" + i.toString + ".json")

  }
}
