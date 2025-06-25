/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package PracticaNum2;

import javax.swing.JOptionPane;

/**
 *
 * @author sanlo
 */
public class SistemaEstudiantil {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int cantEstudiantes = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de estudiantes: ")); // Se pide la cantidad de estudiantes a registrar
        int i = 0; // Contador para controlar el ciclo

        while (i < cantEstudiantes) { // Bucle para registrar cada estudiante

            Estudiante e = new Estudiante(); // Se crea una instancia de Estudiante
            e.setNombre(JOptionPane.showInputDialog("Ingrese el nombre del estudiante: ")); // Se pide el nombre del estudiante
            e.setCedeula(JOptionPane.showInputDialog("Ingrese la cedula del estudiante: ")); // Se pide la cédula del estudiante
            e.setCodigo(JOptionPane.showInputDialog("Ingrese el codigo del estudiante: ")); // Se pide el código del estudiante
            e.setGrupoPerteneciente(JOptionPane.showInputDialog("Ingrese el grupo que pertnece el estudiante: ")); // Se pide el grupo al que pertenece
            e.setBeca(JOptionPane.showConfirmDialog(null, "¿El estudiante posee beca?") == 0); // Se pregunta si tiene beca (Sí = true), el 0 en este caso es true

            CalificacionesYActividades c = new CalificacionesYActividades(); // Se crea una instancia para registrar las actividades del estudiante
            c.procesoNotas(); // Se llama al método que gestiona las actividades y cálculos

            JOptionPane.showMessageDialog(null, e.toString()); // Se muestra la información del estudiante
            JOptionPane.showMessageDialog(null, c.toString()); // Se muestra la información de sus calificaciones y participación
            i++; // Se incrementa el contador para pasar al siguiente estudiante
        }

    }
}
