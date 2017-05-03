/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackEnd.Servers;

import BackEnd.Servidor;
import BackEnd.ServidorImpl;
import Classes.ServidorIndividual;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

/**
 *
 * @author T-Gamer
 */
public class Teste {
    public static void main(String[] args) {
    	//try {
            //Criar o Servidor que vai rodar o individual como o principal
            //Chamar o servidor de nomes
            //Registrar
        	/*Servidor m = new ServidorImpl();
                LocateRegistry.createRegistry(1099);
                ServidorIndividual funcaoTeste = new ServidorIndividual("Teste", "rmi://localhost:1099/ServidorTeste");
        	
        	// crio uma instancia do obj e registro no Binder
            Naming.rebind(funcaoTeste.getAddress(), m);
            
            System.out.println("Server listening on port: 1099");
        } catch( Exception e ) {
        	System.out.println( "Trouble: " + e.getMessage() );
                System.exit(0);
        }*/
        
    }
}
