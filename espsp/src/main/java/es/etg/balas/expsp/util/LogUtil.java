package es.etg.balas.expsp.util;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import es.etg.balas.expsp.common.Constantes;
import es.etg.balas.expsp.exceptions.ExceptionGlobal;

public class LogUtil {

    public static Logger crearLog(String ficheroLog) throws ExceptionGlobal {

        Logger logger = Logger.getLogger(Constantes.LOGGER);

        if (logger.getHandlers().length == Constantes.LONGITUD_FICHERO) {
            try {
                FileHandler fh = new FileHandler(ficheroLog, true);
                SimpleFormatter formato = new SimpleFormatter();

                logger.addHandler(fh);
                fh.setFormatter(formato);

                logger.setUseParentHandlers(false);
            } catch (IOException e) {
                throw new ExceptionGlobal("Error al crear el FileHandler: " + e.getMessage(), e);
            }
        }
        return logger;
    }

    public static void escribirLog(Level nivel, String mensaje) {
        Logger logger = Logger.getLogger(Constantes.LOGGER);
        logger.log(nivel, mensaje);
    }

    public static void escribirLog(Level nivel, String mensaje, Throwable e) {
        Logger logger = Logger.getLogger(Constantes.LOGGER);
        logger.log(nivel, mensaje, e);
    }
}
