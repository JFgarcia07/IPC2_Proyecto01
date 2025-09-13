/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BackEnd.DB;

import BackEnd.DB.Usuario.Usuario;
import static Model.EncriptarPassword.encriptar;
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
        String sql = "SELECT COUNT(email) FROM usuario WHERE email = ? AND password = ? and activo = 1";
        try (PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setString(1, user.getEmail());
            ps.setString(2, encriptar(user.getPassword()));
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int count = rs.getInt(1); 
                if (count > 0){
                    credencialesCorrectas = true;
                    //GUARDAMOS EL CARGO QUE TIENE LA PERSONA QUE ESTA INICIANDO SESION
                    getCargo(user);
                    getIdPersonal(user);
                }
            }
        } catch (SQLException e) {
            System.err.println("Error en el logIn: " + e.getMessage());
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
            ps.setString(2, encriptar(user.getPassword()));
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
    
    private void getIdPersonal(Usuario user){
        Connection connection = BDconnectionSingleton.getInstance().getConnection();
        String sql = "SELECT id_personal FROM usuario WHERE email = ? AND password = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setString(1, user.getEmail());
            ps.setString(2, encriptar(user.getPassword()));
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                SesionGlobal.idPersonal = rs.getString("id_personal");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
}
