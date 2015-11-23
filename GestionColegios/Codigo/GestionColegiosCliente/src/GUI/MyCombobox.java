/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Code.Domain.Anio;
import Code.Domain.InstitucionEducativa;
import Code.Domain.Municipio;
import Code.Domain.Sede;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;

/**
 *
 * @author laynegranadosmogollon
 */
public class MyCombobox extends JComboBox{
    
    ArrayList<InstitucionEducativa> colegios;
    ArrayList<Sede> sedes;
    ArrayList<Anio> anios;
    ArrayList<Municipio> municipios;

    public MyCombobox() {
    }

    public MyCombobox(ComboBoxModel aModel) {
        super(aModel);
    }

    public MyCombobox(Object[] items) {
        super(items);
    }

    public MyCombobox(Vector items) {
        super(items);
    }
    
    public MyCombobox(ArrayList<InstitucionEducativa> colegios) {
        this.colegios=colegios;
    }
    
    
}
