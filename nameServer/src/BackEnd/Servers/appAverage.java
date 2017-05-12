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

public class appAverage {
    
    public static void main(String[] args) {
        try {
            Scanner console = new Scanner(System.in);
            String entrada = "";
            Servidor _server = null;
                    
            averageServerImpl avgServer = new averageServerImpl();
            
            try{
                _server = (Servidor) Naming.lookup("rmi://localhost:1099/Servidor");                                                 
            }catch(Error e){
                System.out.println("Não foi possível conectar ao servidor de nomes: " + e.getMessage());
                System.exit(0);
            }
            

            ServidorIndividual _servico = new ServidorIndividual("FazMedia", "rmi://localhost:1099/Average");
            
            while(entrada.compareTo("Desligar") != 0){
                System.out.println("\nConectar - Conecta ao Servidor de Nomes");
                System.out.println("Verificar - Verifica o Status de Conexão");
                System.out.println("Desconectar - Desconecta do Servidor de Nomes");
                System.out.println("Desligar - Inativa o serviço e desconecta o endereço da rede\n");
                entrada = console.next();
                switch(entrada){
                    case "Conectar":
                        Naming.rebind(_servico.getAddress(), avgServer);
                        _servico.setStatus(_server.conectarServico(_servico));
                        System.out.println(_servico.getStatusMessage());
                    break;
                    case "Desconectar":
                        if(_server.desconectarServico(_servico)){
                            System.out.println("Desconectado do NameServer");
                        }
                    break;
                    case "Verificar":
                        _servico.setStatus(_server.verificaStatus(_servico));
                        System.out.println(_servico.getStatusMessage());
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
