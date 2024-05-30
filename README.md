# Longest Path in a Directed Acyclic Graph

This Java program calculates the longest path in a Directed Acyclic Graph (DAG) using topological sorting and dynamic programming.

## How to Use

1. **Compile the Code**: Compile the Java code using any Java compiler. For example, you can use `javac LongestPath.java`.

2. **Run the Program**: Run the compiled program using the Java Virtual Machine (JVM). For example, you can use `java LongestPath`.

3. **Input**: Enter the number of nodes in the graph when prompted. Then, enter pairs of nodes to create edges in the graph. Enter `-1` to end edge creation.

4. **Source Node**: After creating the graph, enter the source node for which you want to find the longest path.

5. **Output**: The program will output the longest path from the specified source node along with the destination node and its distance.

## Code Overview

The code defines classes for `AdjListNode` and `Graph` to represent the graph structure. It uses an adjacency list to represent the graph.

The `longestPath` method calculates the longest path in the graph using topological sorting and dynamic programming. It iterates through the vertices in topologically sorted order and updates the longest distances.

In the `main` method, the user inputs the graph structure and the source node, and the `longestPath` method is called to find the longest path from the specified source node.

## Example

For example, if the user inputs a graph with the following edges:

```
0  1
0  2
1  3
2  3
0 -1
```

And specifies the source node as `0`, the program will output:

```
The longest path from node 0 is to node 3 with a distance of 2
```

This indicates that the longest path from node `0` in the graph reaches node `3` with a distance of `2` edges.

Note: If the source node doesn't have any outgoing nodes, the result will be a distance of 0 to itself.
