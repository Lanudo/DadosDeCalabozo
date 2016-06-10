package Controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Vistas.*;

public class ControladorMenuPrincipal implements ActionListener {
    private VistaMenuPrincipal menuPrincipal;
    
    
    
    public ControladorMenuPrincipal(VistaMenuPrincipal menuPrincipal){
        this.menuPrincipal = menuPrincipal;
    }
    
    public void iniciar_MenuPrincipal(){
        this.menuPrincipal.iniciarBatalla.addActionListener(this);
        this.menuPrincipal.iniciarTorneo.addActionListener(this);
        this.menuPrincipal.iniciarEstadisticas.addActionListener(this);
        this.menuPrincipal.cerrarSesion.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object boton = e.getSource();
        if (boton == this.menuPrincipal.iniciarBatalla){
            VistaPrevioBatalla pBatalla = new VistaPrevioBatalla();
            ControladorPrevioBatalla ctrlPrevioBatalla = new ControladorPrevioBatalla(pBatalla);
            ctrlPrevioBatalla.iniciar_PrevioBatalla();
            pBatalla.setVisible(true);   
            menuPrincipal.setVisible(false);
        }
        
        if (boton == this.menuPrincipal.iniciarTorneo){
            
        }
        
        if (boton == this.menuPrincipal.iniciarEstadisticas){
            
        }
        
        if (boton.equals(this.menuPrincipal.cerrarSesion)){
            VistaInicio vistaInicio = new VistaInicio();
            ControladorInicio ctrlInicio = new ControladorInicio(vistaInicio);
            ctrlInicio.iniciar_VistaInicio();
            vistaInicio.setVisible(true);
            //Agregar alguna funcion que cirre la sesion de la base de datos..
            menuPrincipal.setVisible(false);
        }
    }
    
}
