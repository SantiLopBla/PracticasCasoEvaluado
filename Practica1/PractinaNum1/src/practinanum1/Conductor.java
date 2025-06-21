/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practinanum1; 

/**
 *
 * @author sanlo
 */
public class Conductor { 

    private String nombre; // Declarar atributo nombre
    private String cedula; // Declarar atributo cédula
    private String ruta; // Declarar atributo ruta

    public Conductor() { // Constructor vacío (necesario para crear el objeto en el main)
    }

    public Conductor(String nombre, String cedula, String ruta) { // Constructor con parámetros 
        this.nombre = nombre;
        this.cedula = cedula;
        this.ruta = ruta;
    }

    public String getNombre() { // Getter para nombre
        return nombre;
    }

    public void setNombre(String nombre) { // Setter para nombre
        this.nombre = nombre;
    }

    public String getCedula() { // Getter para cédula
        return cedula;
    }

    public void setCedula(String cedula) { // Setter para cédula
        this.cedula = cedula;
    }

    public String getRuta() { // Getter para ruta
        return ruta;
    }

    public void setRuta(String ruta) { // Setter para ruta
        this.ruta = ruta;
    }

    @Override
    public String toString() { // Método para mostrar los datos del conductor como texto
        return "Conductor: \n"
                + "nombre= " + nombre + "\n"
                + "Ruta= " + ruta + "\n";
    }

}
