/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avaliacao;

import avaliacao.agenda.Agenda;
import avaliacao.agenda.AgendaMain;
import avaliacao.caixaeletronico.CaixaEletronico;
import avaliacao.calculadora.Calculadora;
import avaliacao.desafiomatriz.QuadradoVogais;
import avaliacao.lojatintas.LojaTintas;
import avaliacao.palindromo.Palindromo;
import java.util.Scanner;

/**
 * Classe com o método principal que chama os problemas resolvidos
 * @author DANILO
 */
public class Avaliacao {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("-----Palíndromo-----");
        Scanner sc = new Scanner(System.in);
        int opcao; // Opção informada pelo usuário
        boolean continua = true; // Controle o loop while
        
        while(continua) {
            System.out.println("-----Avaliação de lógica da TaxaWeb-----\n");
            System.out.println("Informe a opção desejada para executar um exerício");
            System.out.println("1 - Calculadora");
            System.out.println("2 - Palíndromo");
            System.out.println("3 - Agenda");
            System.out.println("4 - Loja de tintas");
            System.out.println("5 - Caixa eletrônico");
            System.out.println("6 - Desafio especial \"matriz\"");
            System.out.println("7 - Sair");
            
            opcao = sc.nextInt();
            sc.nextLine();
            System.out.println("\n");
            
            switch(opcao) {
                case 1:
                    Calculadora.main(null);
                    break;
                case 2:
                    Palindromo.main(null);
                    break;
                case 3:
                    AgendaMain.main(null);
                    break;
                case 4:
                    LojaTintas.main(null);
                    break;
                case 5:
                    CaixaEletronico.main(null);
                    break;
                case 6:
                    QuadradoVogais.main(null);
                    break;
                case 7:
                    continua = false;
                    break;
                default:
                    System.out.println("Informe uma opção válida!\n");
            }                
        }
        
        
    }
    
}
