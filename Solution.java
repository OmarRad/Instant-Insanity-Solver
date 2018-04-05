/**
 * Objects of the class <b>Solution</b> represent partial solutions to the problem. A solution stores 1, 2, 3 or 4 cubes/
 * A Solution is a data structure to store cubes. It represents a partial solution to the instant insanity problem. It portrays a pile
 * of n cubes, where n ∈ [1, 2, 3, 4].
 * @author Omar Radwan Mohsen
 *
 */
public class Solution {
    /** 
     * An array of the cubes of a solution
     */
    private Cube[] cubes;

    /** 
     * Number of calls to isValid() 
     */
    private static int numberOfCalls = 0;

    /** 
     * Object's contructor. The constructor initializes the instance
     * variables.
     * 
     * 
     * @param cubes an array of colors for the solution
     *
     */
    public Solution(Cube[] cubes){
        //initializes this solution using the cubes provided in the array cubes. Because the cubes are
        //mutable, the solution must also copy the cubes.
        this.cubes = new Cube[cubes.length];
        for(int i = 0; i < cubes.length; i++) {
            this.cubes[i] = new Cube(cubes[i]);
        }
    }

    /** 
     * Object's alteranate contructor. The constructor initializes the instance
     * variables by creating a deep copy of another solution and adding a new cube to it
     * 
     * 
     * @param other another solution to be deep copied by the constructor
     * @param c a cube to be added to the solution
     */
    public Solution(Solution other, Cube c){
        if(other == null){
            this.cubes = new Cube[4];
            this.cubes[0] = new Cube(c);
        }
        else if(c == null){
            System.out.println("A cube is null");
        }
        else{
            this.cubes = new Cube[other.size() + 1];
            for(int i = 0; i < other.size(); i++){
                this.cubes[i] = new Cube(other.cubes[i]);
            }
            this.cubes[other.size()] = new Cube(c);
        }
    }

    /** 
     * returns the logical size of the data structure. In other words, it returns the number of cubes that are stored in
     * this solution
    * @return the size of the data structure
    */
    public int size(){
        int size = 0;
        for(int i = 0; i < cubes.length; i++){
            if (cubes[i] == null) {
                break;
            } else {
                size++;
            }
        }
        return size;
    }

    /** 
     * returns the reference of the Cube at the specified position.
     * 
    * @return returns the reference of the Cube at the specified position
    */
    public Cube getCube(int pos){
            return cubes[pos];
    }

    /** 
     * returns true if each side of the pile of cubes has no duplicated colour, and false otherwise
     *
    * @return true if each side of the pile of cubes has no duplicated colour, and false otherwise
    */
    public boolean isValid(){
        numberOfCalls++;
        for(int i = 0; i < cubes.length - 1; i++){
            for(int j = i+1; j < cubes.length; j++){
                if(cubes[i] == null || cubes[j] == null){
                    continue;
                }
                if (cubes[i].getFront() == cubes[j].getFront() || cubes[i].getRight() == cubes[j].getRight() || cubes[i].getBack() == cubes[j].getBack() || cubes[i].getLeft() == cubes[j].getLeft()){
                    return false;
                }
            }
        }
        return true;
    }

    /** 
     * returns true the solution would remain valid when adding the cube designated by next to
     * the solution, and false otherwise
    * @return returns true the solution would remain valid when adding the cube designated by next to the solution, and false otherwise
    */
    public boolean isValid(Cube next){
        numberOfCalls++;
        for(int i = 0; i < cubes.length; i++){
            if(cubes[i] == null){
                continue;
            }
            if (cubes[i].getFront() == next.getFront() || cubes[i].getRight() == next.getRight() || cubes[i].getBack() == next.getBack() || cubes[i].getLeft() == next.getLeft()){
                return false;
            }
        }
        return true;
    }

    /** 
     * returns a String representation of the solution
     *
    * @return a String representation of the solution
    */
    public String toString(){
        String string = "";
        for(int i = 0; i < cubes.length; i++){
            if(cubes[i] == null){
                string += "Cube: null \n";
            }
            else{
            string += "Cube " + String.valueOf(i+1) + ": " + cubes[i].toString() + "\n";
            }
        }
        return string;
    }

    /** 
     * Getter for numberOfCalls
     *
    * @return numberOfCalls
    */
    public static int getNumberOfCalls(){
        return numberOfCalls;
    }

    /** 
     * used to intialize numberOfCalls
     * resets numberOfCalls to 0
    */
    public static void resetNumberOfCalls(){
        numberOfCalls = 0;
    }
}