/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

/**
 *
 * @author Administrador
 */
public class JComboBox extends javax.swing.JComboBox {

    public Object getObjectSelected() {
        return ((ToComboBoxModel) dataModel).getSelectedObject();
    }
}
