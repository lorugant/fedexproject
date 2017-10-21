
import java.util.PriorityQueue;
import java.util.List;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;

class Vertex implements Comparable<Vertex>
{
    public final String name;
    public Edge[] adjacencies;
    public double minDistance = Double.POSITIVE_INFINITY;
    public Vertex previous;
	public String reachtime;
    public Vertex(String argName) { name = argName; }
    @Override
	public String toString() {
		return  name;
	}
    public int compareTo(Vertex other)
    {
        return Double.compare(minDistance, other.minDistance);
    }

}


class Edge
{
    public final Vertex target;
    public final double weight;
    public Edge(Vertex argTarget, double argWeight)
    { target = argTarget; weight = argWeight; }
}

public class Dijkstra implements Runnable
{
	//public static final List<Vertex> path;
	public static String ist,cs,cd,key;
	public static long time;
	public static final List<Vertex> path = null;
	private static final String Ist = null;
	public static  Vertex Src = null, Des = null,v;
	public static Vertex NB,Ed,PI,AT,MB,CLT,ATL,OL,MP,GC,IP,DI,NBU,MPO,STL,KS,DS,H,D,SLT,PN,LA,CH,SA,SEA,ERR;

	public static void computePaths(String src)
    {
		Vertex source = sourcecity(src);
        source.minDistance = 0;
        PriorityQueue<Vertex> vertexQueue = new PriorityQueue<Vertex>();
    vertexQueue.add(source);

    while (!vertexQueue.isEmpty()) {
        Vertex u = vertexQueue.poll();

            // Visit each edge exiting u
            for (Edge e : u.adjacencies)
            {
                Vertex v = e.target;
                double weight = e.weight;
                double distanceThroughU = u.minDistance + weight;
        if (distanceThroughU < v.minDistance) {
            vertexQueue.remove(v);

            v.minDistance = distanceThroughU ;
            v.previous = u;
            vertexQueue.add(v);
        }
            }
        }
    }

    public static List<Vertex> getShortestPathTo(String t, String t1, String K) throws Exception
    {
    	//Vertex vertex;
    	String cd= t;
    	String cs = t1; 
    	String key = K;
    	Vertex target = sourcecity(t);
        List<Vertex> path = new ArrayList<Vertex>();
        for (Vertex vertex = target; vertex != null; vertex = vertex.previous)
        	path.add(vertex);
/*        	Vertex Ist = vertex;
         time = System.currentTimeMillis();
        	System.out.println("The packet is at " + Ist + " at time " + time);
        	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/feedback?autoReconnect=true&useSSL=false","root","chinnu41093");
    		Statement sttmt = conn.createStatement();
    		PreparedStatement psttmt= conn.prepareStatement("insert into Fedex.packageinfo (Istation, Time, Source, Destination, TNO) values (?, ?, ?,?,?)");
  			psttmt.setString(1, vertex.name);
  			psttmt.setLong(2, time);
  			psttmt.setString(3,cs);
  			psttmt.setString(4,cd );
  			psttmt.setString(5, key);
    		psttmt.executeUpdate();
    		ist = vertex.name;
        	Thread.sleep(5000);*/
       Collections.reverse(path); 
       for(Vertex vertex: path) {
			vertex.reachtime = new Timestamp(System.currentTimeMillis()).toString();
        	System.out.println("The packet is at " + vertex.name + " at time " + vertex.reachtime);
        	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/feedback?autoReconnect=true&useSSL=false","root","chinnu41093");
    		Statement sttmt = conn.createStatement();
    		PreparedStatement psttmt= conn.prepareStatement("insert into Fedex.packageinfo (Istation, Time, Source, Destination, TNO) values (?, ?, ?,?,?)");
  			psttmt.setString(1, vertex.name);
  			psttmt.setString(2, vertex.reachtime);
  			psttmt.setString(3,cs);
  			psttmt.setString(4,cd );
  			psttmt.setString(5, key);
    		psttmt.executeUpdate();
    		ist = vertex.name;
    		System.out.println(ist);
        	Thread.sleep(5000);
			
     }
       
        return path;
    }

    public static void DijkstraAlgo()
    {
    	 Vertex Src = null, Des = null;
        // mark all the vertices 
         NB = new Vertex("NB");
        Ed = new Vertex("Ed");
        PI = new Vertex("PI");
        AT = new Vertex("AT");
         MB = new Vertex("MB");
         CLT = new Vertex("CLT");
        ATL = new Vertex("ATL");
        OL = new Vertex("OL");
        MP = new Vertex("MP");
        GC = new Vertex("GC");
       IP = new Vertex("IP");
        DI = new Vertex("DI");
         NBU = new Vertex("NBU");
         MPO = new Vertex("MPO");
          STL= new Vertex("STL");
       KS = new Vertex("KS");
       DS = new Vertex("DS");
         H = new Vertex("H");
        D = new Vertex("D");
        SLT = new Vertex("SLT");
        PN = new Vertex("PN");
         LA = new Vertex("LA");
        CH = new Vertex("CH");
        SA = new Vertex("SA");
        SEA = new Vertex("SEA");

        // set the edges and weight
        NB.adjacencies = new Edge[]{ new Edge(Ed, 1) };
        Ed.adjacencies = new Edge[]{ new Edge(AT, 1) };
        AT.adjacencies = new Edge[]{ new Edge(PI, 1) };
        PI.adjacencies = new Edge[]{ new Edge(MB, 1) };
        MB.adjacencies = new Edge[]{ new Edge(CLT, 4) };
        CLT.adjacencies = new Edge[]{ new Edge(ATL, 2) };
        ATL.adjacencies = new Edge[]{ new Edge(OL, 5) };
        OL.adjacencies = new Edge[]{ new Edge(H, 8) };
        H.adjacencies = new Edge[]{ new Edge(DS, 2) };
        DS.adjacencies = new Edge[]{ new Edge(MP, 6) };
        DS.adjacencies = new Edge[]{ new Edge(PN, 3) };
        MP.adjacencies = new Edge[]{ new Edge(STL, 2) };
        STL.adjacencies = new Edge[]{ new Edge(KS, 2) };
        PN.adjacencies = new Edge[]{ new Edge(CH, 1) };
        CH.adjacencies = new Edge[]{ new Edge(LA, 1) };
        LA.adjacencies = new Edge[]{ new Edge(SA, 1) };
        SA.adjacencies = new Edge[]{ new Edge(D, 2) };
        D.adjacencies = new Edge[]{ new Edge(SLT, 5) };
        SLT.adjacencies = new Edge[]{ new Edge(SEA, 6) };
        SEA.adjacencies = new Edge[]{ new Edge(MP, 10) };
        KS.adjacencies = new Edge[]{ new Edge(D, 3) };
        MP.adjacencies = new Edge[]{ new Edge(NBU, 2) };
        NBU.adjacencies = new Edge[]{ new Edge(DI, 3) };
        DI.adjacencies = new Edge[]{ new Edge(GC, 5) };
        GC.adjacencies = new Edge[]{ new Edge(IP, 3) };
        IP.adjacencies = new Edge[]{ new Edge(STL, 2) };
    }
        public static Vertex sourcecity(String input) {
        	//DijkstraAlgo();
        /*	input = input.substring(0, input.indexOf("("))+", "
        			+input.substring(input.indexOf("(")+1, input.indexOf(")"));*/
        	
        	switch(input) {
    		case "NorthBorough(MA)" : return NB;
    		case "Edison(NJ)"  : return Ed;
    		case "Pittsburgh(PA)" : return PI;
    		case "AllenTown(PA)": return AT;
    		case "Martinsburg(WV)": return MB;
    		case "Charlotte(NC)" : return CLT;
    		case "Atlanta(GA)" : return ATL;
    		case "Orlando(FL)" : return OL;
    		case "Memphis(TN)": return MP;
    		case "Grove City(OH)" : return GC;
    		case "IndianaPolis(IN)" : return IP;
    		case "Detroit(MI)": return DI;
    		case "NewBerlin(WI)" : return NBU;
    		case "Minneapolis(MN)" : return MP;
    		case "St.Louis(MO)": return STL;
    		case "Kansas(KS)" : return KS;
    		case "Dallas(TX)" : return DS;
    		case "Houston(TX)" : return H;
    		case "Denver(CO)" : return D;
    		case "SaltLakeCity(UT)" : return SLT;
    		case "Phoenix(AZ)" : return PN;
    		case "LosAngeles(CA)" : return LA;
    		case "Chino(CA)" : return CH;
    		case  "Sacramento(CA)": return SA;
    		case "Seattle(WA)" : return SEA;
    		default : return ERR;
        	}

      /*  computePaths(Src); // run Dijkstra
        System.out.println("Distance to " + Des + ": " + Des.minDistance);
        List<Vertex> path = getShortestPathTo(Des);
      //  System.out.println(path.get(3));
        System.out.println("Path: " + path);*/
        
        
        
    }

		@Override
		public void run() {
			// TODO Auto-generated method stubs
			System.out.println("In Dijkstra run method");
			FedexPackage pack = new FedexPackage();
			try {
				pack = (FedexPackage) pack.FedexPackage();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			//pack= Graph.mapper.get(pack.key);
			
			//Dijkstra paths=new Dijkstra();
			ArrayList<String> shortest=new ArrayList<String>();
			String[] cityarray = {"NorthBorough(MA)","Edison(NJ)","Pittsburgh(PA)", "AllenTown(PA)", "Martinsburg(WV)"," Charlotte(NC)","Atlanta(GA)","Orlando(FL)","Memphis(TN)","Grove City(OH)","IndianaPolis(IN)","Detroit(MI)","NewBerlin(WI)","Minneapolis(MN)","St.Louis(MO)","Kansas(KS)","Dallas(TX)","Houston(TX)","Denver(CO)","SaltLakeCity(UT)","Phoenix(AZ)","LosAngeles(CA)","Chino(CA)","Sacremento(CA)","Seattle(WA)"};
			//System.out.println("before DijkstraAlgo");
			String csource = pack.getSval();
			String cdestination = pack.getDval();
			String k =pack.key;
			System.out.println("Exited DijkstraAlgo");
			System.out.println(csource);
			System.out.println(cdestination);
			DijkstraAlgo();
			//System.out.println("Exited DijkstraAlgo");
			computePaths(csource);
				System.out.println("Exited computepaths");
				try {
					System.out.println(csource);
					System.out.println(cdestination);
					List<Vertex> path = getShortestPathTo(cdestination,csource,k);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	
			System.out.println("Path: " + path);
		}
}