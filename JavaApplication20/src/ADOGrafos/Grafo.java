/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ADOGrafos;

import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

public class Grafo {
    private int V; // número de vértices
    private int A; // número de arestas
    private int adj[][]; // matriz de adjcência
    private int I; // vertice da esquina com incendio 

    static private StringBuilder erroMansager = new StringBuilder();
    static private StringBuilder returnMensager = new StringBuilder();
    
    public int getI() {
        return I;
    }

    public void setI(int I) {
        this.I = I;
    }

    // inicializa os atributos da classe e cria a 
    // matriz de adjacência para V vértices
    public Grafo( int V ){
        this.V = V;
        this.A = 0; // nao tenho nenhuma aresta
        // criar a matriz de adjacencia
        adj = new int[V][V];
    }
    /*
    Método insere uma aresta v-w no grafo. O método supõe 
    que v e w são distintos, positivos e menores que V. 
    Se o grafo já tem aresta v-w, o método não faz nada, 
    após a inserção da aresta, o atributo A da classe é 
    atualizado.
    */
    
    public void insereA( int v, int w){
        if(this.adj[v][w] == 0 ){
            if (v == w) {
                erroMansager.append("Par "+v+" "+w+" X deve ser diferente de Y \n");
                return;
            }
            if (ExisteCaminho(w, v)){
                erroMansager.append("Par "+v+" "+w+" forma ciclo \n");
                erroMansager.append("Par "+v+" "+w+" forma ciclo \n");
                return;
            }
            this.adj[v][w]=1;
            this.A++;
            System.out.println("o: " + v + w);
        } else {
            erroMansager.append("Par "+v+" "+w+" já inserido \n");
        }
    }
    /*
    Para cada vértice v do grafo, este método imprime, 
    em uma linha, todos os vértices adjacentes a v. 
    */
    public void mostra( ){
        for( int v=0; v < this.V; v++){
            System.out.print(v+":");
            for( int w=0; w < this.V; w++){
                if( this.adj[v][w]==1)
                    System.out.print(" "+w);
                    
            }
            System.out.println();
        }
    }
    public boolean ExisteCaminho(int s, int t){
        // cria o vetor de visitados
        ArrayList<Integer> caminhos = new ArrayList<>(20);
        // chama a funcao que faz a busca em profundidade a 
        // partir do vertice s
        caminhos.add(s);
        busca_prof(s, t, caminhos);
        
        // como saber se existe caminho até t ?
        // se visitados na posicao t eh igual a true - t foi visitado
        // caso contrario tem false na posicao t
        sendMensage();
        if (caminhos.get(caminhos.size() -1) == t)
            return true;
        
        return false;
        
    }
    // implementacao da busca em profundidade a partir de somente um vertice
    public void busca_prof(int v, int t, ArrayList<Integer> caminhos){
        //marque v como visitado
        if ( caminhos.get(caminhos.size() - 1) != v && v != 0)
            caminhos.add(v);
        System.out.println(v);
        printArray(caminhos);
        //para Cada vértice w adjacente a v faça
        for( int w=0; w < this.V; w++){// w anda na linha da matriz
            // se w eh adjacente a v E
            // se w não foi visitado então
            if(this.adj[v][w]==1 && caminhos.get(caminhos.size() - 1) != t){
                busca_prof( w, t, caminhos);
            } else if(this.adj[v][w]==1 && caminhos.get(caminhos.size() - 1) == t && t == 6 ) {
                System.out.println(v);
                System.out.println(w);
                caminhos.remove(caminhos.size() - 1);
                busca_prof( w, t, caminhos);
                caminhos.remove(caminhos.size() - 1);
            }  
        }
    }
    
    public void printArray(ArrayList<Integer> array) {
        for(int num : array) {
            System.out.print(num);
        }
        System.out.println();
    }
    
    public void sendMensage() {
        try {
            FileConnector.writer("C:\\Users\\Fofolho\\Documents\\NetBeansProjects\\Jogos\\Sº3\\JavaApplication20\\src\\ADOGrafos\\utils\\Out.txt",
                    erroMansager.toString()); 
       } catch(IOException e) {
            System.out.println("error: " + e);
       }
    }
}
