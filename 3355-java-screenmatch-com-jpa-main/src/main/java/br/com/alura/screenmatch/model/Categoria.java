package br.com.alura.screenmatch.model;

import br.com.alura.screenmatch.service.ConsumoApi;

public enum Categoria {
        ACAO("Action", "acao"),
        ROMANCE("Romance", "romance"),
        COMEDIA("Comedy", "comedia"),
        DRAMA("Drama", "drama"),
        CRIME("Crime", "crime");

    private String categoriaOmdb;

    private String categoriaportugues;

    Categoria(String categoriaOmdb, String categoriaportugues){
        this.categoriaOmdb = categoriaOmdb;
        this.categoriaportugues = categoriaportugues;
    }
    public static Categoria fromString(String text) {
        for (Categoria categoria : Categoria.values()) {
            if (categoria.categoriaOmdb.equalsIgnoreCase(text)) {
                return categoria;
            }
        }
        throw new IllegalArgumentException("Nenhuma categoria encontrada para a string fornecida: " + text);
    }

    public static Categoria fromPortugues(String text) {
        for (Categoria categoria : Categoria.values()) {
            if (categoria.categoriaportugues.equalsIgnoreCase(text)) {
                return categoria;
            }
        }
        throw new IllegalArgumentException("Nenhuma categoria encontrada para a string fornecida: " + text);
    }

}