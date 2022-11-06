package Controlador;

import Modelo.Bunch;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Operaciones {

    String linea;
    BufferedReader lector;
    String partes[] = null;
    String nom = "Data.txt";

    private final ArrayList<Bunch> bunch_a = new ArrayList();

    public void init() {
        try {
            lector = new BufferedReader(new FileReader(nom));
            while ((linea = lector.readLine()) != null) {
                partes = linea.split(",");
                Bunch bunch1 = new Bunch();
                bunch1.setMensaje(partes[0]);

                bunch_a.add(bunch1);
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void grabar_archivo(Bunch obj) {
        try {
            FileWriter f = new FileWriter(nom, true);
            BufferedWriter b = new BufferedWriter(f);
            PrintWriter pw = new PrintWriter(b);

            pw.println(obj.getMensaje());
            pw.flush();
            pw.close();

        } catch (IOException e) {
            System.out.println("Ocurrio un error al grabar en el archivo!!!");
        }
    }

    public Bunch get(int pos) {
        return bunch_a.get(pos);
    }

    public int rows() {
        return bunch_a.size();
    }

    public void agregar(Bunch obj) {
        bunch_a.add(obj);
    }

    public int posicion(Bunch obj) {
        for (int i = 0; i < rows(); i++) {
            if (obj.getMensaje().equals(get(i).getMensaje())) {
                return i;
            }
        }
        return -1;
    }

    public void remove(Bunch obj) {
        bunch_a.remove(posicion(obj));
    }

    public void grabarModificareliminar() {
        try {
            FileWriter f = new FileWriter(nom, false);
            BufferedWriter b = new BufferedWriter(f);
            PrintWriter pw = new PrintWriter(b);
            for (Bunch obj : bunch_a) {
                pw.println(obj.getMensaje());
            }
            pw.flush();
            pw.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public Bunch busqueda_msj(String msj) {
        for (int i = 0; i < bunch_a.size(); i++) {
            if (bunch_a.get(i).getMensaje().equals(msj)) {
                return bunch_a.get(i);
            }
        }
        Bunch cliente1 = new Bunch();
        cliente1.setMensaje("error");
        return cliente1;
    }
}
