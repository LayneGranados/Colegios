/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Code.Business;

import Code.DAO.CaracteristicaBoletinDAOImpl;
import Code.Domain.CaracteristicaBoletin;
import java.util.ArrayList;

/**
 *
 * @author laynegranadosmogollon
 */
public class CaracteristicaBoletinBusiness {
    
    CaracteristicaBoletinDAOImpl caracteristicaBoletinDAO;

    public CaracteristicaBoletinBusiness() {
        this.caracteristicaBoletinDAO = new CaracteristicaBoletinDAOImpl();
    }
    
    public ArrayList<CaracteristicaBoletin> getCaracteristicaBoletin(){
        return this.caracteristicaBoletinDAO.getCaracteristicaBoletin();
    }
    
}
