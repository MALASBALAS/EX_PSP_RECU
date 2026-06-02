package es.etg.balas.expsp;

import java.util.logging.Level;

import es.etg.balas.expsp.common.Constantes;
import es.etg.balas.expsp.effect.EffectFactory;
import es.etg.balas.expsp.exceptions.ExceptionGlobal;
import es.etg.balas.expsp.util.HashUtil;
import es.etg.balas.expsp.util.LogUtil;
import es.etg.balas.expsp.util.ParserUtil;

public class Constructor implements Runnable {

    @Override
    public void run() {

        // 2. Crear efecto (esto se recibiría del cliente)

        String[] partes1;
        String[] partes2;
        try {
            partes1 = ParserUtil.parsearEfecto(Constantes.EFECTO1);
            partes2 = ParserUtil.parsearEfecto(Constantes.EFECTO2);
        } catch (Exception e) {
            LogUtil.escribirLog(Level.SEVERE, e.getMessage());
            return;
        }
        int cantidad1 = Integer.parseInt(partes1[0]);
        int cantidad2 = Integer.parseInt(partes2[0]);
        String tipo1 = partes1[1];
        String tipo2 = partes2[1];

        // 3. Crear hash efecto
        String hash1 = tipo1 + cantidad1;
        String hash2 = tipo2 + cantidad2;
        String hashCode1 = null;
        String hashCode2 = null;
        try {
            hashCode1 = HashUtil.convertirSHA256(hash1);
            hashCode2 = HashUtil.convertirSHA256(hash2);
        } catch (Exception e) {
            LogUtil.escribirLog(Level.SEVERE, e.getMessage());
        }

        // 4. Enviar datos a EffectFactory
        EffectFactory effectFactory = new EffectFactory();
        try {
            int resultado1 = effectFactory.usoEfecto(cantidad1, tipo1, hashCode1);
            int resultado2 = effectFactory.usoEfecto(cantidad2, tipo2, hashCode2);
            // 5. Logs de resultados
            LogUtil.escribirLog(Level.INFO, "Resultado efecto 1: " + resultado1);
            LogUtil.escribirLog(Level.INFO, "Resultado efecto 2: " + resultado2);
        } catch (ExceptionGlobal e) {
            LogUtil.escribirLog(Level.SEVERE, e.getMessage());
        } catch (Exception e) {
            LogUtil.escribirLog(Level.SEVERE, e.getMessage());
        }

    }

}
