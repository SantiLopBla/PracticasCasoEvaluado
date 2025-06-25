/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package practinanum1; // Paquete donde está la clase

import javax.swing.JOptionPane; 

public class ControldeViajes { 

    public static void main(String[] args) {
        int cantConductores = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de conductores:")); // Pregutnar cantidad de conductores
        int i = 0; // Inicializar contador en 0

        while (i < cantConductores) { // Bucle que se repite para cada conductor

            Conductor c = new Conductor(); // Crear nuevo objeto Conductor
            c.setNombre(JOptionPane.showInputDialog("Ingrese el nombre: ")); // Solicita el nombre del conductor
            c.setCedula(JOptionPane.showInputDialog("Ingrese su numero de cedula: ")); // Solicita la cédula
            c.setRuta(JOptionPane.showInputDialog("Ingrese la ruta: ")); // Solicita la ruta

            Viaje v = new Viaje(); // Crear nuevo objeto Viaje
            v.setCodigoViaje(JOptionPane.showInputDialog("Ingrese el código de viaje: ")); // Código del viaje
            v.setCantViajes(Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de viajes: "))); // Cantidad de viajes realizados
            v.setDistRecorrida(Double.parseDouble(JOptionPane.showInputDialog("Ingrese la distancia recorrida en kilometros: "))); // Distancia recorrida
            v.setMes(JOptionPane.showInputDialog("Ingrese el mes en el que viajo: ")); // Mes del viaje

            v.setCargaPesada(JOptionPane.showConfirmDialog(null, "¿Usó carga pesada?") == 0); // Si usó carga pesada (Sí = true)
            v.setInternacional(JOptionPane.showConfirmDialog(null, "¿Su viaje fue internacional?") == 0); // Si fue internacional
            v.setLicenciaProfesional(JOptionPane.showConfirmDialog(null, "¿Cuenta con licencia profesional?") == 0); // Si tiene licencia profesional
            v.setNocturno(JOptionPane.showConfirmDialog(null, "¿Su viaje fue nocturno?") == 0); // Si fue nocturno
            ; // Línea sin función, puede eliminarse

            v.calComisionExtraPuntos(); // Llama al método que calcula comisiones y puntos adicionales
            v.clasificarEstado(i); // Llama al método que clasifica el estado del viaje (por ejemplo: completado, cancelado, etc.)

            JOptionPane.showMessageDialog(null, c.toString()); // Muestra los datos del conductor
            JOptionPane.showMessageDialog(null, v.toString()); // Muestra los datos del viaje

            i++; // Incrementa el contador para pasar al siguiente conductor
        }
    }
}
