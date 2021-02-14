package br.com.jussara.apirest.produto.model;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

import static br.com.jussara.apirest.produto.constantes.Constantes.MESSAGE_TAMANHO_MIN_MAX;

@Entity
@Data
public class ProdutoModel implements Serializable {

    private static final long serialLVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Length(min = 1, max = 120, message = MESSAGE_TAMANHO_MIN_MAX)
    private String nome;

    @NotNull
    @Length(min = 1, max = 10, message = MESSAGE_TAMANHO_MIN_MAX)
    private BigDecimal quantidade;

    @NotNull
    @Length(min = 1, max = 10, message = MESSAGE_TAMANHO_MIN_MAX)
    private BigDecimal valor;
}
