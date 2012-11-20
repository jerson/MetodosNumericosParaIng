/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metodos;

import funcion.*;
import java.math.*;
import org.apache.commons.math3.fraction.*;

/**
 *
 * @author Gerson
 */
public class Base {

    public Funcion funcion;
    public boolean fraccion = false;
    public int decimales = 4;
    public int espaciado = 12;

    public void usarFracciones(boolean fraccion) {
        this.fraccion = fraccion;
    }

    protected double getInterpolacion(double xa, double xb) {

        double interpolacion = 0;
        double fxa = funcion.evaluar(xa);
        double fxb = funcion.evaluar(xb);

        interpolacion = xb - ((xb - xa) * fxb) / (fxb - fxa);
        return interpolacion;
    }

    public double[][] clonar(double[][] matriz) {
        double[][] temporal = new double[matriz.length][matriz[0].length];

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                temporal[i][j] = matriz[i][j];
            }
        }
        return temporal;
    }

    public double[] clonar(double[] x) {
        double[] tmp = new double[x.length];

        for (int i = 0; i < x.length; i++) {
            tmp[i] = x[i];
        }

        return tmp;
    }

    public String redondear(double numero, int ancho, boolean centrado) {
        return this.redondear(numero, this.decimales, ancho, centrado);
    }

    public String redondear(double numero, boolean centrado) {
        return this.redondear(numero, this.decimales, this.espaciado, centrado);
    }

    public String redondear(double numero) {
        return this.redondear(numero, this.decimales, this.espaciado);
    }

    public double redondear(double numero, int decimales) {
        return Double.parseDouble(this.redondear(numero, decimales, 0));
    }

    public String redondear(double numero, int decimales, int ancho) {
        return this.redondear(numero, decimales, ancho, false);
    }

    public String redondear(double numero, int decimales, int ancho, boolean centrado) {

        String cadena = "";
        try {
            if (this.fraccion) {
                Fraction fraccion = new Fraction(numero);
                cadena = fraccion.toString();
            } else {

                BigDecimal bd = new BigDecimal(numero);
                bd = bd.setScale(decimales, BigDecimal.ROUND_HALF_UP);
                double resultado = bd.doubleValue();
                cadena = resultado + "";




            }
        } catch (Exception e) {
            cadena = "0";
        }


        return this.redondearString(cadena, ancho, centrado);
    }

    public double truncar(double decimal, int numeroDecimales) {
        decimal = decimal * (Math.pow(10, numeroDecimales));
        decimal = java.lang.Math.floor(decimal);
        decimal = decimal / Math.pow(10, numeroDecimales);

        return decimal;
    }

    public String redondearString(String cadena, int ancho, boolean centrado) {

        String str = "";
        String str2 = "";
        if (cadena.length() < ancho) {

            if (centrado) {
                int repetir = ancho - cadena.length();

                int mitad = Integer.parseInt(repetir / 2 + "");
                str = this.repetir(" ", mitad);
                str2 = this.repetir(" ", repetir - mitad);
                cadena = str2 + cadena + str;
            } else {

                int repetir = ancho - cadena.length();
                str = this.repetir(" ", repetir);
                cadena = cadena + str;
            }

        }

        return cadena;
    }

    public String redondear(String cadena) {
        return this.redondearString(cadena, this.espaciado, false);
    }

    public String redondear(String cadena, boolean centrado) {
        return this.redondearString(cadena, this.espaciado, centrado);
    }

    public String redondear(String cadena, int ancho) {
        return this.redondearString(cadena, ancho, false);
    }

    public String redondear(String cadena, int ancho, boolean centrado) {
        return this.redondearString(cadena, ancho, centrado);
    }

    /* temporal */
    public String redondearString(String cadena) {
        return this.redondearString(cadena, this.espaciado, false);
    }

    public String redondearString(String cadena, boolean centrado) {
        return this.redondearString(cadena, this.espaciado, centrado);
    }

    public String redondearString(String cadena, int ancho) {
        return this.redondearString(cadena, ancho, false);
    }
    /**/

    public String repetir(String str, int times) {
        String repetir = "";
        for (int i = 0; i < times; i++) {
            repetir = repetir + str;
        }
        return repetir;
    }

    public double getErrorAproximado(double actual, double previo) {

        //  System.out.println("(("+actual+"-"+previo+")/"+actual+")");
        double resultado = (actual - previo);

        return Math.abs(resultado);

    }

    public double getErrorAproximadoPorcentual(double actual, double previo) {

        //  System.out.println("(("+actual+"-"+previo+")/"+actual+")");
        double resultado = ((actual - previo) / actual);

        return Math.abs(resultado);

    }

    public double getErrorRelativoAproximado(double actual, double previo) {
        double error = this.getErrorAproximado(actual, previo);
        //  System.out.println("(("+actual+"-"+previo+")/"+actual+")");
        double resultado = (error / actual) * 100;

        return Math.abs(resultado);

    }

    public double derivar(double x) {
        return this.derivar(x, 0.001);
    }

    public double derivar(double x, double h) {
        double resultado = 0;

        resultado = (funcion.evaluar(x + h) - funcion.evaluar(x)) / h;
        //	System.out.println("derivando x:"+ x +"r:"+resultado);
        return resultado;
    }

    public double getErrorAbsoluto(double Xe, double Xa) {

        double resultado = (Xe - Xa);
        return Math.abs(resultado);
    }

    public double getErrorRelativo(double Xe, double Xa) {


        return Math.abs(this.getErrorAbsoluto(Xe, Xa) / Xe);
    }

    public double getErrorRelativoPorcentual(double Xe, double Xa) {


        return Math.abs((this.getErrorRelativo(Xe, Xa) * 100));
    }

    public double getFactorial(double num) {

        int i;
        double r = 1;
        for (i = 1; i <= num; i++) {
            r = r * i;
        }
        return r;
    }

    public void consola() {
        System.out.println("No se Implemento la consola para este metodo");
    }

    public int getEspaciado(double[][] matriz) {
        int tamano = 0;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                int redondeado = (this.redondear(matriz[i][j])).length();
                tamano = redondeado > tamano ? redondeado : tamano;
            }
        }

        return tamano + 2;
    }

    public void reportarmatriz(double[][] matriz) {
        int ancho= this.getEspaciado(matriz);
        this.reportarmatriz(matriz, ancho);
    }

    public void reportarmatriz(double[][] matriz, int ancho) {

        System.out.println("");
        System.out.print(this.redondear("", 3 + 1));

        for (int i = 0; i < matriz[0].length; i++) {
            if ((matriz[0].length - 1) == i) {
                System.out.print(this.redondear(i + "", ancho + 1, true));
            } else {

                System.out.print(this.redondear(i + "", ancho, true));
            }
        }

        System.out.print("\n");

        for (int i = 0; i < matriz.length; i++) {

            System.out.print(this.redondear(i + "", 3, true));
            this.reportarFilamatriz(matriz[i], ancho);

        }

        System.out.println("");
    }

    public void reportarFilamatriz(double[] fila) {
        this.reportarFilamatriz(fila, 5);
    }

    public void reportarFilamatriz(double[] fila, int ancho) {

        System.out.print("[");

        for (int i = 0; i < fila.length; i++) {
            double numero = fila[i];

            if ((fila.length - 1) == i) {

                System.out.print("|" + this.redondear(numero, ancho, true));

            } else {
                System.out.print(this.redondear(numero, ancho, true));
            }

        }

        System.out.print("]");
        System.out.print("\n");

    }

    public void reportarcoordenadas(double[] x, double[] y) {

        int n = x.length;
        double[][] coordenadas = new double[2][n];

        for (int j = 0; j < n; j++) {


            coordenadas[0][j] = x[j];
            coordenadas[1][j] = y[j];

        }

        int ancho = this.getEspaciado(coordenadas);

        System.out.println("");


        System.out.print("\n");

        for (int i = 0; i < coordenadas.length; i++) {

            if (i == 0) {
                System.out.print(this.redondear("X", 5, true));
            } else {
                System.out.print(this.redondear("f(x)", 5, true));
            }

            this.reportarFilacoordenadas(coordenadas[i], ancho);

        }

        System.out.println("");



    }

    public void reportarFilacoordenadas(double[] fila, int ancho) {

        System.out.print("[");
        int n = fila.length;
        for (int i = 0; i < n; i++) {
            double numero = fila[i];

            if (i != 0) {

                System.out.print("|" + this.redondear(numero, ancho, true));

            } else {
                System.out.print(this.redondear(numero, ancho, true));

            }

        }

        System.out.print("]");
        System.out.print("\n");

    }
    
    public double[] inicializar(double[] n) {
        return this.inicializar(n, 0);
    }

    public double[] inicializar(double[] n, double defecto) {

        for (int i = 0; i < n.length; i++) {
            n[i] = defecto;
        }
        return n;
    }

}
