package Modelo;

import java.util.ArrayList;



public class PuzleDeDados {
    
    Dado dado[] = new Dado[15];
    Jugador jugador;
    private String[] dados;
    private ArrayList<String> puzleDeDados;

    public Dado[] getDado() {
        return dado;
    }

    public void setDado(Dado dado[]) {
        this.dado = dado;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    public String[] getDados() {
        return dados;
    }

    public void setDados(String[] dados) {
        this.dados = dados;
    }

    public ArrayList<String> getPuzleDeDados() {
        return puzleDeDados;
    }

    public void setPuzleDeDados(ArrayList<String> puzleDeDados) {
        this.puzleDeDados = puzleDeDados;
    }
    
}
