/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avaliacao.agenda;

import java.util.Scanner;

/**
 * Método principal da agenda de contatos
 * @author DANILO
 */
public class AgendaMain {
    public static void main(String[] args) {
        System.out.println("-----Agenda de contatos-----");
        int opcao; // Opção informada pelo usuário 
        String nome, email; // Informações do contato
        Scanner sc;
        
        // Objeto que representa uma agenda de contatos
        Agenda agendaContatos = new Agenda();
        Contato objContato;
        
        // Laço continua enquanto o usuário não informar a opção 4
        while(true) {        
            System.out.println("Escolha uma opção: ");
            System.out.println("1 - Adicionar um contato");
            System.out.println("2 - Buscar um contato");
            System.out.println("3 - Remover um contato");
            System.out.println("4 - Terminar");

            sc = new Scanner(System.in);
        
            try {
                opcao = sc.nextInt();
                sc.nextLine();

                // Executa a instrução associada à opção escolhida
                switch(opcao) {
                    case 1:
                        System.out.print("Informe o nome do contato: ");
                        nome = sc.nextLine();
                        System.out.print("Informe o e-mail do contato: ");
                        email = sc.nextLine();

                        agendaContatos.adicionarContato(new Contato(nome, email));
                        
                        break;
                    case 2:
                        do {
                            System.out.print("Informe o nome do contato que deseja buscar: ");
                            nome = sc.nextLine();
                        } while (nome.trim().equals(""));

                        objContato = agendaContatos.buscarContato(nome);

                        if (objContato == null) {
                            System.out.println("Contato não encontrado!\n\n");
                        } else {
                            System.out.println(objContato.toString()+"\n\n");
                        }
                        
                        break;
                    case 3:
                        do {
                            System.out.print("Informe o nome do contato que deseja remover: ");
                            nome = sc.nextLine();
                        } while (nome.trim().equals(""));

                        objContato = agendaContatos.excluirContato(nome);

                        if (objContato == null) {
                            System.out.println("Contato não encontrado!\n\n");
                        } else {
                            System.out.println("Contato " + objContato.getNome() + " excluído com sucesso!\n\n");
                        }     
                        
                        break;
                    case 4:
                        return;                        
                    default:
                        System.out.println("Opção inválida! Informe uma das opções mencionadas acima\n\n");                    
                }

            } catch (Exception ex) {
                System.out.println("Informe um número para a opção que deseja executar!");
            }
        }
    }
}