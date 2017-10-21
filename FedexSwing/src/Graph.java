import java.io.IOException;
import java.util.*;

public class Graph
{
   
    public static String cityArray[]= {"NorthBorough(MA)","Edison(NJ)","Pittsburgh(PA)", "AllenTown(PA)", "Martinsburg(WV)"," Charlotte(NC)","Atlanta(GA)","Orlando(FL)","Memphis(TN)","Grove City(OH)","IndianaPolis(IN)","Detroit(MI)","NewBerlin(WI)","Minneapolis(MN)","St.Louis(MO)","Kansas(KS)","Dallas(TX)","Houston(TX)","Denver(CO)","SaltLakeCity(UT)","Phoenix(AZ)","LosAngeles(CA)","Chino(CA)","Sacremento(CA)","Seattle(WA)"};
    Map<String, LinkedList<String>> adj;

    public Graph() {
        adj = new HashMap<String, LinkedList<String>>();
    }

    public void addNode(String node) 
    {
        adj.putIfAbsent(node, new LinkedList<String>());
    }

    public void addNeighbor(String v1,String v2) {
       (adj.get(v1)).add(v2);
    }

    public List<String> getNeighbors(String v) {
       return adj.get(v);
    }
    @Override
    public String toString() {
    	return ("("+cityArray[3]+","+cityArray[1]+")");
   }
    
    public void addEdge(String vertexa, String vertexb, int weight) {
        edge(vertexa, vertexb);
      //  edge(vertexa, vertexb);
    }
    
    private void edge(String vertexA, String vertexB)
    {
    	List<String> edges;
    	if(adj.containsKey(vertexA))
    	{
    		edges = adj.get(vertexA);
    		edges.add(vertexB);
    	}
    	else
    	{
    		edges = new ArrayList<String>();
    		edges.add(vertexB);
    		(this.adj).put(vertexA, (LinkedList<String>) edges);
    	}
    }
        
    public static final Map<String, FedexPackage> mapper = new HashMap<String, FedexPackage>();
    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        Graph g = new Graph();
       // String cityArray[]= {"NorthBorough(MA)","Edison(NJ)","Pittsburgh(PA)", "AllenTown(PA)", "Martinsburg(WV)"," Charlotte(NC)","Atlanta(GA)","Orlando(FL)","Memphis(TN)","Grove City(OH)","IndianaPolis(IN)","Detroit(MI)","NewBerlin(WI)","Minneapolis(MN)","St.Louis(MO)","Kansas(KS)","Dallas(TX)","Houston(TX)","Denver(CO)","SaltLakeCity(UT)","Phoenix(AZ)","LosAngeles(CA)","Chino(CA)","Sacremento(CA)","Seattle(WA)"};
        for(int i=0; i<cityArray.length;i++)
        {
        g.addNode(cityArray[i]);
        }
        g.addEdge(cityArray[0], cityArray[1], 1);
        g.addEdge(cityArray[1], cityArray[3], 1);
        g.addEdge(cityArray[3], cityArray[2], 1);
        g.addEdge(cityArray[2], cityArray[4], 1);
        g.addEdge(cityArray[4], cityArray[5], 4);
        g.addEdge(cityArray[5], cityArray[6], 2);
        g.addEdge(cityArray[6], cityArray[7], 5);
        g.addEdge(cityArray[7], cityArray[17], 8);
        g.addEdge(cityArray[17], cityArray[16], 2);
        g.addEdge(cityArray[16], cityArray[13], 6);
        g.addEdge(cityArray[16], cityArray[20], 3);
        g.addEdge(cityArray[13], cityArray[14], 2);
        g.addEdge(cityArray[14], cityArray[15], 2);
        g.addEdge(cityArray[20], cityArray[22], 1);
        g.addEdge(cityArray[22], cityArray[21], 1);
        g.addEdge(cityArray[21], cityArray[23], 1);
        g.addEdge(cityArray[23], cityArray[18], 2);
        g.addEdge(cityArray[18], cityArray[19], 5);
        g.addEdge(cityArray[19], cityArray[24], 6);
        g.addEdge(cityArray[24], cityArray[8], 1);
        g.addEdge(cityArray[15], cityArray[18], 3);
        g.addEdge(cityArray[8], cityArray[12], 2);
        g.addEdge(cityArray[12], cityArray[11], 3);
        g.addEdge(cityArray[11], cityArray[9], 5);
        g.addEdge(cityArray[9], cityArray[10], 3);
        g.addEdge(cityArray[10], cityArray[14], 2);
     //   System.out.println(g);
/*        FedexSwings fs = new FedexSwings();
        fs.MajorNewFrame();
        FedexDB fdb = new FedexDB();
        fdb.database();*/
      //  FedexInput fi = new FedexInput();
       // fi.feedinput();
       // System.out.println(fi.Source);
       // System.out.println(fi.Destination);
      //  FedexPackage fp = new FedexPackage();
      //  fp.FedexPackage();
       
        Thread simuthread1 = new Thread(new Dijkstra());
        simuthread1.start();
        
        Thread simuthread2 = new Thread(new Dijkstra1());
        simuthread2.start();

        
     }
}