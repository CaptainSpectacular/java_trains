public class GraphTests
{
    public void graphCreation()
    {
        Graph g = new Graph();
        if (g != null)
            System.out.println("passed: graphCreation");
    }

    public void graphInsertion()
    {
        Graph g = new Graph();
        g.insert("AB5");
        
        if (g.gNodes.size() == 2)
            System.out.println("passed: graphInsertion");

        else
            System.out.println("failed: graphInsertion");
    }

    public void graphInsertionWithDuplicateNodes()
    {
        Graph g = new Graph();
        g.insert("AB5");
        g.insert("AB5");
        g.insert("BC4");

        if (g.gNodes.size() == 3)
            System.out.println("passed: graphInsertWithDuplicateNodes");

        else
            System.out.println("failed: graphInsertWithDuplicateNodes");
    }

    public void graphInsertArray()
    {
        Graph g = new Graph();
        String coords[] = { "AB5", "BC4", "CD8", "DC8", "DE6", "AD5", "CE2", "EB3", "AE7" };

        g.insertArray(coords);

        if (g.gNodes.size() == 5)
            System.out.println("passed: graphInsertArray");

        else
            System.out.println("failed: graphInsertArray");
    }

    public void graphRouteDistance()
    {
        Graph g = new Graph();
        String coords[] = { "AB5", "BC4", "CD8", "DC8", "DE6", "AD5", "CE2", "EB3", "AE7" };
        g.insertArray(coords);

        String distance1 = g.routeDistance("A-B-C");
        String distance2 = g.routeDistance("A-D");
        String distance3 = g.routeDistance("A-D-C");
        String distance4 = g.routeDistance("A-E-B-C-D");
        String no_route = g.routeDistance("A-E-D");

        if (Integer.parseInt(distance1) != 9)
        {
            System.out.println("failed: graphRouteDistance.");
            System.out.println("Expected 9, got " + distance1);
        }
        else if (Integer.parseInt(distance2) != 5)
        {
            System.out.println("failed: graphRouteDistance.");
            System.out.println("Expected 5, got " + distance2);
        }
        else if (Integer.parseInt(distance3) != 13)
        {
            System.out.println("failed: graphRouteDistance.");
            System.out.println("Expected 13, got " + distance3);
        }
        else if (Integer.parseInt(distance4) != 22)
        {
            System.out.println("failed: graphRouteDistance.");
            System.out.println("Expected 22, got " + distance4);
        }
        else if (no_route != "NO SUCH ROUTE")
            System.out.println("failed: graphRouteDistance.");

        else
            System.out.println("passed: graphRouteDistance.");
    }

    public void graphFindRoutesWithMaxStops()
    {
        Graph g = new Graph();
        String coords[] = { "AB5", "BC4", "CD8", "DC8", "DE6", "AD5", "CE2", "EB3", "AE7" };
        g.insertArray(coords);

        int result = g.findRoutesWithMaxStops('C', 'C', 3); 

        if (result == 2)
            System.out.println("passed: graphFindRoutesWithMaxStops");

        else
        {
            System.out.println("failed: graphFindRoutesWithMaxStops");
            System.out.println("Got: " + Integer.toString(result));
        }
    }

    public void graphFindRoutesWithExactStops()
    {
        Graph g = new Graph();
        String coords[] = { "AB5", "BC4", "CD8", "DC8", "DE6", "AD5", "CE2", "EB3", "AE7" };
        g.insertArray(coords);

        int result = g.findRoutesWithExactStops('A', 'C', 4); 

        if (result == 3)
            System.out.println("passed: graphFindRoutesWithExactStops");

        else
        {
            System.out.println("failed: graphFindRoutesWithExactStops");
            System.out.println("Got: " + Integer.toString(result));
        }
    }

    public void graphShortestDistance()
    {
        Graph g = new Graph();
        String coords[] = { "AB5", "BC4", "CD8", "DC8", "DE6", "AD5", "CE2", "EB3", "AE7" };
        g.insertArray(coords);
        int result1 = g.shortestDistance('A', 'C');
        int result2 = g.shortestDistance('B', 'B');

        if (result1 == 9)
            System.out.println("passed: shortestDistance1");

        else
        {
            System.out.println("failed: shortestDistance1");
            System.out.println("Got: " + Integer.toString(result1));
        }
        if (result2 == 9)
            System.out.println("passed: shortestDistance2");

        else
        {
            System.out.println("failed: shortestDistance2");
            System.out.println("Got: " + Integer.toString(result2));
        }
    }

    public void graphRoutesWithMaxDistance()
    {
        Graph g = new Graph();
        String coords[] = { "AB5", "BC4", "CD8", "DC8", "DE6", "AD5", "CE2", "EB3", "AE7" };
        g.insertArray(coords);

        int result = g.findRoutesWithMaxDistance('C', 'C', 30, 30);
        if (result == 7)
            System.out.println("Passed: graphRoutesWithMaxDistance");

        else
        {
            System.out.println("Failed: graphRoutesWithMaxDistance");
            System.out.println("Got: " + Integer.toString(result));
        }
    }

    public void graphImportFile()
    {
        Graph g = new Graph();
        g.importFile("SampleFile.txt");

        if (g.gNodes.size() == 5)
            System.out.println("Passed: graphImportFile");
        
        else
        {
            System.out.println("failed: graphImportFile");
            System.out.println("Got: " + Integer.toString(g.gNodes.size()));
        }
    }
}
