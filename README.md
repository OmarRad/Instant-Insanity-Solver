# Instant Insanity Solver

This program solves an instant insanity problem of 4 cubes using two methods. The first is a brute force way method where all the possible solutions are generated and the correct ones are picked out(generateAndTest()) and the second is using a breadth-first search algorithm(breadthFirstSearch()). The program compares the two methods of solving the puzzle by timing each of them as well as counting the number of method calls each one goes through.

It become clear that the breadth-first search is much more efficient than the brute force method as it only does 10,944 method calls as compared to the 331,776 method calls of the brute force method. This also results in the breadth-first search taking only a fraction of the time taken by the brute force method to solve the puzzle.
