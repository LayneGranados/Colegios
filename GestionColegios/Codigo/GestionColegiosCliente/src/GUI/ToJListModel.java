/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;

/**
 *
 * @author Administrador
 */
public class ToJListModel<T> extends DefaultListModel<T> {//extends AbstractListModel {

    private T selectedItem;
    private ArrayList<T> lstObjects;
    private String nameMethod;

    public ToJListModel(ArrayList<T> lstObjects, String nameMethod) {

        this.lstObjects = lstObjects;
        this.nameMethod = nameMethod;
    }

    @Override
    public int getSize() {
        return lstObjects.size();
    }

    @Override
    public T getElementAt(int index) {
        return getValue(lstObjects.get(index));
    }

    public void addItem(T item) {
        lstObjects.add(item);
        super.addElement(item);
    }

    public void removeItem(int... lstIndex) {

        int quitaron = 0;

        for (int index : lstIndex) {
            lstObjects.remove(index - quitaron);
            quitaron++;
        }

    }

    public void ordenar(Comparator compartor) {
        Collections.sort((List<T>) lstObjects, compartor);
    }

    private T getValue(T object) {

        try {
            Class classExam = object.getClass();
            return (T) classExam.getMethod(nameMethod, null).invoke(object, null);

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
