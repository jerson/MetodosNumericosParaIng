package programa;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import consola.Menu;
import consola.MenuCallback;
import funcion.*;
import metodos.*;
import java.io.*;

/**
 *
 * @author Gerson
 */
public class CalcularErrores {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {


        final double error = 0.0001;


        final Base base = new Base();


        Menu menu = new Menu();
        menu.setTitulo("Calculo de Errores");


        Menu submenu = new Menu();
        submenu.agregar("Xe:" + Math.PI + " Xa:" + 3.1416, new MenuCallback() {
            public void ejecutar() {

                double Xe = Math.PI;
                double Xa = 3.1416;
                System.out.println("Error Absoluto  :" + base.getErrorAbsoluto(Xe, Xa));
                System.out.println("Error Relativo  :" + base.getErrorRelativo(Xe, Xa));
                System.out.println("Error Relativo %:" + base.getErrorRelativoPorcentual(Xe, Xa));
            }
        });
        submenu.agregar("Xe:" + Math.sqrt(2) + " Xa:" + 1.4142, new MenuCallback() {
            public void ejecutar() {

                double Xe = Math.sqrt(2);
                double Xa = 1.4142;
                System.out.println("Error Absoluto  :" + base.getErrorAbsoluto(Xe, Xa));
                System.out.println("Error Relativo  :" + base.getErrorRelativo(Xe, Xa));
                System.out.println("Error Relativo %:" + base.getErrorRelativoPorcentual(Xe, Xa));
            }
        });
        submenu.agregar("Xe:" + Math.pow(10, Math.PI) + " Xa:" + 1400, new MenuCallback() {
            public void ejecutar() {


                double Xe = Math.pow(10, Math.PI);
                double Xa = 1400;
                System.out.println("Error Absoluto  :" + base.getErrorAbsoluto(Xe, Xa));
                System.out.println("Error Relativo  :" + base.getErrorRelativo(Xe, Xa));
                System.out.println("Error Relativo %:" + base.getErrorRelativoPorcentual(Xe, Xa));
            }
        });
        submenu.agregar("Xe:" + base.getFactorial(9) + " Xa:" + Math.sqrt((18 * Math.PI)) * Math.pow((9 / Math.E), 9), new MenuCallback() {
            public void ejecutar() {

                double Xe = base.getFactorial(9);
                double Xa = Math.sqrt((18 * Math.PI)) * Math.pow((9 / Math.E), 9);

                System.out.println("Error Absoluto  :" + base.getErrorAbsoluto(Xe, Xa));
                System.out.println("Error Relativo  :" + base.getErrorRelativo(Xe, Xa));
                System.out.println("Error Relativo %:" + base.getErrorRelativoPorcentual(Xe, Xa));
            }
        });


        menu.agregar("Calcule el Error Abosluto y el Error Relativo para los siguientes valores", submenu);


        Menu submenu2 = new Menu();
        submenu2.agregar("Xe:" + Math.PI + " Error:" + error, new MenuCallback() {
            public void ejecutar() {
                double Xe = Math.PI;
                System.out.println("X e + :" + base.redondear(Xe + error, 6) + " - :" + base.redondear(Xe - error, 6));
                System.out.println("X a + :" + base.redondear(Xe / (1 + error), 6) + " - :" + base.redondear(Xe / (1 - error), 6));

            }
        });
        submenu2.agregar("Xe:" + Math.E + " Error:" + error, new MenuCallback() {
            public void ejecutar() {
                double Xe = Math.E;
                System.out.println("X e + :" + base.redondear(Xe + error, 6) + " - :" + base.redondear(Xe - error, 6));
                System.out.println("X a + :" + base.redondear(Xe / (1 + error), 6) + " - :" + base.redondear(Xe / (1 - error), 6));

            }
        });

        submenu2.agregar("Xe:" + Math.sqrt(2) + " Error:" + error, new MenuCallback() {
            public void ejecutar() {
                double Xe = Math.sqrt(2);
                System.out.println("X e + :" + base.redondear(Xe + error, 6) + " - :" + base.redondear(Xe - error, 6));
                System.out.println("X a + :" + base.redondear(Xe / (1 + error), 6) + " - :" + base.redondear(Xe / (1 - error), 6));

            }
        });
        submenu2.agregar("Xe:" + Math.cbrt(7) + " Error:" + error, new MenuCallback() {
            public void ejecutar() {

                double Xe = Math.cbrt(7);
                System.out.println("X e + :" + base.redondear(Xe + error, 6) + " - :" + base.redondear(Xe - error, 6));
                System.out.println("X a + :" + base.redondear(Xe / (1 + error), 6) + " - :" + base.redondear(Xe / (1 - error), 6));

            }
        });

        menu.agregar("Hallar el intervalo mas grande en que debe hallarse Xa para que aproxime con Xe", submenu2);




        Menu submenu3 = new Menu();
        submenu3.agregar("PI^2:" + Math.pow(Math.PI, 2), new MenuCallback() {
            public void ejecutar() {

                double Xe = Math.pow(Math.PI, 2);
                double Xa = base.truncar(Xe, 3);
                System.out.println("  Xe:" + Xe + " Truncado:" + Xa);
                System.out.println("Error Absoluto  :" + base.getErrorAbsoluto(Xe, Xa));
                System.out.println("Error Relativo %:" + base.getErrorRelativoPorcentual(Xe, Xa));
                System.out.println("");

                Xa = base.redondear(Xe, 3);
                System.out.println("  Xe:" + Xe + "  Redondeado:" + Xa);
                System.out.println("Error Absoluto  :" + base.getErrorAbsoluto(Xe, Xa));
                System.out.println("Error Relativo %:" + base.getErrorRelativoPorcentual(Xe, Xa));

            }
        });
        submenu3.agregar("((1 / 3) - (3 / 11)) + (3 / 20):" + ((1.0 / 3.0) - (3.0 / 11.0)) + (3.0 / 20.0), new MenuCallback() {
            public void ejecutar() {

                double Xe = ((1.0 / 3.0) - (3.0 / 11.0)) + (3.0 / 20.0);

                double Xa = base.truncar(Xe, 3);
                System.out.println("  Xe:" + Xe + " Truncado:" + Xa);
                System.out.println("Error Absoluto  :" + base.getErrorAbsoluto(Xe, Xa));
                System.out.println("Error Relativo %:" + base.getErrorRelativoPorcentual(Xe, Xa));
                System.out.println("");

                Xa = base.redondear(Xe, 3);
                System.out.println("  Xe:" + Xe + " Redondeado:" + Xa);
                System.out.println("Error Absoluto  :" + base.getErrorAbsoluto(Xe, Xa));
                System.out.println("Error Relativo %:" + base.getErrorRelativoPorcentual(Xe, Xa));

            }
        });


        menu.agregar("Efectuar los calculos Siguientes", submenu3);

        menu.mostrar();

    }
}
