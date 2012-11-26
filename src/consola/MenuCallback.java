/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package consola;

import java.util.EventListener;

/**
 *
 * @author Gerson
 */
public interface MenuCallback extends EventListener {

    /**
     * funcion que ejecutara el menu
     */
    public void ejecutar();
}
