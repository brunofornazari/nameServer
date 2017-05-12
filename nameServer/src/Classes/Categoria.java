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

package Classes;

import java.util.List;
import java.util.ArrayList;

public class Categoria {

    private String _titulo;
    private int _id;
    private List<Periodo> _periodos = new ArrayList<Periodo>();        

    public String getTitulo() {
        return _titulo;
    }

    public void setTitulo(String Titulo) {
        this._titulo = Titulo;
    }

    public int getID() {
        return _id;
    }

    public void setID(int ID) {
        this._id = ID;
    }

    public List<Periodo> getPeriodos() {
        return _periodos;
    }

    public void setPeriodos(List<Periodo> periodos) {
        this._periodos = periodos;
    }
    
    public void addPeriodo(Periodo novoPeriodo) {
        _periodos.add(novoPeriodo);
    }
}
