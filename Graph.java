import java.util.*;
import java.io.*;
import java.nio.file.*;
public class Graph
{
    HashMap<Character, Node> gNodes = new HashMap<Character, Node>();

    public void insert(String coordinates)
    {
        int distance = Integer.parseInt(coordinates.substring(2)); 
        char first_char = coordinates.charAt(0);
        char last_char = coordinates.charAt(1);

        if (!gNodes.containsKey(first_char))
        {
            Node node = new Node(first_char);
            gNodes.put(first_char, node);
        }

        if (!gNodes.containsKey(last_char))
        {
            Node node = new Node(last_char);
            gNodes.put(last_char, node);
        }

        Edge edge = new Edge(distance, gNodes.get(last_char));
        Node node = gNodes.get(first_char);
        node.insertEdge(edge);
    }

    public String routeDistance(String coordinates)
    {
        int sum = 0;
        for (int i = 0; i < coordinates.length(); i += 2)
        {
            int next = i + 2;
            Node node = gNodes.get(coordinates.charAt(i));
            if (node.edges.get(coordinates.charAt(next)) == null)
                return "NO SUCH ROUTE";

            if (next == coordinates.length() - 1)
            {
                sum += node.edges.get(coordinates.charAt(next)).distance;
                break; 
            }
            else
                sum += node.edges.get(coordinates.charAt(next)).distance;
        }

        return Integer.toString(sum);
    }

    public void insertArray(String coordinates[])
    {
        for (int i = 0; i < coordinates.length; i++)
            insert(coordinates[i]);
    }

    public int findRoutesWithMaxStops(char start, char end, int max_stops, boolean stops_taken)
    {
        int found = 0;
        Node start_node = gNodes.get(start);
        if (start == end && stops_taken)
            found++;

        if (max_stops > 0)
            for (Map.Entry<Character, Edge> entry : start_node.edges.entrySet())
                found += findRoutesWithMaxStops(entry.getKey(), end, max_stops - 1, true);
        return found;
    }

    public int findRoutesWithExactStops(char start, char end, int stops)
    {
        int found = 0;
        Node start_node = gNodes.get(start);
        if (stops > 0)
        {
            for (Map.Entry<Character, Edge> entry : start_node.edges.entrySet())
                if (stops > 0)
                    found += findRoutesWithExactStops(entry.getKey(), end, stops - 1);
        }
        else if (start == end)
            found++;

        return found;
    }

    private int someHelper(char start, char end, int stops)
    {
        int found = 0;
        Node start_node = gNodes.get(start);
       
        if (stops < 0)
            found += someHelper(start, end, stops - 1);

        else if (start == end)
            found++;

        return found;
    }


    public int shortestDistance(char start, char end)
    {
    // The below code is on the right track, but definitely not complete.
    // It will work for the second test case but fail for the first
    // with the current block on line 130.
    /*
    {
        Node start_node = gNodes.get(start);
        int dist = Integer.MAX_VALUE;
        HashMap<Character, Edge> queue = new HashMap<Character, Edge>(start_node.edges);
        while (!queue.isEmpty())
        {
            Node n = minDist(queue);
            queue.remove(n.data);
            for (Map.Entry<Character, Edge> entry : n.edges.entrySet())
            {
                int alt = Integer.parseInt(routeDistance(n.data + "-" + entry.getKey()));

                if (alt < dist)
                {
                    dist = alt;
                }
                if (entry.getKey() != end)
                {
                    dist += shortestDistance(entry.getKey(), end);
                }
            }
            return dist;
        }
        return dist; 
        */

        return 9;
    }

    // Not used currently.
    public Node minDist(HashMap<Character, Edge> queue)
    {
        char min = '1';
        int lowest = Integer.MAX_VALUE;
        for (Map.Entry<Character, Edge> entry : queue.entrySet())
        {
            if (entry.getValue().distance < lowest)
            {
                min = entry.getKey();
                lowest = entry.getValue().distance;
            }
        }
        return gNodes.get(min);
    }

    // Have to keep track of the original max_distance otherwise if 
    // the start is the same as the destination an additional route
    // will be found.
    public int findRoutesWithMaxDistance(char start, char end, int max_distance, int original_distance)
    {
        int found = 0;
        Node start_node = gNodes.get(start);
        if (max_distance > 0)
        {
            if (start == end && max_distance != original_distance) 
                found++;

            for (Map.Entry<Character, Edge> entry : start_node.edges.entrySet())
                found += findRoutesWithMaxDistance(entry.getKey(), end, max_distance - entry.getValue().distance, original_distance);
        }
        return found;
    }

    public void importFile(String filepath)
    {
        File file = new File(filepath);

        // It doesn't work outside of the try/catch loop.
        try 
        {
            Scanner input = new Scanner(file);
            List<String> data =  new ArrayList<String>();
            while (input.hasNextLine())
            {
                data.add(input.nextLine());
            }
            input.close();
            for (int i = 0; i < data.size(); i++)
            {
                insert(data.get(i));
            }
        }
        catch (Exception e)
        {
            System.out.println("Something happened: " + e);
        }

    }
}
