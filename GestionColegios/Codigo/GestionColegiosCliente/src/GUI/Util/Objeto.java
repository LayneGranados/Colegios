/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Util;

/**
 *
 * @author Administrador
 */
public class Objeto {
    private String nombre;
    private int valor;
    private String otro;
    
    public Objeto(String nombre, int valor, String otro){
        this.nombre= nombre;
        this.valor=valor;
        this.otro=otro;
        
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public String getOtro() {
        return otro;
    }

    public void setOtro(String otro) {
        this.otro = otro;
    }
}
