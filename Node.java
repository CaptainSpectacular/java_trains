import java.util.*;
public class Node
{
    char data;
    HashMap<Character, Edge> edges = new HashMap();
    Node(char data)
    {
        this.data = data;
    }

    void insertEdge(Edge edge)
    {
        if (!edges.containsKey(edge.endPoint.data))
        {
            edges.put(edge.endPoint.data, edge);
        }
    }

    public char minDistance()
    {
       char min = '0'; 
       int lowest = Integer.MAX_VALUE; 
        for (Map.Entry<Character, Edge> entry : edges.entrySet())
        {
            if (entry.getValue().distance < lowest)
            {
                lowest = entry.getValue().distance;
                min = entry.getKey();
            }
        }

        return min;
    }
}