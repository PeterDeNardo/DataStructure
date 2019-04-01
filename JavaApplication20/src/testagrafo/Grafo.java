
package testagrafo;

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
    // calcula o grau de entrada de um vértice
    public int indeg( int v ){
        int grauEntrada = 0;
        for( int i=0; i < this.V; i++)
            grauEntrada+=this.adj[i][v];
        
        return grauEntrada;
            
    }
    /*
    Método verifica se uma sequência de vértices armazenada em um vetor seq[] é um 
    caminho simples. O método deve devolver  -1  se a sequência não é um caminho,  
    0  se a sequência é um caminho simples,  1  se a sequência é um caminho mas 
    não é um caminho simples.  
    */
    public int ehCaminho( int seq[] ){
        
        int v=0,w=0;
        int vertices[]=new int[this.V];
        
        for( int i = 0; i < seq.length-1;i++){
            v = seq[i];
            w = seq[i+1];
            if( this.adj[v][w] == 0)
                return -1;// nao eh caminho
            // atualiza a contagem de vertices
            vertices[v]++;
        }
        vertices[w]++;// para o ultimo vertice do caminho
        for( int i = 0; i < this.V;i++)
            if(vertices[i]>1)// nao eh caminho simples
                return 1;
                
        return 0; // caminho simples
    }


}
 
