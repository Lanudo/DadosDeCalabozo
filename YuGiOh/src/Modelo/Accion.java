
package Modelo;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.lang.reflect.Array;


public class Accion {
    
    private Criatura criaturaAtacante;
    private Criatura criaturaDefensora;
    
    public Accion(Criatura ataca, Criatura defiende){
        this.criaturaAtacante = ataca;
        this.criaturaDefensora = defiende;
    }
     private String lanzarDado(Dado dado){
       String[] caras = dado.getDado();
       int x = (int) Math.random() * Array.getLength(caras);
       String resultado = caras[x];
       return resultado;
    }
    
    //En el siguiente método, el jugador1 es el que selecciona a su criatura para que
    //Ataque a la criatura2 del jugador2.
    protected void ataque(Criatura criatura1, Criatura criatura2){
        int cantidadAtk = criatura1.getAtaque();
        int cantidadDef = criatura2.getDefensa();
        int dañoResultante = cantidadAtk - cantidadDef;
        if(dañoResultante <= 0){
            int PV = criatura1.getPuntosDeVida();
            criatura1.setPuntosDeVida(PV + dañoResultante);
        }
        else {
            int PV = criatura2.getPuntosDeVida();
            criatura2.setPuntosDeVida(PV - dañoResultante);
        }
    }
    
    //En el siguiente método, el jefe de terreno del jugador1 es atacado por
    //una criatura del jugador2.
    private void ataqueJefe(Jugador jugador1, Jugador jugador2, JefeDeTerreno jefe, Criatura criatura){
        int PVJefe = jefe.getPuntosDeVida();
        int dañoRealizado = criatura.getAtaque();
        jefe.setPuntosDeVida(dañoRealizado);
    }
    public int[] moverCriatura(Criatura criatura, MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        int rialX = x - 12;
        int rialY = y - 12;
        int coordX = (rialX / 25);
        int coordY = (rialY / 25);
        int[] coordenadas = {coordX, coordY};
        return coordenadas;
    }
    
    public void invocarCriatura(Criatura criatura){
        
    }
    
    
    
}
