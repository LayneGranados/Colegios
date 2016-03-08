/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Util;

import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.plaf.basic.ComboPopup;

/**
 *
 * @author Administrador
 */
public class JComboBox extends javax.swing.JComboBox {

    public Object getObjectSelected() {
        return ((ToComboBoxModel) dataModel).getSelectedObject();
    }
    
     private ListSelectionListener listener;

    public JComboBox() {
        uninstall();
        install();
    }

    @Override
    public void updateUI() {
        uninstall();
        super.updateUI();
        install();
    }

    private void uninstall() {
        if (listener == null) return;
        getPopupList().removeListSelectionListener(listener);
        listener = null;
    }

    protected void install() {
        listener = new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (e.getValueIsAdjusting()) return;

                JList list = getPopupList();
                System.out.println("--> " + String.valueOf(list.getSelectedValue()));
            }
        };
        getPopupList().addListSelectionListener(listener);
    }

    private JList getPopupList() {
        ComboPopup popup = (ComboPopup) getUI().getAccessibleChild(this, 0);
        return popup.getList();

    }
    
}
