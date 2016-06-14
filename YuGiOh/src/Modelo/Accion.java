
package Modelo;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.lang.reflect.Array;


public class Accion {
     
    /*
    private String lanzarDado(Dado dado){
       String[] caras = dado.getDado(null,null,null);
       int x = (int) Math.random() * Array.getLength(caras);
       String resultado = caras[x];
       return resultado;
    }*/
    
    //En el siguiente método, el jugador1 es el que selecciona a su criatura para que
    //Ataque a la criatura2 del jugador2.
    private void ataque(Jugador jugador1, Jugador jugador2, Criatura criatura1, Criatura criatura2){
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
        criatura.setPosicionX(coordX);
        criatura.setPosicionY(coordY);
        return coordenadas;
    }
    
    private void pintarTablero(Graphics g, int[] coordenadas){
        int x = coordenadas[0];
        int y = coordenadas[1];
        g.setColor(Color.ORANGE);
        g.fillRect(12+x*25, 12+y*25, 37+x*25, 37+25*y);
        
    }
    
    
    
    
}
