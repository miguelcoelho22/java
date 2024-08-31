package _daysofcode.br.com.alura.requestresponse;

public interface IConverteDados {
    <T> T converteDados(String json, Class<T> classe);
}
