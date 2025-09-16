/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Convocatorias;

import BackEnd.DB.Convocatoria.Convocatoria;
import BackEnd.DB.Convocatoria.ConvocatoriaDB;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jgarcia07
 */
public class ListadorConvocatorias {
    
    private final ConvocatoriaDB convocatoriaDB = new ConvocatoriaDB();

    public List<Convocatoria> listarConvocatorias() {
        List<Convocatoria> convocatorias = convocatoriaDB.listarConvocatoria();
        convocatorias = desactivarConvocatoria(convocatorias);
        
        return convocatorias;
    }

    private List<Convocatoria> desactivarConvocatoria(List<Convocatoria> convocatorias) {
        List<Convocatoria> convocatoriasList = new ArrayList<>();
        LocalDate hoy = LocalDate.now();
        for (Convocatoria c : convocatorias) {
            LocalDate fechaFin = c.getFechaFin().toLocalDate();
            if (fechaFin.isBefore(hoy)) {
                convocatoriaDB.desactivarConvocatoria(Integer.parseInt(c.getIdConvocatoria()));
            } else {
                convocatoriasList.add(c);
            }
        }
        return convocatoriasList;
    }
}
