/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackEnd;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

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
public class nameServer {
    public static void main(String[] args) {
    	try {
        	Servidor m = new ServidorImpl();
                LocateRegistry.createRegistry(1099);
        	
        	// crio uma instancia do obj e registro no Binder
            Naming.rebind("rmi://localhost:1099/Servidor", m);
            
            System.out.println("Server listening on port: 1099");
        } catch( Exception e ) {
        	System.out.println( "Trouble: " + e.getMessage() );
                System.exit(0);
        }
        
    }
}
