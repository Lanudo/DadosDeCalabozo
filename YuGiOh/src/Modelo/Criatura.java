
package Modelo;

import Modelo.*;
import java.awt.List;
import java.util.AbstractList;

public class Criatura {
    
    private String nombre;
    private int puntosDeVida;
    private int defensa;
    private int nivel;
    private int ataque;
    private int invocaciones = 0;
    private int[] posicionAnterior; 
    private int[] posiciónActual;
    private int dueno;
    private int identificador; 
    boolean atacar;
    boolean mover;
    private Dado dado;

    public Criatura(String nombre, int puntosDeVida, int defensa, int nivel, int ataque, Dado dado) {
        this.nombre = nombre;
        this.puntosDeVida = puntosDeVida;
        this.defensa = defensa;
        this.nivel = nivel;
        this.ataque = ataque;
        this.dado = dado;
    }
    
    public String getNombre() {
        return nombre;
    }

    public int[] getPosicionAnterior() {
        return posicionAnterior;
    }

    public void setPosicionAnterior(int[] posicionAnterior) {
        this.posicionAnterior = posicionAnterior;
    }

    public int[] getPosiciónActual() {
        return posiciónActual;
    }

    public void setPosiciónActual(int[] posiciónActual) {
        this.posiciónActual = posiciónActual;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPuntosDeVida() {
        return puntosDeVida;
    }

    public void setPuntosDeVida(int puntosDeVida) {
        this.puntosDeVida = puntosDeVida;
    }

    public int getDefensa() {
        return defensa;
    }

    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public int getDueno() {
        return dueno;
    }

    public void setDueno(int dueno) {
        this.dueno = dueno;
    }

    public int getInvocaciones() {
        return invocaciones;
    }

    public void setInvocaciones(int invocaciones) {
        this.invocaciones = invocaciones;
    }

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public Dado getDado() {
        return dado;
    }

    public void setDado(Dado dado) {
        this.dado = dado;
    }

    public boolean isAtacar() {
        return atacar;
    }

    public void setAtacar(boolean atacar) {
        this.atacar = atacar;
    }

    public boolean isMover() {
        return mover;
    }

    public void setMover(boolean mover) {
        this.mover = mover;
    }
    
    public int calculoAtaque(int defensa, int ataque, Criatura enemigo){
        int danoRealizado = ataque - defensa;
        enemigo.setPuntosDeVida(danoRealizado);
        return danoRealizado;
    }
    
    public void invocarCriatura(){
        
    }
    
   
    public int[] estadisticasCriatura(Criatura criatura){
        int[] estadisticas = new int[4];
        estadisticas[0] = criatura.getAtaque();
        estadisticas[1] = criatura.getDefensa();
        estadisticas[2] = criatura.getPuntosDeVida();
        estadisticas[3] = criatura.getNivel();  
        return estadisticas;
    }
}
