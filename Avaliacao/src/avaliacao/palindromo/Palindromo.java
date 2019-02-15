/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avaliacao.palindromo;

import java.util.Scanner;

/**
 * Classe criar para executar o segundo problema da avaliação
 * @author DANILO
 * @version 1.0
 */
public class Palindromo {
    public static void main(String[] args) {
        long numeroNatural;
        int numCaracteresString;
        String numeroNaturalString; // Usado para ler cada dígito da String
        char resp; // Variável para indicar se o usuário deseja informar outro número natural
        boolean erroConversao; // Variável que indica se o número informado é válido
        boolean ePalindroma; // Variável para indicar se a palavra é ou não palíndroma
        Scanner sc; // Para solicitar do usuário o número natural n        
        do {
            ePalindroma = true; // A variável é alterada para false se o número não for palíndromo
            
            do {
                sc = new Scanner(System.in);
                
                try {                
                    do {
                        System.out.print("Informe um número maior do que 10: ");
                        // Instrução usada para garantir que o valor informado é de fato um int
                        numeroNatural = sc.nextInt();
                    } while (numeroNatural <= 10);                        

                    // Converte o número de int para String
                    numeroNaturalString = String.valueOf(numeroNatural);                        

                    // Retorna o número de caracteres da String
                    numCaracteresString = numeroNaturalString.length();            

                    // Laço de repetição para percorrer cada dígito da String
                    for (int i = 0; i < (Math.round(numCaracteresString / 2.0)) - (numCaracteresString % 2); i++) {
                        if (numeroNaturalString.charAt(i) != numeroNaturalString.charAt(numCaracteresString-1-i)) {
                            ePalindroma = false;
                            break;
                        }
                    }

                    if (ePalindroma)
                        System.out.println("O número natural informado é palíndromo!\n");
                    else                
                        System.out.println("O número natural informado não é palíndromo!\n");            
                    
                    erroConversao = false;

                } catch(Exception ex) {
                    System.out.println("Informe um número natural válido!");
                    erroConversao = true;
                } 
            } while (erroConversao);
            
            // Pergunta se o usuário deseja informar outro número natural
            System.out.print("Deseja informar outro número natural? (Informe S->Sim ou N->Não): ");
            resp = sc.next().charAt(0);
        } while (resp == 'S' || resp == 's');
    }
}
