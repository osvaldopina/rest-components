package br.gov.bcb.rest.component.grid.domain;

import javax.persistence.*;

/**
 * Created by deinf.osvaldo on 26/08/2015.
 */


@Entity
@Table(name = "CON_CONTA")
public class Conta {

    @Id
    @Column(name = "CON_ID")
    private Integer id;

    @Column(name = "CON_CD")
    private String codigo;

    @Column(name = "CON_NM")
    private String nome;

    @Column(name = "CON_DS")
    private String descricao;

    @Column(name= "CON_DS_BASE_NORMATIVA")
    private String baseNormativa;

    public Conta() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getBaseNormativa() {
        return baseNormativa;
    }

    public void setBaseNormativa(String baseNormativa) {
        this.baseNormativa = baseNormativa;
    }

}
