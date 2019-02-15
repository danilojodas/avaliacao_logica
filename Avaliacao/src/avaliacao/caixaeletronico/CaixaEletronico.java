/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avaliacao.caixaeletronico;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Classe criada para executar o quinto problema da avaliação
 *
 * @author DANILO
 * @version 1.0
 */
public class CaixaEletronico {

    public static void main(String[] args) {
        System.out.println("-----Caixa eletrônico-----");
        Scanner sc = new Scanner(System.in);
        HashMap<Integer, Integer> cedulasComQuantidade = getCedulasComQuantidade();
        ArrayList<Integer> cedulas = getCedulas();
        int valorSaque; // valor do saque informado pelo usuário
        int valorRestante; // representa o restante que falta completar o valor do saque
        boolean erroConversao;

        do {
            try {
                System.out.print("Informe um valor para sacar: ");
                valorSaque = sc.nextInt();

                while (valorSaque < 10 || valorSaque > 600) {
                    sc.nextLine();
                    System.out.print("O valor mínimo para saque é R$ 10,00 e o máximo é R$ 600,00. Informe um valor correto: ");
                    valorSaque = sc.nextInt();
                }

                // Se o valor sacado for igual à uma cédula existente, não é preciso
                // fazer a contagem
                if (cedulasComQuantidade.get(valorSaque) != null) {
                    System.out.println("Saque de 1 cédula de R$ : " + valorSaque);
                } else {
                    valorRestante = valorSaque;
                    int qtdeCedula, maxCedula;

                    // Loop executado sempre que uma nova cédula tem de ser disponibilizada ao
                    // usuário. O valor restante é quem controla o loop            
                    while (valorRestante > 0) {
                        maxCedula = Collections.max(cedulas);

                        // Verifica se há cedulas disponíveis para o saque
                        // A chave representa o valor de uma cédula
                        if (valorRestante >= maxCedula) {
                            valorRestante -= maxCedula;
                            qtdeCedula = cedulasComQuantidade.get(maxCedula);
                            cedulasComQuantidade.replace(maxCedula, qtdeCedula + 1);
                        } else {
                            cedulas.remove(Integer.valueOf(maxCedula));
                        }
                    }

                    System.out.println("\n\nVocê sacou R$ " + valorSaque + " com as seguintes cédulas");
                    mostrarCedulasOrdemCrescente(cedulasComQuantidade);                    
                }
                
                erroConversao = false;
            } catch (Exception ex) {
                System.out.println("Informe um número válido para sacar!");
                sc.nextLine();
                erroConversao = true;
            }
        } while (erroConversao);
        
        System.out.println("\n");
    }

    // Método que gera um HashMap com as células disponíveis e a quantidade
    // sacada de cada cédula
    private static HashMap<Integer, Integer> getCedulasComQuantidade() {
        HashMap<Integer, Integer> cedulas = new HashMap<>();
        cedulas.put(1, 0);
        cedulas.put(5, 0);
        cedulas.put(10, 0);
        cedulas.put(50, 0);
        cedulas.put(100, 0);

        return cedulas;
    }

    // Método que retorna uma lista com as cédulas disponíveis
    private static ArrayList<Integer> getCedulas() {
        ArrayList<Integer> cedulas = new ArrayList<>();
        cedulas.add(1);
        cedulas.add(5);
        cedulas.add(10);
        cedulas.add(50);
        cedulas.add(100);
        return cedulas;
    }

    // Método para mostrar as cédulas do HashMap em ordem crescente
    // Isso é necessário porque o HashMap não ordena as chaves
    private static void mostrarCedulasOrdemCrescente(HashMap<Integer, Integer> cedulas) {
        ArrayList<Integer> listaChavesOrdenadas = new ArrayList<>(cedulas.keySet());
        Collections.sort(listaChavesOrdenadas);
        int qtdeCedula;

        for (Integer key : listaChavesOrdenadas) {
            qtdeCedula = cedulas.get(key);

            if (qtdeCedula > 0) {
                System.out.println("Número de cédulas de R$ " + key + ": " + qtdeCedula);
            }
        }
    }
}
