/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Controladores.ControladorBatalla;

/**
 *
 * @author Lucas
 */
public class Trampas extends javax.swing.JPanel {
    
    

    /**
     * Creates new form Trampas
     */
    public Trampas() {
        initComponents();
        this.setSize(399, 401);
        trampaOsos.setToolTipText("Impide el movimiento de la criatura, pero esta puede atacar.");
        trampaLadrones.setToolTipText("Hace retroceder a la criatura un espacio y le quita el 10% de su salud restante.ln Incluye las casillas adyacentes");
        renacerMuerto.setToolTipText("Revive a una criatura, la cual se coloca en lugar de la criatura actual, que vuelve a ser un dado.");
        
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
        trampaOsos = new javax.swing.JButton();
        trampaLadrones = new javax.swing.JButton();
        renacerMuerto = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Elija la trampa que desea colocar.");

        jLabel2.setText("Puede mantener el mouse sobre el botón para ver la descripción.");

        trampaOsos.setText("Trampa de osos.");
        trampaOsos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                trampaOsosActionPerformed(evt);
            }
        });

        trampaLadrones.setText("Trampa para ladrones.");
        trampaLadrones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                trampaLadronesActionPerformed(evt);
            }
        });

        renacerMuerto.setText("Renacer de los muertos.");
        renacerMuerto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                renacerMuertoActionPerformed(evt);
            }
        });

        jLabel3.setText("Coste: 10 de trampa.");

        jLabel4.setText("Coste: 15 de trampa.");

        jLabel5.setText("Coste: 35 de trampa.");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(jLabel1)))
                .addContainerGap(70, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(trampaOsos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(trampaLadrones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(renacerMuerto, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel5))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jLabel4))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jLabel3)))
                .addGap(114, 114, 114))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(27, 27, 27)
                .addComponent(trampaOsos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(21, 21, 21)
                .addComponent(trampaLadrones)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(19, 19, 19)
                .addComponent(renacerMuerto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addContainerGap(131, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void trampaOsosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_trampaOsosActionPerformed
        // TODO add your handling code here:
        Controladores.ControladorBatalla.setBoton(21);
        this.setVisible(false);
        VistaBatalla.tablero.setVisible(true);
    }//GEN-LAST:event_trampaOsosActionPerformed

    private void trampaLadronesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_trampaLadronesActionPerformed
        // TODO add your handling code here:
        Controladores.ControladorBatalla.setBoton(22);
        this.setVisible(false);
        VistaBatalla.tablero.setVisible(true);
    }//GEN-LAST:event_trampaLadronesActionPerformed

    private void renacerMuertoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_renacerMuertoActionPerformed
        // TODO add your handling code here:
        Controladores.ControladorBatalla.setBoton(23);
        this.setVisible(false);
        VistaBatalla.tablero.setVisible(true);
    }//GEN-LAST:event_renacerMuertoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JButton renacerMuerto;
    private javax.swing.JButton trampaLadrones;
    private javax.swing.JButton trampaOsos;
    // End of variables declaration//GEN-END:variables
}
