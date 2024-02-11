package StockPro.inventario.Excepcion;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)

public class ExcepcionNotFound extends RuntimeException {
    //serial Version UID
    private static final Long serialVersionUID=1L;
    //Campor para proporcionar mas información del recurso no encontrado
    private final String resourceType;
    private final String resourceId;
    //Constructor con todos los parametros
    public ExcepcionNotFound(String resourceType,String resourceId){
        super(String.format("Resource %s with id %s not found",resourceType,resourceId));
        this.resourceId=resourceId;
        this.resourceType=resourceType;
    }
    //getter para acceder a mas información
    public String getResourceType() {
        return resourceType;
    }
    public String getResourceId() {
        return resourceId;
    }
}
