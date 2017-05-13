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
        String despesaDesc = "";
        double despesaVal = 0;
        Despesa despesa = new Despesa();
        List<Categoria> categorias = user.getCategorias();
        
        System.out.println("Digite o nome/descrição da despesa que você quer adicionar: ");
        
        while (entrada.compareTo("Sair") != 0) {
            System.out.println("\nAdicionar - Adiciona nova despesa");
            System.out.println("Remover - Remove despesa existente");
            System.out.println("Sair - Inativa o serviço");
            entrada = scan.next();
            switch(entrada) {
                case "Adicionar":
                    System.out.println("Digite o nome/descrição da despesa que você quer adicionar");
                    despesaDesc = scan.next();
                    System.out.println("Digite o valor da despesa que você quer adicionar");
                    despesaVal = scan.nextDouble();
                    for (Categoria categoria : categorias) {
                        for (Periodo periodo : categoria.getPeriodos()) {
                            if (periodo.getMes() == mes && periodo.getAno() == ano) {
                                for (Despesa despesas : periodo.getDespesas()) {
                                    if (despesas.getDescricao() == despesaDesc 
                                            && despesas.getValor() == despesaVal) {
                                        System.out.println("A despesa já existe");
                                    }
                                }
                                //Adicionar a despesa
                            }
                        }
                    }
                break;
                case "Remover":
                    System.out.println("Digite o nome/descrição da despesa que você quer remover");
                    despesaDesc = scan.next();
                    for (Categoria categoria : categorias) {
                        for (Periodo periodo : categoria.getPeriodos()) {
                            if (periodo.getMes() == mes && periodo.getAno() == ano) {
                                for (Despesa despesas : periodo.getDespesas()) {
                                    if (despesas.getDescricao() == despesaDesc) {
                                        
                                    }
                                }
                            }
                            System.out.println("A despesa não existe");
                        }
                    }
                break;
                case "Sair":
                break;
            }
        }
        return "Operação finalizada";
    }
    
}
