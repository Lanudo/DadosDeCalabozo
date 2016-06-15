package Controladores;

import Vistas.*;
import Modelo.*;
import static Vistas.VistaBatalla.panelTablero;
import java.applet.AudioClip;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;


public class ControladorBatalla implements ActionListener {
    private VistaBatalla vistaBatalla;
    private VistaPrevioBatalla vistaPrevioBatalla;
    private ControladorPrevioBatalla ctrlPrevioBatalla;
    int participantes;
    private int movimiento;
    private int ataque;
    private int defensa;
    private int invocaciones;
    private List<String> dadosSeleccionados = new ArrayList<>();
    int botonPresionado;
    DespliegueDados despliegue;
    public Criatura criaturaInvocada = null;
    public Combate combate = new Combate();
    Accion accion = new Accion(null, null);
    public Tablero tablero = new Tablero(this, this.accion);
    Jugador jugadores[] = new Jugador[2];
    public static Criatura criaturasJ1[] = new Criatura[15];
    Criatura[] criaturasJ2 = new Criatura[15];
    JefeDeTerreno[] jefes = new JefeDeTerreno[2];
    PuzleDeDados[] puzles = new PuzleDeDados[2];

    public VistaBatalla getVistaBatalla() {
        return vistaBatalla;
    }

    public void setVistaBatalla(VistaBatalla vistaBatalla) {
        this.vistaBatalla = vistaBatalla;
    }

    public PuzleDeDados[] getPuzles() {
        return puzles;
    }

    public void setPuzles(PuzleDeDados[] puzles) {
        this.puzles = puzles;
    }
    Dado[] dadosJ1 = new Dado[15];
    Dado[] dadosJ2 = new Dado[15];
    /*Jugador jugador1 = new Jugador();
    Jugador jugador2 = new Jugador();
    Criatura criatura1 = new Criatura();
    Criatura criatura2 = new Criatura();
    Criatura criatura3 = new Criatura();
    Criatura criatura4 = new Criatura();
    Criatura criatura5 = new Criatura();
    Criatura criatura6 = new Criatura();
    Criatura criatura7 = new Criatura();
    Criatura criatura8 = new Criatura();
    JefeDeTerreno jefe1 = new JefeDeTerreno();
    JefeDeTerreno jefe2 = new JefeDeTerreno();
    PuzleDeDados puzleJ1 = new PuzleDeDados();
    PuzleDeDados puzleJ2 = new PuzleDeDados();
    Dado dado1J1 = new Dado();
    Dado dado2J1 = new Dado();
    Dado dado3J1 = new Dado();
    Dado dado4J1 = new Dado();
    Dado dado1J2 = new Dado();
    Dado dado2J2 = new Dado();
    Dado dado3J2 = new Dado();
    Dado dado4J2 = new Dado();*/
   
    public ControladorBatalla(VistaBatalla vistaBatalla){
        this.vistaBatalla = vistaBatalla;  
        AudioClip sonido = java.applet.Applet.newAudioClip(getClass().getResource("/Sonidos/Corona.wav"));
        
        sonido.play();
        
    } 
    
    public void iniciar_VistaBatalla(){
        ///////////////////////////////Jugador 1////////////////////////////////
        this.jugadores[0] = new Jugador("Batman");
        this.combate.setJugador1(this.jugadores[0].getNombreJugador());
        /////Jefe de Terreno J1:
        this.jefes[0] = new JefeDeTerreno("Goblin Superior", "Velocidad");
        //////////Criaturas J1:
        /////Nivel 1:
        String carasD1J1[] = {"mov","inv","atk","atk","mov","inv"};
        String carasD2J1[] = {"mov","inv","inv","atk","mov","inv"};
        String carasD3J1[] = {"mov","mov","atk","atk","mov","mov"};
        String carasD13J1[] = {"mov","inv","atk","atk","mov","inv"};
        Criatura criatura1 = new Criatura("Goblin", 500, 110, 1, 150, dadosJ1[0]);
        Criatura criatura2 = new Criatura("Orco nivel 1",490, 100, 1, 160, dadosJ1[1]);
        Criatura criatura3 = new Criatura("Uruk-hai nivel 1", 500, 110, 1, 150, dadosJ1[2]);
        Criatura criatura13 = new Criatura("Balrog nivel 1", 500, 110, 1, 150, dadosJ1[12]);
        criaturasJ1[0] = criatura1;
        criaturasJ1[1] = criatura2;
        criaturasJ1[2] = criatura3;
        criaturasJ1[12] = criatura13;
        Dado dado1J1 = new Dado(criaturasJ1[0].getNombre(), carasD1J1, criaturasJ1[0]);
        Dado dado2J1 = new Dado(criaturasJ1[1].getNombre(), carasD2J1, criaturasJ1[1]);
        Dado dado3J1 = new Dado(criaturasJ1[2].getNombre(), carasD3J1, criaturasJ1[2]); 
        Dado dado13J1 = new Dado(criaturasJ1[12].getNombre(), carasD13J1, criaturasJ1[12]);
        dadosJ1[0] = dado1J1;
        dadosJ1[1] = dado2J1;
        dadosJ1[2] = dado3J1;
        dadosJ1[12] = dado13J1;
        //Nivel 2:
        String carasD4J1[] = {"tramp","inv","atk","atk","inv","tramp"};
        String carasD5J1[] = {"tramp","inv","atk","atk","inv","tramp"};
        String carasD6J1[] = {"tramp","inv","atk","atk","inv","tramp"};
        String carasD14J1[] = {"tramp","inv","atk","atk","inv","tramp"};
        Criatura criatura4 = new Criatura("Orco nivel 2", 1500, 340, 2, 150, dadosJ1[3]);
        Criatura criatura5 = new Criatura("Balrog nivel 2", 1400, 345, 2, 250, dadosJ1[4]);
        Criatura criatura6 = new Criatura("Uruk-hai nivel 2", 1450, 335, 2, 240, dadosJ1[5]);
        Criatura criatura14 = new Criatura("Goblin nivel 2", 1300, 300, 2, 300, dadosJ1[13]);
        criaturasJ1[3] = criatura4;
        criaturasJ1[4] = criatura5;
        criaturasJ1[5] = criatura6;
        criaturasJ1[13] = criatura14;
        Dado dado4J1 = new Dado(criaturasJ1[3].getNombre(), carasD4J1, criaturasJ1[3]);
        Dado dado5J1 = new Dado(criaturasJ1[4].getNombre(), carasD5J1, criaturasJ1[4]);
        Dado dado6J1 = new Dado(criaturasJ1[5].getNombre(), carasD6J1, criaturasJ1[5]);
        Dado dado14J1 = new Dado(criaturasJ1[13].getNombre(), carasD14J1, criaturasJ1[13]);
        dadosJ1[13] = dado14J1;
        dadosJ1[3] = dado4J1;
        dadosJ1[4] = dado5J1;
        dadosJ1[5] = dado6J1;
        //Nivel 3:
        String carasD7J1[] = {"mov","inv","atk","atk","mov","magia"};
        String carasD8J1[] = {"mov","inv","atk","atk","mov","magia"};
        String carasD9J1[] = {"mov","inv","atk","atk","mov","magia"};
        String carasD15J1[] = {"tramp","inv","atk","atk","inv","tramp"};
        Criatura criatura7 = new Criatura("Uruk-hai", 5000, 234, 3, 1500, dadosJ1[6]);
        Criatura criatura8 = new Criatura("Orco nivel 3", 4000, 120, 3, 1400, dadosJ1[7]);
        Criatura criatura9 = new Criatura("Balrog nivel 3", 5500, 300, 3, 1450, dadosJ1[8]);
        Criatura criatura15 = new Criatura("Goblin nivel 3", 1500, 340, 3, 250, dadosJ1[14]);
        criaturasJ1[6] = criatura7; 
        criaturasJ1[7] = criatura8; 
        criaturasJ1[8] = criatura9;
        criaturasJ1[14] = criatura15;
        Dado dado7J1 = new Dado(criaturasJ1[6].getNombre(), carasD7J1, criaturasJ1[6]);
        Dado dado8J1 = new Dado(criaturasJ1[7].getNombre(), carasD8J1, criaturasJ1[7]);
        Dado dado9J1 = new Dado(criaturasJ1[8].getNombre(), carasD9J1, criaturasJ1[8]);
        Dado dado15J1 = new Dado(criaturasJ1[14].getNombre(), carasD15J1, criaturasJ1[14]);  
        dadosJ1[6] = dado7J1;
        dadosJ1[7] = dado8J1;
        dadosJ1[8] = dado9J1;
        dadosJ1[14] = dado15J1; 
        //Nivel 4:
        String carasD10J1[] = {"inv","inv","atk","atk","atk","tramp"};
        String carasD11J1[] = {"inv","inv","atk","atk","atk","tramp"};
        String carasD12J1[] = {"inv","inv","atk","atk","atk","tramp"};
        Criatura criatura10J1 = new Criatura("Balrog", 6000, 2500, 4, 2500, dadosJ1[9]);
        Criatura criatura11J1 = new Criatura("Orco nivel 4", 5500, 2550, 4, 3000, dadosJ1[10]);
        Criatura criatura12J1 = new Criatura("Goblin nivel 4", 3000, 2000, 4, 2500, dadosJ1[11]);
        criaturasJ1[9] = criatura10J1;
        criaturasJ1[10] = criatura11J1;
        criaturasJ1[11] = criatura12J1;
        Dado dado10J1 = new Dado(criaturasJ1[9].getNombre(), carasD10J1, criaturasJ1[9]);
        Dado dado11J1 = new Dado(criaturasJ1[10].getNombre(), carasD11J1, criaturasJ1[10]);
        Dado dado12J1 = new Dado(criaturasJ1[11].getNombre(), carasD12J1, criaturasJ1[11]); 
        dadosJ1[9] = dado10J1;
        dadosJ1[10] = dado11J1;
        dadosJ1[11] = dado12J1;
        //Puzle de dados Jugador1
        String nombreDadosJ1[] = {criaturasJ1[0].getNombre(), criaturasJ1[1].getNombre(), criaturasJ1[2].getNombre(), criaturasJ1[3].getNombre(), criaturasJ1[4].getNombre(), criaturasJ1[5].getNombre(), criaturasJ1[6].getNombre(), criaturasJ1[7].getNombre(), criaturasJ1[8].getNombre(), criaturasJ1[9].getNombre(), criaturasJ1[10].getNombre(), criaturasJ1[11].getNombre(), criaturasJ1[12].getNombre(), criaturasJ1[13].getNombre(), criaturasJ1[14].getNombre()};
        PuzleDeDados puzleJ1 = new PuzleDeDados();
        puzleJ1.setDados(nombreDadosJ1);
        ArrayList<String> nombresDadosJ1 = new ArrayList();
        for(String nombre : nombreDadosJ1){
            nombresDadosJ1.add(nombre);
        }
        puzleJ1.setPuzleDeDados(nombresDadosJ1);
        puzleJ1.setDado(dadosJ1);
        puzles[0] = puzleJ1;    
        ///////////////////////////////Jugador 2//////////////////////////////// 
        jugadores[1] = new Jugador("Superman");
        this.combate.setJugador2(jugadores[1].getNombreJugador());
        //Jefe de Terreno J2:
        jefes[1] = new JefeDeTerreno("Orco Superior", "+Ataque");
        //////////Criaturas J2:
        /////Nivel 1:
        String carasD1J2[] = {"mov","mov","inv","atk","mov","inv"};
        String carasD2J2[] = {"mov","mov","inv","atk","mov","inv"};
        String carasD3J2[] = {"mov","mov","inv","atk","mov","inv"};
        Criatura criatura1J2 = new Criatura("Rogbal nivel 1", 520, 120, 1, 170, dadosJ2[0]);
        Criatura criatura2J2 = new Criatura("Hairuk nivel 1", 300, 130, 1, 180, dadosJ2[1]);
        Criatura criatura3J2 = new Criatura("Blingo nivel 1", 400, 125, 1, 160, dadosJ2[2]); 
        criaturasJ2[0] = criatura1J2;
        criaturasJ2[1] = criatura2J2;
        criaturasJ2[2] = criatura3J2;
        Dado dado1J2 = new Dado(criaturasJ2[0].getNombre(), carasD1J2, criaturasJ1[0]);
        Dado dado2J2 = new Dado(criaturasJ2[1].getNombre(), carasD2J2, criaturasJ1[1]);
        Dado dado3J2 = new Dado(criaturasJ2[2].getNombre(), carasD3J2, criaturasJ1[2]);
        dadosJ2[0] = dado1J2;
        dadosJ2[1] = dado2J2;
        dadosJ2[2] = dado3J2;
        //Nivel 2:
        String carasD13J2[] = {"inv","magia","mov","mov","atk","tramp"};
        String carasD4J2[] = {"inv","inv","magia","atk","inv","tramp"};
        String carasD5J2[] = {"inv","inv","magia","atk","inv","tramp"};
        String carasD6J2[] = {"inv","inv","magia","atk","inv","tramp"};
        Criatura criatura13J2 = new Criatura("Blingo nivel 2", 1450, 140, 2, 200, dadosJ2[12]);
        Criatura criatura4J2 = new Criatura("Hairuk nivel 2", 1500, 360, 2, 270, dadosJ2[3]);
        Criatura criatura5J2 = new Criatura("Rogbal nivel 2", 1600, 350, 2, 260, dadosJ2[4]);
        Criatura criatura6J2 = new Criatura("Coork nivel 2", 1400, 355, 2, 280, dadosJ2[5]);
        criaturasJ2[12] = criatura13J2;
        criaturasJ2[3] = criatura4J2;
        criaturasJ2[4] = criatura5J2;
        criaturasJ2[5] = criatura6J2;
        Dado dado13J2 = new Dado(criaturasJ2[12].getNombre(), carasD13J2, criaturasJ2[12]);
        Dado dado4J2 = new Dado(criaturasJ2[3].getNombre(), carasD4J2, criaturasJ2[3]);
        Dado dado5J2 = new Dado(criaturasJ2[4].getNombre(), carasD5J2, criaturasJ2[4]);
        Dado dado6J2 = new Dado(criaturasJ2[5].getNombre(), carasD6J2, criaturasJ2[5]);
        dadosJ2[12] = dado13J2;
        dadosJ2[3] = dado4J2;
        dadosJ2[4] = dado5J2;
        dadosJ2[5] = dado6J2;
        //Nivel 3:
        String carasD14J2[] = {"mov","mov","inv","atk","mov","inv"};
        String carasD7J2[] = {"mov","mov","atk","atk","mov","magia"};
        String carasD8J2[] = {"mov","mov","atk","atk","mov","magia"};
        String carasD9J2[] = {"mov","mov","atk","atk","mov","magia"};
        Criatura criatura14J2 = new Criatura("Rogbal nivel 3", 520, 120, 3, 170, dadosJ2[13]);
        Criatura criatura7J2 = new Criatura("Coork nivel 3", 600, 100, 3, 450, dadosJ2[6]);
        Criatura criatura8J2 = new Criatura("Blingo nivel 3", 650, 200, 3, 200, dadosJ2[7]);
        Criatura criatura9J2 = new Criatura("Hairuk nivel 3", 500, 200, 3, 400, dadosJ2[8]);
        criaturasJ2[13] = criatura14J2;
        criaturasJ2[6] = criatura7J2;
        criaturasJ2[7] = criatura8J2;
        criaturasJ2[8] = criatura9J2;  
        Dado dado14J2 = new Dado(criaturasJ2[13].getNombre(), carasD14J2, criaturasJ2[13]);
        Dado dado7J2 = new Dado(criaturasJ2[6].getNombre(), carasD7J2, criaturasJ2[6]);
        Dado dado8J2 = new Dado(criaturasJ2[7].getNombre(), carasD8J2, criaturasJ2[7]);
        Dado dado9J2 = new Dado(criaturasJ2[8].getNombre(), carasD9J2, criaturasJ2[8]); 
        dadosJ2[13] = dado14J2;
        dadosJ2[6] = dado7J2;
        dadosJ2[7] = dado8J2;
        dadosJ2[8] = dado9J2;
        //Nivel 4:
        String carasD15J2[] = {"mov","mov","atk X3","atk","mov","magia"};
        String carasD10J2[] = {"inv","magia","mov","mov","atk","tramp X2"};
        String carasD11J2[] = {"inv","magia X2","mov","mov","atk","tramp"};
        String carasD12J2[] = {"inv","magia","mov X2","mov","atk","tramp"};
        Criatura criatura15J2 = new Criatura("Coork nivel 4", 4000, 100, 4, 1600, dadosJ2[14]);
        Criatura criatura10J2 = new Criatura("Blingo nivel 4", 3000, 200, 4, 1500, dadosJ2[9]);
        Criatura criatura11J2 = new Criatura("Hairuk nivel 4", 2000, 300, 4, 1400, dadosJ2[10]);
        Criatura criatura12J2 = new Criatura("Rogbal nivel 4", 2500, 500, 4, 1300, dadosJ2[11]);
        criaturasJ2[14] = criatura15J2;
        criaturasJ2[9] = criatura10J2;
        criaturasJ2[10] = criatura11J2;
        criaturasJ2[11] = criatura12J2;
        Dado dado15J2 = new Dado(criaturasJ2[14].getNombre(), carasD15J2, criaturasJ2[14]);
        Dado dado10J2 = new Dado(criaturasJ2[9].getNombre(), carasD10J2, criaturasJ2[9]);
        Dado dado11J2 = new Dado(criaturasJ2[10].getNombre(), carasD11J2, criaturasJ2[10]);
        Dado dado12J2 = new Dado(criaturasJ2[11].getNombre(), carasD12J2, criaturasJ2[11]);
        dadosJ2[14] = dado15J2;
        dadosJ2[9] = dado10J2;
        dadosJ2[10] = dado11J2;
        dadosJ2[11] = dado12J2;      
        //Puzle Dados Jugdor 2
        String nombreDadosJ2[] = {criaturasJ2[0].getNombre(), criaturasJ2[1].getNombre(), criaturasJ2[2].getNombre(), criaturasJ2[3].getNombre(), criaturasJ2[4].getNombre(), criaturasJ2[5].getNombre(), criaturasJ2[6].getNombre(), criaturasJ2[7].getNombre(), criaturasJ2[8].getNombre(), criaturasJ2[9].getNombre(), criaturasJ2[10].getNombre(), criaturasJ2[11].getNombre(), criaturasJ2[12].getNombre(), criaturasJ2[13].getNombre(), criaturasJ2[14].getNombre()};
        PuzleDeDados puzleJ2 = new PuzleDeDados();
        puzleJ2.setDados(nombreDadosJ2);
        ArrayList<String> nombresDadosJ2 = new ArrayList();
        for(String nombre : nombreDadosJ2){
            nombresDadosJ2.add(nombre);
        }
        puzleJ2.setPuzleDeDados(nombresDadosJ2);
        puzleJ2.setDado(dadosJ2);
        puzles[1] = puzleJ2;       
        //Llenar Informacion jugadores.
        this.vistaBatalla.txtJugador1.setText(combate.getJugador1());
        this.vistaBatalla.txtJugador2.setText(combate.getJugador2());
        this.vistaBatalla.txtJugador3.setText(null);
        this.vistaBatalla.txtJugador4.setText(null);
        this.vistaBatalla.boxCriaturasJ1.addItem(criaturasJ1[0].getNombre());
        this.vistaBatalla.boxCriaturasJ1.addItem(criaturasJ1[1].getNombre());
        this.vistaBatalla.boxCriaturasJ1.addItem(criaturasJ1[2].getNombre());
        this.vistaBatalla.boxCriaturasJ1.addItem(criaturasJ1[3].getNombre());
        this.vistaBatalla.boxCriaturasJ1.addItem(criaturasJ1[4].getNombre());
        this.vistaBatalla.boxCriaturasJ1.addItem(criaturasJ1[5].getNombre());
        this.vistaBatalla.boxCriaturasJ1.addItem(criaturasJ1[6].getNombre());
        this.vistaBatalla.boxCriaturasJ1.addItem(criaturasJ1[7].getNombre());
        this.vistaBatalla.boxCriaturasJ1.addItem(criaturasJ1[8].getNombre());
        this.vistaBatalla.boxCriaturasJ1.addItem(criaturasJ1[9].getNombre());
        this.vistaBatalla.boxCriaturasJ1.addItem(criaturasJ1[10].getNombre());
        this.vistaBatalla.boxCriaturasJ1.addItem(criaturasJ1[11].getNombre());
        this.vistaBatalla.boxCriaturasJ1.addItem(criaturasJ1[12].getNombre());
        this.vistaBatalla.boxCriaturasJ1.addItem(criaturasJ1[13].getNombre());
        this.vistaBatalla.boxCriaturasJ1.addItem(criaturasJ1[14].getNombre());
        this.vistaBatalla.boxCriaturaJ2.addItem(criaturasJ2[0].getNombre());
        this.vistaBatalla.boxCriaturaJ2.addItem(criaturasJ2[1].getNombre());
        this.vistaBatalla.boxCriaturaJ2.addItem(criaturasJ2[2].getNombre());
        this.vistaBatalla.boxCriaturaJ2.addItem(criaturasJ2[3].getNombre());
        this.vistaBatalla.boxCriaturaJ2.addItem(criaturasJ2[4].getNombre());
        this.vistaBatalla.boxCriaturaJ2.addItem(criaturasJ2[5].getNombre());
        this.vistaBatalla.boxCriaturaJ2.addItem(criaturasJ2[6].getNombre());
        this.vistaBatalla.boxCriaturaJ2.addItem(criaturasJ2[7].getNombre());
        this.vistaBatalla.boxCriaturaJ2.addItem(criaturasJ2[8].getNombre());
        this.vistaBatalla.boxCriaturaJ2.addItem(criaturasJ2[9].getNombre());
        this.vistaBatalla.boxCriaturaJ2.addItem(criaturasJ2[10].getNombre());
        this.vistaBatalla.boxCriaturaJ2.addItem(criaturasJ2[11].getNombre());
        this.vistaBatalla.boxCriaturaJ2.addItem(criaturasJ2[12].getNombre());
        this.vistaBatalla.boxCriaturaJ2.addItem(criaturasJ2[13].getNombre());
        this.vistaBatalla.boxCriaturaJ2.addItem(criaturasJ2[14].getNombre());
        //
        this.vistaBatalla.dadosPuzle.addActionListener(this);
        this.vistaBatalla.seleccionarDado.addActionListener(this);
        //
        this.vistaBatalla.movimientoJ1.setText("0");
        this.vistaBatalla.movimientoJ2.setText("0");
        this.vistaBatalla.cantidadMovJ3.setValue(0);
        this.vistaBatalla.cantidadMovJ4.setValue(0);
        this.vistaBatalla.ataqueJ1.setText("0");
        this.vistaBatalla.ataqueJ2.setText("0");
        this.vistaBatalla.cantidadAtkJ3.setValue(0);
        this.vistaBatalla.cantidadAtkJ4.setValue(0);
        int PVJefe1 = this.jefes[0].getPuntosDeVida();
        this.vistaBatalla.PVJefeJ1.setText(String.valueOf(PVJefe1));
        int PVJefe2 = this.jefes[1].getPuntosDeVida();
        this.vistaBatalla.cantidadPvJ3.setValue(0);
        this.vistaBatalla.PVJefeJ2.setText(String.valueOf(PVJefe2));
        this.vistaBatalla.magiaJ1.setText("0");
        this.vistaBatalla.magiaJ2.setText("0");
        this.vistaBatalla.trampaJ1.setText("0");
        this.vistaBatalla.trampaJ2.setText("0");
        
        
        this.vistaBatalla.jLabel7.setToolTipText("Hola pos!~ ♥");
        
        
        //this.vistaBatalla.panelTablero.
        this.vistaBatalla.finTurno.addActionListener(this);
        this.vistaBatalla.txtJugador1.addActionListener(this);
        this.vistaBatalla.txtJugador2.addActionListener(this);
        this.vistaBatalla.txtJugador3.addActionListener(this);
        this.vistaBatalla.txtJugador4.addActionListener(this);
        this.vistaBatalla.boxCriaturasJ1.addActionListener(this);
        this.vistaBatalla.boxCriaturaJ2.addActionListener(this);
        this.vistaBatalla.boxCriaturasJ3.addActionListener(this);
        this.vistaBatalla.boxCriaturasJ4.addActionListener(this);
        this.vistaBatalla.atacar.setEnabled(false);
        this.vistaBatalla.lanzar.setEnabled(false);
        this.vistaBatalla.lanzarDados.setEnabled(false);
        this.vistaBatalla.magia.setEnabled(false);
        this.vistaBatalla.trampa.setEnabled(false);
        this.vistaBatalla.mover.setEnabled(false);
  
        this.vistaBatalla.estadisticasCriaturasJ1.addActionListener(this);
        this.vistaBatalla.estadisticaCriaturaJ2.addActionListener(this);
        this.vistaBatalla.estadisticasCriaturasJ3.addActionListener(this);
        this.vistaBatalla.estadisticasCriaturaJ4.addActionListener(this); 
        this.vistaBatalla.dadosPuzle.addActionListener(this);
        this.vistaBatalla.turno.addActionListener(this);
        this.vistaBatalla.lanzarDados.addActionListener(this);
        this.vistaBatalla.magia.addActionListener(this);
        this.vistaBatalla.trampa.addActionListener(this);
        this.vistaBatalla.mover.addActionListener(this);
        this.vistaBatalla.atacar.addActionListener(this);
        
        this.vistaBatalla.seleccionarDado.addActionListener(this);
        this.vistaBatalla.lanzar.addActionListener(this);
        this.dibujo();
    }

    public JefeDeTerreno[] getJefes() {
        return jefes;
    }
    public int getBoton(){
        return this.botonPresionado;
    }
    
    public void setBoton(int boton){
        this.botonPresionado = boton;
    }
    public void dibujo(){
        panelTablero.add(tablero);
        panelTablero.setVisible(true);
        
    }
    
    public Criatura getCriatura(){
        return this.criaturaInvocada;
    }
    
    private void desplegarDados(){
        for(int i = 1; i<= this.invocaciones ; i++){
        this.tablero.setVisible(false);
        DespliegueDados despliegue1 = new DespliegueDados(this);
        VistaBatalla.panelTablero.add(despliegue1);
        despliegue1.setVisible(true);
        }
        this.invocaciones -= 1;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object boton = e.getSource();  
        if (boton == this.vistaBatalla.turno){
            this.tablero.ponerJefe(2);
            this.tablero.repaint();
            this.tablero.setVisible(true);
            combate.seleccionarTurno(2, jugadores[0].getNombreJugador(), jugadores[1].getNombreJugador(), null, null);
            System.out.println(combate.getJugadorActual());
            JOptionPane.showMessageDialog(null, "Juega el jugador " + combate.getJugadorActual());
            this.vistaBatalla.turno.setEnabled(false);
            this.vistaBatalla.lanzar.setEnabled(false);
            this.vistaBatalla.lanzarDados.setEnabled(true);
        }
        //Condicion para mostrar los dados del jugador actual
        if (boton == this.vistaBatalla.lanzarDados){                    
            this.vistaBatalla.seleccionarDado.setVisible(true);          
            this.vistaBatalla.panelLanzarDados.setEnabled(true);
            this.vistaBatalla.lanzarDados.setEnabled(false);
            String turno = combate.getJugadorActual();                    
            if (turno.equals(combate.getJugador1())){                    
                System.out.print(combate.getJugador1());                 
                ArrayList<String> criaturasDado = puzles[0].getPuzleDeDados();    
                for (String criaturasDado1 : criaturasDado) {            
                    this.vistaBatalla.dadosPuzle.addItem(criaturasDado1);
                }                                                        
            }                                                            
            else if (turno.equals(combate.getJugador2())){               
                System.out.print(combate.getJugador1());                 
                ArrayList<String> criaturasDado2 = puzles[1].getPuzleDeDados();   
                for (String criaturasDado1 : criaturasDado2) {           
                this.vistaBatalla.dadosPuzle.addItem(criaturasDado1);
                }                                                    
            }                                                     
        }                                                          
        //Condicion para seleccionar dado y guardarlo en una variable
        int i = 0;                                                             
        if (boton == this.vistaBatalla.seleccionarDado){  
            String dado = this.vistaBatalla.dadosPuzle.getSelectedItem().toString();
            this.dadosSeleccionados.add(dado);
            this.vistaBatalla.dadosPuzle.removeItem(dado); 
            this.vistaBatalla.lanzar.setEnabled(true);
            
        }                                                                  
   
        if (boton == this.vistaBatalla.lanzar){  
            this.vistaBatalla.atacar.setEnabled(true);
            this.vistaBatalla.lanzar.setEnabled(false);
            this.vistaBatalla.magia.setEnabled(true);
            this.vistaBatalla.trampa.setEnabled(true);
            this.vistaBatalla.mover.setEnabled(true);
            String jugadorActual = combate.getJugadorActual();
            ArrayList<String> carasEscogidas = new ArrayList<>();
            if (combate.getJugadorActual().equals(combate.getJugador1())){
                for (Dado dadosJugador1 : dadosJ1) {
                    String nombreDado = dadosJugador1.getNombre();
                    if (nombreDado.equals(this.dadosSeleccionados.get(0))) {
                        String caraEscogida1 = dadosJugador1.lanzarDado(dadosJugador1.getCaras());
                        carasEscogidas.add(caraEscogida1);
                        this.vistaBatalla.caraDado1.setText(caraEscogida1);               
                    } else if (nombreDado.equals(this.dadosSeleccionados.get(1))) {
                        String caraEscogida2 = dadosJugador1.lanzarDado(dadosJugador1.getCaras());
                        carasEscogidas.add(caraEscogida2);
                        this.vistaBatalla.caraDado2.setText(caraEscogida2);
                    } else if (nombreDado.equals(this.dadosSeleccionados.get(2))) {
                        String caraEscogida3 = dadosJugador1.lanzarDado(dadosJugador1.getCaras());
                        carasEscogidas.add(caraEscogida3);
                        this.vistaBatalla.caraDado3.setText(caraEscogida3);
                        //this.vistaBatalla.labelDado3.setIcon(icono);
                        
                    } else if (nombreDado.equals(this.dadosSeleccionados.get(3))) {
                        String caraEscogida4 = dadosJugador1.lanzarDado(dadosJugador1.getCaras());
                        carasEscogidas.add(caraEscogida4);
                        this.vistaBatalla.caraDado4.setText(caraEscogida4);
                    }
                }
                for (int j = 0 ; j < 4; j++){
                if(carasEscogidas.get(j).equals("atk")){
                    String ataque = this.vistaBatalla.ataqueJ1.getText();
                    int cantidadAtaque = Integer.parseInt(ataque) + 1;
                    String nuevoAtaque = String.valueOf(cantidadAtaque);
                    this.vistaBatalla.ataqueJ1.setText(nuevoAtaque);
                }
                if(carasEscogidas.get(j).equals("mov")){
                    String movimiento = this.vistaBatalla.movimientoJ1.getText();
                    int cantidadMovimiento = Integer.parseInt(movimiento) + 1;
                    String nuevoMovimiento = String.valueOf(cantidadMovimiento);
                    this.vistaBatalla.movimientoJ1.setText(nuevoMovimiento);
                }
                if(carasEscogidas.get(j).equals("magia")){
                    String magia = this.vistaBatalla.magiaJ1.getText();
                    int cantidadMagia = Integer.parseInt(magia) + 1;
                    String nuevaMagia = String.valueOf(cantidadMagia);
                    this.vistaBatalla.magiaJ1.setText(nuevaMagia);
                }
                if(carasEscogidas.get(j).equals("tramp")){
                    String trampa = this.vistaBatalla.trampaJ1.getText();
                    int cantidadTrampa = Integer.parseInt(trampa) + 1;
                    String nuevaTrampa = String.valueOf(cantidadTrampa);
                    this.vistaBatalla.trampaJ1.setText(nuevaTrampa);
                }
                if(carasEscogidas.get(j).equals("inv")){
                    this.tablero.setVisible(false);
                    DespliegueDados despliegue1 = new DespliegueDados(this);
                    VistaBatalla.panelTablero.add(despliegue1);
                    despliegue1.setVisible(true);
                     for(int a = 0; a < 15 ; a++){
                        if(dadosSeleccionados.get(j).equals(criaturasJ1[a].getNombre())){
                            this.setCriatura(criaturasJ1[a]);
                            a = 15; 
                        }
                }
            }    
            }
            }
            else if(combate.getJugadorActual().equals(combate.getJugador2())){
                for (Dado dadosJugador2 : dadosJ2) {
                    String nombreDado = dadosJugador2.getNombre();
                    if (nombreDado.equals(this.dadosSeleccionados.get(0))) {
                        String caraEscogida1 = dadosJugador2.lanzarDado(dadosJugador2.getCaras());
                        carasEscogidas.add(caraEscogida1);
                        this.vistaBatalla.caraDado1.setText(caraEscogida1);
                    } else if (nombreDado.equals(this.dadosSeleccionados.get(1))) {
                        String caraEscogida2 = dadosJugador2.lanzarDado(dadosJugador2.getCaras());
                        carasEscogidas.add(caraEscogida2);
                        this.vistaBatalla.caraDado2.setText(caraEscogida2);
                    } else if (nombreDado.equals(this.dadosSeleccionados.get(2))) {
                        String caraEscogida3 = dadosJugador2.lanzarDado(dadosJugador2.getCaras());
                        carasEscogidas.add(caraEscogida3);
                        this.vistaBatalla.caraDado3.setText(caraEscogida3);
                    } else if (nombreDado.equals(this.dadosSeleccionados.get(3))) {
                        String caraEscogida4 = dadosJugador2.lanzarDado(dadosJugador2.getCaras());
                        carasEscogidas.add(caraEscogida4);
                        this.vistaBatalla.caraDado4.setText(caraEscogida4);
                    }
                }
                for (int j = 0 ; j < 4 ; j++ ){
                if(carasEscogidas.get(j).equals("atk")){
                    String ataque = this.vistaBatalla.ataqueJ2.getText();
                    int cantidadAtaque = Integer.parseInt(ataque) + 1;
                    String nuevoAtaque = String.valueOf(cantidadAtaque);
                    this.vistaBatalla.ataqueJ2.setText(nuevoAtaque);
                }
                if(carasEscogidas.get(j).equals("mov")){
                    String movimiento = this.vistaBatalla.movimientoJ2.getText();
                    int cantidadMovimiento = Integer.parseInt(movimiento) + 1;
                    String nuevoMovimiento = String.valueOf(cantidadMovimiento);
                    this.vistaBatalla.movimientoJ2.setText(nuevoMovimiento);
                }
                if(carasEscogidas.get(j).equals("magia")){
                    String magia = this.vistaBatalla.magiaJ2.getText();
                    int cantidadMagia = Integer.parseInt(magia) + 1;
                    String nuevaMagia = String.valueOf(cantidadMagia);
                    this.vistaBatalla.magiaJ2.setText(nuevaMagia);
                }
                if(carasEscogidas.get(j).equals("tramp")){
                    String trampa = this.vistaBatalla.trampaJ2.getText();
                    int cantidadTrampa = Integer.parseInt(trampa) + 1;
                    String nuevaTrampa = String.valueOf(cantidadTrampa);
                    this.vistaBatalla.trampaJ2.setText(nuevaTrampa);
                }
                if(carasEscogidas.get(j).equals("inv")){
                    this.tablero.setVisible(false);
                    DespliegueDados despliegue1 = new DespliegueDados(this);
                    VistaBatalla.panelTablero.add(despliegue1);
                    despliegue1.setVisible(true);
                    for(int a = 0; a < 15 ; a++){
                        if(dadosSeleccionados.get(j).equals(criaturasJ2[a].getNombre())){
                            this.setCriatura(criaturasJ2[a]);
                            a = 15;
                        }
                    }
                }
            }    
            }            
           
        }
        
        if(boton == this.vistaBatalla.mover ){
            this.setBoton(70);
            }
            
        if(boton == this.vistaBatalla.trampa){
            this.setBoton(21);
            tablero.setVisible(false);
            Trampas trampa = new Trampas(this);
            panelTablero.add(trampa);
            trampa.setVisible(true);
        
        }
        if(boton == this.vistaBatalla.atacar){
            String jugadorActual = this.combate.getJugadorActual();
            if(jugadorActual.equals(this.combate.getJugador1())){
                int cantidadAtaque = Integer.parseInt(this.vistaBatalla.ataqueJ1.getText());
                if(cantidadAtaque >= 1){
                    JOptionPane.showMessageDialog(null, "Selecciona la criatura con la que deseas atacar.");
                    this.vistaBatalla.ataqueJ1.setText(String.valueOf(cantidadAtaque-1));
                }
                else{
                    JOptionPane.showMessageDialog(null, "No tienes la cantidad de ataque suficiente.");
                }
            }
            else {
                int cantidadAtaque = Integer.parseInt(this.vistaBatalla.ataqueJ2.getText());
                if(cantidadAtaque >= 1){
                    JOptionPane.showMessageDialog(null, "Selecciona la criatura con la que deseas atacar.");
                    this.vistaBatalla.ataqueJ2.setText(String.valueOf(cantidadAtaque-1));
                }
                else{
                    JOptionPane.showMessageDialog(null, "No tienes la cantidad de ataque suficiente.");
                }
            
            this.setBoton(77);
            
        
        }
        }
        if(boton == this.vistaBatalla.finTurno){
            this.vistaBatalla.atacar.setEnabled(false);
            this.vistaBatalla.lanzar.setEnabled(false);
            this.vistaBatalla.magia.setEnabled(false);
            this.vistaBatalla.trampa.setEnabled(false);
            this.vistaBatalla.mover.setEnabled(false);
            this.vistaBatalla.lanzarDados.setEnabled(true);
            this.dadosSeleccionados.clear();
            String actual = this.combate.getJugadorSiguente();
            String siguiente = this.combate.getJugadorActual();
            this.combate.setJugadorActual(actual);
            this.combate.setJugadorSiguente(siguiente);
            JOptionPane.showMessageDialog(null, "Juega el jugador " + combate.getJugadorActual());
            this.vistaBatalla.dadosPuzle.removeAllItems();
        }
        
    }

    public Combate getCombate() {
        return combate;
    }

    public void setCriatura(Criatura criaturaInvocada) {
        this.criaturaInvocada = criaturaInvocada;
    }
}

    
            
