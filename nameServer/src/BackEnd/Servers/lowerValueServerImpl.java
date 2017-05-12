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

public class lowerValueServerImpl extends UnicastRemoteObject implements lvServer {
    
    public lowerValueServerImpl() throws RemoteException {
        super();
    }
    
    @Override
    public String MenorValor(Usuario user, int mes, int ano) throws RemoteException {
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
