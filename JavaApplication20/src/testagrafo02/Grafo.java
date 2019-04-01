
package testagrafo02;

public class Grafo {
    private int V; // número de vértices
    private int A; // número de arestas
    private int adj[][]; // matriz de adjcência

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
        if(this.adj[v][w]==0){
            this.adj[v][w]=1;
            this.A++;
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
        boolean visitados[] = new boolean[this.V];
        
        // chama a funcao que faz a busca em profundidade a 
        // partir do vertice s
        busca_prof(s,visitados);
        
        // como saber se existe caminho até t ?
        // se visitados na posicao t eh igual a true - t foi visitado
        // caso contrario tem false na posicao t
        return visitados[t];
        
    }
    // implementacao da busca em profundidade a partir de somente um vertice
    public void busca_prof(int v, boolean visitados[]){
        //marque v como visitado
        visitados[v]=true;
        // imprime v
        System.out.println(v);
        //para Cada vértice w adjacente a v faça
        for( int w=0; w < this.V; w++){// w anda na linha da matriz
            // se w eh adjacente a v E
            // se w não foi visitado então
            if(this.adj[v][w]==1 && visitados[w]==false )
                busca_prof( w, visitados );
                                         
                
        }

    }
    
}
