package es.etg.balas.expsp.util;

public class ParserUtil {

    public static String[] parsearEfecto(String efecto) throws Exception {
        String[] partes = efecto.split(" ");
        if (partes.length != 2) {
            throw new Exception("Formato de efecto inválido: " + efecto);
        }
        return partes;
    }
}
