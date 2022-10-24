package it.frabrick;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.jayway.restassured.RestAssured;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = TestFabrickApplication.class)
@WebAppConfiguration
public class CashBalanceRestControllerTest {
	
    @Value("${local.server.port}")
    int port;

    @Before
    public void setUp() throws Exception {
        RestAssured.port = port;
    }

    @Test
    public void test() throws Exception {
        given().pathParam("accountId", "14537780")
    	.when().get("/api/cash-balance/{accountId}").then()
        	.statusCode(200)
        	.assertThat().body("status", equalTo("OK"))
        	.assertThat().body("date", equalTo(getToday()));
    }
    
    private String getToday() {
    	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    	return format.format(new Date());
    }
}