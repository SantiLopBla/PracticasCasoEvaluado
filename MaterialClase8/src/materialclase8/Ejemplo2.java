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
public class Ejemplo2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //Arreglo bidimensional
        //int ejemplo [][]= new int[10][10] //Arreglo de 1o filas y 10 columnas

        int fila=2;
        int columna=3;
        String ropa [][]=new String [fila][columna];
        solicitaDataMatrix(ropa,fila,columna);
        imprimeDataMatrix(ropa, fila, columna);
    }
    public static void solicitaDataMatrix(String [][] matrix, int fila, int columna){
        for (int i = 0; i < fila; i++) {
            for (int j = 0; j < columna; j++) {
                matrix[i][j]=JOptionPane.showInputDialog("Digite la ropa");
            }
            
        }
    }
    
    public static void imprimeDataMatrix(String[][] matrix, int fila, int columna){
        String res="";
        for (int i = 0; i < fila; i++) {
            for (int j = 0; j < columna; j++) {
                res+=matrix[i][j];
            }
            res+="\n";
        }
    }
}