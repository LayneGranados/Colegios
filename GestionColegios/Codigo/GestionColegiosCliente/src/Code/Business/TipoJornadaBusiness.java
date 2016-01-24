/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Code.Business;

import Code.DAO.TipoJornadaDAOImpl;
import Code.Domain.TipoJornada;
import java.util.ArrayList;

/**
 *
 * @author AndresOrlando
 */
public class TipoJornadaBusiness {
    
    TipoJornadaDAOImpl tipoJornadaDAOImpl;

    public TipoJornadaBusiness(){
        this.tipoJornadaDAOImpl = new TipoJornadaDAOImpl();
    }
    
    public TipoJornada guardarTipoJornada(TipoJornada tj) {      
       return this.tipoJornadaDAOImpl.guardarTipoJornada(tj);
    }
    
    
    public ArrayList<TipoJornada> getTodasLosTipoJornada(){
        return this.tipoJornadaDAOImpl.getTodosLosTipoJornada();
    }
    
    public TipoJornada updateTipoJornada(TipoJornada tj) {
        return this.tipoJornadaDAOImpl.updateTipoJornada(tj);
    }
    
    public TipoJornada tipoJornadaPorId(int id_tj){
        return this.tipoJornadaDAOImpl.tipoJornadaPorId(id_tj);
    }
    
    
}
