/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flyweightpattern;
import java.util.*;



/**
 *
 * @author Estudiante
 */
public class FlyWeightPattern {
   
    static String marca[] = {"Chevrolet", "Volkswagen", "Ferrari", "Skoda"};
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       
        for(int i = 0; i < 15; i++) {
            Carro carro1 = (Carro)CarroFactory.getCarro(getRandomMarca());
            carro1.setAnio(123);
            carro1.setColor("amarillo");
            carro1.descripcion();
        }
       
       
    }
   
    static String getRandomMarca(){
        return marca[(int)Math.random()*marca.length];
    }
   
   
    static int getRandomAnio(){
        return (int)Math.random()*100;
    }
   
   
   
   
}

interface Vehiculo {
    void descripcion();
}
class Carro implements Vehiculo{
   
    String color;
    String marca;
    int anio;
   
    Carro(String marca) {
        this.marca = marca;
    }
   
    void setColor(String color) {
        this.color = color;
    }

    void setAnio(int anio) {
        this.anio = anio;
    }
   
   
    public void descripcion() {
        System.out.println("Carro, Color: " + color + ", Marca: " + marca + ", Año: " + anio);
    }
}

class CarroFactory {
   
    private static final HashMap carroMap = new HashMap();
   
    public static Vehiculo getCarro(String marca) {
       
        Carro carro = (Carro)carroMap.get(marca);
       
        if(carro == null) {
           
            carro = new Carro(marca);
            carroMap.put(marca, carro);
            System.out.println("Se creo un carro de marca: " + marca);
        }
       
        return carro;
    }
}


