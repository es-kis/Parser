import java.io.{BufferedWriter, File, FileWriter}

object InfoProcessing {
  def getFullName(str: String): String = {
    val regex = "(?<=Full name: )(.*)(?= Gender)".r
    val fullName = (regex findAllIn str).mkString("")
    fullName
  }

  def getGender(str: String): String = {
    val regex = "(?<=Gender: )(.*)(?= Country)".r
    val gender = (regex findAllIn str).mkString("")
    gender
  }

  def getCountry(str: String): String = {
    val regex = "(?<=Country: )(.*)(?= Terms)".r
    val country = (regex findAllIn str).mkString("")
    country
  }

  def getTerms(str: String): String = {
    var terms = "No Information"
    if (str.contains("Preceded by")) {
      val regex = "(?<=Terms: )(.*)(?= Preceded by)".r
      terms = (regex findAllIn str).mkString("")
    }
    else if (str.contains("Succeeded by")) {
      val regex = "(?<=Terms: )(.*)(?= Succeeded by)".r
      terms = (regex findAllIn str).mkString("")
    }
    else if (str.contains("Political Party")) {
      val regex = "(?<=Terms: )(.*)(?= Political Party)".r
      terms = (regex findAllIn str).mkString("")
    }
    terms
  }

  def getParty(str: String): String = {
    var polParty = "No information"
    if (str.contains("Other Political Titles")) {
      val regex = "(?<=Political Party: )(.*)(?= Other Political Titles)".r
      polParty = (regex findAllIn str).mkString("")
    }
    else if (str.contains("Political Party")) {
      val regex = "(?<=Political Party: )(.*)(?= Date of Birth)".r
      polParty = (regex findAllIn str).mkString("")
    }
    polParty
  }

  def getBirth(str: String): String = {
    val regex = "(?<=Date of Birth: )(.*)(?= Birth Place)".r
    val birth = (regex findAllIn str).mkString("")
    birth
  }

  def getEducation(str: String): String = {
    var education = "No information"
    if (str.contains("Education")) {
      val regex = "(?<=Education: )(.*)(?= END)".r
      education = (regex findAllIn str).mkString("")
    }
    education
  }

  def writeFile(json: String, path: String): Unit = {
    val file = new File(path)
    val buffer = new BufferedWriter(new FileWriter(file))
    buffer.write(json)
    buffer.close()
  }
}


