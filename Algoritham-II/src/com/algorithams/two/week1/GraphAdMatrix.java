package com.algorithams.two.week1;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class GraphAdMatrix {
	
	private final int V;
	private int E;
	private boolean  adj [][];
	
	public GraphAdMatrix(int v) {
		V=v;
		adj=new boolean[V][V];				
	}
	
	
	public int V() {
		return V;
	}
	
	public int E() {
		return E;
	}
	
	public void adj(int s, int d) {
		if(!adj[s][d])
			E++;
		adj[s][d]=true;
		adj[d][s]=true;
	}
	   // does the graph contain the edge v-w?
    public boolean contains(int v, int w) {
        return adj[v][w];
    }
    
    public Iterable<Integer> adj(int v) {
    	
        return new AdjIterator(v);
    }
    
    private class AdjIterator implements Iterator<Integer>, Iterable<Integer> {
        private int v;
        private int w = 0;

        AdjIterator(int v) {
            this.v = v;
        }

        public Iterator<Integer> iterator() {
            return this;
        }

        public boolean hasNext() {
            while (w < V) {
                if (adj[v][w]) return true;
                w++;
            }
            return false;
        }

        public Integer next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return w++;
        }

        public void remove()  {
            throw new UnsupportedOperationException();
        }
    }

    public static void main(String[] args) {
		// TODO Auto-generated method stub
    	GraphAdMatrix gr=new GraphAdMatrix(4);
    	gr.adj[1][2]=true;
    	gr.adj[2][1]=true;
		

			for(int w:gr.adj(1))
				System.out.println(w);

	
	}

}
