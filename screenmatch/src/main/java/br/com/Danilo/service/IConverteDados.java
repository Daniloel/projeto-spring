package br.com.Danilo.service;

public interface IConverteDados {

    <T> T obterDados(String json, Class<T> classe);
}
