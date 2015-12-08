/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;

/**
 *
 * @author Administrador
 */
public class ToComboBoxModel<T> extends AbstractListModel implements ComboBoxModel {

    private T selectedItem;
    private ArrayList<T> lstObjects;    
    private String nameMethod;

    /**
     *
     * @param ArrayList<T> lstObjects lista de beans a cargar
     * @param String nameMethod nombre del metodo que pertenece al bean que
     * referencia la lista
     * @param Class type clase que corresponde al tipo de parametro que recibe
     * el metodo
     */
    public ToComboBoxModel(ArrayList<T> lstObjects, String nameMethod) {
        this.lstObjects = lstObjects;
        this.nameMethod = nameMethod;
        this.lstObjects = lstObjects;

        if (!lstObjects.isEmpty()) {
            selectedItem = lstObjects.get(0);
        }
    }

    @Override
    public int getSize() {
        return lstObjects.size();
    }

    @Override
    public Object getElementAt(int index) {

        return getValue((T) lstObjects.get(index));
    }

    @Override
    public void setSelectedItem(Object anItem) {

        for (T object : lstObjects) {

            if (getValue(object).equals(anItem)) {
                selectedItem = object;
            }
        }
    }

    public void addItem(T item){        
        lstObjects.add(item);  
    }
    
     public void ordenar(Comparator compartor){    
       Collections.sort((List<T>) lstObjects,compartor);      
    }
    
    public void removeItem(int index) {
        lstObjects.remove(index);
    }

    public void removeItem(int... lstIndex) {

        int quitaron = 0;
        
        for(int index :lstIndex){            
            lstObjects.remove(index - quitaron);            
            quitaron++;
        }

    }

    @Override
    public Object getSelectedItem() {
        return selectedItem == null ? selectedItem : getValue(((T) selectedItem));
    }

    public Object getSelectedObject() {
        return selectedItem;
    }
    
  

    private Object getValue(T object) {

        try {
            Class classExam = object.getClass();
            return classExam.getMethod(nameMethod, null).invoke(object, null);

        } catch (IllegalAccessException ex) {
            Logger.getLogger(ToComboBoxModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(ToComboBoxModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(ToComboBoxModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(ToComboBoxModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex) {
            Logger.getLogger(ToComboBoxModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
