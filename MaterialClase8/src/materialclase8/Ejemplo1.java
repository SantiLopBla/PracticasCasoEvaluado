/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package materialclase8;

import javax.swing.JOptionPane;

/**
 *
 * @author sanlo
 */
public class Ejemplo1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //Los arreglos solo pueden ser de un tipo
        //int ejemploArreglo[]=new int [100]
        //Arreglo unidimensional

        int notas[] = new int[3]; // Arreglo de 3 posiciones. Empieza siempre en 0
        for (int i = 0; i < notas.length; i++) {
            notas[i] = Integer.parseInt(JOptionPane.showInputDialog("Ingrese las notas del estudiante: "));
            int edades[] = new int[5];
            solicitaDataArreglo(edades, "Digite la edad");

            notas[2] = 3;
            //notas[3]=3;// Esto daria error
            imprimeDataArreglo(edades);
            imprimeDataArreglo(notas);
        }
    }

    //Crear metodos que reciban e ingresen esa informacion
    public static void solicitaDataArreglo(int[] arreglo, String texto) {
        for (int i = 0; i < arreglo.length; i++) { //lenght es la longitud del dato
            arreglo[i] = Integer.parseInt(JOptionPane.showInputDialog(texto + i));
        }
    }

    public static void imprimeDataArreglo(int[] arreglo) {
        String resultado = "";
        for (int i = 0; i < arreglo.length; i++) {
            resultado += arreglo[i] + ",";
        }
        JOptionPane.showMessageDialog(null, resultado);
    }
}
