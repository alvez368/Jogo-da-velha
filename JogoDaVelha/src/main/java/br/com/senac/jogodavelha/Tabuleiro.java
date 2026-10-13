/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.senac.jogodavelha;

/**
 *
 * @author laryssa62922516
 */
public class Tabuleiro {
    private int notaJ1;
    private int notaJ2;
    private String regras;
    private boolean houveGanhadorUltimaRodada;
    private int jogadorDaVez;

    private char a1 = ' ', a2 = ' ', a3 = ' ';
    private char b1 = ' ', b2 = ' ', b3 = ' ';
    private char c1 = ' ', c2 = ' ', c3 = ' ';

    public int getJogadorDaVez() {
        return jogadorDaVez;
    }

    public void setJogadorDaVez(int jogadorDaVez) {
        this.jogadorDaVez = jogadorDaVez;
    }

    public boolean isHouveGanhadorUltimaRodada() {
        return houveGanhadorUltimaRodada;
    }

    public void setHouveGanhadorUltimaRodada(boolean houveGanhadorUltimaRodada) {
        this.houveGanhadorUltimaRodada = houveGanhadorUltimaRodada;
    }

    public int getNotaJ1() {
        return notaJ1;
    }

    public void setNotaJ1(int notaJ1) {
        this.notaJ1 = notaJ1;
    }

    public int getNotaJ2() {
        return notaJ2;
    }

    public void setNotaJ2(int notaJ2) {
        this.notaJ2 = notaJ2;
    }

    public String getRegras() {
        return regras;
    }

    public void setRegras(String regras) {
        this.regras = regras;
    }

    public Tabuleiro(String regras) {
        this.regras = regras;
        this.notaJ1 = 0;
        this.notaJ2 = 0;
        this.houveGanhadorUltimaRodada = false;
        this.jogadorDaVez = 1;
    }

    public void verificarGanhador(char simbolo) {
        if (
            (a1 == simbolo && b1 == simbolo && c1 == simbolo) ||
            (a2 == simbolo && b2 == simbolo && c2 == simbolo) ||
            (a3 == simbolo && b3 == simbolo && c3 == simbolo) ||
            (a1 == simbolo && a2 == simbolo && a3 == simbolo) ||
            (b1 == simbolo && b2 == simbolo && b3 == simbolo) ||
            (c1 == simbolo && c2 == simbolo && c3 == simbolo) ||
            (a1 == simbolo && b2 == simbolo && c3 == simbolo) ||
            (a3 == simbolo && b2 == simbolo && c1 == simbolo)
        ) {
            this.houveGanhadorUltimaRodada = true;
            System.out.println("HOUVE UM GANHADOR!!!");
        }
    }

    public void mostrarTabuleiro() {
        System.out.printf("""
                  A       B       C
                      |       |       
              1   %c   |   %c   |   %c
                      |       |       
               -------+-------+-------
                      |       |       
              2   %c   |   %c   |   %c
                      |       |       
               -------+-------+-------
                      |       |       
              3   %c   |   %c   |   %c
                      |       |       
                """, a1, b1, c1, a2, b2, c2, a3, b3, c3);
    }

    public boolean marcarJogada(char simbolo, String coordenada) {
        switch (coordenada.trim().toUpperCase()) {
            case "A1":
                if (a1 != ' ') break;
                a1 = simbolo;
                return true;

            case "A2":
                if (a2 != ' ') break;
                a2 = simbolo;
                return true;

            case "A3":
                if (a3 != ' ') break;
                a3 = simbolo;
                return true;

            case "B1":
                if (b1 != ' ') break;
                b1 = simbolo;
                return true;

            case "B2":
                if (b2 != ' ') break;
                b2 = simbolo;
                return true;

            case "B3":
                if (b3 != ' ') break;
                b3 = simbolo;
                return true;

            case "C1":
                if (c1 != ' ') break;
                c1 = simbolo;
                return true;

            case "C2":
                if (c2 != ' ') break;
                c2 = simbolo;
                return true;

            case "C3":
                if (c3 != ' ') break;
                c3 = simbolo;
                return true;
        }

        System.out.println("Posição ocupada ou inválida! Escolha outra.");
        return false;
    }
}
