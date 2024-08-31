package alura.com.br.tabelafipedb.service;

public interface IConverteDados {
    <T> T  obterDados(String json, Class<T> classe);
}
