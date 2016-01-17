/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Code.Business.AuxiliaresBusiness;
import Code.Business.InstitucionEducativaBusiness;
import Code.Business.SedeBusiness;
import Code.Domain.Anio;
import Code.Domain.Departamento;
import Code.Domain.InstitucionEducativa;
import Code.Domain.Municipio;
import Code.Domain.Sede;
import GUI.Util.ControllerComboAnio;
import GUI.Util.ControllerComboSede;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author laynegranadosmogollon
 */
public class AnioModal extends javax.swing.JDialog {
    
    private boolean ALLOW_ROW_SELECTION = true;
    
    ControllerComboAnio controller;
    SedeBusiness sedeBusiness;
    AuxiliaresBusiness auxiliaresBusiness;
    
    Sede sedeActual;
    ArrayList<Sede> sedes;
    
    Anio anioActual;
    final String[] columnNames = {"Id", "Año", "Descripcion", "Sede"};

    /**
     * Creates new form AnioModal
     */
    public AnioModal(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        this.controller= new ControllerComboAnio(this);
        this.sedeBusiness= new SedeBusiness();
        this.auxiliaresBusiness = new AuxiliaresBusiness();
        
        //this.sedes =this.sedeBusiness.selectAllSedes(actualColegio.getId());
        
        this.sedeActual = new Sede();
        
        JTable jtable = this.createJTable(this.dataTable());
        //this.scrollPaneListadoSede.setViewportView(jtable);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jComboBox2 = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        scrollPaneListadoAnios = new javax.swing.JScrollPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel6.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabel6.setText("Agregar o Modificar nuevo año a Sede");

        jLabel7.setText("Año (Solo números)");

        jLabel10.setText("Sede");

        jButton2.setText("Guardar Año");

        jLabel1.setText("Descripción");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jButton1.setText("Nuevo año");

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 0, 8)); // NOI18N
        jLabel2.setText("(Opcional)");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(85, 85, 85)
                            .addComponent(jLabel6))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(31, 31, 31)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel2))
                                .addComponent(jLabel7))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jLabel10)
                            .addGap(15, 15, 15)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 443, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(scrollPaneListadoAnios, javax.swing.GroupLayout.PREFERRED_SIZE, 443, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scrollPaneListadoAnios, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AnioModal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AnioModal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AnioModal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AnioModal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AnioModal dialog = new AnioModal(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JScrollPane scrollPaneListadoAnios;
    // End of variables declaration//GEN-END:variables
    
    private Object[][] dataTable(){
        int tamSedes = this.sedes.size();
        Object[][] data = new Object[tamSedes][5];
        
        for(int i=0;i<sedes.size();i++){
           Sede s = sedes.get(i);
            data[i][0]= s.getId();
            data[i][1]= s.getNombre();
            data[i][2]= s.getCodigoDANEantiguo();
            data[i][3]= s.getMunicipio();
            data[i][4]= s.getConsecutivo();
        }
        return data;
    }
    
    private JTable createJTable(Object[][] data){
        JTable jTable = new JTable(data, columnNames);
        jTable.setPreferredScrollableViewportSize(new Dimension(500, 70));
        jTable.setFillsViewportHeight(true);
        jTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        if (ALLOW_ROW_SELECTION) {
            ListSelectionModel rowSM = jTable.getSelectionModel();
            rowSM.addListSelectionListener(new ListSelectionListener() {
                public void valueChanged(ListSelectionEvent e) {
                    
                    if (e.getValueIsAdjusting()) 
                        return;

                    ListSelectionModel lsm = (ListSelectionModel)e.getSource();
                    if (!lsm.isSelectionEmpty()) {
                        getSedeSelected(jTable, lsm.getMinSelectionIndex());
                    }
                }
            });
        } else {
            jTable.setRowSelectionAllowed(false);
        }
        
        return jTable;
    }
    private void getSedeSelected(JTable table, int row) {
        int numRows = table.getRowCount();

        if(row<numRows){
            
            javax.swing.table.TableModel model = table.getModel();
            this.sedeActual= new Sede();
            
            this.sedeActual.setId((Integer)(model.getValueAt(row,0)));
            this.sedeActual.setNombre((String)(model.getValueAt(row,1)));
            this.sedeActual.setCodigoDANEantiguo(((String)model.getValueAt(row,2)));
            this.sedeActual.setMunicipio((Integer)(model.getValueAt(row,3)));
            this.sedeActual.setConsecutivo((Integer)(model.getValueAt(row,4)));
            
            /*this.txtNombreSede.setText(this.sedeActual.getNombre());
            this.txtConsecutivoSede.setText(""+this.sedeActual.getConsecutivo());
            this.txtCodigoDANEAnterior.setText(this.sedeActual.getCodigoDANEantiguo());
            this.lblIdSede.setText(""+this.sedeActual.getId());*/
            
            Municipio municipio = this.auxiliaresBusiness.getMunicipioPorId(this.sedeActual.getMunicipio());
            Departamento departamento =  this.auxiliaresBusiness.getDepartamentoPorId(municipio.getDepartamentoId());
            this.controller= new ControllerComboAnio(this);
            this.controller.setSelectedItemDepartamento(departamento);
            this.controller.llenarMunicipioSede(departamento.getId());
            this.controller.setSelectedItemMunicipio(municipio);
            
        }
        
    }
    

}
