package es.etg.balas.expsp;

import es.etg.balas.expsp.exceptions.ExceptionGlobal;
import es.etg.balas.expsp.util.LogUtil;

public class Main {

    public static void main(String[] args) throws ExceptionGlobal {
        // 0. Inicializar log
        LogUtil.crearLog("log.txt");

        try {
            for (int i = 0; i < 5; i++) {
                // 1. Lanzar Hilo de constructor
                Thread hiloConstructor = new Thread((Runnable) new Constructor());
                hiloConstructor.start();
            }

        } catch (Exception e) {
            LogUtil.escribirLog(java.util.logging.Level.SEVERE, "Error al iniciar el hilo del constructor: " + e.getMessage(), e);
        }

    }
}
