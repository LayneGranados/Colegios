/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Util;

/**
 *
 * @author Administrador
 */
public class JComboBoxRenderer extends javax.swing.JComboBox {

    private ListenerHideJCombo listenerHide;

    public JComboBoxRenderer(Object[] objeto) {
        super(objeto);
    }

    @Override
    public void setPopupVisible(boolean v) {
    }

    @Override
    public void firePopupMenuWillBecomeInvisible() {
        listenerHide.actionHide();
    }

    public void addListenerHideJCombo(ListenerHideJCombo listenerHide) {
        this.listenerHide = listenerHide;
    }
}
