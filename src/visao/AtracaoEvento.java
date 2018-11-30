package visao;

import modelo.ModeloTabela;
import controle.ConectaBanco;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;

public class AtracaoEvento extends javax.swing.JFrame {

    ConectaBanco conectaAtracaoEvento = new ConectaBanco();
    String combinadata;

    public AtracaoEvento() {
        initComponents();
        conectaAtracaoEvento.conexao();
        conectaAtracaoEvento.executaSQL("select nome,data from evento join contrato on nome=eventonome and data=eventodata");
        jComboBoxAtracaoEvento.removeAllItems();
        try {
            conectaAtracaoEvento.rs.first();
            do {
                combinadata = "" + conectaAtracaoEvento.rs.getString("nome") + "-" + conectaAtracaoEvento.rs.getString("data") + "";
                jComboBoxAtracaoEvento.addItem(combinadata);
            } while (conectaAtracaoEvento.rs.next());
        } catch (SQLException ex) {
        }

    }

    public void PreencherTabela(String SQL) {
        ArrayList dados = new ArrayList();
        String[] colunas = new String[]{"Nome", "Cache"}; // aqui são os nomes que irão aparecer nas colunas da tabela
        try {
            conectaAtracaoEvento.executaSQL(SQL);
            conectaAtracaoEvento.rs.first();
            do {
                dados.add(new Object[]{conectaAtracaoEvento.rs.getString("NOME"), conectaAtracaoEvento.rs.getString("VALORCACHE")});
            } while (conectaAtracaoEvento.rs.next());
        } catch (SQLException ex) {
        }
        
        ModeloTabela modelo = new ModeloTabela(dados, colunas);
        jTableAtracaoEvento.setModel(modelo);
        jTableAtracaoEvento.getColumnModel().getColumn(0).setPreferredWidth(285);
        jTableAtracaoEvento.getColumnModel().getColumn(0).setResizable(false);
        jTableAtracaoEvento.getColumnModel().getColumn(1).setPreferredWidth(285);
        jTableAtracaoEvento.getColumnModel().getColumn(1).setResizable(false);
        jTableAtracaoEvento.getTableHeader().setReorderingAllowed(false);
        jTableAtracaoEvento.setAutoResizeMode(jTableAtracaoEvento.AUTO_RESIZE_OFF);
        jTableAtracaoEvento.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelNumAtracoesEventos = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableAtracaoEvento = new javax.swing.JTable();
        jComboBoxAtracaoEvento = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jButtonRefreshAtracaoEvento = new javax.swing.JButton();
        jButtonAtracaoEventoSair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Atrações do Evento");

        jTableAtracaoEvento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTableAtracaoEvento);

        jComboBoxAtracaoEvento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxAtracaoEventoActionPerformed(evt);
            }
        });

        jLabel4.setText("Evento");

        jButtonRefreshAtracaoEvento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/refresh.png"))); // NOI18N
        jButtonRefreshAtracaoEvento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRefreshAtracaoEventoActionPerformed(evt);
            }
        });

        jButtonAtracaoEventoSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/sign-out.png"))); // NOI18N
        jButtonAtracaoEventoSair.setToolTipText("Sair");
        jButtonAtracaoEventoSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAtracaoEventoSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                        .addComponent(jComboBoxAtracaoEvento, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonRefreshAtracaoEvento, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonAtracaoEventoSair, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabelNumAtracoesEventos, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jComboBoxAtracaoEvento, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButtonRefreshAtracaoEvento, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonAtracaoEventoSair, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelNumAtracoesEventos, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxAtracaoEventoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxAtracaoEventoActionPerformed

    }//GEN-LAST:event_jComboBoxAtracaoEventoActionPerformed

    private void jButtonRefreshAtracaoEventoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRefreshAtracaoEventoActionPerformed
        String concatenada;
        String array[] = new String[2];
        concatenada = (String) jComboBoxAtracaoEvento.getSelectedItem();
        array = concatenada.split("-");
        PreencherTabela("select nome,valorcache from contrato join atracao on atracao=cnpj"
                + " where eventonome='" + array[0] + "' and"
                + " eventodata ='" + array[1] + "'");
    }//GEN-LAST:event_jButtonRefreshAtracaoEventoActionPerformed

    private void jButtonAtracaoEventoSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAtracaoEventoSairActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButtonAtracaoEventoSairActionPerformed

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
            java.util.logging.Logger.getLogger(AtracaoEvento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AtracaoEvento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AtracaoEvento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AtracaoEvento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AtracaoEvento().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAtracaoEventoSair;
    private javax.swing.JButton jButtonRefreshAtracaoEvento;
    private javax.swing.JComboBox jComboBoxAtracaoEvento;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelNumAtracoesEventos;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableAtracaoEvento;
    // End of variables declaration//GEN-END:variables
}
