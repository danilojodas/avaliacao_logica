/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avaliacao.desafiomatriz;

import java.util.HashSet;
import java.util.Scanner;

/**
 * Esta classe contém o método que retorna um quadrado 2x2 de vogais num array
 * de String
 *
 * @author DANILO
 */
public class QuadradoVogais {

    /**
     * Método que retorna um quadrado 2x2 das vogais contidas num array de
     * String
     *
     * @param strArr Representa o array de String
     * @return Um array com os índices dos quadrados 2x2 encontrados
     */
    public static String quadradosDeVogais(String[] strArr) {
        // O objeto hashset foi criado aqui para manter a combinação de todas as
        // vogais que devem ser procuradas no array. O objetivo de usar essas
        // combinações é simplificar o algoritmo e reduzir o tempo de busca de
        // uma sequência de vogais. O objeto do tipo HashSet será composto por
        // 25 elementos, que é a soma das 5 combinações para cada vogal
        HashSet<String> combinacoes = new HashSet<>();
        // variável auxiliar para ler uma String de strArr
        String str;
        // variáveis que representam a sequência de vogais da linha atual e da
        // linha seguinte, respectivamente
        String sAtual, sPosterior;
        // String com os índices dos quadrados 2x2 encontrados
        String idxStr = "";

        // Combinações para a vogal A
        combinacoes.add("aa");
        combinacoes.add("ae");
        combinacoes.add("ai");
        combinacoes.add("ao");
        combinacoes.add("au");

        // Combinações para a vogal E
        combinacoes.add("ea");
        combinacoes.add("ee");
        combinacoes.add("ei");
        combinacoes.add("eo");
        combinacoes.add("eu");

        // Combinações para a vogal I
        combinacoes.add("ia");
        combinacoes.add("ie");
        combinacoes.add("ii");
        combinacoes.add("io");
        combinacoes.add("iu");

        // Combinações para a vogal O
        combinacoes.add("oa");
        combinacoes.add("oe");
        combinacoes.add("oi");
        combinacoes.add("oo");
        combinacoes.add("ou");

        // Combinações para a vogal U
        combinacoes.add("ua");
        combinacoes.add("ue");
        combinacoes.add("ui");
        combinacoes.add("uo");
        combinacoes.add("uu");

        // O tratamento de exceção é realizado para o caso de uma entrada com 
        // strings de tamanhos diferentes em cada linha de strArr
        try {
            for (int i = 0; i < strArr.length - 1; i++) {
                str = strArr[i];

                for (int j = 0; j < str.length() - 1; j++) {
                    sAtual = str.substring(j, j + 2);
                    sPosterior = strArr[i + 1].substring(j, j + 2);
                    //System.out.print("Combinação linha atual: " + sAtual+ ". ");
                    //System.out.println("Combinação linha posterior: " + sPosterior);

                    // Se a combinação sAtual e sPosterior existir, armazenar os índices
                    // vetor de resultado
                    // As strings sAtual e sPosterior são convertidas para caracteres
                    // minúsculos a fim de tornar o algoritmo case insensitive
                    if (combinacoes.contains(sAtual.toLowerCase()) && combinacoes.contains(sPosterior.toLowerCase())) {
                        idxStr += ("[" + i + "," + j + "] ");
                    }
                }
            }
        } catch (IndexOutOfBoundsException ex) {
            return null;
        }

        return idxStr;
    }

    public static void main(String[] args) {
        System.out.println("-----Desafio Matriz-----");
        // Para solicitação das Strings do usuário
        Scanner sc = new Scanner(System.in);
        String[] strArr; // Array que armazenará as Strings informadas pelo usuário
        int numStrings; // Quantidade de Strings que o usuário deseja informar
        int i; // Controle do laço de repetição. Declarada aqui para economizar memória
        boolean erroConversao;

        do {
            try {
                System.out.print("Quantas Strings deseja informar? ");
                numStrings = sc.nextInt();
                sc.nextLine();
                strArr = new String[numStrings];

                for (i = 0; i < numStrings; i++) {
                    System.out.print("Informe a " + (i + 1) + " ª String: ");
                    strArr[i] = sc.nextLine();
                }
                
                // Chamando o método para encontrar os índices dos quadrados 2x2 de vogais
                String idx = quadradosDeVogais(strArr);

                // idx será null se alguma string possuir tamanho diferente das demais
                if (idx == null) {
                    System.out.println("\nAs Strings devem ter a mesma quantidade de caracteres!");
                    return;
                }
                
                if (idx.length() == 0)
                    System.out.println("\nNão há qualquer quadrado de vogal na String informada");
                else
                    System.out.println("\nÍndices dos quadrados 2x2 de vogais encontrados: " + idx);

                erroConversao = false;
            } catch (Exception ex) {
                System.out.println("Informe somente números para a quantidade de Strings!");
                sc.nextLine();
                erroConversao = true;
            }
        } while (erroConversao);
        
        System.out.println("\n");
    }
}
