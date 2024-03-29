/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Telas;

import AcessoBanco.AcessoMysql;
import Classes.Funcionario;
import Controles.AdministradorDAO;
import Controles.FuncionarioDAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author dayan
 */
public class AlteraSenha extends javax.swing.JFrame {
    
    
    List<Funcionario> funcionarios;
    Funcionarios funcionario;
    Funcionario telaFuncionario;
    /**
     * Creates new form AlteraSenha
     */
    public AlteraSenha() {
        initComponents();
        iniciar();
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
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tfUsuario = new javax.swing.JTextField();
        btAlteraSenha = new javax.swing.JButton();
        btSalvar = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();
        btSair = new javax.swing.JButton();
        pfSenhaAntiga = new javax.swing.JPasswordField();
        pfSenhaNova = new javax.swing.JPasswordField();
        pfConfirmaSenha = new javax.swing.JPasswordField();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuOpcoes = new javax.swing.JMenu();
        menuSobre = new javax.swing.JMenuItem();
        menuSair = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Senha antiga: *");

        jLabel2.setText("Senha nova: *");

        jLabel3.setText("Confirmar senha: *");

        jLabel4.setText("*: Campos com preenchimento obrigatório!");

        jLabel5.setText("Usuário: *");

        tfUsuario.setEditable(false);

        btAlteraSenha.setText("Alterar Senha");
        btAlteraSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAlteraSenhaActionPerformed(evt);
            }
        });

        btSalvar.setText("Salvar");
        btSalvar.setEnabled(false);
        btSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarActionPerformed(evt);
            }
        });

        btCancelar.setText("Cancelar");
        btCancelar.setEnabled(false);
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });

        btSair.setText("Sair");
        btSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSairActionPerformed(evt);
            }
        });

        pfSenhaAntiga.setEditable(false);
        pfSenhaAntiga.setText("jPasswordField1");

        pfSenhaNova.setEditable(false);
        pfSenhaNova.setText("jPasswordField2");

        pfConfirmaSenha.setEditable(false);
        pfConfirmaSenha.setText("jPasswordField3");

        menuOpcoes.setText("Opções");

        menuSobre.setText("Sobre");
        menuSobre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSobreActionPerformed(evt);
            }
        });
        menuOpcoes.add(menuSobre);

        menuSair.setText("Sair");
        menuSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSairActionPerformed(evt);
            }
        });
        menuOpcoes.add(menuSair);

        jMenuBar1.add(menuOpcoes);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel4)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(btAlteraSenha)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btSalvar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btCancelar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btSair)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(tfUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(pfSenhaNova, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(71, 71, 71)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pfConfirmaSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jLabel1))
                    .addComponent(jLabel3)
                    .addComponent(pfSenhaAntiga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(72, 72, 72))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btAlteraSenha, btCancelar, btSair, btSalvar});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {pfConfirmaSenha, pfSenhaAntiga, pfSenhaNova, tfUsuario});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pfSenhaAntiga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pfSenhaNova, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pfConfirmaSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btAlteraSenha)
                    .addComponent(btSalvar)
                    .addComponent(btCancelar)
                    .addComponent(btSair))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btAlteraSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAlteraSenhaActionPerformed
        habilitaCampos();
    }//GEN-LAST:event_btAlteraSenhaActionPerformed

    private void btSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSairActionPerformed
        if (JOptionPane.showConfirmDialog(null, "Deseja sair da tela de Alteração de Senha?", "ATENÇÃO!", JOptionPane.YES_NO_OPTION) == 0) {
            this.dispose();
        }
    }//GEN-LAST:event_btSairActionPerformed

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        if(JOptionPane.showConfirmDialog(null, "Deseja Cancelar esta ação?", "ATENÇÃO", JOptionPane.YES_NO_OPTION)==0){
            desabilitaCampos();
        }
    }//GEN-LAST:event_btCancelarActionPerformed

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
        alteraSenha();
    }//GEN-LAST:event_btSalvarActionPerformed

    private void menuSobreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSobreActionPerformed
        JOptionPane.showMessageDialog(null, "Sistema de Emissão de Carteirinhas v1.0 desenvolvido por: \nDayan Costa\nIury Rezende"
                + "\nLuciano Costa\nVitor Almeida");
    }//GEN-LAST:event_menuSobreActionPerformed

    private void menuSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSairActionPerformed
        if (JOptionPane.showConfirmDialog(null, "Esta ação irá sair do sistema por completo, confirma esta ação?", "ATENÇÃO!", JOptionPane.YES_NO_OPTION) == 0) {
            System.exit(0);
        }
        
    }//GEN-LAST:event_menuSairActionPerformed
    
    private void mostrarPrincipalFuncionario(){
        if(telaFuncionario == null){
            
        }
    }
    
    private void iniciar(){
        pfConfirmaSenha.setText(null);
        pfSenhaAntiga.setText(null);
        pfSenhaNova.setText(null);
    }
    
    private void habilitaCampos(){
        tfUsuario.setEditable(true);
        pfConfirmaSenha.setEditable(true);
        pfSenhaAntiga.setEditable(true);
        pfSenhaNova.setEditable(true);  
        btAlteraSenha.setEnabled(false);
        btSalvar.setEnabled(true);
        btCancelar.setEnabled(true);
        btSair.setEnabled(false);
    }
    private void desabilitaCampos(){
        tfUsuario.setEditable(true);
        pfConfirmaSenha.setEditable(true);
        pfSenhaAntiga.setEditable(true);
        pfSenhaNova.setEditable(true);
        btSalvar.setEnabled(false);
        btCancelar.setEnabled(false);
        btSair.setEnabled(true);
    }
    /**
     * Verifica se o login e senha são os mesmo cadastrados no banco de dados
     * @param login
     * @param senha
     * @return
     * @throws SQLException 
     */
    public boolean verificaLogin(String login, String senha) throws SQLException{
        boolean resultado;
         String sql = "select login, senha from funcionarios where login = ? and senha = ?";
         PreparedStatement pstm;
        
         pstm = AcessoMysql.getInstance().conectar().prepareStatement(sql);
         pstm.setString(1, login);
         pstm.setString(2, senha);

         ResultSet rs;
         rs = pstm.executeQuery();

         if(rs.next()){
                String loginBanco = rs.getString("login");
                String senhaBanco = rs.getString("senha");
                resultado = true;
         } else{
             JOptionPane.showMessageDialog(null, "Usuário e/ou Senha Antiga Incorretos!");
             resultado = false;
         }
         
         AcessoMysql.getInstance().desconectar();
         
        return resultado;
    }
   
    
    public void alteraSenha(){
        try{
            if(verificaLogin(tfUsuario.getText(), pfSenhaAntiga.getText())){
                if(pfSenhaNova.getText().equals(pfConfirmaSenha.getText())){
                    Funcionario func = new Funcionario();

                    func.setSenha(pfSenhaNova.getText().trim());

                    FuncionarioDAO dao = new FuncionarioDAO();
                    dao.alteraSenha(func);
                    JOptionPane.showMessageDialog(null,"Senha do Funcionário:" + func.getNome() + " alterada com sucesso!");
                    desabilitaCampos();

                } else{
                    JOptionPane.showMessageDialog(null, "Nova Senha e Confirmação não se conferem!");
                    pfSenhaNova.setText("");
                    pfConfirmaSenha.setText("");
                    pfSenhaNova.requestFocus();
                }
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
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
            java.util.logging.Logger.getLogger(AlteraSenha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AlteraSenha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AlteraSenha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AlteraSenha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AlteraSenha().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAlteraSenha;
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btSair;
    private javax.swing.JButton btSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu menuOpcoes;
    private javax.swing.JMenuItem menuSair;
    private javax.swing.JMenuItem menuSobre;
    private javax.swing.JPasswordField pfConfirmaSenha;
    private javax.swing.JPasswordField pfSenhaAntiga;
    private javax.swing.JPasswordField pfSenhaNova;
    private javax.swing.JTextField tfUsuario;
    // End of variables declaration//GEN-END:variables
}
