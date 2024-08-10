/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import java.util.List;
import projeto.studio.danca.dao.PersistenciaJPA;
import projeto.studio.danca.model.Professores;
import projeto.studio.danca.model.modalidades;

/**
 *
 * @author aliss
 */
public class TelaCadastroModalidades extends javax.swing.JDialog {
    
    private modalidades modal;
    PersistenciaJPA persistencia;
    /**
     * Creates new form TelaCadastroModalidades
     */
    public TelaCadastroModalidades(java.awt.Frame parent, boolean mod) {
        super(parent, mod);
        initComponents();
        preencheListaProf();
    }
    
    public void preencheListaProf() {
    persistencia = new PersistenciaJPA();
    List<Professores> listProf = null;

    try {
        persistencia.conexaoAberta();
        
        listProf = persistencia.getProfessores();
        if (listProf != null) {
            System.out.println("Número de professores encontrados: " + listProf.size());
        } else {
            System.out.println("A lista de professores está nula.");
        }
        for (Professores p : listProf) {
            boxProfessor.addItem(p);
        }
        persistencia.fecharConexao();
    } catch (Exception e) {
        System.out.println("Erro ao buscar professores: " + e.getMessage());
        e.printStackTrace();
    }


    if (modal != null) {
        txtDescr.setText(modal.getDescricao());

        if (modal.getProfessores() != null) {
            for (Professores p : listProf) {
                if (p.getId().equals(modal.getProfessores().getId())) {
                    boxProfessor.setSelectedItem(p);
                }
            }
        } else {
            boxProfessor.setSelectedIndex(-1);
        }
    }
}

    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        boxProfessor = new javax.swing.JComboBox<>();
        txtDescr = new javax.swing.JTextField();
        bntSave = new javax.swing.JButton();
        bntCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("CADASTRAR MODALIDADES");

        jLabel2.setText("Descrição:");

        jLabel3.setText("Professor:");

        txtDescr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDescrActionPerformed(evt);
            }
        });

        bntSave.setText("Salvar");
        bntSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntSaveActionPerformed(evt);
            }
        });

        bntCancel.setText("Cancelar");
        bntCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(124, 124, 124))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtDescr)
                            .addComponent(boxProfessor, 0, 209, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addComponent(bntSave)
                .addGap(67, 67, 67)
                .addComponent(bntCancel)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jLabel1)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(txtDescr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(boxProfessor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bntSave)
                    .addComponent(bntCancel))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtDescrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescrActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDescrActionPerformed

    private void bntCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntCancelActionPerformed
       dispose();
    }//GEN-LAST:event_bntCancelActionPerformed

    private void bntSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntSaveActionPerformed
        if(modal == null){
           modal = new modalidades();
           modal.setDescricao(txtDescr.getText());
           modal.setProfessores((Professores)boxProfessor.getSelectedItem());
           
           persistencia = new PersistenciaJPA();
            persistencia.conexaoAberta();
            persistencia.persist(modal);
            persistencia.fecharConexao();
            dispose();
           
       } else {
           try {
                modalidades test = new modalidades();
                test = modal;
                test = (modalidades) persistencia.find(modalidades.class, test.getId());
                test.setDescricao(txtDescr.getText());
                test.setProfessores((Professores)boxProfessor.getSelectedItem());
                persistencia.conexaoAberta();
                persistencia.persist(test);
                persistencia.fecharConexao();
                dispose();
            } catch (Exception e) {
                System.out.println("Erro" + e.getMessage());
            }
       }
    }//GEN-LAST:event_bntSaveActionPerformed

    private void boxProfessorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxProfessorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boxProfessorActionPerformed

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
            java.util.logging.Logger.getLogger(TelaCadastroModalidades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroModalidades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroModalidades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroModalidades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TelaCadastroModalidades dialog = new TelaCadastroModalidades(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton bntCancel;
    private javax.swing.JButton bntSave;
    private javax.swing.JComboBox<Professores> boxProfessor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField txtDescr;
    // End of variables declaration//GEN-END:variables
}
