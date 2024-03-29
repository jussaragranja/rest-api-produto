package br.com.jussara.apirest.produto.controller;

import br.com.jussara.apirest.produto.exception.ResourceNotFoundException;
import br.com.jussara.apirest.produto.model.ProdutoModel;
import br.com.jussara.apirest.produto.repository.ProdutoRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static br.com.jussara.apirest.produto.constantes.Constantes.*;

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
    public ProdutoModel consultarProdutoPorID(@PathVariable(value = "id") long id){
        return produtoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(MESSAGE_PRODUTO_NAO_ENCONTRADO));
    }

    @PostMapping("/create-produto")
    @ApiOperation(value = "Criar um produto")
    @ResponseStatus(value = HttpStatus.CREATED)
    public ProdutoModel criarProduto(@RequestBody ProdutoModel produtoModel){
        if (produtoModel.getId() != null){
            if(produtoRepository.findById(produtoModel.getId()).isPresent()) {
                throw new ResourceNotFoundException(MESSAGE_PRODUTO_JA_CADASTRADO);
            }
        }
        if(produtoModel.getNome() == null || produtoModel == null || produtoModel.equals("")){
            throw new ResourceNotFoundException(MESSAGE_PRODUTO_NAO_PODE_SER_VAZIO_OU_NULO);
        }
        return produtoRepository.save(produtoModel);
    }

    @DeleteMapping("/delete-produto")
    @ApiOperation(value = "Deletar um produto")
    public void deletarProduto(@RequestBody ProdutoModel produtoModel){
        if(!produtoRepository.findById(produtoModel.getId()).isPresent()) {
            throw new ResourceNotFoundException(MESSAGE_PRODUTO_NAO_ENCONTRADO);
        }
        produtoRepository.delete(produtoModel);
    }

    @DeleteMapping("/delete-produto-id/{id}")
    @ApiOperation(value = "Deletar um produto por ID")
    public ProdutoModel deletarProdutoPorID(@PathVariable(value = "id") long id){
        if(produtoRepository.findById(id) == null) {
            throw new ResourceNotFoundException(MESSAGE_PRODUTO_NAO_ENCONTRADO);
        }
        return produtoRepository.deleteById(id);
    }
    
    @PutMapping("/update-produto")
    @ApiOperation(value = "Atualizar um produto")
    public ProdutoModel atualizarProduto(@RequestBody ProdutoModel produtoModel){
        if(!produtoRepository.findById(produtoModel.getId()).isPresent()) {
            throw new ResourceNotFoundException(MESSAGE_PRODUTO_NAO_ENCONTRADO);
        }
        return produtoRepository.save(produtoModel);
    }
}
