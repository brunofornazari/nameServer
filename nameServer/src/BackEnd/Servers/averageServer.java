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

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import Classes.*;

public class averageServer extends UnicastRemoteObject {
    
    public averageServer() throws RemoteException {
        
    }
    
    public double calculaMedia(Usuario user, int mes, int ano) throws RemoteException {
        double total = 0;
        double media = 0;
        List<Categoria> categorias = user.getCategorias();
        for (Categoria categoria : categorias) {
            for (Periodo periodo : categoria.getPeriodos()) {
                if (periodo.getMes() == mes && periodo.getAno() == ano) {
                    for (Despesa despesa : periodo.getDespesas()) {
                        total += despesa.getValor();
                    }
                }
            }
        }
        media = total/categorias.size();
        return media;
    }
    
}
