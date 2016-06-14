
package Modelo;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JPanel;
import Controladores.ControladorBatalla;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Tablero extends JPanel{
    
    ControladorBatalla controladorBatalla;
    
    JefeDeTerreno jefe;
    Criatura criatura;
    Accion accion;
    public static int[][][] tableroTerreno = new int[15][15][3];
    private Criatura[][] tableroCriatura = new Criatura[15][15];
    private ControladorBatalla batalla;
    private ArrayList<JButton> botones = new ArrayList<>();
    private Criatura criaturaAtacante;
    private Criatura criaturaDefensora;
    private Criatura criaturaMoviendose;
    boolean isJefe = false;
    boolean isCriatura = false;
    boolean isTerreno = false;
    
    public Tablero(ControladorBatalla cb, Accion a) {
        
        this.controladorBatalla = cb;
        this.accion = a;
        this.setBackground(Color.white);
        this.setBounds(0, 0, 404, 401);
        this.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt){
                JPanelMouseClicked(evt);
                setTerreno(false);
                
                }
        });
        
    }
    
    @Override
    public void paint(Graphics g){
        
        for(JButton boton: botones){
        this.controladorBatalla.tablero.remove(boton);
        }
        super.paint(g);
        
        g.setColor(Color.BLACK);
        for(int i = 12; i <= 399; i = i + 25){
            
            g.drawLine(i, 12, i, 387);
            g.drawLine(12, i, 387, i);
            
        }
        for(int i = 0; i < 15; i++){
            for(int j = 0; j < 15; j++){
                if(tableroTerreno[i][j][0] == 1){
                    g.setColor(Color.yellow);
                    int x1 = 12 + i*25;
                    int y1 = 12 + j*25;
                    g.fillRect(x1+1, y1+1, 24, 24);
                }
                if (tableroTerreno[i][j][1] == 1 && tableroCriatura[i][j] != null){
                    g.setColor(Color.blue);
                    int x1 = 12 + i*25;
                    int y1 = 12 + j*25;
                    g.fillOval(x1+5, y1+5, 15, 15);
                    
                } 
                if (tableroTerreno[i][j][1] == 2 && tableroCriatura[i][j] != null){
                    g.setColor(Color.red);
                    int x1 = 12 + i*25;
                    int y1 = 12 + j*25;
                    g.fillOval(x1+5, y1+5, 15, 15);
                } 
                if(tableroCriatura[i][j] != null){
                    int x1 = 12 + i*25;
                    int y1 = 12 + j*25;
                    JButton boton = new JButton();
                    boton.setText("");
                    boton.setBounds(10 + x1,10 + y1, 5, 5);
                    Criatura criatura = this.tableroCriatura[i][j];
                    String info = criatura.getNombre()+"/PV: "+criatura.getPuntosDeVida();
                    boton.setToolTipText(info);
                    this.add(boton);
                    boton.setVisible(true);
                    boton.setEnabled(true);
                    boton.setBorderPainted(true);
                    botones.add(boton);
                }
                if (tableroTerreno[i][j][2] == 1 && tableroTerreno[i][j][0] == 1){
                    g.setColor(Color.ORANGE);
                    int x1 = 12 + i*25;
                    int y1 = 12 + j*25;
                    g.fillRect(x1+5, y1+5, 15, 15);
                }
                if (tableroTerreno[i][j][0] == 10){
                    g.setColor(Color.BLUE);
                    int x1 = 12 + i*25;
                    int y1 = 12 + j*25;
                    g.fillRect(x1+1, y1+1, 24, 24);
                } 
                if (tableroTerreno[i][j][0] == 11){
                    g.setColor(Color.RED);
                    int x1 = 12 + i*25;
                    int y1 = 12 + j*25;
                    g.fillRect(x1+1, y1+1, 24, 24);
                } 
                if (tableroTerreno[i][j][0] == 12){
                    g.setColor(Color.GREEN);
                    int x1 = 12 + i*25;
                    int y1 = 12 + j*25;
                    g.fillRect(x1+1, y1+1, 24, 24);
                } 
                if (tableroTerreno[i][j][0] == 13){
                    g.setColor(Color.MAGENTA);
                    int x1 = 12 + i*25;
                    int y1 = 12 + j*25;
                    g.fillRect(x1+1, y1+1, 24, 24);
                }
                
            }
        }
        
     }
        
    
    
     public void  JPanelMouseClicked(MouseEvent evt){
        Point coordenadas = evt.getPoint();
        double x = coordenadas.getX();
        double y = coordenadas.getY();
        int xReal = (int)(x - 12)/25;
        int yReal = (int)(y-12)/25;
        if(this.controladorBatalla.getBoton() == 1){
            Tablero.tableroTerreno[xReal][yReal][0] = 1;
            Tablero.tableroTerreno[xReal-1][yReal][0] = 1;
            Tablero.tableroTerreno[xReal-1][yReal+1][0] = 1;
            Tablero.tableroTerreno[xReal-1][yReal-1][0] = 1;
            Tablero.tableroTerreno[xReal+1][yReal][0] = 1;
            Tablero.tableroTerreno[xReal+2][yReal][0] = 1;
            this.controladorBatalla.setBoton(71);
        }
        else if(this.controladorBatalla.getBoton()  == 2){
            Tablero.tableroTerreno[xReal][yReal][0] = 1;
            Tablero.tableroTerreno[xReal-1][yReal][0] = 1;
            Tablero.tableroTerreno[xReal-1][yReal+1][0] = 1;
            Tablero.tableroTerreno[xReal][yReal-1][0] = 1;
            Tablero.tableroTerreno[xReal+1][yReal][0] = 1;
            Tablero.tableroTerreno[xReal+2][yReal][0] = 1;
            this.controladorBatalla.setBoton(71);
        }
        else if(this.controladorBatalla.getBoton() == 3){
            Tablero.tableroTerreno[xReal][yReal][0] = 1;
            Tablero.tableroTerreno[xReal-1][yReal][0] = 1;
            Tablero.tableroTerreno[xReal-1][yReal+1][0] = 1;
            Tablero.tableroTerreno[xReal+1][yReal-1][0] = 1;
            Tablero.tableroTerreno[xReal+1][yReal][0] = 1;
            Tablero.tableroTerreno[xReal+2][yReal][0] = 1;
            this.controladorBatalla.setBoton(71);
        }
        else if(this.controladorBatalla.getBoton() == 4){
            Tablero.tableroTerreno[xReal][yReal][0] = 1;
            Tablero.tableroTerreno[xReal-1][yReal][0] = 1;
            Tablero.tableroTerreno[xReal-1][yReal+1][0] = 1;
            Tablero.tableroTerreno[xReal+2][yReal-1][0] = 1;
            Tablero.tableroTerreno[xReal+1][yReal][0] = 1;
            Tablero.tableroTerreno[xReal+2][yReal][0] = 1;
            this.controladorBatalla.setBoton(71);
        }
        else if(this.controladorBatalla.getBoton() == 5){
            Tablero.tableroTerreno[xReal][yReal][0] = 25;
            Tablero.tableroTerreno[xReal-1][yReal-1][0] = 1;
            Tablero.tableroTerreno[xReal][yReal-1][0] = 1;
            Tablero.tableroTerreno[xReal+1][yReal-1][0] = 1;
            Tablero.tableroTerreno[xReal+2][yReal-1][0] = 1;
            Tablero.tableroTerreno[xReal][yReal-2][0] = 1;
            this.controladorBatalla.setBoton(71);
        }
        else if(this.controladorBatalla.getBoton() == 6){
            Tablero.tableroTerreno[xReal][yReal][0] = 1;
            Tablero.tableroTerreno[xReal-1][yReal-1][0] = 1;
            Tablero.tableroTerreno[xReal][yReal-1][0] = 1;
            Tablero.tableroTerreno[xReal+1][yReal-1][0] = 1;
            Tablero.tableroTerreno[xReal+2][yReal-1][0] = 1;
            Tablero.tableroTerreno[xReal+1][yReal-2][0] = 1;
            this.controladorBatalla.setBoton(71);
        }
        else if(this.controladorBatalla.getBoton() == 7){
            Tablero.tableroTerreno[xReal][yReal][0] = 1;
            Tablero.tableroTerreno[xReal-1][yReal][0] = 1;
            Tablero.tableroTerreno[xReal][yReal-1][0] = 1;
            Tablero.tableroTerreno[xReal+1][yReal-1][0] = 1;
            Tablero.tableroTerreno[xReal+2][yReal-1][0] = 1;
            Tablero.tableroTerreno[xReal][yReal-2][0] = 1;
            this.controladorBatalla.setBoton(71);
        }
        else if(this.controladorBatalla.getBoton() == 8){
            Tablero.tableroTerreno[xReal][yReal][0] = 1;
            Tablero.tableroTerreno[xReal-1][yReal][0] = 1;
            Tablero.tableroTerreno[xReal][yReal-1][0] = 1;
            Tablero.tableroTerreno[xReal+1][yReal-1][0] = 1;
            Tablero.tableroTerreno[xReal+2][yReal-1][0] = 1;
            Tablero.tableroTerreno[xReal+1][yReal-2][0] = 1;
            this.controladorBatalla.setBoton(71);
        }
        else if(this.controladorBatalla.getBoton() == 9){
            Tablero.tableroTerreno[xReal][yReal][0] = 1;
            Tablero.tableroTerreno[xReal-1][yReal][0] = 1;
            Tablero.tableroTerreno[xReal][yReal-1][0] = 1;
            Tablero.tableroTerreno[xReal+1][yReal-1][0] = 1;
            Tablero.tableroTerreno[xReal+2][yReal-1][0] = 1;
            Tablero.tableroTerreno[xReal+2][yReal-2][0] = 1;
            this.controladorBatalla.setBoton(71);
        }
        else if(this.controladorBatalla.getBoton() == 10){
            Tablero.tableroTerreno[xReal][yReal][0] = 1;
            Tablero.tableroTerreno[xReal+1][yReal][0] = 1;
            Tablero.tableroTerreno[xReal+2][yReal][0] = 1;
            Tablero.tableroTerreno[xReal][yReal-1][0] = 1;
            Tablero.tableroTerreno[xReal-1][yReal-1][0] = 1;
            Tablero.tableroTerreno[xReal-2][yReal-1][0] = 1;
            this.controladorBatalla.setBoton(71);
        }
        else if(this.controladorBatalla.getBoton() == 11){
            Tablero.tableroTerreno[xReal][yReal][0] = 1;
            Tablero.tableroTerreno[xReal+1][yReal][0] = 1;
            Tablero.tableroTerreno[xReal][yReal-1][0] = 1;
            Tablero.tableroTerreno[xReal-1][yReal-1][0] = 1;
            Tablero.tableroTerreno[xReal-1][yReal-2][0] = 1;
            Tablero.tableroTerreno[xReal-2][yReal-2][0] = 1;
            this.controladorBatalla.setBoton(71);
        }
        else if(this.controladorBatalla.getBoton() == 21) {
            Tablero.tableroTerreno[xReal][yReal][2] = 1;
            this.controladorBatalla.setBoton(0);
        }
        else if(this.controladorBatalla.getBoton()  == 77 && Tablero.tableroTerreno[xReal][yReal][1] !=  0 ){
            this.criaturaAtacante = this.tableroCriatura[xReal][yReal];
            this.controladorBatalla.setBoton(78);
        }
        else if(this.controladorBatalla.getBoton()  == 78 && Tablero.tableroTerreno[xReal][yReal][1] !=  0 ){
            this.criaturaDefensora = this.tableroCriatura[xReal][yReal];
            this.accion.ataque(criaturaAtacante, criaturaDefensora);
            this.criaturaAtacante = null;
            this.criaturaDefensora = null;
            this.controladorBatalla.setBoton(0);
        }
         else if(this.controladorBatalla.getBoton() == 70 && Tablero.tableroTerreno[xReal][yReal][1] == 1) {
            Criatura criaturaMover = tableroCriatura[xReal][yReal];
            int[] anterior = {xReal, yReal};
            criaturaMover.setPosicionAnterior(anterior);
            this.criaturaMoviendose = criaturaMover;
            Tablero.tableroTerreno[xReal][yReal][1] = 0;
         }
         else if(this.controladorBatalla.getBoton() == 70 && Tablero.tableroTerreno[xReal][yReal][1] == 2) {
             Criatura criaturaMover = tableroCriatura[xReal][yReal];
            int[] anterior = {xReal, yReal};
            criaturaMover.setPosicionAnterior(anterior);
            this.criaturaMoviendose = criaturaMover;
            Tablero.tableroTerreno[xReal][yReal][1] = 0;
         }
         
        else if(this.controladorBatalla.getBoton() == 71 && Tablero.tableroTerreno[xReal][yReal][0] == 1) {
            String actual = this.controladorBatalla.combate.getJugadorActual();
            String jugador = this.controladorBatalla.combate.getJugador1();
            if(actual.equals(jugador)){
                Tablero.tableroTerreno[xReal][yReal][1] = 1;
                Criatura criaturaInvocada = this.controladorBatalla.getCriatura();
                if(criaturaInvocada.getNivel() == 1){
                    this.tableroCriatura[xReal][yReal] = criaturaInvocada;
                    JOptionPane.showMessageDialog(null, "Has logrado invocar a la criatura " + criaturaInvocada.getNombre());
                }
                else if(criaturaInvocada.getNivel() == 2){
                    int invocaciones = criaturaInvocada.getInvocaciones();
                    criaturaInvocada.setInvocaciones(invocaciones + 1);
                    if(criaturaInvocada.getInvocaciones() == 2){
                        this.tableroCriatura[xReal][yReal] = criaturaInvocada;
                        JOptionPane.showMessageDialog(null, "Has logrado invocar a la criatura " + criaturaInvocada.getNombre());
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Te falta 1 invocación para obtner a " + criaturaInvocada.getNombre());
                    }
                    
                }
                this.controladorBatalla.setBoton(0);
            }
            else{
                Tablero.tableroTerreno[xReal][yReal][1] = 2;
                Criatura criaturaInvocada = this.controladorBatalla.getCriatura();
                if(criaturaInvocada.getNivel() == 1){
                    this.tableroCriatura[xReal][yReal] = criaturaInvocada;
                    JOptionPane.showMessageDialog(null, "Has logrado invocar a la criatura " + criaturaInvocada.getNombre());
                }
                else if(criaturaInvocada.getNivel() == 2){
                    int invocaciones = criaturaInvocada.getInvocaciones();
                    criaturaInvocada.setInvocaciones(invocaciones + 1);
                    if(criaturaInvocada.getInvocaciones() == 2){
                        this.tableroCriatura[xReal][yReal] = criaturaInvocada;
                        JOptionPane.showMessageDialog(null, "Has logrado invocar a la criatura " + criaturaInvocada.getNombre());
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Te falta 1 invocación para obtner a " + criaturaInvocada.getNombre());
                    }
                    
                }
                this.controladorBatalla.setBoton(0);
            }
        }
        
        
        this.repaint();
     }
    
    
    public void generarTablero(Graphics g, int tab[][], int x, int y){
        super.paint(g);
        g.setColor(Color.BLACK);
        for(int i = 0; i<15; i++){
            for(int j = 0;j<15;j++){
                g.drawLine(i, 12, i, 387);
                g.drawLine(12, i, 387, i);
                g.fillRect(x+i*30, y+j*30, 30, 30);
            }
        }
    }
    public void pintarTablero(Graphics g, int[] coordenadas){
        int x = coordenadas[0];
        int y = coordenadas[1];
        g.setColor(Color.ORANGE);
        g.fillRect(12+x*25, 12+y*25, 37+x*25, 37+25*y);
        
    }
    
    public boolean getTerreno(){
        return isTerreno;
    }
    
    public void setTerreno(boolean ToF){
        isTerreno = ToF;
    }
    

    

    public JefeDeTerreno getJefe() {
        return jefe;
    }

    public void setJefe(JefeDeTerreno jefe) {
        this.jefe = jefe;
    }

    public Criatura getCriatura() {
        return criatura;
    }

    public void setCriatura(Criatura criatura) {
        this.criatura = criatura;
    }

    public int[][][] getTableroTerreno() {
        return tableroTerreno;
    }

    public void setTableroTerreno(int[][][] tableroTerreno) {
        this.tableroTerreno = tableroTerreno;
    }

    public Criatura[][] getTableroCriatura() {
        return tableroCriatura;
    }

    public void setTableroCriatura(Criatura[][] tableroCriatura) {
        this.tableroCriatura = tableroCriatura;
    }
    
    public void ponerJefe(int participantes){
        switch (participantes) {
            case 2:
                tableroTerreno[7][0][0] = 10;
                tableroTerreno[8][14][0] = 11;
                break;
            case 3:
                tableroTerreno[9][1][0] = 10;
                tableroTerreno[9][14][0] = 11;
                tableroTerreno[1][8][0] = 12;
                break;
            case 4:
                tableroTerreno[8][1][0] = 10;
                tableroTerreno[8][14][0] = 11;
                tableroTerreno[1][8][0] = 12;
                tableroTerreno[15][8][0] = 13;
                break;
            default:
                break;
        }
    }
    
    
    
}
