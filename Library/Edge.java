package Library;

public class Edge<T> {
   
    public enum ConnectionType {
        /** Represents an Edge where you can only traverse in one direction. */
        UNIDIRECTIONAL,
        /** Represents an Edge where you can traverse in either direction. */
        BIDIRECTIONAL
    }

    private T privFromNode, privToNode;
    private ConnectionType privType;

    /**
     * Creates a {@link ConnectionType#UNIDIRECTIONAL} edge between two nodes.
     * @param _fromNode The node the edge originates from.
     * @param _toNode The node the edge ends at.
     */
    public Edge(T _fromNode, T _toNode){
        this(_fromNode,_toNode,ConnectionType.UNIDIRECTIONAL);
    }

    /**
     * Creates an edge of a specified type between two nodes. 
     * @param _fromNode The node the edge originates from.
     * @param _toNode The nodes the edge originates at.
     * @param _type The type of the node, either {@link ConnectionType#UNIDIRECTIONAL} or {@link ConnectionType#BIDIRECTIONAL}.
     */
    public Edge(T _fromNode, T _toNode, ConnectionType _type) {
        privFromNode = _fromNode;
        privToNode = _toNode;
        privType = _type;
    }

    public T fromNode(){
        return privFromNode;
    }

    public T toNode(){
        return privToNode;
    }

    public ConnectionType type(){
        return privType;
    }

}