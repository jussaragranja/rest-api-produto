package br.com.jussara.apirest.produto.rest.test;

import br.com.jussara.apirest.produto.model.ProdutoModel;
import br.com.jussara.apirest.produto.rest.config.SetupTest;
import br.com.jussara.apirest.produto.rest.repository.ProdutoRepositoryTestUtil;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static br.com.jussara.apirest.produto.rest.constantes.Constantes.ID_INVALIDO;
import static br.com.jussara.apirest.produto.rest.constantes.Constantes.PATH_PARAM_ID;
import static br.com.jussara.apirest.produto.rest.constantes.Paths.PATH_PRODUTO_ID;
import static br.com.jussara.apirest.produto.rest.constantes.Paths.PATH_PRODUTO_ID_NULO;
import static io.restassured.RestAssured.given;

public class ProdutoResourceTest extends SetupTest {

    @Autowired
    private ProdutoRepositoryTestUtil produtoRepositoryTestUtil;

    @Test
    public void deveRetornar200_quandoConsultarProdutoPorId(){
        ProdutoModel produtoModel = produtoRepositoryTestUtil.findRandomProduto();

        given()
                .pathParam(PATH_PARAM_ID, produtoModel.getId())
            .when()
                .get(PATH_PRODUTO_ID)
            .then()
                .contentType(ContentType.JSON)
                .statusCode(HttpStatus.SC_OK).log().all();
    }

    @Test
    public void deveRetornar200_quandoConsultarProdutoComIdInvalido(){

        given()
            .pathParam(PATH_PARAM_ID, ID_INVALIDO)
        .when()
            .get(PATH_PRODUTO_ID)
        .then()
            .contentType(ContentType.JSON)
            .statusCode(HttpStatus.SC_BAD_REQUEST).log().all();
    }

    @Test
    public void deveRetornar200_quandoConsultarProdutoComIdInexistente(){

        //buscar ultimo id e somar +1

        given()
            .pathParam(PATH_PARAM_ID, ID_INVALIDO)
        .when()
            .get(PATH_PRODUTO_ID)
        .then()
            .contentType(ContentType.JSON)
            .statusCode(HttpStatus.SC_NOT_FOUND).log().all();
    }

    @Test
    public void deveRetornar200_quandoConsultarProdutoComIdVazio(){

        given()
            .pathParam(PATH_PARAM_ID, ID_INVALIDO)
        .when()
            .get(PATH_PRODUTO_ID)
        .then()
            .contentType(ContentType.JSON)
            .statusCode(HttpStatus.SC_BAD_REQUEST).log().all();
    }

    @Test
    public void deveRetornar200_quandoConsultarProdutoComIdNulo(){

        given()
            .pathParam(PATH_PARAM_ID, ID_INVALIDO)
        .when()
            .get(PATH_PRODUTO_ID_NULO)
        .then()
            .contentType(ContentType.JSON)
            .statusCode(HttpStatus.SC_BAD_REQUEST).log().all();
    }
}
