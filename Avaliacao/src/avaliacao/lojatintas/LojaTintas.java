/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avaliacao.lojatintas;

import java.util.Scanner;

/**
 * Classe que representa o quarto problema da avalição
 * @author DANILO
 * @version 1.0
 */
public class LojaTintas {
    public static void main(String[] args) {
        System.out.println("-----Loja de tintas-----");
        int n18, n18Baixo; //número de latas de tinta de 18 litros
        int n4, n4Rest; // número de galões de tinta de 4 litros
        int litros; // quantidade de litros de tinta para pintar o metro quadrado informado
        float litrosAux; // quantidade de litros sem os 10% de folga
        float preco18; // preço somente para latas de 18 litros
        float preco4; // preço somente para galões de 4 litros
        float precoMisto; // preço misto considerando latas e galões de 18 e 4 litros
        int metrosQuadrados; // quantidade de metros quadrados para pintar
        boolean erroConversao; // controle para o caso de haver uma entrada incorreta
        
        // Constantes declaradas para evitar repetição de valores
        final float METROS_QUADRADO_POR_LITRO = 6; // metros quadrados que podem ser pintados por litro de tinta
        final float PRECO_POR_LATA = 80.0F; // preço por lata de 18 litros
        final float PRECO_POR_GALAO = 25.0F; // preço por galão de 4 litros
        final float LTS_LATA = 18F; // Quantidade de litros por lata
        final float LTS_GALAO = 4F; // Quantidade de litros por galão
        
        Scanner sc;
        
        do {
            try {
                sc = new Scanner(System.in);

                System.out.print("Informe quantos metros quadrados de área deverão ser pintados: ");
                metrosQuadrados = sc.nextInt();

                // Impedindo a entrada de números negativos
                while (metrosQuadrados < 1) {
                    sc.nextLine();
                    System.out.print("O valor em metros quadrados deve ser maior do que zero: ");
                    metrosQuadrados = sc.nextInt();                
                }

                System.out.println("\n");

                // Arredondando o valor para cima
                litrosAux = (float)Math.ceil(metrosQuadrados / METROS_QUADRADO_POR_LITRO);
                // Quantidade de litros considerando uma folga de 10%
                litros = (int)(Math.ceil(litrosAux + litrosAux * 0.1));            

                n18 = (int)Math.ceil(litros / LTS_LATA);
                n18Baixo = (int)Math.floor(litros / LTS_LATA);
                n4 = (int)Math.ceil((litros / LTS_GALAO));
                n4Rest = (int)Math.ceil(n18Baixo/LTS_LATA/LTS_GALAO);

                preco18 = n18 * PRECO_POR_LATA;
                preco4 = n4 * PRECO_POR_GALAO;
                precoMisto = n18Baixo * PRECO_POR_LATA + n4Rest * PRECO_POR_GALAO;

                if (precoMisto == 0) {
                    precoMisto = preco4;
                    n4Rest = n4;
                }

                System.out.println("Será necessário utilizar " + litros + " litro(s) para pintar " + metrosQuadrados 
                                    + " metro(s) quadrado(s) de área");
                System.out.println("Preço apenas por " + n18 + " lata(s) de " + LTS_LATA + " litros: " + preco18);
                System.out.println("Preço apenas por " + n4 + " galão(ões) de " + LTS_GALAO + " litros: " + preco4);
                System.out.println("Preço misto considerando " + n18Baixo + " lata(s) de " + LTS_LATA + " litros"
                                    + " e " + n4Rest + " galão(ões) de " + LTS_GALAO + " litros: " + precoMisto);

                erroConversao = false;
            } catch(Exception ex) {
                System.out.println("Informe um número válido para a quantidade de metros quadrados!");
                erroConversao = true;
            }
        } while (erroConversao);
        System.out.println("\n");
    }
}
