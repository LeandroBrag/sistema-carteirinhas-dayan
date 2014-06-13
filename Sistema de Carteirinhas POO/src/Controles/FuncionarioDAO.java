    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controles;

import AcessoBanco.AcessoMysql;
import Classes.Carteirinha;
import Classes.Estudante;
import Classes.Funcionario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author dayan
 */
public class FuncionarioDAO {

    PreparedStatement pstm;
    ResultSet rs;
    Estudante estudante = new Estudante();

    public FuncionarioDAO() {
    }

    String cadastraEstudante = "INSERT INTO estudantes (NOME, CPF, TELEFONE,INSTITUICAO_ENSINO, CURSO, DATA_NASCIMENTO, NUMERO_MATRICULA, FOTO)"
            + " VALUES (?,?,?,?,?,?,?,?)";
    String consultaEstudante = "SELECT * FROM estudantes WHERE NOME LIKE ?";
    String alteraEstudante = "UPDATE estudantes SET nome=?, cpf=?, telefone=?, instituicao_ensino=?, curso=?,"
            + "numero_matricula=?, data_nascimento=?, foto=? where id=?";
    
    /**
     * Cadastra um estudante no banco de dados.
     * @param estudante
     * @throws SQLException 
     */
    public void cadastraEstudante(Estudante estudante) throws SQLException {

        pstm = AcessoMysql.getInstance().conectar().prepareStatement(cadastraEstudante);

        pstm.setString(1, estudante.getNome());
        pstm.setString(2, estudante.getCpf());
        pstm.setString(3, estudante.getTelefone());
        pstm.setString(4, estudante.getInstituicaoDeEnsino());
        pstm.setString(5, estudante.getCurso());
        pstm.setString(6, estudante.getDataNascimento());
        pstm.setString(7, estudante.getNumeroMatricula());
        pstm.setString(8, estudante.getFoto());

        pstm.execute();
        AcessoMysql.getInstance().desconectar();
    }
    /**
     * Cadastra uma carterinha
     * @param carteirinha
     * @throws SQLException 
     */
    public void cadastraCarteirinha(Carteirinha carteirinha) throws SQLException {
        String sql = "INSERT INTO carteirinhas (data_emissao, data_vencimento, id_estudante)"
                + " VALUES (?,?,?)";

        pstm = AcessoMysql.getInstance().conectar().prepareStatement(sql);

        pstm.setString(1, carteirinha.getDataEmissao());
        pstm.setString(2, carteirinha.getDataValidade());
        pstm.setInt(3, carteirinha.getId_estudante());

        pstm.execute();
        AcessoMysql.getInstance().desconectar();

    }
    /**
     * Lista estudantes cadastrados no banco de dados pelo nome
     * @param nome
     * @return
     * @throws SQLException
     * @throws Exception 
     */

    public List<Estudante> listarEstudantes(String nome) throws SQLException, Exception {
        String sql = "SELECT estudantes.*, carteirinhas.*"
                + " FROM estudantes INNER JOIN carteirinhas ON "
                + "estudantes.id = carteirinhas.id_estudante WHERE estudantes.nome LIKE ?";
        List<Estudante> estudantes = new ArrayList<>();

        pstm = AcessoMysql.getInstance().conectar().prepareStatement(sql);
        pstm.setString(1, nome);
        rs = pstm.executeQuery();

        while (rs.next()) {
            
            Carteirinha carteirinha = new Carteirinha();
            carteirinha.setDataEmissao(rs.getString("data_emissao"));
            carteirinha.setDataValidade(rs.getString("data_vencimento"));
            
            Estudante estudante = new Estudante();
            estudante.setId(Integer.valueOf(rs.getString("id_estudante")));
            estudante.setNome(rs.getString("nome"));
            estudante.setCpf(rs.getString("cpf"));
            estudante.setTelefone(rs.getString("telefone"));
            estudante.setInstituicaoDeEnsino(rs.getString("instituicao_ensino"));
            estudante.setCurso(rs.getString("curso"));
            estudante.setDataNascimento(rs.getString("data_nascimento"));
            estudante.setNumeroMatricula(rs.getString("numero_matricula"));
            estudante.setFoto(rs.getString("foto"));
            estudante.setCarteirinha(carteirinha);
           
            estudantes.add(estudante);

        }
        rs.close();
        pstm.close();
        return estudantes;
    }

    /**
     * Lista estudantes cadastrados no banco de dados pelo CPF
     * @param cpf
     * @return
     * @throws SQLException
     */
    public List<Estudante> listarEstudantesCpf(String cpf) throws SQLException {
        List<Estudante> estudantes = new ArrayList<Estudante>();
        String sql = "select * from estudantes where CPF like ?";

        pstm = AcessoMysql.getInstance().conectar().prepareStatement(sql);
        pstm.setString(1, cpf);
        rs = pstm.executeQuery();

        while (rs.next()) {
            Estudante estudante = new Estudante();

            estudante.setId(Integer.valueOf(rs.getString("id")));

            estudantes.add(estudante);

        }
        rs.close();
        pstm.close();
        return estudantes;
    }

    /**
     * Lista estudantes cadastrados no banco de dados pela instituição de ensino
     * @param instituicaoEnsino
     * @return
     * @throws SQLException
     */
    public List<Estudante> listarEstudantesInstituicao(String instituicaoEnsino) throws SQLException {
        List<Estudante> estudantes = new ArrayList<>();

        String sql = "select * from estudantes where INSTITUICAO_ENSINO like ?";

        pstm = AcessoMysql.getInstance().conectar().prepareStatement(sql);
        pstm.setString(1, instituicaoEnsino);
        rs = pstm.executeQuery();

        while (rs.next()) {
            Estudante estudante = new Estudante();

            estudante.setId(Integer.valueOf(rs.getString("id")));

            estudantes.add(estudante);

        }
        rs.close();
        pstm.close();
        return estudantes;
    }

    /**
     * Lista estudantes cadastrados no banco de dados pelo número de matricula
     * @param numeroMatricula
     * @return
     * @throws SQLException
     */
    public List<Estudante> listarEstudantesMatricula(String numeroMatricula) throws SQLException {
        List<Estudante> estudantes = new ArrayList<Estudante>();

        String sql = "select * from estudantes where NUMERO_MATRICULA like ?";

        pstm = AcessoMysql.getInstance().conectar().prepareStatement(sql);
        pstm.setString(1, numeroMatricula);
        rs = pstm.executeQuery();

        while (rs.next()) {
            Estudante estudante = new Estudante();

            estudante.setId(Integer.valueOf(rs.getString("id")));

            estudantes.add(estudante);

        }
        rs.close();
        pstm.close();
        return estudantes;
    }
    /**
     * Modifica os dados de um estudante cadastrado no banco de dados
     * @param estudante
     * @throws SQLException
     */
    public void alteraEstudante(Estudante estudante) throws SQLException {

        pstm = AcessoMysql.getInstance().conectar().prepareStatement(alteraEstudante);

        pstm.setString(1, estudante.getNome());
        pstm.setString(2, estudante.getCpf());
        pstm.setString(3, estudante.getTelefone());
        pstm.setString(4, estudante.getInstituicaoDeEnsino());
        pstm.setString(5, estudante.getCurso());
        pstm.setString(6, estudante.getNumeroMatricula());
        pstm.setString(7, estudante.getDataNascimento());
        pstm.setString(8, estudante.getFoto());
        pstm.setInt(9, estudante.getId());

        pstm.executeUpdate();
        AcessoMysql.getInstance().desconectar();

    }
    /**
     * Revalida uma carteirinha de estudante
     * @param carteirinha
     * @throws SQLException 
     */

    public void revalidaCarteirinha(Carteirinha carteirinha) throws SQLException {
        String sql = "UPDATE carteirinhas SET data_vencimento=? WHERE id = ?";

        pstm = AcessoMysql.getInstance().conectar().prepareStatement(sql);

        pstm.setString(1, carteirinha.getDataValidade());

        pstm.executeUpdate();
        AcessoMysql.getInstance().desconectar();

    }
    /**
     * Permite que o funcionário altere a sua senha de acesso ao sistema
     * @param funcionario
     * @throws SQLException 
     */

    public void alteraSenha(Funcionario funcionario) throws SQLException {
        String sql = "update funcionarios SET SENHA=? where LOGIN=?";
        pstm = AcessoMysql.getInstance().conectar().prepareStatement(sql);

        pstm.setString(1, funcionario.getSenha());

        pstm.executeUpdate();
        AcessoMysql.getInstance().desconectar();

    }
    /**
     * Exclui ume estudante do sistema
     * @param estudante
     * @throws SQLException 
     */

    public void excluirEstudante(Estudante estudante) throws SQLException {
        String sql = "delete from estudantes where nome like ?";
        pstm = AcessoMysql.getInstance().conectar().prepareStatement(sql);
        pstm.setString(1, estudante.getNome());
        pstm.executeUpdate();
        AcessoMysql.getInstance().desconectar();

    }
    /**
     * Lista as carteirinhas de estudante cadastradas no banco de dados
     * @param nomeEstudante
     * @return
     * @throws SQLException
     */

    public List<Carteirinha> listarCarteirinhas(String nomeEstudante) throws SQLException {
        String sql = "SELECT estudantes.*, carteirinhas.*"
                + " FROM carteirinhas INNER JOIN estudantes ON "
                + "estudantes.id = carteirinhas.id_estudante WHERE estudantes.nome LIKE ?";
        List<Carteirinha> carteirinhas = new ArrayList<>();
                
        pstm = AcessoMysql.getInstance().conectar().prepareStatement(sql);
        pstm.setString(1, nomeEstudante);
        rs = pstm.executeQuery();

        while (rs.next()) {
           Estudante estudante = new Estudante();
           estudante.setId(rs.getInt("id"));
           estudante.setNome(rs.getString("nome"));
           estudante.setCpf(rs.getString("cpf"));
           estudante.setTelefone(rs.getString("telefone"));
           estudante.setInstituicaoDeEnsino(rs.getString("instituicao_ensino"));
           estudante.setCurso(rs.getString("curso"));
           estudante.setDataNascimento(rs.getString("data_nascimento"));
           estudante.setNumeroMatricula(rs.getString("numero_matricula"));
           estudante.setId(rs.getInt("id_estudante"));

           Carteirinha carteirinha = new Carteirinha();
           carteirinha.setId(rs.getInt("id_carteirinha"));
           carteirinha.setDataEmissao(rs.getString("data_emissao"));
           carteirinha.setDataValidade(rs.getString("data_vencimento"));
           carteirinha.setEstudante(estudante);
           
           carteirinhas.add(carteirinha);
            
        }
        rs.close();
        pstm.close();
        AcessoMysql.getInstance().desconectar();

        return carteirinhas;
    }
}

