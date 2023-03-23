package fr.ensicaen.sidiabdallah.tennis.appli;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class Hashing {
    private static Hashing instance;

    public static Hashing getInstance() {
        if (instance == null) instance = new Hashing();
        return instance;
    }

    /**
     * @brief hashing a password with the sha-256 algorithm
     * @param password the password to be hashed
     * @return the password's hash
     */
    public static String hashPassword(String password) /*throws NoSuchAlgorithmException*/ {
        MessageDigest digest = null;
        try {
            digest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        byte[] hash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
        StringBuilder hexString = new StringBuilder();
        for (byte b : hash) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    }

    /**
     * @brief verifies if the hash is equals to the password's hash
     * @param password in plaintext
     * @param hash
     * @return return true if the password's hash is equal to the hash, otherwise false
     */
    public static boolean verifyPassword(String password, String hash) /*throws NoSuchAlgorithmException*/ {
        String hashedPasswordString = null;
        hashedPasswordString = hashPassword(password);
        return hashedPasswordString.equals(hash);
    }

    /**
     * @brief generates a unique adherent number for each adherent by hashing his email
     * @param email
     * @return the adherent number if everything is ok, -1 otherwise
     */
    public static int emailToUniqueInt(String email) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] emailBytes = email.getBytes();
            byte[] hashBytes = md.digest(emailBytes);
            BigInteger hashNum = new BigInteger(1, hashBytes);
            int uniqueInt = hashNum.mod(BigInteger.valueOf(100000)).intValue();
            return uniqueInt;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return -1;
        }
    }


}
