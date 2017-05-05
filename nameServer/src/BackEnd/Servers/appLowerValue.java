/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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

package BackEnd.Servers;

import BackEnd.Servidor;
import Classes.ServidorIndividual;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.util.Scanner;

public class appLowerValue {
    
    public static void main(String[] args) {
        try {
            Scanner console = new Scanner(System.in);
            String entrada = "";
            
            lowerValueServer lvServer = new lowerValueServer();
            LocateRegistry.createRegistry(1100);
            Naming.rebind("rmi://localhost:1100/LowerValue", lvServer);
            
            Servidor _server = (Servidor) Naming.lookup("rmi://localhost:1099/Servidor");
            
            ServidorIndividual _servico = new ServidorIndividual("Teste", "rmi://localhost:1100/LowerValue");
            
            while(entrada.compareTo("Desligar") != 0){
                entrada = console.next();
                switch(entrada){
                    case "Conectar":
                        System.out.println(_server.conectarServico(_servico).getStatusMessage());
                    break;
                    case "Desconectar":
                        if(_server.desconectarServico(_servico)){
                            System.out.println("Desconectado do NameServer");
                        }
                    break;
                    case "Desligar":
                        if (_servico.getStatus() == 2) {
                            _server.desconectarServico(_servico);
                        }
                        System.exit(0);
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("Trouble: " + e.getMessage());
            System.exit(0);
        }
    }
}