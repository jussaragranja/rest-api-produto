package br.com.jussara.apirest.produto.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Data
public class ProdutoModel implements Serializable {

    private static final long serialLVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private BigDecimal quantidade;
    private BigDecimal valor;
}
