package GraphTraversal;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

import GraphTraversal.Edge.ConnectionType;
import Library.AlgoTools;

public class BreadthFirstTraversal {

    private static List<Integer> visited;
    private static List<Integer> marked;
    private static Queue<Integer> queue;

    public static void run(AdjacencyMatrix g, int _v) {
        visited = new ArrayList<Integer>(g.matrix.length);
        marked = new LinkedList<Integer>();
        queue = new PriorityQueue<>(g.matrix.length);
        BFT(g, _v);
        System.out.print("Matrix BFT: " + visited.get(0));
        for (int i = 1; i < visited.size(); i++) {
            System.out.print(", " + visited.get(i));
        }
        System.out.print('\n');
    }

    public static void run(AdjacencyList g, int _v) {
        visited = new ArrayList<Integer>(g.list.length);
        marked = new LinkedList<>();
        queue = new PriorityQueue<>(g.list.length);
        for (int i = 0; i < g.list.length; i++) {
            g.list[i].sort(Comparator.naturalOrder());
        }
        BFT(g, _v);
        System.out.print("List BFT: " + visited.get(0));
        for (int i = 1; i < visited.size(); i++) {
            System.out.print(", " + visited.get(i));
        }
        System.out.print('\n');
    }

    private static void BFT(AdjacencyMatrix g, int _v) {
        visit(_v);
        mark(_v);
        enqueue(_v);
        while (!queue.isEmpty()) {
            int x = queue.remove();
            for (int i = 0; i < g.matrix[x - 1].length; i++) {
                if (g.matrix[x - 1][i] == 1 && !marked.contains(i + 1)) {
                    visit(i + 1);
                    mark(i + 1);
                    enqueue(i + 1);
                }
            }
        }
        return;
    }

    private static void BFT(AdjacencyList g, int _v) {
        visit(_v);
        mark(_v);
        enqueue(_v);
        while (!queue.isEmpty()) {
            int x = queue.remove();
            for (int i = 0; i < g.list[x-1].size(); i++) {
                if(!marked.contains(g.list[x-1].get(i))){
                    visit(g.list[x-1].get(i));
                    mark(g.list[x-1].get(i));
                    enqueue(g.list[x-1].get(i));
                }
            }
        }
        return;
    }

    private static void visit(int _i) {
        visited.add(_i);
    }

    private static void mark(int _i) {
        marked.add(_i);
    }

    private static void enqueue(int _i) {
        queue.add(_i);
    }

    public static void main(String[] args) {
        Edge[] arr = {
                new Edge(1, 4, ConnectionType.BIDIRECTIONAL),
                new Edge(2, 7, ConnectionType.BIDIRECTIONAL),
                new Edge(7, 5, ConnectionType.BIDIRECTIONAL),
                new Edge(2, 5, ConnectionType.BIDIRECTIONAL),
                new Edge(7, 3, ConnectionType.BIDIRECTIONAL),
                new Edge(1, 2, ConnectionType.BIDIRECTIONAL),
                new Edge(3, 4, ConnectionType.BIDIRECTIONAL),
                new Edge(3, 6, ConnectionType.BIDIRECTIONAL),
                new Edge(6, 5, ConnectionType.BIDIRECTIONAL),
                new Edge(5, 4, ConnectionType.BIDIRECTIONAL)
        };
        AdjacencyList list = new AdjacencyList(arr);
        AlgoTools.printList(list.list);
        run(list, 1);
    }
}
