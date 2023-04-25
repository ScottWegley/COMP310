package GraphAlgorithms;

import GraphAlgorithms.Edge.ConnectionType;

public class WeightedEdge<T> extends Edge<T> {

    private int privWeight;

    /**
     * Creates a {@link ConnectionType#UNIDIRECTIONAL} weighted edge between two
     * nodes.
     * 
     * @param _fromNode The node the edge originates from.
     * @param _toNode   The node the edge ends at.
     * @param _weight   The weight of the node.
     */
    public WeightedEdge(T _fromNode, T _toNode, int _weight) {
        super(_fromNode, _toNode);
        this.privWeight = _weight;
    }

    /**
     * Creates a weighted edge of a specified type between two nodes.
     * 
     * @param _fromNode The node the edge originates from.
     * @param _toNode   The nodes the edge originates at.
     * @param _type     The type of the node, either
     *                  {@link ConnectionType#UNIDIRECTIONAL} or
     *                  {@link ConnectionType#BIDIRECTIONAL}.
     * @param _weight   The weight of the node.
     */
    public WeightedEdge(T _fromNode, T _toNode, ConnectionType _type, int _weight) {
        super(_fromNode, _toNode, _type);
        this.privWeight = _weight;
    }

    public int weight() {
        return privWeight;
    }

}
