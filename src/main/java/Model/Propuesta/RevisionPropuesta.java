/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Propuesta;

import BackEnd.DB.Propuesta.PropuestaDB;
import Exception.EntityNotFoundException;

/**
 *
 * @author jgarcia07
 */
public class RevisionPropuesta {
    private final PropuestaDB propuestaDB = new PropuestaDB();
    
    public void rechazarOaceptar(int idPropuesta, String valor) throws EntityNotFoundException{
        
        if(!propuestaDB.existePropuesta(idPropuesta)){
            throw new EntityNotFoundException(String.format("La propuesta con id %d no existe en el sistema", idPropuesta));
        }
        propuestaDB.revisarPropuesta(idPropuesta, valor);
    }
}
