BankerSAlgorithm
----------------------------
Description:
The Banker's algorithm is a resource allocation and deadlock avoidance method used in operating systems.
It tests for safety by simulating the allocation of predetermined maximum possible amounts of all resources. 
The algorithm then makes a "safe state" check to test for possible deadlock conditions for all other pending activities, 
before deciding whether allocation should be granted. The Banker's algorithm is run by the operating system whenever a process 
requests some resources. The goal is to avoid a deadlock by denying the requests that may lead to an unsafe state. 
When a new process enters a system, it must declare the maximum number of instances of each resource that it may ever claim; 
clearly, that number may not exceed the total number of resources available in the system. Also, when a process 
gets all its requested resources it must return all the instances of the resources it has to the system.

-------------------------

Files:
- /src/java/main/bankers algorithm/BankerSAlgoritm.java
	Driven Class and have Bussinse logic of program , take numbers of Resources and process information and Run algorthim

++++++++++++++++++++++++++

how to compile and Run the file 
	-open cmd
	-change directory to folder of BankerSAlgoritm.java
	-javac BankerSAlgoritm.java
	-java BankerSAlgoritm
	