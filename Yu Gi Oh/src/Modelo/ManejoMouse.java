/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author Lucas
 */
public class ManejoMouse extends MouseAdapter{
    int[] coordenadas;
    
    public void mouseClicked(MouseEvent e){
        int x = e.getX();
        int y = e.getY();
        int[] coordenadas = {x, y};
        this.coordenadas = coordenadas;

    }

    
}

