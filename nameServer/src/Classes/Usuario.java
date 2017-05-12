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

import Classes.Categoria;
import java.util.ArrayList;
import java.util.List;

public class Usuario {

    private String _nome;
    private String _CPF;
    private String _endereco;
    private String _senha;
    private int _id;
    private List<Categoria> _categorias = new ArrayList<Categoria>();

    public String getNome() {
        return _nome;
    }

    public void setNome(String _nome) {
        this._nome = _nome;
    }

    public String getCPF() {
        return _CPF;
    }

    public void setCPF(String _CPF) {
        this._CPF = _CPF;
    }

    public String getEndereco() {
        return _endereco;
    }

    public void setEndereco(String _endereco) {
        this._endereco = _endereco;
    }

    public String getSenha() {
        return _senha;
    }

    public void setSenha(String _senha) {
        this._senha = _senha;
    }

    public int getId() {
        return _id;
    }

    public void setId(int _id) {
        this._id = _id;
    }

    public List<Categoria> getCategorias() {
        return _categorias;
    }

    public void setCategorias(List<Categoria> _categorias) {
        this._categorias = _categorias;
    }
    
    public void AddCategoria(Categoria categoria){
        _categorias.add(categoria);
    }
    
    public Categoria getCategoria(int id){
        for(Categoria categoria : _categorias){
            if(categoria.getID() == id){
                return categoria;
            }
        }
        return null;
    }
    
    public Categoria getCategoria(String titulo){
        for(Categoria categoria : _categorias){
            if(categoria.getTitulo().compareTo(titulo) == 0){
                return categoria;
            }
        }
        return null;
    }
}
