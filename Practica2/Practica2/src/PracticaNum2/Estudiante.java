/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PracticaNum2;

/**
 *
 * @author sanlo
 */
public class Estudiante {

    private String nombre; // Nombre del estudiante
    private String cedeula; // Cédula del estudiante 
    private String codigo; // Código de estudiante
    public static String nombCole = "Patitos Colegio"; // Nombre del colegio (atributo compartido por todos)
    private String grupoPerteneciente; // Grupo al que pertenece el estudiante
    private boolean beca; // Si tiene beca o no

    public Estudiante() { // Constructor vacío
    }

    public Estudiante(String nombre, String cedeula, String codigo, String grupoPerteneciente, boolean beca) { // Constructor con todos los atributos
        this.nombre = nombre;
        this.cedeula = cedeula;
        this.codigo = codigo;
        this.grupoPerteneciente = grupoPerteneciente;
        this.beca = beca;
    }

    public String getNombre() { // Getter para nombre
        return nombre;
    }

    public void setNombre(String nombre) { // Setter para nombre
        this.nombre = nombre;
    }

    public String getCedeula() { // Getter para cédula
        return cedeula;
    }

    public void setCedeula(String cedeula) { // Setter para cédula
        this.cedeula = cedeula;
    }

    public String getCodigo() { // Getter para código
        return codigo;
    }

    public void setCodigo(String codigo) { // Setter para código
        this.codigo = codigo;
    }

    public static String getNombCole() { // Getter para nombre del colegio (estático)
        return nombCole;
    }

    public static void setNombCole(String nombCole) { // Setter para nombre del colegio (estático)
        Estudiante.nombCole = nombCole;
    }

    public String getGrupoPerteneciente() { // Getter para grupo
        return grupoPerteneciente;
    }

    public void setGrupoPerteneciente(String grupoPerteneciente) { // Setter para grupo
        this.grupoPerteneciente = grupoPerteneciente;
    }

    public boolean isBeca() { // Getter para beca (booleano)
        return beca;
    }

    public void setBeca(boolean beca) { // Setter para beca
        this.beca = beca;
    }

    @Override
    public String toString() { // Método para mostrar la información del estudiante
        return "Desglose dek estudiante " + nombre + ", con codigo de estudiante " + codigo + ", que pertenece al grupo " + grupoPerteneciente + " y la valoracion si contiene beca o no es " + beca + '}';
    }

}
