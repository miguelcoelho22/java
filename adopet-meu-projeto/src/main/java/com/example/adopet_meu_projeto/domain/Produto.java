package com.example.adopet_meu_projeto.domain;

import com.example.adopet_meu_projeto.dto.CadastroProdutoDto;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "produtos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String descricao;

    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    private BigDecimal preco;

    private Boolean ativo;

    public Produto(CadastroProdutoDto dto) {
        this.nome = dto.nome();
        this.descricao = dto.descricao();
        this.categoria = Categoria.valueOf(dto.categoria().toUpperCase());
        this.preco = dto.preco();
        this.ativo = true;
    }
}
