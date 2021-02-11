package br.com.jussara.apirest.produto.rest.repository;

import br.com.jussara.apirest.produto.model.ProdutoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProdutoRepositoryTestUtil extends JpaRepository<ProdutoModel, Long> {

    ProdutoModel findById(long id);

    ProdutoModel deleteById(long id);

    @Query(value="SELECT * FROM produto_model ORDER BY random() limit 1", nativeQuery=true)
    ProdutoModel findRandomProduto();

}
