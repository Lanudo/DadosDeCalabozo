
package Controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Vistas.*;
import Modelo.*;

public class ControladorRegistroUsuarios implements ActionListener {
    private VistaRegistroUsuarios registroUsuario; 
    
    public ControladorRegistroUsuarios(VistaRegistroUsuarios registroUsuario){
        this.registroUsuario = registroUsuario;
    }
    
    public void iniciarRegistroUsuarios(){
        this.registroUsuario.nombreUsuario.addActionListener(this);
        this.registroUsuario.contrasena1.addActionListener(this);
        this.registroUsuario.contrasena2.addActionListener(this);
        this.registroUsuario.cambiarPuzle.addActionListener(this);
        this.registroUsuario.Registrarse.addActionListener(this);
        this.registroUsuario.Volver.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String nombreUser = this.registroUsuario.nombreUsuario.getText();
        String contrasenaUser = this.registroUsuario.contrasena1.getText();
        String contrasena2User = this.registroUsuario.contrasena2.getText();
        Object boton = e.getSource();
        if (boton == this.registroUsuario.Registrarse){
            //Codigo que guardara un nuevo usuario en la base de datos..
            //ocuapndo los metodos de la clase Jugador.
        }
        
        if (boton == this.registroUsuario.cambiarPuzle){
            VistaPuzleDeDados puzleDados = new VistaPuzleDeDados();
            ControladorPuzleDeDados ctrlPuzle = new ControladorPuzleDeDados(puzleDados);
            ctrlPuzle.iniciarPuzleDados();
            puzleDados.setVisible(true);
        }
        if (boton == this.registroUsuario.Volver){
            VistaInicio vistaInicio = new VistaInicio();
            ControladorInicio ctrlInicio = new ControladorInicio(vistaInicio);
            ctrlInicio.iniciar_VistaInicio();
            vistaInicio.setVisible(true);
            registroUsuario.setVisible(false);
        }
        
    }
    
}
