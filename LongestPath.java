import java.util.*;

public class LongestPath {
  static class AdjListNode {
    int v;

    AdjListNode(int _v)
    {
      v = _v;
    }
    int getVertex() { return v; }
  }

  static class Graph {
    int V; 

    ArrayList<ArrayList<AdjListNode>> adj;

    Graph(int V)
    {
      this.V = V;
      adj = new ArrayList<ArrayList<AdjListNode>>(V);

      for(int i = 0; i < V; i++) {
        adj.add(new ArrayList<AdjListNode>());
      }
    }

    void addEdge(int u, int v)
    {
      AdjListNode node = new AdjListNode(v);
      adj.get(u).add(node); // Add v to u's list
    }

    void topologicalSortUtil(int v, boolean visited[],
                             Stack<Integer> stack)
    {
      visited[v] = true;

      for (int i = 0; i < adj.get(v).size(); i++) {
        AdjListNode node = adj.get(v).get(i);
        if (!visited[node.getVertex()])
          topologicalSortUtil(node.getVertex(), visited, stack);
      }

      stack.push(v);
    }

    void longestPath(int s)
    {
      Stack<Integer> stack = new Stack<Integer>();
      int dist[] = new int[V];

      boolean visited[] = new boolean[V];
      for (int i = 0; i < V; i++) {
        visited[i] = false;
      }

      for (int i = 0; i < V; i++) {
        if (visited[i] == false)
          topologicalSortUtil(i, visited, stack);
      }

      for (int i = 0; i < V; i++) {
        dist[i] = Integer.MIN_VALUE;
      }

      dist[s] = 0;

      while (stack.isEmpty() == false)
      {

        int u = stack.peek();
        stack.pop();

        if (dist[u] != Integer.MIN_VALUE)
        {
          for (int i = 0; i < adj.get(u).size(); i++)
          {
            AdjListNode node = adj.get(u).get(i);
            if (dist[node.getVertex()] < dist[u] + 1)
              dist[node.getVertex()] = dist[u] + 1;
          }
        }
      }

      int maxDist = 0;
      int destNode = s;
      for (int i = 0; i < V; i++) {
        if(dist[i] >= maxDist) {
          maxDist = dist[i];
          destNode = i;
        }
      }
      System.out.println("The longest path from node " + s + " is to node " + destNode + " with a distance of " +maxDist);
    }
  }

  public static void main(String args[])
  {
    Scanner sc = new Scanner(System.in);
    System.out.println("Please enter the number of nodes in the graph");
    int numNodes = sc.nextInt();
    Graph g = new Graph(numNodes);
    System.out.println("Enter pair of nodes to create edges. Please enter -1 to end creation");
    while(true) {
      int v1 = sc.nextInt();
      int v2 = sc.nextInt();
      if(v1 == -1 || v2 == -1)
        break;
      else
        g.addEdge(v1, v2);
      System.out.println("Please enter next edge");  
    }

    System.out.println("Please enter source node");

    int s = sc.nextInt();
    g.longestPath(s);
  }
}
