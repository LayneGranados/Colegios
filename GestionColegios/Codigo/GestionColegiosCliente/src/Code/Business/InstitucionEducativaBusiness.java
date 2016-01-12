/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Code.Business;

import Code.DAO.InstitucionEducativaDAOImpl;
import Code.Domain.InstitucionEducativa;

/**
 *
 * @author laygrana
 */
public class InstitucionEducativaBusiness {
    
    InstitucionEducativaDAOImpl institucionEducativaDAOImpl;

    public InstitucionEducativaBusiness() {
        this.institucionEducativaDAOImpl = new InstitucionEducativaDAOImpl();
    }
    
    public InstitucionEducativa guardarColegio(InstitucionEducativa ie){
        return this.institucionEducativaDAOImpl.guardarColegio(ie);
    }
    
    public InstitucionEducativa selectColegio(){
        return this.institucionEducativaDAOImpl.selectColegio();
    }
    
}
