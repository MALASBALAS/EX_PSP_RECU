package es.etg.balas.expsp.exceptions;

import es.etg.balas.expsp.common.Constantes;

public class ExceptionGlobal extends Exception {

    public ExceptionGlobal(String message) {
        super(String.format(Constantes.MSG, message));
    }

    public ExceptionGlobal(String message, Throwable cause) {
        super(String.format(Constantes.MSG, message), cause);
    }
}
