package Vista;

import Modelo.Bunch;
import Controlador.Operaciones;
import javax.swing.JOptionPane;

public class Panel extends javax.swing.JFrame {

    Operaciones ope = new Operaciones();

    public Panel() {
        initComponents();
        ope.init();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ejer_label = new javax.swing.JLabel();
        b_cargar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        ta_write = new javax.swing.JTextArea();
        b_write = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(467, 398));
        setSize(this.getPreferredSize());
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        b_cargar.setText("Cargar data");
        b_cargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_cargarActionPerformed(evt);
            }
        });

        ta_write.setColumns(20);
        ta_write.setRows(5);
        ta_write.setText("Ingrese su texto aqui...");
        ta_write.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ta_writeMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(ta_write);

        b_write.setText("Escribir data");
        b_write.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_writeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(ejer_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(184, 184, 184)
                        .addComponent(b_cargar)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(190, 190, 190)
                .addComponent(b_write)
                .addContainerGap(183, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ejer_label, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(b_cargar)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(b_write)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void b_cargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_cargarActionPerformed
        ta_write.setText("");
        ejer_label.setText(ope.get(0).getMensaje());
    }//GEN-LAST:event_b_cargarActionPerformed

    private void b_writeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_writeActionPerformed
        String msj = ta_write.getText();
        String label_msj = ejer_label.getText();
        if (!msj.isBlank()) {
            if (ope.rows() > 0) {
                Bunch del_bunch = ope.busqueda_msj(label_msj);
                ope.remove(del_bunch);
                ope.grabarModificareliminar();
            }

            Bunch add_bunch = new Bunch();
            add_bunch.setMensaje(msj);
            ope.agregar(add_bunch);
            ope.grabar_archivo(add_bunch);
        } else {
            JOptionPane.showMessageDialog(rootPane, "Escriba algo en el cuadro");
        }
    }//GEN-LAST:event_b_writeActionPerformed

    private void ta_writeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ta_writeMouseClicked
        ta_write.setText("");
    }//GEN-LAST:event_ta_writeMouseClicked

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        for (int i = 0; i < ope.rows(); i++) {
            ope.remove(ope.get(i));
        }
        ope.grabarModificareliminar();
        System.exit(0);
    }//GEN-LAST:event_formWindowClosing

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
            java.util.logging.Logger.getLogger(Panel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Panel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Panel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Panel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Panel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b_cargar;
    private javax.swing.JButton b_write;
    private javax.swing.JLabel ejer_label;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea ta_write;
    // End of variables declaration//GEN-END:variables
}
