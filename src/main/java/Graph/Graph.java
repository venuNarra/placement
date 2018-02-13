package Graph;


import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Graph {
	private int V;
	private List<Integer> adj[];
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	Graph(int v){
		this.V=v;
		this.adj=new LinkedList[v];
		for(int i=0;i<v;i++) {
			this.adj[i]=new LinkedList();
		}
	}
	void addEdge(int u, int v) {
		this.adj[u].add(v);
	}
	void BFS(int s) {
		boolean visited[]= new boolean[V];
		Queue<Integer> queue=new LinkedList<Integer>();
		queue.add(s);
		while(!queue.isEmpty()) {
			s=queue.poll();
			System.out.println(s+" ");
			visited[s]=true;
			for(int v:adj[s]) {
				if(!visited[v]) {
					queue.add(v);
				}
			}
//			Iterator<Integer> i=adj[s].listIterator();
//			while(i.hasNext()) {
//				int v=i.next();
//				if(!visited[v]) {
//					visited[v]=true;
//					queue.add(v);
//				}
//			}
		}
		
	}
	void DFS(int s) {
		boolean visited[]=new boolean[V];
		DFSUtil(s,visited);
	}
	void DFSUtil(int u,boolean visited[]){
		System.out.println(u+" ");
		visited[u]=true;
	for(int v: adj[u]) {
			if(!visited[v])
				DFSUtil(v, visited);
		}
//		Iterator<Integer> i=adj[u].listIterator();
//		while(i.hasNext()) {
//			int v=i.next();
//			if(!visited[v]) {
//				DFSUtil(v, visited);
//			}
//		}
	}
	void TopoSortBFS(){
		int indegree[]=new int[V];
		
		for(int i=0;i<V;i++) {
			for(int v:adj[i])
				indegree[v]++;
		}
		Queue<Integer> queue=new LinkedList<Integer>();
		for(int i=0;i<V;i++)
			if(indegree[i]==0)
				queue.add(i);
		while(!queue.isEmpty()) {
			int u=queue.poll();
			System.out.println(u);
			for(int v:adj[u])
				if(--indegree[v]==0)
					queue.add(v);
		}
		
	}
	public static void main(String args[]) {
		Graph g=new Graph(6);
//		g.addEdge(0, 1);
//		g.addEdge(0, 2);
//		g.addEdge(1, 2);
//		g.addEdge(2, 0);
//		g.addEdge(2, 3);
//		g.addEdge(3, 3);
		g.addEdge(5, 2);
		g.addEdge(5, 0);
		g.addEdge(4, 0);
		g.addEdge(1, 4);
		g.addEdge(2, 3);
		g.addEdge(3, 1);
		
	g.BFS(5); 
	System.out.println();
	g.DFS(5);
	System.out.println();
	g.TopoSortBFS();
		
	}

}



