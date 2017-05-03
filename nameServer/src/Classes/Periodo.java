package Classes;
import Classes.Despesa;
import java.util.ArrayList;
import java.util.List;

public class Periodo {

    private int _ano;
    private int _mes;
    private List<Despesa> _despesas = new ArrayList<Despesa>();

    public int getAno() {
        return _ano;
    }

    public void setAno(int Ano) {
        this._ano = Ano;
    }

    public int getMes() {
        return _mes;
    }

    public void setMes(int Mes) {
        this._mes = Mes;
    }

    public List<Despesa> getDespesas() {
        return _despesas;
    }

    public void setDespesas(List<Despesa> _despesas) {
        this._despesas = _despesas;
    }
    
    public void AddDespesa(Despesa despesa){
        _despesas.add(despesa);
    }
}
