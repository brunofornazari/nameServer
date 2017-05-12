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

import Classes.Categoria;
import Classes.Despesa;
import Classes.Periodo;
import Classes.ServidorIndividual;
import Classes.Usuario;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import java.util.Scanner;

public class expenseServerImpl extends UnicastRemoteObject implements expServer {
    
    public expenseServerImpl() throws RemoteException {
        super();
    }
    
    @Override
    public String ctrlDespesa(Usuario user, int mes, int ano) throws RemoteException {
        Scanner scan = new Scanner(System.in);
        String entrada = "";
        List<Categoria> categorias = user.getCategorias();
        
        System.out.println("Digite o nome/descrição da despesa que você quer adicionar: ");
        
        while (entrada.compareTo("Sair") != 0) {
            System.out.println("\nAdicionar - Adiciona nova despesa");
            System.out.println("Remover - Remove despesa existente");
            System.out.println("Sair - Inativa o serviço");
            entrada = scan.next();
            switch(entrada) {
                case "Adicionar":
                    
                break;
                case "Remover":
                    
                break;
                case "Sair":
                break;
            }
        }
        return entrada;
    }
    
}
