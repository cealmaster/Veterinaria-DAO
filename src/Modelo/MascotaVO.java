package Modelo;

public class MascotaVO {
    private int id;
    private String nombre;
    private int edad;
    private String raza;
    private int idraza;

    public MascotaVO() {  }
    public MascotaVO(int id, String nombre, int edad, String raza, int idraza) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.raza=raza;
        this.idraza=idraza;
        
    }

    public int getIdraza() {
        return idraza;
    }

    public void setIdraza(int idraza) {
        this.idraza = idraza;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }   
}