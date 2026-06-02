package es.etg.balas.expsp.effect;

import es.etg.balas.expsp.common.Constantes;

class Effect {

    private static int efecto_basico = Constantes.EFECTO_BASICO;
    private static int efecto_epico = Constantes.EFECTO_EPICO;

    public synchronized int usoBasico(int cantidad) {
        efecto_basico = efecto_basico - cantidad;
        return efecto_basico;
    }

    public synchronized int usoEpico(int cantidad) {
        efecto_epico = efecto_epico - cantidad;
        return efecto_epico;
    }
}
