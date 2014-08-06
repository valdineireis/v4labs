package br.com.valdineireis.v4labs.exception;

/**
 *
 * @author valdineireis
 */
public class CommonException extends Exception {

    private static final long serialVersionUID = 6890574797223901401L;

    public CommonException(String mensagem) {
        super(mensagem);
    }

    public CommonException(String mensagem, Throwable e) {
        super(mensagem, e);
    }
}
