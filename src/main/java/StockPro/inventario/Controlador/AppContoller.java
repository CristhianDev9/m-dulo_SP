package StockPro.inventario.Controlador;

import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.mapping.List;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import StockPro.inventario.Excepcion.ExcepcionNotFound;
import StockPro.inventario.Modelo.Preforma;
import StockPro.inventario.Servicio.ServicioPreforma;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("bd_stockprotest")


public class AppContoller {
    @Autowired
    private ServicioPreforma servicioPreform;
    private static final Logger loger =
     LoggerFactory.getLogger(AppContoller.class);

     //Metodo para listar las preformas existentes
     @GetMapping("/preformas")
     public java.util.List<Preforma> listarPreforma(){
        java.util.List<Preforma> users = this.servicioPreform.listarPreforma();
        users.forEach((lam->loger.info(lam.toString())));
        return users; 
     }

     //Metodo para guardar un nuevo tipo de preforma
    @PostMapping("/guardar")
     public ResponseEntity<String> agregarNuevaPreforma(@RequestBody Preforma user){
      try{
            Preforma preformaNueva = servicioPreform.guardarPreforma(user);
           return ResponseEntity.status(HttpStatus.CREATED).body("Registro de preforma agregado correctamente");
      }catch(Exception ex){
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al agregar usuario");
     }
     
      
    }
    //Buscar por id
    @GetMapping("/buscar/{id}")
    public ResponseEntity<Preforma> buscarPrefPorId(@PathVariable int id) {
        Preforma prefNew = this.servicioPreform.buscarPreforma(id);
        if(prefNew!=null){
            return ResponseEntity.ok(prefNew);
        }
        else
        throw new ExcepcionNotFound("No encontrado",String.valueOf(id));
    }
     
   //actualizar un dato por id
   @PutMapping("/actualizar/{id}")
   public ResponseEntity <Preforma> actualizarPreforma(@PathVariable int id, @RequestBody Preforma preformaNew){
    try{
        Preforma prefNew = servicioPreform.buscarPreforma(id);
        prefNew.setGramaje(preformaNew.getGramaje());
        prefNew.setColor(preformaNew.getColor());
        prefNew.setCantidad(preformaNew.getCantidad());
        servicioPreform.guardarPreforma(prefNew);
        return ResponseEntity.ok(prefNew);
    }catch(ExcepcionNotFound ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
   }
      
    //Metodo para eliminar un dato
    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<Map<String, Boolean>> eliminarPreforma(@PathVariable int id){
        Preforma user = servicioPreform.buscarPreforma(id);
        this.servicioPreform.eliminarPreforma(user.getIdPreforma());
        Map<String,Boolean> mensajeRespuesta = new HashMap<>();
        mensajeRespuesta.put("Eliminado", Boolean.TRUE);
        return ResponseEntity.ok(mensajeRespuesta); 
    }
   }

    

