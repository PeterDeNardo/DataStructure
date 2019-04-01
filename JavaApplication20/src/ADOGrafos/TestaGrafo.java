/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ADOGrafos;

import java.io.IOException;

public class TestaGrafo {
   public static void main(String[] args) {
       readFile();
       
    }
   public static void readFile() {
       Grafo grafo = new Grafo(20);
       String[] textArray = null;
       try {
            textArray = FileConnector.reader("C:\\Users\\Fofolho\\Documents\\NetBeansProjects\\Jogos\\Sº3\\JavaApplication20\\src\\ADOGrafos\\utils\\In.txt"); 
       } catch(IOException e) {
            System.out.println("error: " + e);
       }
       
       for( String line : textArray ) {
            String[] a = line.split(" ");
            int v = Integer.parseInt(a[0]); 
            if ( a.length > 1) {
                // Liga as vertices
                grafo.insereA(v, Integer.parseInt(a[1]));
            } else {
//              // Identifica a esquina com o incendio
                grafo.setI(v);
            }
           
       }
       System.out.println(grafo.ExisteCaminho(1, 6));
   }
    
}