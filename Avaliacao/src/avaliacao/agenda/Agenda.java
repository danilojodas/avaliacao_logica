/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avaliacao.agenda;

import java.util.ArrayList;

/**
 * Classe que representa uma agenda de contatos
 * @author DANILO
 * @version 1.0
 */
public class Agenda {
    
    private ArrayList<Contato> contatos;
    
    public Agenda() {
        contatos = new ArrayList<>();
    }
    
    /**
     * @return the contatos
     */
    public ArrayList<Contato> getContatos() {
        return contatos;
    }    
    
    /**
     * Adiciona um contato à lista de contatos
     * @param contato O objeto contato para adicionar à lista de contatos
     * @return true se o contato foi adicionado e false caso contrário
     */
    public boolean adicionarContato(Contato contato) {
        return contatos.add(contato);
    }
    
    /**
     * Busca um contato na lista pelo nome
     * @param nome O nome do contato que deve ser pesquisado
     * @return O objeto contato encontrado ou null se não foi encontrado
     */
    public Contato buscarContato(String nome) {
        for (Contato c : contatos) {
            if (c.getNome().equals(nome)) {
                return c;
            }
        }
        
        return null;
    }
    
    /**
     * Remove um contato da lista
     * @param nome O nome do contato que deve ser excluído
     * @return O objeto contato que foi removido ou null se não foi encontrado
     */
    public Contato excluirContato(String nome) {
        for (int i = 0; i < contatos.size(); i++) {
            if (contatos.get(i).getNome().equals(nome)) {
                return contatos.remove(i);
                
            }
        }
        
        return null;
    }
}
