/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PracticaNum2;

import javax.swing.JOptionPane;

/**
 *
 * @author sanlo
 */
public class CalificacionesYActividades { // Clase que representa una actividad con calificación

    private String nombreActividad; // Nombre de la actividad
    private String codigoActividad; // Código de la actividad
    private double calificacion; // Nota obtenida
    private int semanaActividad; // Semana en la que se realizó
    private double notaBase; // Nota base 
    private boolean tardioAtempo = false; // Si se entregó a tiempo
    private boolean grupalSolitario = false; // Si fue grupal
    private boolean revisadoProfe = false; // Si fue revisado por el profesor
    private boolean bonoExtra = false; // Si obtuvo bono extra
    private double promedio = 0; // Promedio final
    private double sumaNotas = 0; // Suma de todas las notas
    private double sumaPuntos = 0; // Puntos de participación
    private EstadoActividad estado; // Estado de la actividad (enum)

    public CalificacionesYActividades() {
    }

    public CalificacionesYActividades(String nombreActividad, String codigoActividad, double calificacion, int semanaActividad, double notaBase, EstadoActividad estado) {
        this.nombreActividad = nombreActividad;
        this.codigoActividad = codigoActividad;
        this.calificacion = calificacion;
        this.semanaActividad = semanaActividad;
        this.notaBase = notaBase;
        this.estado = estado;
    }

    public String getNombreActividad() {
        return nombreActividad;
    }

    public void setNombreActividad(String nombreActividad) {
        this.nombreActividad = nombreActividad;
    }

    public String getCodigoActividad() {
        return codigoActividad;
    }

    public void setCodigoActividad(String codigoActividad) {
        this.codigoActividad = codigoActividad;
    }

    public double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(double calificacion) {
        this.calificacion = calificacion;
    }

    public int getSemanaActividad() {
        return semanaActividad;
    }

    public void setSemanaActividad(int semanaActividad) {
        this.semanaActividad = semanaActividad;
    }

    public double getNotaBase() {
        return notaBase;
    }

    public void setNotaBase(double notaBase) {
        this.notaBase = notaBase;
    }

    public boolean isTardioAtempo() {
        return tardioAtempo;
    }

    public void setTardioAtempo(boolean tardioAtempo) {
        this.tardioAtempo = tardioAtempo;
    }

    public boolean isGrupalSolitario() {
        return grupalSolitario;
    }

    public void setGrupalSolitario(boolean grupalSolitario) {
        this.grupalSolitario = grupalSolitario;
    }

    public boolean isRevisadoProfe() {
        return revisadoProfe;
    }

    public void setRevisadoProfe(boolean revisadoProfe) {
        this.revisadoProfe = revisadoProfe;
    }

    public boolean isBonoExtra() {
        return bonoExtra;
    }

    public void setBonoExtra(boolean bonoExtra) {
        this.bonoExtra = bonoExtra;
    }

    public double getPromedio() {
        return promedio;
    }

    public void setPromedio(double promedio) {
        this.promedio = promedio;
    }

    public double getSumaNotas() {
        return sumaNotas;
    }

    public void setSumaNotas(double sumaNotas) {
        this.sumaNotas = sumaNotas;
    }

    public double getSumaPuntos() {
        return sumaPuntos;
    }

    public void setSumaPuntos(double sumaPuntos) {
        this.sumaPuntos = sumaPuntos;
    }

    public EstadoActividad getEstado() {
        return estado;
    }

    public void setEstado(EstadoActividad estado) {
        this.estado = estado;
    }

    public void procesoNotas() { // Método para registrar actividades y calcular promedio y puntos
        boolean seguir = true; // Control para salir del ciclo
        int u = 0; // Contador de actividades

        while (seguir) {
            int respuesta = JOptionPane.showConfirmDialog(null, "¿Desea agregar una actividad?"); // Pregunta si desea ingresar una actividad, ingresar "si" es 0

            if (respuesta == 0) { // Si presiona "Sí"
                u++;
                CalificacionesYActividades cya = new CalificacionesYActividades(); // Nueva actividad

                cya.setNombreActividad(JOptionPane.showInputDialog("Ingrese el nombre de la actividad: ")); // Nombre
                cya.setCodigoActividad(JOptionPane.showInputDialog("Ingrese el codigo de la actividad:")); // Código
                cya.setCalificacion(Double.parseDouble(JOptionPane.showInputDialog("Ingrese la nota de la actividad"))); // Nota
                cya.setGrupalSolitario(JOptionPane.showConfirmDialog(null, "¿El trabajo fue solitaro o grupal?") == 0); // Boolean Grupal
                cya.setRevisadoProfe(JOptionPane.showConfirmDialog(null, "¿Fue revisado por el profesor?") == 0); // Boolean Revisado
                cya.setTardioAtempo(JOptionPane.showConfirmDialog(null, "¡El trabajo fue entregado a tiempo?") == 0); // Boolean A tiempo

                int semana = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la semana de la actividad:")); // Semana

                while (true) { // Validación de la semana
                    if (semana <= 15) {
                        break; // Semana válida
                    } else {
                        JOptionPane.showMessageDialog(null, "Semana inválida. Debe estar entre 1 y 15.");
                        semana = Integer.parseInt(JOptionPane.showInputDialog("Ingrese nuevamente la semana de la actividad:"));//Para volver a ingresar la semana
                        cya.setSemanaActividad(semana); // Se guarda la semana
                    }
                    
                }

                sumaNotas += cya.getCalificacion(); // Se suma la nota
                promedio = sumaNotas / u; // Se actualiza el promedio

                if (promedio >= 70) { // Se asigna el estado según el promedio final
                    estado = EstadoActividad.Aprobado;
                } else {
                    estado = EstadoActividad.Reprobado;
                }

                // Se suman puntos de participación según condiciones
                if (tardioAtempo) {
                    sumaPuntos += 1;
                } else if (grupalSolitario) {
                    sumaPuntos += 2;
                } else if (revisadoProfe) {
                    sumaPuntos += 1;
                } else if (calificacion > 90) {
                    sumaPuntos += 2;
                } else if (calificacion < 70) {
                    sumaPuntos -= 1;
                } else if (u > 5 || promedio > 85) {
                    bonoExtra = true;
                    sumaPuntos += 10;
                }
            } else {
                seguir = false; // Si no desea agregar más actividades, sale del ciclo
            }
        }
    }

    @Override
    public String toString() { // Método para mostrar el resumen de calificaciones y puntos
        return "Tiene el bono extra= " + bonoExtra + "\n"
                + "Promedio= " + promedio + "\n"
                + ", Puntos de participacion= " + sumaPuntos;
    }
}
