/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author T-Gamer
 */
public class ServidorIndividual {
    private String _name;
    private String _address;
    
    public ServidorIndividual(String _name, String _address){
        this._name = _name;
        this._address = _address;
    }

    public String getName() {
        return _name;
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
    
    
}
