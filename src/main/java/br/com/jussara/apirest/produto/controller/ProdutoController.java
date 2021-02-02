package br.com.jussara.apirest.produto.controller;

import br.com.jussara.apirest.produto.model.ProdutoModel;
import br.com.jussara.apirest.produto.repository.ProdutoRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
@Api(value = "API REST Produtos")
@CrossOrigin(origins = "*")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @GetMapping("/produtos")
    @ApiOperation(value = "Consultar lista com todos os produtos")
    public List<ProdutoModel> listarProdutos(){
        return produtoRepository.findAll();
    }

    @GetMapping("/produto/{id}")
    @ApiOperation(value = "Consultar produto por ID")
    public ProdutoModel listarProdutoPorID(@PathVariable(value = "id") long id){
        return produtoRepository.findById(id);
    }

    @PostMapping("/produto")
    @ApiOperation(value = "Criar um produto")
    @ResponseStatus(value = HttpStatus.CREATED)
    public ProdutoModel criarProduto(@RequestBody ProdutoModel produtoModel){
        return produtoRepository.save(produtoModel);
    }

    @DeleteMapping("/produto")
    @ApiOperation(value = "Deletar um produto")
    public void deleteProduto(@RequestBody ProdutoModel produtoModel){
        produtoRepository.delete(produtoModel);
    }

    @DeleteMapping("/produto/{id}")
    @ApiOperation(value = "Deletar um produto por ID")
    public ProdutoModel deletarProdutoPorID(@PathVariable(value = "id") long id){
        return produtoRepository.deleteById(id);
    }
    
    @PutMapping("/produto")
    @ApiOperation(value = "Atualizar um produto")
    public ProdutoModel atualizarProduto(@RequestBody ProdutoModel produtoModel){
        return produtoRepository.save(produtoModel);
    }

}
