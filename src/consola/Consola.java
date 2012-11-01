/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package consola;

import funcion.Funcion;
import java.awt.AWTException;
import java.awt.Robot;
import java.io.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gerson
 */
public class Consola {

    InputStream in;

    public Consola() {
        this.in = System.in;
    }

    public int getEntero() {
        return this.getEntero("");


    }

    public int getEntero(String mensaje) {
        return this.getEntero(mensaje, 0);
    }

    public int getEntero(String mensaje, int defecto) {


        mensaje = mensaje.equals("") ? mensaje : mensaje + " [" + defecto + "]";
        int numero = (int) this.getNumero(mensaje, defecto);


        return numero;
    }

    public double getNumero() {
        return this.getNumero("");
    }

    public boolean getBoolean(String mensaje) {
        boolean opcion;

        mensaje = mensaje.equals("") ? mensaje : mensaje + " [SI/NO]";
        String respuesta = this.getCadena(mensaje);

        if (respuesta.equalsIgnoreCase("SI")) {
            opcion = true;
        } else {
            opcion = false;
        }



        return opcion;
    }

    public double getNumero(String mensaje) {
        return this.getNumero(mensaje, 0);
    }

    public double getNumero(String mensaje, double defecto) {
        double numero;

        try {

            Funcion funcion = new Funcion(this.getCadena(mensaje), false);
            numero = funcion.evaluar(true);

        } catch (Exception ex) {


            if (defecto != 0) {
                return defecto;
            } else {
                System.out.println("**Error: Valor Incorrecto, Intente Nuevamente**");
                System.out.println("");
                return this.getNumero(mensaje,defecto);

            }
        }

        return numero;
    }

    public String getCadena() {
        return this.getCadena("");
    }

    public String getCadena(String mensaje) {
        String cadena = "";
        if (!"".equals(mensaje)) {
            System.out.print(mensaje + ": ");
        }


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            cadena = br.readLine();
        } catch (IOException ex) {

        }

       // Scanner in = new Scanner(this.in);
       // cadena = in.next();

        return cadena;
    }

    public double[][] getMatriz(int ancho) {
        return this.getMatriz(ancho, ancho);

    }

    public double[][] getMatriz(int ancho, int alto) {
        System.out.println("");

        double[][] matriz = new double[alto][ancho];

        for (int i = 0; i < alto; i++) {

            System.out.println("Ingresa datos para M[" + i + "]:");
            for (int j = 0; j < ancho; j++) {

                System.out.print("M[" + i + "][" + j + "]:");
                matriz[i][j] = this.getNumero();

            }


            System.out.println("");
        }

        return matriz;
    }
    public double[][] getCoordenadas(int cantidad) {
        System.out.println("");

        double[][] matriz = new double[2][cantidad];

        for (int i = 0; i < cantidad; i++) {

            System.out.println("Los Los Datos para I[" + i + "]:");
            for (int j = 0; j < 2; j++) {

                System.out.print("I[" + i + "][" + ((j==0) ? "X" : "Y") + "]:");
                matriz[j][i] = this.getNumero();

            }


            System.out.println("");
        }

        
        
        return matriz;
    }

    public void limpiarPantalla() {
        try {
            Robot robbie = new Robot();
             robbie.keyPress(17);
             robbie.keyPress(76);
             robbie.keyRelease(17);
             robbie.keyRelease(76);

             Thread.sleep(100);

            // esto es para jcreator
            robbie.keyPress(17);
            robbie.keyPress(16);
            robbie.keyPress(82);
            robbie.keyRelease(17);
            robbie.keyRelease(16);
            robbie.keyRelease(82);



            Thread.sleep(100);

        } catch (Exception ex) {

        }

    }
}
