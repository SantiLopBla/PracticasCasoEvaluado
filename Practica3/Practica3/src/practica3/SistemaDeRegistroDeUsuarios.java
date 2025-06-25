/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package practica3; // Paquete del proyecto

import javax.swing.JOptionPane; // Librería para entradas/salidas gráficas

public class SistemaDeRegistroDeUsuarios {

    public static void main(String[] args) {
        // TODO code application logic here
        int cantUsuarios = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de usuarios: ")); // Pide cuántos usuarios se registrarán
        int i = 0; // Contador para el ciclo

        while (i < cantUsuarios) { // Repite mientras falten usuarios

            Usuario u = new Usuario(); // Crea un nuevo usuario
            u.setNombre(JOptionPane.showInputDialog("Ingrese su nombre: ")); // Pide nombre
            u.setCedula(JOptionPane.showInputDialog("Ingrese su cedula: ")); // Pide cédula
            u.setMail(JOptionPane.showInputDialog("Ingrese su correo electronico: ")); // Pide correo

            u.seleccionCategoria(); // Abre la funcion de pedir categoria y pide y asigna la categoría según enum

            Proyectos p = new Proyectos(); // Crea instancia de proyecto
            p.procesoNotasProyecto(); // Registra actividades del usuario

            JOptionPane.showMessageDialog(null, u.toString()); // Muestra datos del usuario
            JOptionPane.showMessageDialog(null, p.toString()); // Muestra resumen del proyecto

            i++; // Avanza al siguiente usuario
        }
    }
}
