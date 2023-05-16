package md5;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class MD5Hash {

    public static void main(String[] args) {
        String message = "";
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Geben Sie eine Textnachricht ein: ");
            message = scanner.nextLine();
        }

        try {
            System.out.println();
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] dataBytes = message.getBytes();
            md.update(dataBytes);
            byte[] mdbytes = md.digest();

            StringBuilder hexString = new StringBuilder();
            for (byte b : mdbytes) {
                hexString.append(String.format("%02x", b));
            }

            System.out.println();
            System.out.println("MD5 Hash-Wert: " + hexString);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}
