## Union-Find
Steps to developing a usable algorithm:
-   Model the problem
-   Find an algorithm to solve
-   Fast enough? Fits in memory?
-   If not, figure out why.
-   Find a way to address the problem.
-   Iterate until satisfied.

### Dynamic connectivity:

Given a set of N objects.
-  Union command: connect two objects.
-  Find/connected query: is there a path connecting the two objects.
  

Applications:
-  Computers in a network
-  Pixels in a digital photo
-  Friends in a social network

Tricks:
-  When programming, convennient to name objects 0 to N-1.
-  Supress details not relevant to Union-find.
  
  