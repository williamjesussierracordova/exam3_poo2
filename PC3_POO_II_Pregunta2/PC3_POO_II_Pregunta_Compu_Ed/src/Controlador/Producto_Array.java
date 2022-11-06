/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Producto;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.swing.JOptionPane;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;



public class Producto_Array {
    
    String linea;
    BufferedReader lector;
    String partes[] = null;
    String nom = "Productos.txt";
    
    private final ArrayList<Producto> producto_a = new ArrayList();
    
    /* Métodos main */
    public void productos_ini() {
       
        try {
            lector = new BufferedReader(new FileReader(nom));
            while ((linea = lector.readLine()) != null) {
                partes = linea.split(",");
                Producto prod1 = new Producto();
                prod1.setID(Integer.parseInt(partes[0]));
                prod1.setNombre(partes[1]);
                prod1.setCategoría(partes[2]);
                

                producto.add(prod1);
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private static class producto {

        private static void add(Producto prod1) {
            
        }

        public producto() {
        }
    }
    
    
    public void grabar_arch_product(Producto obj) {
        try {
            FileWriter fw = new FileWriter(nom, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            pw.println(
                    obj.getID()+ "," + obj.getNombre()+ "," + obj.getCategoría());
            pw.print("\n");
            pw.flush();
            pw.close();
            bw.close();
            fw.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    
    public int Correlativo() {
        if (producto_a.isEmpty()) {
            return 1;
        } else {
            return producto_a.get(producto_a.size() - 1).getID()+ 1;
        }
    }
    
    public int rows() {
        return producto_a.size();
    }
    
    public Producto get(int pos) {
        return producto_a.get(pos);
    }
    
}
