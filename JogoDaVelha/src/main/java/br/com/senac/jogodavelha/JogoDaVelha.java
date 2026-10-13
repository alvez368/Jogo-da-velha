/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package br.com.senac.jogodavelha;
import java.util.Scanner;
/**
 *
 * @author laryssa62922516
 */
public class JogoDaVelha {

    public static void main(String[] args) {
       Scanner entrada = new Scanner(System.in);

        Tabuleiro tabuleiro = new Tabuleiro(
            "1 - Cada jogador deve escolher um símbolo; " +
            "2 - O jogador 1 inicia a partida"
        );

        Jogador jogador1 = new Jogador(1, "Daniel", 'X');
        Jogador jogador2 = new Jogador(2, "Laryssa", 'Y');

        do {
            tabuleiro.mostrarTabuleiro();

            if (tabuleiro.getJogadorDaVez() == 1) {
                System.out.println("Jogador 1 (Daniel), escolha onde jogar: ");
            } else {
                System.out.println("Jogador 2 (Laryssa), escolha onde jogar: ");
            }

            String local = entrada.nextLine();
            boolean jogadaValida;

            if (tabuleiro.getJogadorDaVez() == 1) {
                jogadaValida = tabuleiro.marcarJogada(
                    jogador1.getSimbolo(), local
                );
            } else {
                jogadaValida = tabuleiro.marcarJogada(
                    jogador2.getSimbolo(), local
                );
            }

            if (jogadaValida) {
                if (tabuleiro.getJogadorDaVez() == 1) {
                    tabuleiro.verificarGanhador(jogador1.getSimbolo());
                } else {
                    tabuleiro.verificarGanhador(jogador2.getSimbolo());
                }

                if (!tabuleiro.isHouveGanhadorUltimaRodada()) {
                    if (tabuleiro.getJogadorDaVez() == 1) {
                        tabuleiro.setJogadorDaVez(2);
                    } else {
                        tabuleiro.setJogadorDaVez(1);
                    }
                }
            }

        } while (!tabuleiro.isHouveGanhadorUltimaRodada());

        tabuleiro.mostrarTabuleiro();
        entrada.close();
    }
}
