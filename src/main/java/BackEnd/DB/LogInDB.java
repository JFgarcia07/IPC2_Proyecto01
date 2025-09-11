/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BackEnd.DB;

import BackEnd.DB.Usuario.SesionGlobal;
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
                    //GUARDAMOS EL CARGO QUE TIENE LA PERSONA QUE ESTA INICIANDO SESION
                    getCargo(user);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return credencialesCorrectas;
    }

    private String getCargo(Usuario user) {
        String cargo = "";
        Connection connection = BDconnectionSingleton.getInstance().getConnection();
        String sql = "SELECT id_rol FROM usuario WHERE email = ? AND password = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, user.getEmail());
            ps.setString(2, user.getPassword());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                cargo = rs.getString("id_rol");
                SesionGlobal.idRol = cargo;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cargo;
    }
}
