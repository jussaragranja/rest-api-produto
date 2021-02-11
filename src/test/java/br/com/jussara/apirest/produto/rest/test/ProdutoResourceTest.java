package br.com.jussara.apirest.produto.rest.test;

import br.com.jussara.apirest.produto.rest.config.SetupTest;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.Test;

import static br.com.jussara.apirest.produto.rest.constantes.Paths.PATH_PRODUTO_ID;
import static io.restassured.RestAssured.given;

public class ProdutoResourceTest extends SetupTest {

    @Test
    public void deveRetornar200_quandoConsultarProdutoPorID(){

        given()
                .pathParam("id", 1)
            .when()
                .get(PATH_PRODUTO_ID)
            .then()
                .contentType(ContentType.JSON)
                .statusCode(HttpStatus.SC_OK).log().all();
    }

}
