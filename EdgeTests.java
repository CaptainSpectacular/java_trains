public class EdgeTests
{
    public void edgeCreation()
    {
        Node node = new Node('A');
        Edge edge = new Edge(32, node);

        if (edge.distance == 32 && edge.endPoint == node)
            System.out.println("passed: edgeCreation");
    }
}
