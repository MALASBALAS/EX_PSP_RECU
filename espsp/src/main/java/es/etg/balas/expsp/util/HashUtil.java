package es.etg.balas.expsp.util;

import java.security.MessageDigest;

import es.etg.balas.expsp.common.Constantes;

public class HashUtil {

    public static String convertirSHA256(String cadena) throws Exception {
        MessageDigest md = MessageDigest.getInstance(Constantes.ALGORITMO);
        byte[] hash = md.digest(cadena.getBytes(Constantes.CODIFICACION));
        return bytesToHex(hash);
    }

    private static String bytesToHex(byte[] hash) {
        StringBuilder hexString = new StringBuilder(Constantes.BYTE_A_HEX * hash.length);
        for (int i = 0; i < hash.length; i++) {
            String hex = Integer.toHexString(Constantes.MASCARA_BYTE & hash[i]);
            if (hex.length() == Constantes.UN_DIGITO_HEX) {
                hexString.append(Constantes.CARACTER_RELLENO);
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }
}
