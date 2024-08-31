package br.com.alura.excetions;

public class ErroDeConversaoException extends RuntimeException {
    private String  mensagem;
   public ErroDeConversaoException(String mensagem) {
       this.mensagem = mensagem;
   }

    public String getMensagem() {
        return this.mensagem;
    }
}
