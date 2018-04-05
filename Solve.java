/**
 * The class  <b>Solve</b> provides two methods for solving the instant insanity problem: breadthFirstSearch and generateAndTest.
 * 
 *
 * @author Omar Radwan Mohsen
 *
 */
public class Solve {

    /** 
     * finds all the solutions to the instant insanity problem by
     * exhaustively generating all the possible solutions. It returns a Queue that contains all the valid solutions to the problem
    * @return a queue that contains all the valid solutions to the problem
    */
    public static CircularQueue<Solution> generateAndTest(){
        Solution.resetNumberOfCalls();
        Solution solution;
        CircularQueue queue =  new CircularQueue(24*24*24*24);
        Cube[] cubeStack = new Cube[4];
        cubeStack[0] = new Cube(new Color[]{Color.BLUE, Color.GREEN, Color.WHITE, Color.GREEN, Color.BLUE, Color.RED});
        cubeStack[1] = new Cube(new Color[]{Color.WHITE, Color.GREEN, Color.BLUE, Color.WHITE, Color.RED, Color.RED});
        cubeStack[2] = new Cube(new Color[]{Color.GREEN, Color.WHITE, Color.RED, Color.BLUE, Color.RED, Color.RED});
        cubeStack[3] = new Cube(new Color[]{Color.BLUE, Color.RED, Color.GREEN, Color.GREEN, Color.WHITE, Color.WHITE});
        for(int i = 0; i < cubeStack.length; i++){
            cubeStack[i].reset();
        }
        while(cubeStack[0].hasNext()){
            cubeStack[0].next();
            cubeStack[1].reset();
            while(cubeStack[1].hasNext()){
                cubeStack[1].next();
                cubeStack[2].reset();
                while(cubeStack[2].hasNext()){
                    cubeStack[2].next();
                    cubeStack[3].reset();
                    while(cubeStack[3].hasNext()){
                        cubeStack[3].next();
                        solution = new Solution(cubeStack);
                        if(solution.isValid()){
                            queue.enqueue(solution);
                        }
                    }
                }
            }
        }
        System.out.println(Solution.getNumberOfCalls());
        return queue;
    }

    /** 
     * finds all the solutions to the instant insanity problem by
     * using a breadth-first search algorithm. It returns a Queue that contains all the valid solutions to the problem
    * @return a queue that contains all the valid solutions to the problem
    */
    public static CircularQueue<Solution> breadthFirstSearch(){
        Solution.resetNumberOfCalls();
        int numSolutions = 0;
        CircularQueue<Solution> open = new CircularQueue<Solution>(24*24*24*24);
        CircularQueue<Solution> solutions = new CircularQueue<Solution>(24*24*24*24);
        Cube[] cubeStack = new Cube[4];
        cubeStack[0] = new Cube(new Color[]{Color.BLUE, Color.GREEN, Color.WHITE, Color.GREEN, Color.BLUE, Color.RED});
        cubeStack[1] = new Cube(new Color[]{Color.WHITE, Color.GREEN, Color.BLUE, Color.WHITE, Color.RED, Color.RED});
        cubeStack[2] = new Cube(new Color[]{Color.GREEN, Color.WHITE, Color.RED, Color.BLUE, Color.RED, Color.RED});
        cubeStack[3] = new Cube(new Color[]{Color.BLUE, Color.RED, Color.GREEN, Color.GREEN, Color.WHITE, Color.WHITE});
        for(int i = 0; i < cubeStack.length; i++){
            cubeStack[i].reset();
        }
        while(cubeStack[0].hasNext()){
            cubeStack[0].next();
            Cube cube = cubeStack[0].copy();
            Solution tmp = new Solution(null, cube);
            open.enqueue(tmp);
        }
        cubeStack[0].reset();
        while(!open.isEmpty()){
            Solution current = open.dequeue();
            while(cubeStack[current.size()].hasNext()){
                cubeStack[current.size()].next();
                if(current.isValid(cubeStack[current.size()])){
                    Solution current2 = new Solution(current, cubeStack[current.size()]);
                    if(current2.size() == 4){
                        numSolutions++;
                        solutions.enqueue(current2);
                    }
                    else {
                        open.enqueue(current2);
                    }
                }    
            }
            cubeStack[current.size()].reset();
        }
        System.out.println(Solution.getNumberOfCalls());
        return solutions;
    }
    
    /** 
     * The main class calls on generateAndTest() and breadthFirstSearch() and compares the performance of both of them and displaying the number of times the method isValid() was called by each of them.
     * 
    * @return a queue that contains all the valid solutions to the problem
    */
    public static void main(String[] args){
        StudentInfo.display();
        long start, stop;

        System.out.println("generateAndTest:");
        start = System.currentTimeMillis();

        generateAndTest();

        stop = System.currentTimeMillis();
        System.out.println("Elapsed time " + (stop - start) + " milliseconds");

        System.out.println("breadthFirstSearch:");
        start = System.currentTimeMillis();

        breadthFirstSearch();

        stop = System.currentTimeMillis();
        System.out.println("Elapsed time " + (stop - start) + " milliseconds");
    }
}