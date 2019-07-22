/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import decoradores.Carro;
import decoradores.ColorDecorador;
import decoradores.MotorDecorador;
import enumm.Motor;
import enumm.Pintura;
import marcas.Bmw;
import marcas.Toyota;

/**
 *
 * @author Estudiante
 */
public class Decorator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Creando carros");
        System.out.println();
        Carro carroT = new Toyota();
        Carro carroB = new Bmw();
       
        System.out.println("Carros simples carros");
        carroT.marca();
        carroB.marca();
        System.out.println();
       
        System.out.println("Creando carros con color");
        Carro carroC = new ColorDecorador(new Toyota(), Pintura.ROJO);
        carroC.marca();
        System.out.println();

        System.out.println("Creando carros con motor");
        Carro carroH = new MotorDecorador(new Bmw(), Motor.DIESEL);
        carroH.marca();
        System.out.println();
       
        System.out.println("Creando carros con motor y color");
       
        Toyota toyotaC = new Toyota();
        ColorDecorador colorC = new ColorDecorador(toyotaC,Pintura.AZUL);
        MotorDecorador motorC = new MotorDecorador(colorC,Motor.ELECTRICO);
        Carro carroK = motorC;
        carroK.marca();
        System.out.println();
       
    }
   
}


