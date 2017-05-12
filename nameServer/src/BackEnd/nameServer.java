/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackEnd;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.util.Scanner;

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
            Scanner console = new Scanner(System.in);
            String entrada = "";
            
            Servidor _nameServer = new ServidorImpl();
            boolean isOnline = false;
            
            while(entrada.compareTo("Desligar") != 0){
                System.out.println("\nConectar - Conecta O Servidor de Nomes");
                System.out.println("Listar_Todos - Lista todos os serviços ativos");
                System.out.println("Desconectar_Servico - Desconecta um Serviço específico");
                System.out.println("Desconectar_Todos - Desconecta todos os serviços");
                System.out.println("Desligar - Desativa o servidor de nomes\n");
                
                entrada = console.next();
                
                switch(entrada){
                    case "Conectar":
                        if(isOnline == false){
                            try{
                                int port = 1099;
                               LocateRegistry.createRegistry(port);
                               Naming.rebind("rmi://localhost:" + Integer.toString(port) + "/Servidor", _nameServer);
                               isOnline = true;
                                System.out.println("Servido de nomes conectado com sucesso na porta " + Integer.toString(port));
                            } catch(Error e){
                                System.out.println("Não foi possível disponibilizar o servidor de nomes. Erro: " + e.getMessage());
                            }
                        } else {
                            System.out.println("Servidor de Nomes já está online!");
                        }
                    break;
                    case "Desconectar_Todos":
                        _nameServer.desconectarTodosOsServicos();
                        System.out.println("Todos os serviços foram desconectados.");
                    break;
                    case "Listar_Todos" : 
                        System.out.println(_nameServer.listarServicosAtivos());
                    break;
                    case "Desconectar_Servico":
                        System.out.println("Digite o nome da função:");
                        String servico = console.next();
                        
                        if(isOnline == true){
                            if(_nameServer.desconectarServico(servico)){
                                System.out.println("Serviço: " + servico + " desconectado com sucesso!");
                            } else {
                                System.out.println("Não foi possível executar: Nenhum serviço " + servico + " encontrado.");
                            }
                        } else {
                            System.out.println("Não foi possível executar: Servidor está offline");
                        }
                    break;
                    case "Desligar":
                        if(isOnline == true){
                            _nameServer.desconectarTodosOsServicos();
                            System.out.println("Todos os serviços foram desconectados.");
                        }
                        
                        System.out.println("Desativando Servidor");
                        System.exit(0);
                }
                
            }

            System.out.println("Server listening on port: 1099");
        } catch( Exception e ) {
            System.out.println( "Trouble: " + e.getMessage() );
            System.exit(0);
        }
        
    }
}
