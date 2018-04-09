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

        productlista.add(new producto("KFC","Miralflores", "(01)-8465697", "https://tse4.mm.bing.net/th?id=OIP.HN6IPC9J8U20k1T9Zo1YowHaHa&pid=15.1&P=0&w=300&h=300","Venta de Pollo frito." ,"kfc.com"));
        productlista.add(new producto("BEMBOS","Magdalena", "985184554","bemb" ,"Venta de hamburguesas y comidas.","bembos.com.pe" ));
        productlista.add(new producto("PIZZA HUT","San Isidro", "(01)-8465697","pizzahut" ,"Venta de pizza familiar,pequeña o mediana." ,"pizzahut.com"));
        productlista.add(new producto("MC DONALDS","Ate", "(01)-8465697","mcdon" ,"Venta de hamburguesas y comidas." ,"mcdonalds.com"));
        productlista.add(new producto("BURGER KING","Comas", "(01)-8465697","burger","Venta de hamburguesas y comidas." ,"burgerking.com.pe" ));
        productlista.add(new producto("CHILI","Surco", "(01)-8465697","chil","Venta de bebidas y comidas." , "chilis.com"));
        productlista.add(new producto("STARTBUCKS","San Borja", "(01)-8465697","star" ,"Venta de cafes, milkshake u otras bebidas heladas y calientes.","starbucks.com.pe" ));


    }
    public static List<producto> getList(){
        return productlista;
    }



}
