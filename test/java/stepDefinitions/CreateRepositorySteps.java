//package stepDefinitions;
//
//import io.cucumber.java.en.When;
//import io.cucumber.java.en.Then;
//import io.restassured.response.Response;
//import static org.hamcrest.Matchers.equalTo;
//
//public class CreateRepositorySteps  {
//
//    private Response response;
//
//    @When("User sends a {string} request to {string} with the following JSON:")
//    public void user_sends_request_with_json(String method, String endpoint, String jsonBody) {
//        if (method.equalsIgnoreCase("POST")) {
//            response = request.body(jsonBody).post(endpoint);
//        }
//    }
//
//    @Then("The API response status should be {int}")
//    public void api_response_status_should_be(int expectedStatus) {
//        response.then().statusCode(expectedStatus);
//    }
//
//    @Then("The response should contain {string} with {string}")
//    public void response_should_contain(String key, String expectedValue) {
//        response.then().body(key, equalTo(expectedValue));
//    }
//}
