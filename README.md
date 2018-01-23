# Algorithm
Maze Problem:
Find the path in a maze from the start point to the end point.
The input should look like:
5 5
1 0 0 0 1
1 1 0 0 1
1 1 1 1 1
0 1 1 1 1
1 1 0 1 1

The first 5 is the number of rows in the maze, the second 5 the number of columns in the maze. The 1 in maze stands for the path, and the 0 stands for wall. For this case, if we want to go to point(0, 4) from point(0, 0), the output is:
(0, 0)
(1, 0)
(1, 1)
(2, 1)
(2, 2)
(2, 3)
(2, 4)
(1, 4)
(0, 4)

-point(0, 4) is point at the upper right corner
