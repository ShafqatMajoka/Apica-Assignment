package Apica.API;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import java.net.URI;
import java.net.URISyntaxException;

 public  class  RestAPI  {
    String userName;
    String password;
    String baseURL;
    public RestAPI(String userName, String password,String baseURL){
        this.userName = userName;
        this.password = password;
        this.baseURL = baseURL;
    }
   RestAPI(){}
   protected JsonPath getBodyContents(String pathExtension) throws URISyntaxException {
    return new JsonPath(
            RestAssured.given()
               .auth()
               .basic(userName, password)
               .when()
               .get(new URI(baseURL+pathExtension))
               .thenReturn()
               .body()
               .asString()
       );
   }
}
