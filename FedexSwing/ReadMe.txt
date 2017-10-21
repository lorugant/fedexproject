This code is the implementation of Fedex package tracking with multithreading implementation
The following are the java classes and their purposes:

1) GUI PART:
a) FedexSwings.java file has the main method for implementation of GUI part
b) FedexSwings2.java file has the implementation of second window box
c) FedexSwings4.java file has the implementation of Tracking my package window box

2) DATABASE PART:
a) Connection.java file has the implementation of connecting to mysql database
b) InsertRow.java file has the implementation of Inserting rows according to ID number in the database

3) PACKET PART:
a) Graph.java file has the implementation of creating vertices and edges for network simulation using java adjacency list and has the main method
b) FedexPackage.java file has the creation of packet to be transfered
c) Dijkstra.java file has the runnable method where the packet is transfered along the route for the given path 
d) Dijkstra1.java file also has the runnable method for the second packet transmission to happen using multithreading

IMPLEMENTATION:

I have a database called FedTrack where the table called package is created with the fields such as (Istation Varchar, Time Varchar, Source Varchar, Destination Varchar, Trackingnumber Varchar)
I also have another database called Fedex where the table is called packageinfo is created with fields such as (Istation varchar, Time Varchar,Source Varchar, Destination Varchar, TNO Varchar)

I have two main methods, one in FedexSwings.java file to enter the shipping information. Once all the information is entered, click Ok and then you will be given a tracking ID

Then Run Graph.java file to enter the tracking IDs that were created before. Then you can see packet transmission in console. We can also view the History by running the FedexSwings.java file again in which click for track my package then you will be asked to enter the tracking ID where the information is pulled from database and printed on the text area 

GRAPH EDGES AND VERTICES:
List of Fedex Distribution Centers
Northborough, MA
Edison, NJ
Pittsburgh, PA
Allentown, PABD Strap Endlinksth
Martinsburg, WV
Charlotte, NC
Atlanta, GA
Orlando, FL
Memphis, TN
Grove City, OH
Indianapolis, IN
Detroit, MI
New Berlin, WI
Minneapolis, MN
St. Louis, MO
Kansas, KS
Dallas, TX
Houston, TX
Denver, CO
Salt Lake City, UT
Phoenix, AZ
Los Angeles, CA
Chino, CA
Sacramento, CA
Seattle, WA


NB-------Edison
Edison------Allentown
Allentown-----Pittsburgh
Pittsburgh---------Martinsburg
Martinsburg-----------Charlotte
Charlotte-----------Atlanta
Atlanta --------------Orlando
Orlando------------Houston
Houston-----------Dallas
Dallas--------------Memphis
Dallas------------phoenix
Memphis--------St.louis
St.louis-----------Kansas
Phoenix-----------chino
Chino-------------LA
LA--------Sacremento
Sacremento-------Denver
Denver----------Utah
Utah-----------washington
Washington--------Minneapolis
Kansas ---------Denver
Minneapolis------NewBerlin
NewBerlin--------Detroit
Detroit----------GroveCity
GroveCity-------Indianapolis
Indianapolis--------St.Louis

