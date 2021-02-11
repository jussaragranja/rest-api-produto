package br.com.jussara.apirest.produto.rest.config;

import io.restassured.RestAssured;
import io.restassured.config.ConnectionConfig;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SetupTest {

    @LocalServerPort
    int port;

    @Before
    public void before(){
        RestAssured.port = port;
        RestAssured.config().connectionConfig(new ConnectionConfig().closeIdleConnectionsAfterEachResponse());
    }
}
