/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//ADICIONAR METODOS PARA LOGIN

package Controles;

import AcessoBanco.AcessoMysql;
import Classes.Funcionario;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * extends FuncionarioDAO
 * @author dayan
 */
public class AdministradorDAO extends FuncionarioDAO {
    
    
    String consultaFuncionario = "select * from funcionarios where NOME like ?";
    String cadastraFuncionario = "INSERT INTO funcionarios (NOME, CPF, ENDERECO, CEP, CIDADE, UF, TELEFONE, DATA_NASCIMENTO, LOGIN, SENHA) "
            + "VALUES (?,?,?,?,?,?,?,?,?,?)";
    String alteraFuncionario = "update funcionarios set NOME=?, CPF=?, ENDERECO=?, CIDADE=?, UF=?, CEP=?, TELEFONE=?,"
                + "data_nascimento=?, login=? where id=?";
    String excluirFuncionario = "delete from funcionarios where nome like ?";
    
    /**
     * Cadastra um funcionário no banco de dados MySQL
     * @param funcionario
     * @throws SQLException 
     */    
    public void cadastraFuncionario(Funcionario funcionario) throws SQLException{
                        
        pstm = AcessoMysql.getInstance().conectar().prepareStatement(cadastraFuncionario);

        pstm.setString(1, funcionario.getNome());
        pstm.setString(2, funcionario.getCpf());
        pstm.setString(3, funcionario.getEndereco());
        pstm.setString(4, funcionario.getCep());
        pstm.setString(5, funcionario.getCidade());
        pstm.setString(6, funcionario.getUf());
        pstm.setString(7, funcionario.getTelefone());
        pstm.setString(8, funcionario.getDataNascimento());
        pstm.setString(9, funcionario.getLogin());
        pstm.setString(10, funcionario.getSenha());

        pstm.execute();
        AcessoMysql.getInstance().desconectar();
    }
    /**
     * Lista os funcionários pelo Nome
     * @param nome
     * @return
     * @throws SQLException 
     */
    public List<Funcionario> listarFuncionarios(String nome) throws SQLException {
        List<Funcionario> funcionarios = new ArrayList<>();

        pstm = AcessoMysql.getInstance().conectar().prepareStatement(consultaFuncionario);
        pstm.setString(1, nome);
        rs = pstm.executeQuery();

        while (rs.next()) {
            Funcionario funcionario = new Funcionario();

            funcionario.setId(Integer.valueOf(rs.getString("id")));
            funcionario.setNome(rs.getString("nome"));
            funcionario.setCpf(rs.getString("cpf"));
            funcionario.setEndereco(rs.getString("endereco"));
            funcionario.setCep(rs.getString("cep"));
            funcionario.setCidade(rs.getString("cidade"));
            funcionario.setUf(rs.getString("uf"));
            funcionario.setTelefone(rs.getString("telefone"));
            funcionario.setDataNascimento(rs.getString("DATA_NASCIMENTO"));
            funcionario.setLogin(rs.getString("login"));
            
            funcionarios.add(funcionario);

        }
        rs.close();
        pstm.close();
        return funcionarios;
    }
    /**
     * Lista os funcionários pelo CPF
     * @param cpf
     * @return
     * @throws SQLException 
     */
    public List<Funcionario> listarFuncionariosCpf(String cpf) throws SQLException{
        List<Funcionario> funcionarios = new ArrayList<Funcionario>();
        String sql = "select * from funcionarios where CPF like ?";
        
        pstm = AcessoMysql.getInstance().conectar().prepareStatement(sql);
        pstm.setString(1, cpf);
        rs = pstm.executeQuery();

        while (rs.next()) {
            Funcionario funcionario = new Funcionario();

            funcionario.setId(Integer.valueOf(rs.getString("id")));
                       
            funcionarios.add(funcionario);

        }
        rs.close();
        pstm.close();
        return funcionarios;
    }
    /**
     * Lista os funcionários pelo Login do sistema
     * @param login
     * @return
     * @throws SQLException 
     */
     public List<Funcionario> listarFuncionariosLogin(String login) throws SQLException{
        List<Funcionario> funcionarios = new ArrayList<Funcionario>();
        String sql = "select * from funcionarios where login like ?";
        
        pstm = AcessoMysql.getInstance().conectar().prepareStatement(sql);
        pstm.setString(1, login);
        rs = pstm.executeQuery();

        while (rs.next()) {
            Funcionario funcionario = new Funcionario();

            funcionario.setId(Integer.valueOf(rs.getString("id")));
                      
            funcionarios.add(funcionario);

        }
        rs.close();
        pstm.close();
        return funcionarios;
    }
     /**
      * Modifica os dados dos Funcionários
      * @param funcionario
      * @throws SQLException 
      */
    public void alteraFuncionario(Funcionario funcionario) throws SQLException {
              
        pstm = AcessoMysql.getInstance().conectar().prepareStatement(alteraFuncionario);

        pstm.setString(1, funcionario.getNome());
        pstm.setString(2, funcionario.getCpf());
        pstm.setString(3, funcionario.getEndereco());
        pstm.setString(4, funcionario.getCidade());
        pstm.setString(5, funcionario.getUf());
        pstm.setString(6, funcionario.getCep());
        pstm.setString(7, funcionario.getTelefone());
        pstm.setString(8, funcionario.getDataNascimento());
        pstm.setString(9, funcionario.getLogin());
        pstm.setInt(10, funcionario.getId());
        
        pstm.executeUpdate();
        AcessoMysql.getInstance().desconectar();

    } 
    /**
     * Exclui um funcionário do Banco.
     * @param funcionario
     * @throws SQLException 
     */
    public void excluirFuncionario(Funcionario funcionario) throws SQLException {
        
        pstm = AcessoMysql.getInstance().conectar().prepareStatement(excluirFuncionario);
        pstm.setString(1, funcionario.getNome());
        pstm.executeUpdate();
        AcessoMysql.getInstance().desconectar();

    }
}
