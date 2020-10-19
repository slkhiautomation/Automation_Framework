package Test.Automation.Utils;

import java.io.IOException;
import java.io.FileReader;
import java.io.IOException;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.Assert.assertEquals;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.Assert;

public class REST_GET_Action {

    static Response GETResponse;

    public static Response GETRequest(String APIUrl) throws IOException
    {
        System.out.println(APIUrl);
        GETResponse=
                given().
                when().
                get(APIUrl);
        ResponseBody body = GETResponse.getBody();
        System.out.println(body.asString());
        return GETResponse;
    }

    public static void getStatusCode(String code) throws IOException

    {
        int get_response = GETResponse.getStatusCode();
        System.out.println(get_response);
        int status= Integer.parseInt(code);
        System.out.println(status);
        assertEquals(get_response,status);

    }
}
