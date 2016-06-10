
package Modelo;

import java.util.Random;


public class Dado {
    
    private String nombre;
    private String caras[];
    private Criatura criatura;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String[] getCaras() {
        return caras;
    }

    public void setCaras(String[] dado) {
        this.caras = dado;
    }

    public Criatura getCriatura() {
        return criatura;
    }

    public void setCriatura(Criatura criatura) {
        this.criatura = criatura;
    }   
    
    public String lanzarDado(String[] dado){
        Random  rnd = new Random();
        int numero = rnd.nextInt(6);
        String cara = dado[numero];
        return cara;
    }

    String[] getDado() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
