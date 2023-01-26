import java.time.Month

case class President(fullName: String, gender: String, country: String, terms: String, politicalParty: String, birthDate: String, education: String) {

  // Преобразование даты рождения в удобный формат. / Date converting.
  val splitDate = birthDate.replace(",", "").split(" ")

  // Обработка информации о стране. / Country information processing.
  val countryInfo = country.split(" \\(")

  def getMonthNumber(str: String): Int = {
    Month.valueOf(str.toUpperCase).getValue
  }

  //  Методы для обработки значений дня/месяца/года рождения. / Methods for obtaining the value of the day/month/year of birth.
  def getBirthDay(): Int = {
    val day = splitDate(1).toInt
    day
  }

  def getBirthYear(): Int = {
    val year = splitDate(2).toInt
    year
  }

  def getBirthMonth(): Int = {
    val month = getMonthNumber(splitDate(0))
    month
  }

  def getCountry(): String = {
    val countryName = countryInfo(0)
    countryName
  }

  def getPost(): String = {
    var post = "No information"
    if (country.contains("(")) post = countryInfo(1).replace(")", "")
    post
  }
}
