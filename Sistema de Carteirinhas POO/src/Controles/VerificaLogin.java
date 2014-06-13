    /*
     * To change this license header, choose License Headers in Project Properties.
     * To change this template file, choose Tools | Templates
     * and open the template in the editor.
     */

    package Controles;


    import AcessoBanco.AcessoMysql;
    import Telas.PrincipalAdministrador;
    import Telas.PrincipalFuncionario;
    import java.sql.PreparedStatement;
    import java.sql.ResultSet;
    import java.sql.SQLException;
    import javax.swing.JOptionPane;

    /**
     *
     * @author dayan
     */
    public class VerificaLogin {

        PrincipalAdministrador principalAdm;
        PrincipalFuncionario principalFunc;

        private void mostraAdm(){
            if(principalAdm == null){
                principalAdm = new PrincipalAdministrador();
                principalAdm.setVisible(true);
            }else{
                principalAdm.setVisible(true);
            }
        }
        private void mostraFuncionario(){
            if(principalFunc == null){
                principalFunc = new PrincipalFuncionario();
                principalFunc.setVisible(true);
            }else{
                principalFunc.setVisible(true);
            }
        }

        public boolean verificarAdm(String usuario, String senha) {

            if((usuario.equals("admin"))&&(senha.equals("admin"))){
                JOptionPane.showMessageDialog(null, "Seja bem-vindo Administrador!");
                mostraAdm();
                return true;            
            }
            return false;
        }

        /**
         * Faz a validação de Login e Senha de um funcionário/administrador do sistema no banco de dados
         * @param login
         * @param senha
         * @return
         * @throws SQLException 
         */
        public boolean verificarFuncionario(String login, String senha) throws SQLException{
            boolean autenticacao;
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
                JOptionPane.showMessageDialog(null, "Seja bem-vindo!");
                mostraFuncionario();
                autenticacao = true;
            } else {
                autenticacao = false;
            }

            AcessoMysql.getInstance().desconectar();

            return autenticacao;

        }

    }
