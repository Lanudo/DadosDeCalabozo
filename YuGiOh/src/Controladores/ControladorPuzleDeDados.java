package Controladores;

import Vistas.VistaPuzleDeDados;
import Modelo.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ControladorPuzleDeDados implements ActionListener {
    private VistaPuzleDeDados vistaPuzleDeDados;
    

    ControladorPuzleDeDados(VistaPuzleDeDados puzleDados) {
        this.vistaPuzleDeDados = puzleDados;
    }

    void iniciarPuzleDados() {
        this.vistaPuzleDeDados.txtUsuario.addActionListener(this);
        this.vistaPuzleDeDados.buscarDados.addActionListener(this);
        this.vistaPuzleDeDados.boxDadosNivel1.addActionListener(this);
        this.vistaPuzleDeDados.boxDadosNivel2.addActionListener(this);
        this.vistaPuzleDeDados.boxDadosNivel3.addActionListener(this);
        this.vistaPuzleDeDados.boxDadosNivel4.addActionListener(this);
        this.vistaPuzleDeDados.caracteristicas1.addActionListener(this);
        this.vistaPuzleDeDados.caracteristicas2.addActionListener(this);
        this.vistaPuzleDeDados.caracteristicas3.addActionListener(this);
        this.vistaPuzleDeDados.caracteristicas4.addActionListener(this);
        this.vistaPuzleDeDados.cara1.addActionListener(this);
        this.vistaPuzleDeDados.cara2.addActionListener(this);
        this.vistaPuzleDeDados.cara3.addActionListener(this);
        this.vistaPuzleDeDados.cara4.addActionListener(this);
        this.vistaPuzleDeDados.cara5.addActionListener(this);
        this.vistaPuzleDeDados.cara6.addActionListener(this);
        this.vistaPuzleDeDados.mostrarNombre.addActionListener(this);
        this.vistaPuzleDeDados.mostrarAtaque.addActionListener(this);
        this.vistaPuzleDeDados.mostrarDefensa.addActionListener(this);
        this.vistaPuzleDeDados.mosstrarPV.addActionListener(this);
        this.vistaPuzleDeDados.agragarAlPuzle.addActionListener(this);
        this.vistaPuzleDeDados.guardarPuzle.addActionListener(this);
        this.vistaPuzleDeDados.quitarDelPuzle.addActionListener(this);
        
    }
   
    @Override
    public void actionPerformed(ActionEvent e) {
        Object boton = e.getSource();
        String usuario = this.vistaPuzleDeDados.txtUsuario.getText();
        if (boton == this.vistaPuzleDeDados.buscarDados){
            
        }
        if (boton == this.vistaPuzleDeDados.caracteristicas1){
            String criatura = this.vistaPuzleDeDados.boxDadosNivel2.getSelectedItem().toString();
          
        }
        if (boton == this.vistaPuzleDeDados.caracteristicas2){
            String criatura = this.vistaPuzleDeDados.boxDadosNivel2.getSelectedItem().toString();
            
            
        }
        if (boton == this.vistaPuzleDeDados.caracteristicas3){
            String criatura = this.vistaPuzleDeDados.boxDadosNivel3.getSelectedItem().toString();
            
        }
        if (boton == this.vistaPuzleDeDados.caracteristicas4){
            String criatura = this.vistaPuzleDeDados.boxDadosNivel4.getSelectedItem().toString();
            
        }
    }
    
}
