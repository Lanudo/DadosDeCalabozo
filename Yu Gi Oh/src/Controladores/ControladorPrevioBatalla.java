package Controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Vistas.*;
import Modelo.*;
import static javafx.beans.binding.Bindings.or;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;


public class ControladorPrevioBatalla implements ActionListener {
    private VistaPrevioBatalla previoBatalla;
    private VistaBatalla vistaBatalla;
    private Combate combate;
    public int competidores;
    public String[] jugadores;
    ButtonGroup grupoCompetidores = new ButtonGroup();
    ButtonGroup grupoModalidad = new ButtonGroup();
    
    public ControladorPrevioBatalla(VistaPrevioBatalla previoBatalla){
        this.previoBatalla = previoBatalla;
    }
    
    public void iniciar_PrevioBatalla(){
        //Botones que contiene la vista Previo Batalla.
        this.previoBatalla.GenerarBatalla.addActionListener(this);
        this.previoBatalla.cantidadCpu.addActionListener(this);
        this.previoBatalla.Volver.addActionListener(this);
        this.previoBatalla.cantidadUsuarios.addActionListener(this);
        this.previoBatalla.equipos.addActionListener(this);
        this.previoBatalla.escogerDados.addActionListener(this);
        this.previoBatalla.individual.addActionListener(this);
        this.previoBatalla.soloUsuarios.addActionListener(this);
        this.previoBatalla.soloCpu.addActionListener(this);
        this.previoBatalla.usuariosCpu.addActionListener(this);
        //Grupo de botones que sirve para seleccionar quienes competiran.
        grupoCompetidores.add(this.previoBatalla.soloUsuarios);
        grupoCompetidores.add(this.previoBatalla.soloCpu);
        grupoCompetidores.add(this.previoBatalla.usuariosCpu);
        //Grupo de botones que sirve para seleccionar solo una modalidad.
        grupoModalidad.add(this.previoBatalla.individual);
        grupoModalidad.add(this.previoBatalla.equipos);
        //
        this.previoBatalla.soloUsuarios.setActionCommand("solo usuarios");
        this.previoBatalla.soloCpu.setActionCommand("solo cpu");
        this.previoBatalla.usuariosCpu.setActionCommand("usuarios cpu");
        //
        this.previoBatalla.individual.setActionCommand("individual");
        this.previoBatalla.equipos.setActionCommand("equipos");
        //
        this.previoBatalla.individual.setEnabled(false);
        this.previoBatalla.equipos.setEnabled(false); 
        //
        //this.previoBatalla.cantidadCpu.setEnabled(false);
        //this.previoBatalla.cantidadUsuarios.setEnabled(false);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object boton = e.getSource();
        String botonGrupo1 = grupoCompetidores.getSelection().getActionCommand();
        int cantCompetidor = 0;
        int cantCpu = 0;
        if (null != botonGrupo1)switch (botonGrupo1) {
            case "solo usuarios":
                this.previoBatalla.cantidadUsuarios.setEnabled(true);
                this.previoBatalla.cantidadCpu.setEnabled(false);
                cantCompetidor = this.previoBatalla.cantidadUsuarios.getItemCount();
                break;
            case "solo cpu":
                this.previoBatalla.cantidadCpu.setEnabled(true);
                this.previoBatalla.cantidadUsuarios.setEnabled(false);
                cantCpu = this.previoBatalla.cantidadCpu.getItemCount();
                break;
            case "usuarios cpu":
                this.previoBatalla.soloUsuarios.setEnabled(true);
                this.previoBatalla.soloCpu.setEnabled(true);
                cantCompetidor = this.previoBatalla.cantidadUsuarios.getItemCount();
                cantCpu = this.previoBatalla.cantidadCpu.getItemCount();
                if ((cantCompetidor + cantCpu) > 4){
                    JOptionPane.showMessageDialog(null, "Debe escoger entre 2 y 4 jugadores");
                }
         
                break;
            default:
                break;
        }
        
        if (boton == this.previoBatalla.GenerarBatalla){
            
            VistaBatalla vistaBatalla = new VistaBatalla(combate);
            ControladorBatalla ctrlBatalla = new ControladorBatalla(vistaBatalla);
            ctrlBatalla.iniciar_VistaBatalla();
            vistaBatalla.setVisible(true);
            previoBatalla.setVisible(false); 
        }
            /*if ("solo usuarios".equals(botonGrupo1)){
                this.previoBatalla.cantidadUsuarios.setEnabled(true);
                cantCompetidor = this.previoBatalla.cantidadUsuarios.getItemCount();
                if (cantCompetidor == 2 || cantCompetidor == 3 || cantCompetidor == 4){
                    VistaBatalla vistaBatalla = new VistaBatalla();
                    ControladorBatalla ctrlBatalla = new ControladorBatalla(vistaBatalla);
                    ctrlBatalla.iniciar_VistaBatalla();
                    vistaBatalla.setVisible(true);
                    previoBatalla.setVisible(false);   
                }   
            }
            
            if ("solo cpu".equals(botonGrupo1)){
                this.previoBatalla.cantidadCpu.setEnabled(true);
            }
            
            if ("usuarios cpu".equals(botonGrupo1)){
                this.previoBatalla.cantidadUsuarios.setEnabled(true);
                this.previoBatalla.cantidadCpu.setEnabled(true);
                VistaBatalla vistaBatalla = new VistaBatalla();
                ControladorBatalla ctrlBatalla = new ControladorBatalla(vistaBatalla);
                ctrlBatalla.iniciar_VistaBatalla();
                vistaBatalla.setVisible(true);
                previoBatalla.setVisible(false);  
            }
        }*/
        if (boton == this.previoBatalla.Volver){
            VistaMenuPrincipal menuPrincipal = new VistaMenuPrincipal();
            ControladorMenuPrincipal ctrlMenuPrincipal = new ControladorMenuPrincipal(menuPrincipal);
            ctrlMenuPrincipal.iniciar_MenuPrincipal();
            menuPrincipal.setVisible(true);
            previoBatalla.setVisible(false);
        }
}
}