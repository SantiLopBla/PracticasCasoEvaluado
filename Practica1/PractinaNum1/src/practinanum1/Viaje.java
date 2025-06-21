/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license/default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practinanum1; 

import javax.swing.JOptionPane; 

public class Viaje { 

    private String codigoViaje; // Código del viaje
    private double distRecorrida; // Distancia recorrida en km
    private String mes; // Mes en el que se realizó el viaje
    private boolean licenciaProfesional = true; // Si el conductor tiene licencia profesional
    private boolean internacional = true; // Si el viaje fue internacional
    private boolean cargaPesada = true; // Si el viaje tuvo carga pesada
    private boolean nocturno; // Si fue un viaje nocturno
    private int cantViajes; // Cantidad de viajes realizados
    private double base; // Monto base del viaje
    private int cantPuntos = 0; // Puntos del conductor
    private double comisionInternacional = 0; // Comisión por viaje internacional
    private double comisionNocturno = 0; // Comisión por viaje nocturno
    private double comisionPesada = 0; // Comisión por carga pesada
    private double comisionFinal = 0; // Comisión total final
    private double comisionDist = 0; // Comisión por distancia recorrida
    private int bonoExtra; // Bono adicional si cumple condiciones
    private boolean obtuvoBonoExtra = false; // Indica si recibió el bono extra
    private EstadoViaje estado; // Enum con estado del viaje (Completado, Cancelado, EnProceso)

    public Viaje() { // Constructor vacío para usar en el main
    }

    public Viaje(String codigoViaje, double distRecorrida, String mes, boolean nocturno, int cantViajes, double base, int bonoExtra, EstadoViaje estado) {
        this.codigoViaje = codigoViaje;
        this.distRecorrida = distRecorrida;
        this.mes = mes;
        this.nocturno = nocturno;
        this.cantViajes = cantViajes;
        this.base = base;
        this.bonoExtra = bonoExtra;
        this.estado = estado;
    }

    public String getCodigoViaje() {
        return codigoViaje;
    }

    public void setCodigoViaje(String codigoViaje) {
        this.codigoViaje = codigoViaje;
    }

    public double getDistRecorrida() {
        return distRecorrida;
    }

    public void setDistRecorrida(double distRecorrida) {
        this.distRecorrida = distRecorrida;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public EstadoViaje getEstado() {
        return estado;
    }

    public void setEstado(EstadoViaje estado) {
        this.estado = estado;
    }

    public boolean isLicenciaProfesional() {
        return licenciaProfesional;
    }

    public void setLicenciaProfesional(boolean licenciaProfesional) {
        this.licenciaProfesional = licenciaProfesional;
    }

    public boolean isInternacional() {
        return internacional;
    }

    public void setInternacional(boolean internacional) {
        this.internacional = internacional;
    }

    public boolean isCargaPesada() {
        return cargaPesada;
    }

    public void setCargaPesada(boolean cargaPesada) {
        this.cargaPesada = cargaPesada;
    }

    public boolean isNocturno() {
        return nocturno;
    }

    public void setNocturno(boolean nocturno) {
        this.nocturno = nocturno;
    }

    public int getCantViajes() {
        return cantViajes;
    }

    public void setCantViajes(int cantViajes) {
        this.cantViajes = cantViajes;
    }

    public void calComisionExtraPuntos() { // Calcula las comisiones y puntos extra según condiciones
        base = distRecorrida * 10; // El precio base es 10$ por kilómetro

        if (internacional) { // Si es internacional
            comisionInternacional = base * 0.1;
        } else if (nocturno) { // Si es nocturno
            comisionNocturno = base * 0.1;
            cantPuntos += 2; // Suma 2 puntos
        } else if (cargaPesada) { // Si tiene carga pesada
            comisionPesada = base * 0.2;
            cantPuntos += 3;
        } else if (distRecorrida > 200) { // Si recorrió más de 200 km
            comisionDist = base * 0.05;
            cantPuntos += 1;
        } else if (cantViajes > 5 || distRecorrida > 1000) { // Si hizo más de 5 viajes o recorrió más de 1000 km
            bonoExtra = 5000;
            cantPuntos += 5;
            obtuvoBonoExtra = true; // Se marca que obtuvo bono extra
        }

        comisionFinal = comisionInternacional + comisionNocturno + comisionPesada + comisionDist + bonoExtra; // Se suma todo
    }

    public void clasificarEstado(int opcionEstado) { // Permite asignar el estado del viaje usando un menú
        boolean valido = false; // Bandera para saber si la opción es válida
        while (!valido) { // Repite hasta que se elija una opción válida
            opcionEstado = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el estado. 1=Finalizado, 2=Cancelado, 3=En proceso"));
            switch (opcionEstado) {
                case 1:
                    estado = EstadoViaje.Completado;
                    valido = true; // Opción válida
                    break;
                case 2:
                    estado = EstadoViaje.Cancelado;
                    valido = true;
                    break;
                case 3:
                    estado = EstadoViaje.EnProceso;
                    valido = true;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opcion erronea,"); // Si no es una opción válida
            }
        }
    }

    @Override
    public String toString() { // Muestra toda la información del viaje
        return "Viaje:\n"
                + "Codigo del viaje= " + codigoViaje + "\n"
                + "Distancia Recorrida= " + distRecorrida + "\n"
                + "Mes= " + mes + "\n"
                + "estado= " + estado + "\n"
                + "Porta licencia profesional= " + licenciaProfesional + "\n"
                + "Cantidad de puntos= " + cantPuntos + "\n"
                + "Comision Final= " + comisionFinal + "\n"
                + "Obtuvo Bono Extra= " + obtuvoBonoExtra + "\n";
    }
}
