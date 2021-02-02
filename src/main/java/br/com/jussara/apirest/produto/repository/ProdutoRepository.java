package br.com.jussara.apirest.produto.repository;

import br.com.jussara.apirest.produto.model.ProdutoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoModel, Long> {

    ProdutoModel findById(long id);

    ProdutoModel deleteById(long id);

}
