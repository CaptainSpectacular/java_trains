// The following is a basic graph implementation. I'm not super familiar with Java,
// and there are most definitely data structures that are probably better to use
// for keeping track of the graph's nodes. I used a HashMap to help speed up the 
// development process on my end, but getting to the shortest distance calculations
// I think going with an array or a list probably would have been more scalable
// and maintainable. Tests are all handrolled but I would have loved to get into
// JUnit or another testing suite.  

// If you want to run anything, add it to the main loop and go!

public class Main
{
    public static void main(String args[])
    {
        runTests();
    }

    public static void runTests()
    {
        GraphTests gt = new GraphTests();
        NodeTests nt = new NodeTests();
        EdgeTests et = new EdgeTests();
        
        // Run the graph tests.
        gt.graphCreation();
        gt.graphSingleInsertion();
        gt.graphInsertion();
        gt.graphInsertionWithDuplicateNodes();
        gt.graphInsertArray();
        gt.graphRouteDistance();
        gt.graphFindRoutesWithMaxStops();
        gt.graphFindRoutesWithExactStops();
        gt.graphShortestDistance();
        gt.graphRoutesWithMaxDistance();
        gt.graphImportFile();
        
        // Run the node tests.
        nt.nodeCreation();
        nt.edgeInsertion();

        // Run edge tests.
        et.edgeCreation(); 
    }
}
