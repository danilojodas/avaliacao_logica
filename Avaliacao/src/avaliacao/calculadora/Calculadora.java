/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avaliacao.calculadora;

import java.util.Scanner;

/**
 * Classe criada para a execução do primeiro problema da avaliação
 * @author DANILO
 * @version 1.0
 */
public class Calculadora {
    public static void main(String[] args) {
        System.out.println("-----Calculadora-----");
        float valor1 = 0,valor2 = 0;
        char resp; // Variável para controlar a continuidade da execução do programa
        boolean erroConversao; // Variável para controlar a solicitação de números em caso de erro de conversão
        
        Scanner sc; // Objeto para solicitar os números do usuário
        
        // Laço que controla a solicitação dos números enquanto o usuário desejar
        do
        {
            // Tratamento de exceção para o caso de erro de conversão de string para float
            do {
                sc = new Scanner(System.in);
                try {
                    System.out.print("Informe o primeiro valor: ");
                    valor1 = sc.nextFloat();

                    System.out.print("Informe o segundo valor: ");
                    valor2 = sc.nextFloat();
                    erroConversao = false;
                } catch(Exception ex) {
                    System.out.println("Informe números válidos!!\n");                    
                    erroConversao = true;
                }   
            } while (erroConversao);
            
            // Exibindo os resultados
            System.out.println("A soma dos números é: "  +(valor1 + valor2));
            System.out.println("A subtração dos números é: " + (valor1 - valor2));
            System.out.println("A multiplicação dos números é: " + (valor1 * valor2));        
            
            // Verifica se houve divisão por zero. Apesar de ser possível com
            // o tipo float, o tratamento de divisão por zero melhora a interface
            // com o usuário
            if (Float.isInfinite(valor1 / valor2))
                System.out.println("Divisão por zero não é possível!!");
            else                
                System.out.println("A divisão dos números é: " + (valor1 / valor2));
            
            // Solicita se o usuário quer continuar a informar mais números
            System.out.print("Deseja continuar a informar valores? (Informe S -> Sim ou N -> Não): ");
            resp = sc.next().charAt(0);
            System.out.println("");
        } while (resp == 'S' || resp == 's');        
    }
}
