/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackEnd.SeveralServers;

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

public class appHigherValue {
    
    public static void main(String[] args) {
        try{
            functionServer hvServer = new higherValueServer();
            LocateRegistry.createRegistry(1100);
            Naming.rebind("rmi://localhost:1100/HigherValue", hvServer);
            //Naming.lookup();  não instanciado
        } catch (Exception e) {
            System.out.println("Trouble: " + e.getMessage());
            System.exit(0);
        }
    }
}
