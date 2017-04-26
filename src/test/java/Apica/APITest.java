package Apica;

import Apica.API.RestAPI;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.URISyntaxException;

public class APITest extends RestAPI {
    APITest() {
        super("hshafqat@outlook.com", "apica2017", "https://API-wpm-trial.apicasystem.com");
    }

    @Test
    public void verifyChecks() throws URISyntaxException {
        JsonPath json = (getBodyContents("/v3/checks"));
        Assert.assertEquals(json.get("enabled").toString(), "[true]");
        Assert.assertEquals(json.get("location").toString(), "[Sweden, Stockholm]");
        Assert.assertEquals(json.get("country_code").toString(), "[SE]");
        Assert.assertEquals(json.get("name").toString(), "[chrome checks]");
        Assert.assertEquals(json.get("unit").toString(), "[ms]");
    }
}
