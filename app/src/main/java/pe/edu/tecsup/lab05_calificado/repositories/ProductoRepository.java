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

        productlista.add(new producto("KFC","mIRAFLORES", "8465697", "kfc","Pollo frito" ));
        productlista.add(new producto("BEMBOS","mIRAFLORES", "8465697","bemb" ,"Pollo frito" ));
        productlista.add(new producto("PIZZA HUT","mIRAFLORES", "8465697","pizzahut" ,"Pollo frito" ));
        productlista.add(new producto("MC DONALDS","mIRAFLORES", "8465697","mcdon" ,"Pollo frito" ));
        productlista.add(new producto("BURGER KING","mIRAFLORES", "8465697","burger","Pollo frito"  ));
        productlista.add(new producto("CHILI","mIRAFLORES", "8465697","chil","Pollo frito"  ));
        productlista.add(new producto("STARTBUCKS","SAN ISIDRO", "8465697","star" ,"Pollo frito" ));


    }
    public static List<producto> getList(){
        return productlista;
    }

}
