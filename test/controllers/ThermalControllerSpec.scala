package controllers

import bases.BasedSpec
import play.api.libs.json.Json
import play.api.test.FakeRequest
import play.api.test.Helpers._

class ThermalControllerSpec
  extends BasedSpec {

  s"POST $CREATE_URL" should {
    "return created JSON if success" in {
      val thermal = "42"

      val result = route(app, FakeRequest(POST, CREATE_URL)
        .withJsonBody(Json.parse(
          s"""
             |{
             | "sensor_id" : "atdkjfadfadfs",
             | "thermal" : "$thermal"
             |}
             | """.stripMargin)
        ))
        .get

      status(result) mustBe OK
      contentType(result) mustBe Some("application/json")
      contentAsString(result) must include(thermal)
    }
  }

  private lazy val CREATE_URL = "/api/v1/thermal"

}
