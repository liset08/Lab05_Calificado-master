package pe.edu.tecsup.lab05_calificado.repositories;

import java.util.ArrayList;
import java.util.List;

import pe.edu.tecsup.lab05_calificado.R;
import pe.edu.tecsup.lab05_calificado.models.producto;

/**
 * Created by Alumno on 5/04/2018.
 */

public class ProductoRepository {

 public static   List<producto> productlista=new ArrayList<>();

    static {

        productlista.add(new producto("KFC","Av. Javier Prado Este 5288, La Molina 15023", "(01)-8465697", "https://tse4.mm.bing.net/th?id=OIP.HN6IPC9J8U20k1T9Zo1YowHaHa&pid=15.1&P=0&w=300&h=300","Kentucky Fried Chicken, más conocido por sus siglas KFC, es una franquicia de restaurantes de comida rápida especializada en pollo frito." ,"kfc.com"));
        productlista.add(new producto("BEMBOS","Mall Aventura Santa Anita - Ate", "985184554","bemb" ,"Bembos es una empresa peruana de comida rápida, dedicada principalmente al mercado del consumo de hamburguesas. Sus colores tradicionales son el rojo, azul y amarillo. .","bembos.com.pe" ));
        productlista.add(new producto("PIZZA HUT","Raul Ferrero 15024, La Molina 15024", "(01)-8465697","pizzahut" ,"Pizza Hut es una cadena de restaurantes de comida rápida subsidiaria del grupo Yum! Brands. Es conocido por su menú italoamericano de cocina que incluye pizza y pasta," ,"pizzahut.com"));
        productlista.add(new producto("MC DONALDS","Av. Proceres de la Independencia 1698, San Juan de Lurigancho 15431", "(01)-8465697","mcdon" ,"McDonald's es una cadena de restaurantes de comida rápida. Sus principales productos son las hamburguesas, las papas fritas, los menús para el desayuno, los refrescos, los batidos, los helados." ,"mcdonalds.com"));
        productlista.add(new producto("BURGER KING","Mall Aventura Santa Anita - Ate", "(01)-8465697","burger","Burger King, también conocida como BK, es una cadena de establecimientos de comida rápida estadounidense con sede central en Miami, presente a nivel internacional y especializada principalmente en la elaboración de hamburguesas." ,"burgerking.com.pe" ));
        productlista.add(new producto("CHILI","Av. Nicolás Ayllón 3012, Ate 15023", "(01)-8465697","chil","Chili's Grill & Bar es una cadena de restaurantes de Comida Mexicana y Licores Fabricados Por Ellos. Cuenta con más de 1.600 sucursales, situadas la mayoría en los Estados Unidos." , "chilis.com"));
        productlista.add(new producto("STARTBUCKS","Mall Aventura Santa Anita - Ate", "(01)-8465697","star" ,"Starbucks Corporation es una cadena internacional de café fundada en Washington. Es la compañía de café más grande del mundo, con más de 24 000 locales en 70 países.","starbucks.com.pe" ));


    }
    public static List<producto> getList(){
        return productlista;
    }



}
