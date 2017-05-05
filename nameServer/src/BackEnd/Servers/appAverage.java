/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackEnd.Servers;

/**
 *
 * @author Engenharia de Computação - 9º Semestre
 * André Apollo
 * Bruno Fornazari
 * Felipe Arias
 * Filipe Nathan
 * Thales Correa
 * 
 */

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class appAverage {
    
    public static void main(String[] args) {
        try {
            functionServer avgServer = new averageServer();
            LocateRegistry.createRegistry(1100);
            Naming.rebind("rmi://localhost:1100/Average", avgServer);
            //Naming.lookup();  não instanciado
        } catch (Exception e) {
            System.out.println("Trouble: " + e.getMessage());
            System.exit(0);
        }
    }
}
