/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Base64;

/**
 *
 * @author jgarcia07
 */
public class EncriptarPassword {
    
    public static String encriptar(String password){
        return Base64.getEncoder().encodeToString(password.getBytes());
    }
    
    public static String desencriptar(String encoded) {
        return new String(Base64.getDecoder().decode(encoded));
    }
}
