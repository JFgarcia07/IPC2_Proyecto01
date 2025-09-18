/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Congreso;

import BackEnd.DB.Congreso.Congreso;
import BackEnd.DB.Congreso.CongresoDB;
import java.util.List;

/**
 *
 * @author jgarcia07
 */
public class ListadorCongresos {
    private final CongresoDB congresoDB = new CongresoDB();
    
    public List<Congreso> listaCongresos(){
        List<Congreso> congresos = congresoDB.listarCongresos();
        
        return congresos;
    }
    
    public List<Congreso> listaGestorCongresos(String idPersonal){
        List<Congreso> congresosPorAdmin = congresoDB.obtenerCongresoPorAdminCongreso(idPersonal);
        
        return congresosPorAdmin;
    }
}
