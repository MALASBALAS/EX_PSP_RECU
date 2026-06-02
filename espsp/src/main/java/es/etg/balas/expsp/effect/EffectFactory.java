package es.etg.balas.expsp.effect;

import es.etg.balas.expsp.common.Constantes;
import es.etg.balas.expsp.exceptions.ExceptionGlobal;
import es.etg.balas.expsp.util.HashUtil;

public class EffectFactory {

    

    private static boolean estaEn(String tipo, String[] tipos) {
        for (String t : tipos) {
            if (t.equals(tipo)) {
                return true;
            }
        }
        return false;
    }

    public int usoEfecto(int cantidad, String tipo, String hashMsg) throws Exception {

        String crearHash = tipo + cantidad;

        String hashReal = HashUtil.convertirSHA256(crearHash);

        if (hashMsg.equals(hashReal)) {

            if (estaEn(tipo, Constantes.TIPOS_BASICOS)) {
                Effect efecto = new Effect();
                return efecto.usoBasico(cantidad);
            } else if (estaEn(tipo, Constantes.TIPOS_EPICOS)) {
                Effect efecto = new Effect();
                return efecto.usoEpico(cantidad);
            }
            throw new ExceptionGlobal("Tipo de efecto desconocido: " + tipo);

        } else {
            return -1;
        }
    }
}
