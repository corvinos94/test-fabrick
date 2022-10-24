package it.frabrick;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.number.OrderingComparison.greaterThan;

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
public class CashTransactionsRestControllerTest {
	
    @Value("${local.server.port}")
    int port;

    @Before
    public void setUp() throws Exception {
        RestAssured.port = port;
    }

    @Test
    public void test() throws Exception {
        given().pathParam("accountId", "14537780").queryParam("fromAccountingDate", "2019-01-01").queryParam("toAccountingDate", "2019-12-01")
    	.when().get("/api/cash-transactions/{accountId}").then()
        	.statusCode(200)
        	.assertThat().body("status", equalTo("OK"))
        	.assertThat().body("list.size()", greaterThan(0));
    }
}