/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Code.Business.AnioBusiness;
import Code.Business.AuxiliaresBusiness;
import Code.Business.CalificacionBusiness;
import Code.Business.InstitucionEducativaBusiness;
import Code.Business.SedeBusiness;
import Code.Domain.Anio;
import Code.Domain.Asignatura;
import Code.Domain.CaracteristicaBoletin;
import Code.Domain.Curso;
import Code.Domain.DetalleCalificacion;
import Code.Domain.InstitucionEducativa;
import Code.Domain.Matricula;
import Code.Domain.Periodo;
import Code.Domain.Persona;
import Code.Domain.Sede;
import GUI.Util.ControllerAgregarCalificaciones;
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
public class CalificacionEstudianteModal extends javax.swing.JDialog {
    
    private boolean ALLOW_ROW_SELECTION = true;
    
    ControllerAgregarCalificaciones controller;
    AnioBusiness anioBusiness;    
    InstitucionEducativaBusiness institucionEducativaBusiness;
    AuxiliaresBusiness auxiliaresBusiness;    
    Anio anioActual;
    InstitucionEducativa actualColegio;
    ArrayList<DetalleCalificacion> detalles;
    SedeBusiness sedeBusiness;
    CalificacionBusiness calificacionBusiness;
    Matricula matriculaSelected;
    Periodo periodoSelected;
    Curso cursoSelected;
    DetalleCalificacion detalleSelectedTable;
    
    final String[] columnNames = {"Id", "Asignatura","Nota", "Observaciones", "Tipo Nota"};

    /**
     * Creates new form AnioModal
     */
    public CalificacionEstudianteModal(java.awt.Frame parent, boolean modal, Matricula matricula, Periodo periodo, Curso curso) {
        super(parent, modal);
        this.calificacionBusiness = new CalificacionBusiness();
        this.matriculaSelected = matricula;
        this.periodoSelected = periodo;
        this.cursoSelected = curso;
        initComponents();
        this.controller = new ControllerAgregarCalificaciones(this);
        Persona p = matriculaSelected.getEstudiante().getPersona();
        this.lblNombreEstudiante.setText(matriculaSelected.getCodigo()+"-"+p.getNombre1()+" "+p.getNombre2()+" "+p.getApellido1()+" "+p.getApellido2());
        this.lblCurso.setText(cursoSelected.getNombre());
        this.lblGrado.setText(cursoSelected.getGrado().getNombre());
        this.lblPeriodo.setText(periodoSelected.getComentario());
        this.controller.llenarAsignaturaPorCursoCalificacion(curso.getId());
        this.controller.llenarCaracteristicaBoletin();
        this.detalles = this.calificacionBusiness.getListadoTabla(this.matriculaSelected, this.periodoSelected);
        if(detalles != null && !detalles.isEmpty()){
            this.txtObservacionesBoletin.setText(detalles.get(0).getCalificacion().getBoletin().getObservaciones());
            JTable jtable = this.createJTable(this.dataTable());
            this.scrollListadoCalificaciones.setViewportView(jtable);
        }
        
    }

    public InstitucionEducativa getActualColegio() {
        return actualColegio;
    }

    public void setActualColegio(InstitucionEducativa actualColegio) {
        this.actualColegio = actualColegio;
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollBar1 = new javax.swing.JScrollBar();
        jLabel6 = new javax.swing.JLabel();
        cmbTipoCalificacion = new GUI.Util.JComboBox();
        btnGuardarCalificacion = new javax.swing.JButton();
        btnLimpiarCampos = new javax.swing.JButton();
        scrollListadoCalificaciones = new javax.swing.JScrollPane();
        lblIdAnio = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblNombreEstudiante = new javax.swing.JLabel();
        lblPeriodo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtValorCalificacion = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cmbAsignaturaCalificaciones = new GUI.Util.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtObservacionesBoletin = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtObservacionesNotaDada = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        lblCurso = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lblGrado = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(600, 600));
        setResizable(false);

        jLabel6.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        jLabel6.setText("Agregar o Modificar Calificaciones Estudiante");

        cmbTipoCalificacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTipoCalificacionActionPerformed(evt);
            }
        });

        btnGuardarCalificacion.setText("Guardar Calificación");
        btnGuardarCalificacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarCalificacionActionPerformed(evt);
            }
        });

        btnLimpiarCampos.setText("Nueva Calificacion");
        btnLimpiarCampos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarCamposActionPerformed(evt);
            }
        });

        jLabel3.setText("Estudiante:");

        jLabel4.setText("Periodo");

        lblNombreEstudiante.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblPeriodo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setText("Tipo Calificación");

        jLabel2.setText("Calificación");

        jLabel7.setText("Asignatura");

        cmbAsignaturaCalificaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbAsignaturaCalificacionesActionPerformed(evt);
            }
        });

        txtObservacionesBoletin.setColumns(20);
        txtObservacionesBoletin.setRows(5);
        txtObservacionesBoletin.setBorder(javax.swing.BorderFactory.createTitledBorder("Observaciones al Boletin del Periodo Seleccionado"));
        jScrollPane1.setViewportView(txtObservacionesBoletin);
        txtObservacionesBoletin.getAccessibleContext().setAccessibleName("Observaciones en el Boletin del Periodo seleccionado");

        txtObservacionesNotaDada.setColumns(20);
        txtObservacionesNotaDada.setRows(5);
        txtObservacionesNotaDada.setBorder(javax.swing.BorderFactory.createTitledBorder("Observaciones a la nota dada"));
        jScrollPane2.setViewportView(txtObservacionesNotaDada);

        jButton1.setText("Eliminar Calificación");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel8.setText("Curso");

        lblCurso.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel9.setText("Grado");

        lblGrado.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jButton2.setText("Generar Boletin");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(scrollListadoCalificaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 523, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(btnGuardarCalificacion, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(27, 27, 27)
                                    .addComponent(btnLimpiarCampos)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(35, 35, 35)
                                        .addComponent(lblPeriodo, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel9))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel7)
                                            .addComponent(jLabel2))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(cmbAsignaturaCalificaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(cmbTipoCalificacion, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(txtValorCalificacion, javax.swing.GroupLayout.PREFERRED_SIZE, 443, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(245, 245, 245)
                                        .addComponent(lblGrado, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(39, 39, 39)
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jScrollPane2))))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(86, 86, 86)
                            .addComponent(jLabel6))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(lblNombreEstudiante, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblIdAnio, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lblIdAnio)
                        .addContainerGap(617, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblNombreEstudiante, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblPeriodo, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGap(6, 6, 6)
                                    .addComponent(jLabel9)))
                            .addComponent(lblGrado, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(cmbAsignaturaCalificaciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(cmbTipoCalificacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtValorCalificacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnGuardarCalificacion)
                            .addComponent(btnLimpiarCampos)
                            .addComponent(jButton1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(scrollListadoCalificaciones)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2)
                        .addContainerGap())))
        );

        lblNombreEstudiante.getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarCalificacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarCalificacionActionPerformed
        Object a = this.controller.getObjetoSeleccionado((GUI.Util.JComboBox)this.cmbAsignaturaCalificaciones);
        Asignatura asignatura = (Asignatura) a;
        Object c = this.controller.getObjetoSeleccionado((GUI.Util.JComboBox)this.cmbTipoCalificacion);
        CaracteristicaBoletin caracteristicaBoletin = (CaracteristicaBoletin) c;
        if(this.detalleSelectedTable == null){
            this.calificacionBusiness.guardarCalificacion(
                matriculaSelected, periodoSelected, this.txtObservacionesBoletin.getText(), asignatura, 
                caracteristicaBoletin, this.txtValorCalificacion.getText(), this.txtObservacionesNotaDada.getText());
            this.scrollListadoCalificaciones.setViewportView(null);
        }
        else{
            this.detalleSelectedTable.setCaracteristicaBoletin(caracteristicaBoletin);
            this.detalleSelectedTable.getCalificacion().setObservaciones(this.txtObservacionesNotaDada.getText());
            this.detalleSelectedTable.setValorNota(this.txtValorCalificacion.getText());
            this.calificacionBusiness.updateCalificacion(detalleSelectedTable);
        }
        this.limpiarCamposCalificaciones();
        this.detalles = this.calificacionBusiness.getListadoTabla(this.matriculaSelected, this.periodoSelected);
        JTable jtable = this.createJTable(this.dataTable());
        this.scrollListadoCalificaciones.setViewportView(jtable);
    }//GEN-LAST:event_btnGuardarCalificacionActionPerformed

    private void btnLimpiarCamposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarCamposActionPerformed
        // TODO add your handling code here:
        this.limpiarCamposCalificaciones();
    }//GEN-LAST:event_btnLimpiarCamposActionPerformed

    private void limpiarCamposCalificaciones(){
        this.cmbAsignaturaCalificaciones.setSelectedIndex(0);
        this.cmbAsignaturaCalificaciones.requestFocusInWindow();
        this.cmbTipoCalificacion.setSelectedIndex(0);
        this.cmbTipoCalificacion.requestFocusInWindow();
        this.txtObservacionesNotaDada.setText("");
        this.txtValorCalificacion.setText("");
        this.detalleSelectedTable = null; 
    }
    
    private void cmbTipoCalificacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTipoCalificacionActionPerformed

    }//GEN-LAST:event_cmbTipoCalificacionActionPerformed

    private void cmbAsignaturaCalificacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbAsignaturaCalificacionesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbAsignaturaCalificacionesActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.calificacionBusiness.deleteCalificacionYDetalle(this.detalleSelectedTable.getCalificacion().getId());
        this.detalles.remove(detalleSelectedTable);
        this.detalleSelectedTable = null;
        JTable jtable = this.createJTable(this.dataTable());
        this.scrollListadoCalificaciones.setViewportView(jtable);
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(CalificacionEstudianteModal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CalificacionEstudianteModal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CalificacionEstudianteModal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CalificacionEstudianteModal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                CalificacionEstudianteModal dialog = new CalificacionEstudianteModal(new javax.swing.JFrame(), true, null, null, null);
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
    private javax.swing.JButton btnGuardarCalificacion;
    private javax.swing.JButton btnLimpiarCampos;
    public javax.swing.JComboBox cmbAsignaturaCalificaciones;
    public javax.swing.JComboBox cmbTipoCalificacion;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblCurso;
    private javax.swing.JLabel lblGrado;
    private javax.swing.JLabel lblIdAnio;
    private javax.swing.JLabel lblNombreEstudiante;
    private javax.swing.JLabel lblPeriodo;
    private javax.swing.JScrollPane scrollListadoCalificaciones;
    private javax.swing.JTextArea txtObservacionesBoletin;
    private javax.swing.JTextArea txtObservacionesNotaDada;
    private javax.swing.JTextField txtValorCalificacion;
    // End of variables declaration//GEN-END:variables
    
    private Object[][] dataTable(){
        int tamAnio = this.detalles.size();
        Object[][] data = new Object[tamAnio][5];
        final String[] columnNames = {"Id", "Asignatura","Nota", "Observacioness", "Tipo Nota"};
        for(int i=0;i<detalles.size();i++){
           DetalleCalificacion d = detalles.get(i);
            data[i][0] = d.getCalificacion().getAsignaturaCursoId().getAsignatura().getId();
            data[i][1] = d.getCalificacion().getAsignaturaCursoId().getAsignatura().getNombre();
            data[i][2] = d.getValorNota();
            data[i][3] = d.getCalificacion().getObservaciones();
            data[i][4] = d.getCaracteristicaBoletin().getId()+"-"+d.getCaracteristicaBoletin().getNombre();
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
                        getDetalleSelected(jTable, lsm.getMinSelectionIndex());
                    }
                }
            });
        } else {
            jTable.setRowSelectionAllowed(false);
        }        
        return jTable;
    }
    private void getDetalleSelected(JTable table, int row) {
        int numRows = table.getRowCount();

        if(row<numRows){
            
            javax.swing.table.TableModel model = table.getModel();
            
            this.anioActual= new Anio();
            int x = (Integer)(model.getValueAt(row,0));    
            System.out.println("Row Selected"+row);
            this.detalleSelectedTable = this.detalles.get(row);
            this.txtValorCalificacion.setText(this.detalleSelectedTable.getValorNota());
            this.controller.setSelectedItemAsignatura(detalleSelectedTable.getCalificacion().getAsignaturaCursoId().getAsignatura());
            this.controller.setSelectedItemTipoCalificacion(detalleSelectedTable.getCaracteristicaBoletin());
            this.txtObservacionesNotaDada.setText(this.detalleSelectedTable.getCalificacion().getObservaciones());
        }        
    }
}
