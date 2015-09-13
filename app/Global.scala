import play.api._
import models.User

object Global extends GlobalSettings {
  
  override def onStart(app: Application) {
    InitialData.insert()
  }
}

/**
 * Initialize test data
 */
object InitialData {

  def insert() = {
    if (User.findAll.isEmpty) {
      Seq(
        User("noah1@example.com", "Noah One", "test"),
        User("noah2@company.com", "Noah Two", "test"),
        User("noah3@company.com", "Noah Three", "test")
      ).foreach(User.create)
    }
  }

}