/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.io.Serializable;

/**
 *
 * @author T-Gamer
 */
public class ServidorIndividual implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private String _name = null;
    private String _address = null;
    private int _status = -1;

    public int getStatus() {
        return _status;
    }

    public void setStatus(int _status) {
        this._status = _status;
    }
    
    public ServidorIndividual(String _name, String _address){
        this._name = _name;
        this._address = _address;
    }

    public String getName() {
        if(_name != null){
            return _name;
        } else {
            return null;
        }
    }

    public void setName(String _name) {
        this._name = _name;
    }

    public String getAddress() {
        return _address;
    }

    public void setAddress(String _address) {
        this._address = _address;
    }
    
    public String getStatusMessage(){
        String _tempMessage = "";
        switch(this._status){
            case 0 :
                _tempMessage = "Erro ao conectar: Um serviço com esse nome já foi conectado!";
                break;
            case 1 :
                _tempMessage = "Erro ao conectar: Esse serviço já está conectado!";
                break;
            case 2 : 
                _tempMessage = "Conectado ao servidor de nomes com sucesso!";
                break;
            case 3 :
                _tempMessage = "Serviço não está conectado no momento.";
                break;
            case 4 : 
                _tempMessage = "O Serviço está conectado.";
                break;
            default : 
                _tempMessage = "Não foi possível definir o estado de conexão, contate o administrador do sistema";
        }
        
        return _tempMessage;
    }
    
}
