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
        
        Tabuleiro tabuleiro = new Tabuleiro ("1 - Cada jogador deve escolher um símbolo; "
            + "2 - O jogador 1 inicia a partida");
     
     Jogador jogador1 = new Jogador (1, "Daniel", 'X');
     Jogador jogador2 = new Jogador (2, "Laryssa", 'Y');
     
     tabuleiro.mostrarTabuleiro();
     
     do{
        tabuleiro.mostrarTabuleiro();
     
       if(tabuleiro.getJogadorDaVez() == 1){
           System.out.println("Jogador 1, escolha onde jogar: ");
           String local = entrada.nextLine();
           
           tabuleiro.marcarJogada(jogador1.getSimbolo(), local);
           tabuleiro.setJogadorDaVez(2);
           tabuleiro.mostrarTabuleiro();
           tabuleiro.verificarGanhador(jogador1.getSimbolo());
       }
       else{
           System.out.println("Jogador 2, escolha onde jogar: ");
           String local = entrada.nextLine();
           
           tabuleiro.marcarJogada(jogador2.getSimbolo(), local);
           tabuleiro.setJogadorDaVez(1);
           tabuleiro.mostrarTabuleiro();
           tabuleiro.verificarGanhador(jogador2.getSimbolo());
        }
           
       
     }while(tabuleiro.isHouveGanhadorUltimaRodada() == false);
    }
}

