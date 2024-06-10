/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package scoutspoo;

import controlador.CScoutPoo;

/**
 *
 * @author Fd
 */
public class ScoutsPoo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CScoutPoo ctrl = new CScoutPoo(); 
        ctrl.abrir();
        ctrl.run();
        ctrl.guardar();
        // TODO code application logic here
    }
    
}
