/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Classes;

/**
 *
 * @author note
 */
public class Estudante extends Pessoa {
    private String numeroMatricula;
    private String curso;
    private String instituicaoDeEnsino;
    private Carteirinha carteirinha;
    private String foto;
    
       

    /**
     * @return the numeroMatricula
     */
    public String getNumeroMatricula() {
        return numeroMatricula;
    }

    /**
     * @param numeroMatricula the numeroMatricula to set
     */
    public void setNumeroMatricula(String numeroMatricula) {
        this.numeroMatricula = numeroMatricula;
    }

    /**
     * @return the curso
     */
    public String getCurso() {
        return curso;
    }

    /**
     * @param curso the curso to set
     */
    public void setCurso(String curso) {
        this.curso = curso;
    }

    /**
     * @return the instituicaoDeEnsino
     */
    public String getInstituicaoDeEnsino() {
        return instituicaoDeEnsino;
    }

    /**
     * @param instituicaoDeEnsino the instituicaoDeEnsino to set
     */
    public void setInstituicaoDeEnsino(String instituicaoDeEnsino) {
        this.instituicaoDeEnsino = instituicaoDeEnsino;
    }

    /**
     * @return the carteirinha
     */
    public Carteirinha getCarteirinha() {
        return carteirinha;
    }

    /**
     * @param carteirinha the carteirinha to set
     */
    public void setCarteirinha(Carteirinha carteirinha) {
        this.carteirinha = carteirinha;
    }

    /**
     * @return the foto
     */
    public String getFoto() {
        return foto;
    }

    /**
     * @param foto the foto to set
     */
    public void setFoto(String foto) {
        this.foto = foto;
    }

   
    
}
