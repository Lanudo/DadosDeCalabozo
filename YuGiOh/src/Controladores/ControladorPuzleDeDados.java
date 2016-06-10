package Controladores;

import Vistas.VistaPuzleDeDados;
import Modelo.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ControladorPuzleDeDados implements ActionListener {
    private VistaPuzleDeDados vistaPuzleDeDados;
    Dado dado1 = new Dado();
    Dado dado2 = new Dado();
    JefeDeTerreno jefe1 = new JefeDeTerreno();
    JefeDeTerreno jefe2 = new JefeDeTerreno();
    Criatura criatura1 = new Criatura();
    Criatura criatura2 = new Criatura();

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
        //Criatura nivel 1
        String caras[] = {"mov","inv","atk","atk","mov","inv"};
        dado1.setCaras(caras);
        criatura1.setNombre("Goblin");
        criatura1.setDefensa(110);
        criatura1.setNivel(1);
        criatura1.setPuntosDeVida(500);
        criatura1.setAtaque(150);
        criatura1.setDado(dado1);
        //Criatura nivel 2
        String caras2[] = {"tramp","inv","atk","atk","inv","tramp"};
        dado2.setCaras(caras2);
        criatura2.setNombre("Orco");
        criatura2.setAtaque(250);
        criatura2.setDefensa(340);
        criatura2.setPuntosDeVida(1500);
        criatura2.setNivel(2);
        criatura2.setDado(dado2);
    }
   
    @Override
    public void actionPerformed(ActionEvent e) {
        Object boton = e.getSource();
        String usuario = this.vistaPuzleDeDados.txtUsuario.getText();
        if (boton == this.vistaPuzleDeDados.buscarDados){
            if (usuario == "dados"){
                this.vistaPuzleDeDados.boxDadosNivel1.addItem(criatura1.getNombre());
                this.vistaPuzleDeDados.boxDadosNivel2.addItem(criatura2.getNombre());
                
            }
        }
        if (boton == this.vistaPuzleDeDados.caracteristicas1){
            //Se obtiene el nombre de la criatura y se buscan sus datos.
            String criatura = this.vistaPuzleDeDados.boxDadosNivel1.getSelectedItem().toString();
            this.vistaPuzleDeDados.mostrarNombre.setText(criatura1.getNombre());
            //this.vistaPuzleDeDados.mosstrarPV.setText(criatura1.getPuntosDeVida());
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
