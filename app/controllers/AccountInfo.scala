package controllers

import play.api.mvc.{AnyContent, Request, Controller}
import models.User
import views._

object AccountInfo extends Controller with Secured {

  /**
   * Display accountinfo area only if user is logged in.
   */
  def index = IsAuthenticated { (username: String, request: Request[AnyContent]) =>
      User.findByEmail(username).map { user =>
        Ok(
          html.accountinfo(user)
        )
      }.getOrElse(Forbidden)
  }
    
}