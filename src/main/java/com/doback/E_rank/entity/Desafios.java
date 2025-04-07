package com.doback.E_rank.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "desafios")
public class Desafios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "data_desafio")
    private Date dataDesafio;

    @Column(name = "resultado")
    private String resultado;

    @Column(name = "sts")
    private char sts;

    @ManyToOne
    @JoinColumn(name = "id_amizade", referencedColumnName = "id_amizade")
    private Amizades amizade;

    @ManyToOne
    @JoinColumn(name = "id_jogo", referencedColumnName = "id_jogo")
    private Jogos jogo;

    public Desafios( Date dataDesafio, String resultado, char sts, Amizades amizade, Jogos jogo) {
        this.dataDesafio = dataDesafio;
        this.resultado = resultado;
        this.sts = sts;
        this.amizade = amizade;
        this.jogo = jogo;
    }

    public Desafios() {
    }


    public Date getDataDesafio() {
        return dataDesafio;
    }

    public void setDataDesafio(Date dataDesafio) {
        this.dataDesafio = dataDesafio;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public char getSts() {
        return sts;
    }

    public void setSts(char sts) {
        this.sts = sts;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

//    public Amizades getAmizade() {
//        return amizade;
//    }
//
//    public void setAmizade(Amizades amizade) {
//        this.amizade = amizade;
//    }
//
//    public Jogos getJogo() {
//        return jogo;
//    }
//
//    public void setJogo(Jogos jogo) {
//        this.jogo = jogo;
//    }
}
