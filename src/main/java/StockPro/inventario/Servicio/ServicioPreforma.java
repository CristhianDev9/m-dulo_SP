package StockPro.inventario.Servicio;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import StockPro.inventario.Modelo.Preforma;
import StockPro.inventario.Repositorio.IPreformaRepo;

@Service
public class ServicioPreforma implements IServicioPreforma{

    @Autowired
    private IPreformaRepo repositorioPreforma;
    
    //listar todas las preformas
    @Override
    public List<Preforma> listarPreforma() {
        // Implementación del método
        return this.repositorioPreforma.findAll();
    }

    //Eliminar preforma por id
    @Override
    public void eliminarPreforma(Integer idPreforma) {
        // Implementación del método
        this.repositorioPreforma.deleteById(idPreforma);
    }

    //Guaradar Preforma
    @Override
      public Preforma guardarPreforma(Preforma preforma) {
    // Implementación del método
         return this.repositorioPreforma.save(preforma);
            }
    

    @Override
    public Preforma buscarPreforma(Integer idPreforma) {
        // Implementación del método
        Preforma user =this.repositorioPreforma.findById(idPreforma).orElse(null);
        return user;
    }
}
    
    

