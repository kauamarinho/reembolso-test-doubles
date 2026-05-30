package exception;

public class ConsultaNaoAutorizadaException extends RuntimeException {

    public ConsultaNaoAutorizadaException(String mensagem) {
        super(mensagem);
    }
}
