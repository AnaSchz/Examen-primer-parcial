/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen;

//importaciones necesarias

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Ana San
 */
public class Ventana extends JFrame{
    
    //declaramos variables de instancia: un JTextField donde se verán los datos y el resultado, 
    //los paneles que contendrán los botones,
    //dos numeros double que serán dato y resultado y un panel más para la ventana general.
    
    JTextField numeros;
    JPanel ventana, panelN, panelO, pantalla;
    double num, resultado;
    
    //creamos el constructor
    
    public Ventana(){
        
        //En el constructor creamos todos los componentes
    
        configurarVentana();
        configurarC();
    
    }
    
    //En este método damos características a nuestra ventana, como tamaño, título, etc.
    
    public void configurarVentana(){
        
        setSize(450,500);
        setTitle("Convertidor");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        ventana = new JPanel(new BorderLayout());
        ventana = (JPanel) this.getContentPane();
        
    }
    
    //En este método creamos todos los componentes y los añadimos a la ventana.
    
    public void configurarC(){
      
        pantalla = new JPanel();
        JLabel titulo = new JLabel("Convertidor");
        pantalla.add("North",titulo);
        numeros = new JTextField("0", 20);
        numeros.setEditable(false);
        pantalla.add("South", numeros);
        ventana.add("North",pantalla);
        
        //Aquí creamos el panel numérico y llamamos a un método que crea los botones numéricos.
        panelN = new JPanel();
        panelN.setLayout(new GridLayout(4,3));
        ventana.add("Center",panelN);
        for(int i=9; i>=0; i--){
            botonN(""+ i);
        }
        botonN(".");
        
        //Aquí creamos el panel de las opciones y llamamos al método que crea botones.
        panelO = new JPanel();
        panelO.setLayout(new GridLayout(2,1));
        ventana.add("East",panelO);
        botonO("Convertir");
        botonO("Limpiar");
    
    }
    
    //Este método crea los botones numéricos y les añade un MouseListener
    public void botonN(String numero){
        
        JButton boton = new JButton(numero);
        boton.addMouseListener (new MouseAdapter(){
            //método sobreescrito que evalúa el evento en el botón
            public void mouseReleased(MouseEvent event){
                JButton boton = (JButton) event.getSource();
                numeroP(boton.getText());
            }
        });
        panelN.add(boton);
    }
    
    //Este método evalúa el número pulsado y lo muestra en pantalla
    public void numeroP(String numero){
    
        if(numeros.getText().equals("0")){
            numeros.setText(numero);
        }
        else{
            numeros.setText(numeros.getText() + numero);
        }
        
    }
    
    //Este método crea los botones de opciones y les añade un MouseListener
    public void botonO(String opcion){
        
        JButton boton = new JButton(opcion);
        boton.addMouseListener (new MouseAdapter(){
            public void mouseReleased(MouseEvent event){
                JButton boton = (JButton) event.getSource();
                opcionP(boton.getText());
            }
        });
        panelO.add(boton);
    
    }
    
    //Este método evalúa la opción seleccionada y realiza la acción elegida
    public void opcionP(String opcion){
    
        
        //Aquí convertimos a dólares
        if(opcion.equals("Convertir")){
        
            num = Double.parseDouble(numeros.getText());
            resultado = num/17;
            numeros.setText(""+ resultado);
            
        }
        else
            //Aquí limpiamos la pantalla
            if(opcion.equals("Limpiar")){
                
                numeros.setText("0");
                
            }
        
    }
    
}
