/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package consola;

import java.io.*;
import java.util.*;
import metodos.Base;

/**
 *
 * @author Gerson
 */
public class Menu extends Consola {

    ArrayList<MenuItem> lista = new ArrayList<>();
    private String titulo = "";

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Menu() {
        super();
    }

    public void agregar(String titulo, MenuCallback callback) {
        lista.add(new MenuItem(titulo, callback));
    }

    public void agregar(String titulo, final Menu menu) {
        final Menu padre = this;

        if (menu.getTitulo().equals("")) {
            menu.setTitulo(titulo);
        }



        menu.agregar("Regresar", new MenuCallback() {
            public void ejecutar() {
                padre.mostrar();
            }
        });
        lista.add(new MenuItem(titulo, new MenuCallback() {
            public void ejecutar() {

                menu.mostrar();
            }
        }).setMenu(true));
    }

    public void mostrar() {

        this.limpiarPantalla();
        int choosen = 0;
        Scanner in = new Scanner(this.in);
        Base base = new Base();


        if (!this.getTitulo().equals("")) {
            int ancho_titulo = this.titulo.length();
            ancho_titulo = ancho_titulo < 60 ? 60 : ancho_titulo;
            System.out.println(base.repetir("-", ancho_titulo  ));
            System.out.println("-" + base.redondear(this.titulo, ancho_titulo-2, true) + "-");
            System.out.println(base.repetir("-", ancho_titulo ));
        }
        int i = 0;
        for (i = 0; i < lista.size(); ++i) {
            MenuItem mi = lista.get(i);
            System.out.printf("[%d] %s \n", i + 1, mi.getTexto());
        }

        System.out.printf("[%d] %s \n", i + 1, "Salir");

        System.out.println();
        System.out.print("Selecciona una Opcion:");

        try {
            choosen = in.nextInt();
        } catch (Exception e1) {
        }




        if (choosen == lista.size() + 1) {

            System.out.println("");
            System.out.println(base.repetir("*", 60));
            System.out.println(base.redondear("Adios, que tengas buen dia...", 60, true));
            System.out.println(base.repetir("*", 60));


            System.exit(1);
        } else if (choosen > lista.size() || choosen < 1) {


            System.out.println("");
            System.out.println(base.repetir("*", 60));
            System.out.println(base.redondear("Opcion Invalida, Presione Enter Para ir al Menu...", 60, true));
            System.out.println(base.repetir("*", 60));
            in.nextLine();
            in.nextLine();
            this.mostrar();
        } else {

            MenuItem mi = lista.get(choosen - 1);
            MenuCallback mc = mi.getMenuCallback();

            this.limpiarPantalla();

            if (!mi.isMenu() && !mi.getTexto().equals("Regresar")) {

                System.out.println(base.repetir("-", 60));
                System.out.println(base.redondear(mi.getTexto(), 60, true));
                System.out.println(base.repetir("-", 60));

                System.out.println("");
            }
            mc.ejecutar();


            System.out.println("");

            System.out.println(base.repetir("*", 60));
            System.out.println(base.redondear("Presione ENTER para ir al menu...", 60, true));
            System.out.println(base.repetir("*", 60));

            in.nextLine();
            in.nextLine();
            this.mostrar();
        }
    }
}
