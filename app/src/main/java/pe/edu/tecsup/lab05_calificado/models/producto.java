package pe.edu.tecsup.lab05_calificado.models;

/**
 * Created by Alumno on 5/04/2018.
 */

public class producto {










    public producto(String name, String adress, String phone, String picture, String descripcion) {
        this.name = name;
        this.adress = adress;
        this.phone = phone;
        this.picture = picture;
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "producto{" +
                "name='" + name + '\'' +
                ", adress='" + adress + '\'' +
                ", phone='" + phone + '\'' +
                ", picture='" + picture + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }

    private  String name;
    private String adress;
    private String phone;
    private String picture;
    private String descripcion;


    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }




}
