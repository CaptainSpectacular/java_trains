public class NodeTests
{
    public void nodeCreation()
    {
        Node n = new Node('A');
        if (n.data == 'A' && n.edges.isEmpty())
        {
            System.out.println("passed: nodeCreation");
        }
        else
        {
            System.out.println("failed: nodeCreation");
        }
    }

    public void edgeInsertion()
    {
        Node node1 = new Node('A');
        Node node2 = new Node('B');
        Node node3 = new Node('C');
        Edge edge1 = new Edge(21, node2);
        Edge edge2 = new Edge(16, node3);
        Edge edge3 = new Edge(9, node1);

        node1.insertEdge(edge1);
        node1.insertEdge(edge2);
        node1.insertEdge(edge3);

        if (node1.edges.containsKey('A') && node1.edges.containsKey('B') && node1.edges.containsKey('C'))
        {
            System.out.println("passed: edgeInsertion");
        }
        else
        {
            System.out.println("failed: edgeInsertion");
        }
    }
}
