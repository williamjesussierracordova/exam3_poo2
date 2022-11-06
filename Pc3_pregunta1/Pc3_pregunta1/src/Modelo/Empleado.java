/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author WILLIAM
 */
public class Empleado {
    String nombre_apellidos;
    String dni;
    double sueldo;
    int dias_trabajados;
    String cargo;
    String oficina;
    double sueldo_total;

    public Empleado() {
    }

    public Empleado(String nombre_apellidos, String dni, double sueldo, int dias_trabajados, String cargo, String oficina, double sueldo_total) {
        this.nombre_apellidos = nombre_apellidos;
        this.dni = dni;
        this.sueldo = sueldo;
        this.dias_trabajados = dias_trabajados;
        this.cargo = cargo;
        this.oficina = oficina;
        this.sueldo_total = sueldo_total;
    }
    
    

    public double getSueldo_total() {
        return sueldo_total;
    }

    public void setSueldo_total(double sueldo_total) {
        this.sueldo_total = sueldo_total;
    }

    

    public String getNombre_apellidos() {
        return nombre_apellidos;
    }

    public void setNombre_apellidos(String nombre_apellidos) {
        this.nombre_apellidos = nombre_apellidos;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public int getDias_trabajados() {
        return dias_trabajados;
    }

    public void setDias_trabajados(int dias_trabajados) {
        this.dias_trabajados = dias_trabajados;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getOficina() {
        return oficina;
    }

    public void setOficina(String oficina) {
        this.oficina = oficina;
    }
    
    
}
