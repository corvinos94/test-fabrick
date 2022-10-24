package it.frabrick;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = TestFabrickApplication.class)
@WebAppConfiguration
public class CashTransferRestControllerTest {
	
    @Value("${local.server.port}")
    int port;

    private Map<String, String> request;
    
    @Before
    public void setUp() throws Exception {
        RestAssured.port = port;
        request = new HashMap<>();
        request.put("accountId", "14537780");
        request.put("receiverName", "John Doe");
        request.put("description", "Payment invoice 75/2017");
        request.put("currency", "EUR");
        request.put("amount", "800");
        request.put("executionDate", getToday());
        request.put("accountCode", "IT23A0336844430152923804660");
    }

    @Test
    public void test() throws Exception {
        given().contentType(ContentType.JSON).body(request)
    	.when().post("/api/money-transfer").then()
        	.statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
        	.assertThat().body("status", equalTo("KO"));
    }
    
    private String getToday() {
    	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    	return format.format(new Date());
    }
}