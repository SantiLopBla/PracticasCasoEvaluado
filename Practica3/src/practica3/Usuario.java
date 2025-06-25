/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica3; // Paquete del proyecto

import javax.swing.JOptionPane; // Librería para ventanas emergentes

public class Usuario {

    private String nombre; // Nombre del usuario
    private String cedula; // Cédula del usuario
    private String mail; // Correo del usuario
    private int seleccionUserCategoria = 0; // Opción numérica de categoría
    private Categoria categoria; // Enum de categoría

    public Usuario() {
    } // Constructor vacío

    public Usuario(String nombre, String cedula, String mail, Categoria categoria) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.mail = mail;
        this.categoria = categoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getMail() {
        return mail.substring(0, 3) + "...." + mail.substring(mail.indexOf("@"));
    } // Retorna solo las 3 primeras letras y el dominio

    public void setMail(String mail) {
        if (!mail.contains("@")) { // Valida si contiene @
            mail = "";
            JOptionPane.showMessageDialog(null, "Este correo no es valido" + mail);
        }
        this.mail = mail; // Guarda el correo (válido o vacío)
    }

    public int getSeleccionUserCategoria() {
        return seleccionUserCategoria;
    }

    public void setSeleccionUserCategoria(int seleccionUserCategoria) {
        this.seleccionUserCategoria = seleccionUserCategoria;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public void seleccionCategoria() { // Pide categoría y la asigna según número
        seleccionUserCategoria = Integer.parseInt(JOptionPane.showInputDialog("Ingrese su categoria. 1=Administrador. 2=Supervisor. 3=Colaborador"));
        if (seleccionUserCategoria == 1) {
            categoria = Categoria.Administrador;
        } else if (seleccionUserCategoria == 2) {
            categoria = Categoria.Supervisor;
        } else if (seleccionUserCategoria == 3) {
            categoria = Categoria.Colaborador;
        }
    }

    @Override
    public String toString() {
        return "Usuario \n"
                + "Nombre=" + nombre + "\n"
                + "Cedula=" + cedula + "\n"
                + "Correo electronico=" + getMail() + "\n" //LLAMAR getMail() PORQUE SI SE LLAMA mail MUESTRA EL CORREO SIN ESCONDER NADA
                + "Categoria de usuario= " + seleccionUserCategoria + "\n";
    }
}
