package StockPro.inventario.Servicio;
import java.util.List;

import StockPro.inventario.Modelo.Preforma;

public interface IServicioPreforma {
    //Metodo para listar todas las preformas
    public List<Preforma> listarPreforma();

    //Metodo para eliminr preforma por Id
    public void eliminarPreforma(Integer idPreforma);

    //Metodo para guardar un registro de preforma
    public Preforma guardarPreforma(Preforma preforma);

    //Metodo para buscar un tipo de preforma
    public Preforma buscarPreforma(Integer idPreforma);
    
}
