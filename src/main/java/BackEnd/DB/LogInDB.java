/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BackEnd.DB;

import BackEnd.DB.Usuario.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author jgarcia07
 */
public class LogInDB {
    
    public boolean validarLogIn(Usuario user){
        boolean credencialesCorrectas = false;
        Connection connection = BDconnectionSingleton.getInstance().getConnection();
        String sql = "SELECT COUNT(email) FROM usuario WHERE email = ? AND password = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setString(1, user.getEmail());
            ps.setString(2, user.getPassword());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int count = rs.getInt(1); 
                if (count > 0){
                    credencialesCorrectas = true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return credencialesCorrectas;
    }
}
