/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica3; // Paquete del proyecto

import javax.swing.JOptionPane; // Librería para interfaces gráficas

public class Proyectos {

    private String nombreProyecto; // Nombre del proyecto
    private String codigoProyceto; // Código del proyecto
    private double calificacionProyecto; // Nota obtenida
    private double puntObtenido = 0; // Puntos acumulados
    private int numSemana = 0; // Semana de entrega
    private boolean solitarioGrupal = false; // Si fue grupal
    private boolean aTiempoTardio = false; // Si fue entregado a tiempo
    private boolean revisadoProfe = false; // Si lo revisó el profe
    private boolean bonoExtra = false; // Si recibió bono extra
    private double sumaNotas = 0; // Suma de todas las notas
    private double promedio = 0; // Promedio final
    private Estado estado; // Estado del proyecto (enum)

    public Proyectos() {
    } // Constructor vacío para que se vea en el main

    public Proyectos(String nombreProyecto, String codigoProyceto, double calificaiconProyecto, Estado estado) {
        this.nombreProyecto = nombreProyecto;
        this.codigoProyceto = codigoProyceto;
        this.calificacionProyecto = calificaiconProyecto;
        this.estado = estado;
    }

    public String getNombreProyecto() {
        return nombreProyecto;
    }

    public void setNombreProyecto(String nombreProyecto) {
        this.nombreProyecto = nombreProyecto;
    }

    public String getCodigoProyceto() {
        return codigoProyceto;
    }

    public void setCodigoProyceto(String codigoProyceto) {
        this.codigoProyceto = codigoProyceto;
    }

    public double getCalificaiconProyecto() {
        return calificacionProyecto;
    }

    public void setCalificaiconProyecto(double calificaiconProyecto) {
        this.calificacionProyecto = calificaiconProyecto;
    }

    public double getPuntObtenido() {
        return puntObtenido;
    }

    public void setPuntObtenido(double puntObtenido) {
        this.puntObtenido = puntObtenido;
    }

    public int getNumSemana() {
        return numSemana;
    }

    public void setNumSemana(int numSemana) {
        this.numSemana = numSemana;
    }

    public boolean isSolitarioGrupal() {
        return solitarioGrupal;
    }

    public void setSolitarioGrupal(boolean solitarioGrupal) {
        this.solitarioGrupal = solitarioGrupal;
    }

    public boolean isaTiempoTardio() {
        return aTiempoTardio;
    }

    public void setaTiempoTardio(boolean aTiempoTardio) {
        this.aTiempoTardio = aTiempoTardio;
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

    public double getSumaNotas() {
        return sumaNotas;
    }

    public void setSumaNotas(double sumaNotas) {
        this.sumaNotas = sumaNotas;
    }

    public double getPromedio() {
        return promedio;
    }

    public void setPromedio(double promedio) {
        this.promedio = promedio;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public void procesoNotasProyecto() { // Registra proyectos y calcula puntos/promedio
        boolean seguir = true;
        int u = 0; // Cantidad de actividades
        int g = 0; // Cantidad entregadas a tiempo

        while (seguir) {
            int respuesta = JOptionPane.showConfirmDialog(null, "¿Desea agregar una actividad?");
            if (respuesta == 0) {
                u++;
                Proyectos p = new Proyectos(); // Nueva actividad
                p.setNombreProyecto(JOptionPane.showInputDialog("Ingrese el nombre del proyecto:"));
                p.setCodigoProyceto(JOptionPane.showInputDialog("Ingrese el codigo del proyecto:"));
                p.setSolitarioGrupal(JOptionPane.showConfirmDialog(null, "El proyecto fue grupal o solitario?") == 0);
                p.setRevisadoProfe(JOptionPane.showConfirmDialog(null, "El proyecto fue revisado por el profesor?") == 0);
                p.setCalificaiconProyecto(Double.parseDouble(JOptionPane.showInputDialog("Ingrese la nota del proyecto:")));
                p.setaTiempoTardio(JOptionPane.showConfirmDialog(null, "El proyecto fue entragado a tiempo") == 0);
                if (p.aTiempoTardio) {
                    g++;
                }

                int semana = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la semana de la actividad:"));
                while (true) {
                    if (semana <= 16) {
                        break;
                    } else {
                        JOptionPane.showMessageDialog(null, "Semana inválida. Debe estar entre 1 y 15.");
                        semana = Integer.parseInt(JOptionPane.showInputDialog("Ingrese nuevamente la semana de la actividad:"));
                        p.setNumSemana(numSemana);
                    }
                }

                int estadoProyecto = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el estado de la tarea. 1=Aprobado. 2=Pendiente. 3=Reprobado)"));
                if (estadoProyecto == 1) {
                    estado = Estado.Aprobado;
                } else if (estadoProyecto == 2) {
                    estado = Estado.Pendiente;
                } else if (estadoProyecto == 3) {
                    estado = Estado.Reprobado;
                }

                sumaNotas += p.getCalificaiconProyecto();
                promedio = sumaNotas / u;

                // Corrección: usar solo IFs independientes para que todas las condiciones se apliquen correctamente
                if (p.aTiempoTardio) {
                    puntObtenido += 1;
                }

                if (p.solitarioGrupal) {
                    puntObtenido += 2;
                }

                if (p.revisadoProfe) {
                    puntObtenido += 1;
                }

                if (p.calificacionProyecto >= 90) {
                    puntObtenido += 2;
                }

                if (p.calificacionProyecto < 70) {
                    puntObtenido -= 1;
                }

                if (promedio > 85 || g > 5) {
                    puntObtenido += 10;
                    bonoExtra = true;
                }

            } else {
                seguir = false;
            }
        }
    }

    @Override
    public String toString() {
        return "Proyectos"
                + "Puntos obtenidos= " + puntObtenido + "\n"
                + "¿Obtuvo bono extra? = " + bonoExtra + "\n"
                + "Promedio= " + promedio;
    }
}
