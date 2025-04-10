package com.doback.E_rank.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "desafios")
public class Desafios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "data_desafio")
    private Date dataDesafio;

    @Column(name = "resultado")
    private String resultado;

    @Column(name = "sts")
    private char sts;

    @OneToMany(mappedBy = "desafio", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private List<Estatisticas> estatisticas = new ArrayList<>();

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_amizade", referencedColumnName = "id", insertable = false, updatable = false)
    private Amizades amizade;

    @Column(name = "id_amizade")
    private int idAmizade;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_jogo", referencedColumnName = "id", insertable = false, updatable = false)
    private Jogos jogos;

    @Column(name = "id_jogo")
    private int idJogo;

    public Desafios( Date dataDesafio, String resultado, char sts, Amizades amizade, Jogos jogos) {
        this.dataDesafio = dataDesafio;
        this.resultado = resultado;
        this.sts = sts;
        this.amizade = amizade;
        this.jogos = jogos;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdAmizade() {
        return idAmizade;
    }

    public void setIdAmizade(int idAmizade) {
        this.idAmizade = idAmizade;
    }

    public int getIdJogo() {
        return idJogo;
    }

    public void setIdJogo(int idJogo) {
        this.idJogo = idJogo;
    }

}
