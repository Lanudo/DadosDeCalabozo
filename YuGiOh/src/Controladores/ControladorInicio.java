
package Controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import Vistas.*;
import javax.swing.JOptionPane;


public class ControladorInicio implements ActionListener {
    private VistaInicio vistaInicio;
    
    public ControladorInicio(VistaInicio vistaInicio){
        this.vistaInicio = vistaInicio;
    }
    public void iniciar_VistaInicio(){
        this.vistaInicio.iniciar.addActionListener(this);
        this.vistaInicio.contraseña.addActionListener(this);
        this.vistaInicio.iniciar.addActionListener(this);
        this.vistaInicio.registrarse.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object boton = e.getSource();
        String nombreUsuario = this.vistaInicio.nombreUsuario.getText();
        String contrasena = this.vistaInicio.contraseña.getText();
        if (boton == this.vistaInicio.iniciar){
            if (nombreUsuario.equals("dados") && contrasena.equals("123")){
                VistaMenuPrincipal menuPrincipal = new VistaMenuPrincipal();
                ControladorMenuPrincipal ctrlMenu = new ControladorMenuPrincipal(menuPrincipal);
                ctrlMenu.iniciar_MenuPrincipal();
                menuPrincipal.setVisible(true);
                vistaInicio.setVisible(false); 
            }
            else{
            JOptionPane.showMessageDialog(null, "Datos incorrectos, por favor intentelo de nuevo");
        }
        }
        
        if (boton == this.vistaInicio.registrarse){
            VistaRegistroUsuarios registroUsuarios = new VistaRegistroUsuarios();
            ControladorRegistroUsuarios ctrlRegistro = new ControladorRegistroUsuarios(registroUsuarios);
            ctrlRegistro.iniciarRegistroUsuarios();
            registroUsuarios.setVisible(true);
            vistaInicio.setVisible(false);
        }
     
    }
    
    
}
