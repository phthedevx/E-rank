package com.doback.E_rank.entity;

import java.time.LocalDate;

public class Temporadas {

    private int id;
    private String nome;
    private String descricao;
    private LocalDate dataInicio;
    private LocalDate dataFim;

    public Temporadas(String nome, String descricao, LocalDate dataInicio, LocalDate dataFim) {
        this.nome = nome;
        this.descricao = descricao;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }

    public boolean validarTemporada() {
        LocalDate hoje = LocalDate.now();

        return nome != null && !nome.trim().isEmpty()
                && descricao != null && !descricao.trim().isEmpty()
                && dataInicio != null && !dataInicio.isBefore(hoje)
                && dataFim != null && !dataFim.isBefore(dataInicio);
    }

    public String getErrosValidacao() {
        StringBuilder erros = new StringBuilder();
        LocalDate hoje = LocalDate.now();

        if (nome == null || nome.trim().isEmpty()) {
            erros.append("Nome não pode estar vazio.");
        }

        if (descricao == null || descricao.trim().isEmpty()) {
            erros.append("Descrição não pode estar vazia.");
        }

        if (dataInicio == null) {
            erros.append("Data de início não pode ser nula.");
        }
        if (dataInicio != null && dataInicio.isBefore(hoje)) {
            erros.append("Data de início deve ser hoje ou no futuro.");
        }

        if (dataFim == null) {
            erros.append("Data de fim não pode ser nula.");
        }
        if (dataInicio != null && dataFim != null && dataFim.isBefore(dataInicio)) {
            erros.append("Data de fim deve ser após a data de início.");
        }

        return erros.toString().trim();
    }
}
