package StockPro.inventario.Modelo;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

//Utilizamos anotaciones 
@Entity
@ToString
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="preformas")

//creamos la clase para la entidad preforma
public class Preforma {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer IdPreforma;
    String gramaje;
    String color;
    Integer Cantidad;
}