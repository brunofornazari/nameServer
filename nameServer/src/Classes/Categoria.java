package Classes;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author filipearaujo
 */
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
