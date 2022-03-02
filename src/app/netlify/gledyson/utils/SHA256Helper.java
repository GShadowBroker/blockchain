package app.netlify.gledyson.utils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

public class SHA256Helper {

    public static String generateHash(String data) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");

            byte[] hashBytes = digest.digest(data.getBytes(StandardCharsets.UTF_8));

            StringBuffer buffer = new StringBuffer();

            for (int i = 0; i < hashBytes.length; i++) {
                String hexadecimal = Integer.toHexString(0xff & hashBytes[i]);

                if (hexadecimal.length() == 1) {
                    buffer.append('0');
                }

                buffer.append(hexadecimal);
            }

            return buffer.toString();

        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
