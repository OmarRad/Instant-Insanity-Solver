/**
 * Objects of the class  <b>Cube</b> are used to represent the cubes in the puzzle instant insanity.
 * Each cube memorizes the color of its 6 faces
 *
 * @author Omar Radwan Mohsen
 *
 */

public class Cube {
    /** 
     * The sides of the cube
     */
    private Color up;
    private Color front;
    private Color right;
    private Color back; 
    private Color left;
    private Color down;

    /** 
     * A counter to keep track of how many times the cube's orientation has been altered
     */
    private int counter = 0;

    /** 
     * The original orientation of the cube
     */
    private Color[] identity;

    /** 
     * Object's contructor. The constructor initializes the instance
     * variables.
     * 
     * 
     * @param faces an array of colors for the cube
     *
     */
    public Cube(Color[] faces) {
        identity = new Color[faces.length];
        for(int i = 0; i < faces.length; i++){
            identity[i] = faces[i];
        }
        up = faces[0];
        front = faces[1];
        right = faces[2];
        back = faces[3];
        left = faces[4];
        down = faces[5];
    }

    /** 
     * Object's alteranate contructor. The constructor initializes the instance
     * variables by creating a deep copy of another cube
     * 
     * 
     * @param other another cube to be deep copied by the constructor
     *
     */
    public Cube(Cube other){
        identity = new Color[6];
        //System.out.println(other.up);
        // System.out.println(other.front);
        identity[0] = up = other.up;
        identity[1] = front = other.front;
        identity[2] = right = other.right;
        identity[3] = back = other.back;
        identity[4] = left = other.left;
        identity[5] = down = other.down;
        counter = other.counter;
    }

    /** 
     * Creates a deep copy of this cube
     *
    * @return a deep copy of this cube
    */
    public Cube copy(){
        return new Cube(this);
    }

    /** 
     * Checks if there is an orientation that the cube hasnt been in yet
     *
    * @return return true if and only if a call to the method next would succeed, and false otherwise.
    */
    public boolean hasNext(){
        return counter < 24;
    }

    /** 
     * Each call to the method next changes the orientation of the cube. It throws an exception IllegalStateException if the
     * call to next sets the orientation of the Cube to one that has been seen since the last call to the method reset.
    * 
    */
    public void next() throws IllegalStateException {
        if (counter > 23){
            //throw exception
            throw new IllegalStateException("No more new cube orientations since last reset");
        }
        else if (counter % 4 != 0){
            //Rotate
            Color tmp = front;
            front = left;
            left = back;
            back = right;
            right = tmp;
        }
        else if((0<counter && counter<9) || counter>19){
            //RightRoll
            Color tmp = up;
            up = left;
            left = down;
            down = right;
            right = tmp;
        }
        else if(counter == 0){
            //Identity
            reset();
        }
        else{
            //LeftRoll
            Color tmp = up;
            up = right;
            right = down;
            down = left;
            left = tmp;
        }
        counter++;
    }

    /** 
     * The method reset puts the cube in its original orientation (the orientation that the cube had when it was first created)
    * 
    */
    public void reset(){
        up = identity[0];
        front = identity[1];
        right = identity[2];
        back = identity[3];
        left = identity[4];
        down = identity[5];
        counter = 0;
    }

    /** 
     * Getter for up
     *
    * @return up
    */
    public Color getUp(){
        return up;
    }
    
    /** 
     * Getter for front
     *
    * @return front
    */
    public Color getFront(){
        return front;
    }

    /** 
     * Getter for right
     *
    * @return right
    */
    public Color getRight(){
        return right;
    }

    /** 
     * Getter for back
     *
    * @return back
    */
    public Color getBack(){
        return back;
    }

    /** 
     * Getter for left
     *
    * @return left
    */
    public Color getLeft(){
        return left;
    }

    /** 
     * Getter for down
     *
    * @return down
    */
    public Color getDown(){
        return down;
    }

    /** 
     * Returns a string representation the cube
     * 
    * @return [up, front, right, left, down]
    */
    public String toString(){
        return "[" + up + ", " + front + ", " + right + ", " + back + ", " + left + ", " + down + "]";
    }
}