/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Empleado;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author WILLIAM
 */
public class Empleado_Array {

    String linea;
    BufferedReader lector;
    String partes[] = null;
    String nom = "Empleado.txt";

    private ArrayList<Empleado> empleado_a = new ArrayList();

    /* Metodos main */
    public void inicializar() {
        try {
            lector = new BufferedReader(new FileReader(nom));
            while ((linea = lector.readLine()) != null) {
                partes = linea.split(",");
                Empleado empleado1 = new Empleado();
                empleado1.setNombre_apellidos(partes[0]);
                empleado1.setDni(partes[1]);
                empleado1.setSueldo(Double.parseDouble(partes[2]));
                empleado1.setDias_trabajados(Integer.parseInt(partes[3]));
                empleado1.setCargo(partes[4]);
                empleado1.setOficina(partes[5]);
                empleado1.setSueldo_total(Double.parseDouble(partes[6]));

                empleado_a.add(empleado1);
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void grabar_archivo(Empleado obj) {

        try {
            FileWriter f = new FileWriter(nom, true);
            BufferedWriter b = new BufferedWriter(f);
            PrintWriter pw = new PrintWriter(b);

            pw.print(obj.getNombre_apellidos()+","+obj.getDni()+","+obj.getSueldo()+","+obj.getDias_trabajados()
            +","+obj.getCargo()+","+obj.getOficina()+","+obj.getSueldo_total());
            pw.print("\n");
            pw.flush();
            pw.close();

        } catch (IOException e) {
            System.out.println("Ocurrio un error al grabar en el archivo!!!");
        }
    }

    
    /*public int Correlativo() {
        if (empleado_a.isEmpty()) {
            return 1;
        } else {
            return empleado_a.get(empleado_a.size() - 1).getId() + 1;
        }
    }*/
    
    public Empleado get(int pos) {
        return empleado_a.get(pos);
    }

    public int rows() {
        return empleado_a.size();
    }

    public void agregar(Empleado obj) {
        empleado_a.add(obj);
    }
    
    public int posicion(Empleado empleado) {
        for (int i = 0; i < rows(); i++) {
            if (empleado.getDni().equals(get(i).getDni())) {
                return i;
            }
        }
        return -1;
    }


    public void grabarModificareliminar() {
        try {
            FileWriter f = new FileWriter(nom, false);
            BufferedWriter b = new BufferedWriter(f);
            PrintWriter pw = new PrintWriter(b);
            for (Empleado obj : empleado_a) {
                pw.println(obj.getNombre_apellidos()+","+obj.getDni()+","+obj.getSueldo()+","+obj.getDias_trabajados()
            +","+obj.getCargo()+","+obj.getOficina()+","+obj.getSueldo_total());
            }

            pw.flush();
            pw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

