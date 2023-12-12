/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package projetoa3;

/**
 *
 * @author fgs_l
 */
public class Carros extends javax.swing.JFrame {

    /**
     * Creates new form Carros
     */
    public Carros() {
        initComponents();
        
        DB db = new DB("BancoDados.db");
        
        db.query("SELECT * from Carros");
        String cols[] = {"CODIGO", "NOME", "COR", "MARCA", "QUANTIDADE", "ANO", "PRECO"};
        String fields[] = {"Codigo", "Nome", "Cor", "Marca", "Quantidade", "Ano", "Preco"};
        TableRender.render(table, cols, fields, db);
        while(db.next()){
            int codigo = db.getInt("Codigo");
            String carro = db.getString("Nome");
            System.out.println("C�digo: " + codigo);
            System.out.println("Nome: " + carro);
           }
        db.closeConnection();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        novoCarro = new javax.swing.JButton();
        edicao = new javax.swing.JButton();
        atualizarTabela = new javax.swing.JButton();
        removerCarro = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        novoCarro.setText("Adicionar Carro");
        novoCarro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                novoCarroActionPerformed(evt);
            }
        });

        edicao.setText("Editar Carro");
        edicao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edicaoActionPerformed(evt);
            }
        });

        atualizarTabela.setText("Atualizar Tabela");
        atualizarTabela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atualizarTabelaActionPerformed(evt);
            }
        });

        removerCarro.setText("Remover Carro");
        removerCarro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removerCarroActionPerformed(evt);
            }
        });

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(table);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(novoCarro)
                        .addGap(18, 18, 18)
                        .addComponent(edicao, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(atualizarTabela)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(removerCarro)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(novoCarro)
                    .addComponent(edicao)
                    .addComponent(atualizarTabela)
                    .addComponent(removerCarro))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void novoCarroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_novoCarroActionPerformed
        BotaoAdicionarCarro cadastro = new BotaoAdicionarCarro();
        cadastro.setVisible(true);
    }//GEN-LAST:event_novoCarroActionPerformed

    private void atualizarTabelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atualizarTabelaActionPerformed
        this.dispose();
        
        DB db = new DB("BancoDados.db");
        
        db.query("SELECT * from Carros");
        String cols[] = {"CODIGO", "NOME", "COR", "MARCA", "QUANTIDADE", "ANO", "PRECO"};
        String fields[] = {"Codigo", "Nome", "Cor", "Marca", "Quantidade", "Ano", "Preco"};
        TableRender.render(table, cols, fields, db);
        while(db.next()){
            int codigo = db.getInt("Codigo");
            String carro = db.getString("Nome");
            System.out.println("C�digo: " + codigo);
            System.out.println("Nome: " + carro);
           }
        
        this.setVisible(true);
        
        db.closeConnection();
    }//GEN-LAST:event_atualizarTabelaActionPerformed

    private void removerCarroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removerCarroActionPerformed
        var linhaSelecionada = table.getSelectedRow();
        var codigo = table.getValueAt(linhaSelecionada, 0);
        
        DB db = new DB("BancoDados.db");
        var query = "DELETE FROM Carros WHERE Codigo = " + codigo; 
        db.execQuery(query);
    }//GEN-LAST:event_removerCarroActionPerformed

    private void edicaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edicaoActionPerformed
        BotaoEditarCarro editar = new BotaoEditarCarro();
        editar.setVisible(true);
    }//GEN-LAST:event_edicaoActionPerformed

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
            java.util.logging.Logger.getLogger(Carros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Carros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Carros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Carros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Carros().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton atualizarTabela;
    private javax.swing.JButton edicao;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton novoCarro;
    private javax.swing.JButton removerCarro;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
