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

import Classes.Categoria;
import Classes.Despesa;
import Classes.Periodo;
import Classes.Usuario;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class lowerValueServer extends UnicastRemoteObject {
    
    public lowerValueServer() throws RemoteException {
        
    }
    
    public String menorValor(Usuario user, int mes, int ano) throws RemoteException {
        double menorValor = 0;
        String categoriaMenorValor = "";
        List<Categoria> categorias = user.getCategorias();
        for (Categoria categoria : categorias) {
            double total = 0;
            for (Periodo periodo : categoria.getPeriodos()) {
                if (periodo.getMes() == mes && periodo.getAno() == ano) {
                    for (Despesa despesa : periodo.getDespesas()) {
                        total += despesa.getValor();
                    }
                }
            }
            if (menorValor == 0) {
                menorValor = total;
                categoriaMenorValor = categoria.getTitulo();
            } else if (total < menorValor) {
                menorValor = total;
                categoriaMenorValor = categoria.getTitulo();
            }
        }
        return categoriaMenorValor;
    }
    
}
