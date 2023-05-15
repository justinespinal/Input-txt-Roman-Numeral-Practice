/**
 * This class Node allows users to store info of type RomanNumeral in a Node, which can later be entered into a list
 * @author Justin Espinal
 */
public class Node { //start of class node

    public RomanNumeral data; //make a RomanNumeral variable called data as this will hold what is in the node, which is of type RomanNumeral
    public Node next; //set the next value to a node

    /**
     * This constructor takes a RomanNumeral as input and stores it as data, and points to a dummy null
     * @param d RomanNumeral parameter to be taken as input and stored in the Node
     */
    public Node(RomanNumeral d) //constructor that takes a RomanNumeral as a parameter
    {
        data = d; //set the data in our current node equal to the parameter that was passed
        next = null; //set the next node equal to node as a new node was just created with nothing to point to
    } // constructor
} // class Node