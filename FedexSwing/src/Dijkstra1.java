
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

class Vertex1 implements Comparable<Vertex1>
{
    public final String name;
    public Edge1[] adjacencies;
    public double minDistance = Double.POSITIVE_INFINITY;
    public Vertex1 previous;
	public String reachtime;
    public Vertex1(String argName) { name = argName; }
    @Override
	public String toString() {
		return  name;
	}
    public int compareTo(Vertex1 other)
    {
        return Double.compare(minDistance, other.minDistance);
    }

}


class Edge1
{
    public final Vertex1 target;
    public final double weight;
    public Edge1(Vertex1 argTarget, double argWeight)
    { target = argTarget; weight = argWeight; }
}

public class Dijkstra1 implements Runnable
{
	//public static final List<Vertex1> path;
	public static String ist,cs,cd,key;
	public static long time;
	public static final List<Vertex1> path = null;
	private static final String Ist = null;
	public static  Vertex1 Src = null, Des = null,v;
	public static Vertex1 NB,Ed,PI,AT,MB,CLT,ATL,OL,MP,GC,IP,DI,NBU,MPO,STL,KS,DS,H,D,SLT,PN,LA,CH,SA,SEA,ERR;

	public static void computePaths(String src)
    {
		Vertex1 source = sourcecity(src);
        source.minDistance = 0;
        PriorityQueue<Vertex1> Vertex1Queue = new PriorityQueue<Vertex1>();
    Vertex1Queue.add(source);

    while (!Vertex1Queue.isEmpty()) {
        Vertex1 u = Vertex1Queue.poll();

            // Visit each Edge1 exiting u
            for (Edge1 e : u.adjacencies)
            {
                Vertex1 v = e.target;
                double weight = e.weight;
                double distanceThroughU = u.minDistance + weight;
        if (distanceThroughU < v.minDistance) {
            Vertex1Queue.remove(v);

            v.minDistance = distanceThroughU ;
            v.previous = u;
            Vertex1Queue.add(v);
        }
            }
        }
    }

    public static List<Vertex1> getShortestPathTo(String t, String t1, String K) throws Exception
    {
    	//Vertex1 Vertex1;
    	String cd= t;
    	String cs = t1; 
    	String key = K;
    	Vertex1 target = sourcecity(t);
        List<Vertex1> path = new ArrayList<Vertex1>();
        for (Vertex1 Vertex1 = target; Vertex1 != null; Vertex1 = Vertex1.previous)
        	path.add(Vertex1);
/*        	Vertex1 Ist = Vertex1;
         time = System.currentTimeMillis();
        	System.out.println("The packet is at " + Ist + " at time " + time);
        	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/feedback?autoReconnect=true&useSSL=false","root","chinnu41093");
    		Statement sttmt = conn.createStatement();
    		PreparedStatement psttmt= conn.prepareStatement("insert into Fedex.packageinfo (Istation, Time, Source, Destination, TNO) values (?, ?, ?,?,?)");
  			psttmt.setString(1, Vertex1.name);
  			psttmt.setLong(2, time);
  			psttmt.setString(3,cs);
  			psttmt.setString(4,cd );
  			psttmt.setString(5, key);
    		psttmt.executeUpdate();
    		ist = Vertex1.name;
        	Thread.sleep(5000);*/
       Collections.reverse(path); 
       for(Vertex1 Vertex1: path) {
			Vertex1.reachtime = new Timestamp(new Date(time).getTime()).toString();
        	System.out.println("The packet is at " + Vertex1.name + " at time " + Vertex1.reachtime);
        	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/feedback?autoReconnect=true&useSSL=false","root","chinnu41093");
    		Statement sttmt = conn.createStatement();
    		PreparedStatement psttmt= conn.prepareStatement("insert into Fedex.packageinfo (Istation, Time, Source, Destination, TNO) values (?, ?, ?,?,?)");
  			psttmt.setString(1, Vertex1.name);
  			psttmt.setString(2, Vertex1.reachtime);
  			psttmt.setString(3,cs);
  			psttmt.setString(4,cd );
  			psttmt.setString(5, key);
    		psttmt.executeUpdate();
    		ist = Vertex1.name;
    		System.out.println(ist);
        	Thread.sleep(5000);
			
     }
       
        return path;
    }

    public static void DijkstraAlgo()
    {
    	 Vertex1 Src = null, Des = null;
        // mark all the vertices 
         NB = new Vertex1("NB");
        Ed = new Vertex1("Ed");
        PI = new Vertex1("PI");
        AT = new Vertex1("AT");
         MB = new Vertex1("MB");
         CLT = new Vertex1("CLT");
        ATL = new Vertex1("ATL");
        OL = new Vertex1("OL");
        MP = new Vertex1("MP");
        GC = new Vertex1("GC");
       IP = new Vertex1("IP");
        DI = new Vertex1("DI");
         NBU = new Vertex1("NBU");
         MPO = new Vertex1("MPO");
          STL= new Vertex1("STL");
       KS = new Vertex1("KS");
       DS = new Vertex1("DS");
         H = new Vertex1("H");
        D = new Vertex1("D");
        SLT = new Vertex1("SLT");
        PN = new Vertex1("PN");
         LA = new Vertex1("LA");
        CH = new Vertex1("CH");
        SA = new Vertex1("SA");
        SEA = new Vertex1("SEA");

        // set the Edge1s and weight
        NB.adjacencies = new Edge1[]{ new Edge1(Ed, 1) };
        Ed.adjacencies = new Edge1[]{ new Edge1(AT, 1) };
        AT.adjacencies = new Edge1[]{ new Edge1(PI, 1) };
        PI.adjacencies = new Edge1[]{ new Edge1(MB, 1) };
        MB.adjacencies = new Edge1[]{ new Edge1(CLT, 4) };
        CLT.adjacencies = new Edge1[]{ new Edge1(ATL, 2) };
        ATL.adjacencies = new Edge1[]{ new Edge1(OL, 5) };
        OL.adjacencies = new Edge1[]{ new Edge1(H, 8) };
        H.adjacencies = new Edge1[]{ new Edge1(DS, 2) };
        DS.adjacencies = new Edge1[]{ new Edge1(MP, 6) };
        DS.adjacencies = new Edge1[]{ new Edge1(PN, 3) };
        MP.adjacencies = new Edge1[]{ new Edge1(STL, 2) };
        STL.adjacencies = new Edge1[]{ new Edge1(KS, 2) };
        PN.adjacencies = new Edge1[]{ new Edge1(CH, 1) };
        CH.adjacencies = new Edge1[]{ new Edge1(LA, 1) };
        LA.adjacencies = new Edge1[]{ new Edge1(SA, 1) };
        SA.adjacencies = new Edge1[]{ new Edge1(D, 2) };
        D.adjacencies = new Edge1[]{ new Edge1(SLT, 5) };
        SLT.adjacencies = new Edge1[]{ new Edge1(SEA, 6) };
        SEA.adjacencies = new Edge1[]{ new Edge1(MP, 10) };
        KS.adjacencies = new Edge1[]{ new Edge1(D, 3) };
        MP.adjacencies = new Edge1[]{ new Edge1(NBU, 2) };
        NBU.adjacencies = new Edge1[]{ new Edge1(DI, 3) };
        DI.adjacencies = new Edge1[]{ new Edge1(GC, 5) };
        GC.adjacencies = new Edge1[]{ new Edge1(IP, 3) };
        IP.adjacencies = new Edge1[]{ new Edge1(STL, 2) };
    }
        public static Vertex1 sourcecity(String input) {
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
        List<Vertex1> path = getShortestPathTo(Des);
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
					List<Vertex1> path = getShortestPathTo(cdestination,csource,k);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	
			System.out.println("Path: " + path);
		}
}

