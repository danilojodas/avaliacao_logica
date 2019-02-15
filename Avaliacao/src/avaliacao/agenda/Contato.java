/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avaliacao.agenda;

/**
 * Classe que representa as infomações de um contato
 * @author DANILO
 * @version 1.0
 */
public class Contato {
    
    private String nome;
    private String email;    
    
    public Contato() {
        
    }
    
    public Contato(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }
    
    /**
     * @return O nome do contato
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome O nome do contato para atribuir
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return O e-mail do contato
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email O e-mail do contato para atribuir
     */
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Nome do contato: " + this.nome + "\n" + 
               "E-mail do contato: " + this.email + "\n";
    }
}
