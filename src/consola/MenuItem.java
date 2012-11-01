/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package consola;

/**
 *
 * @author Gerson
 */
public class MenuItem {

    private MenuCallback funcion;
    private String texto;
    private boolean menu=false;

    public boolean isMenu() {
        return menu;
    }

    public MenuItem setMenu(boolean menu) {
        this.menu = menu;
        return this;
    }

   
    public MenuItem(String texto, MenuCallback funcion) {
        this.funcion = funcion;
        this.texto = texto;
    }

    
    public MenuCallback getMenuCallback() {
        return this.funcion;
    }

    public String getTexto() {
        return this.texto;
    }
    
}
