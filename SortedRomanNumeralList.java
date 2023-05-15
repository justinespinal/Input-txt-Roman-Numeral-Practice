/**
 * SortedRomanNumeralList extends RomanNumeralList, and allows a user to make a RomanNumeralList that is in an ordered fashion, unlike UnsortedRomanNumeralList
 *
 */
public class SortedRomanNumeralList extends RomanNumeralList { //start of class SortedRomanNumeralList
    //we extend RomanNumeralList so that we can access the variables initialized in RomanNumeralList, and use its methods

    /**
     * The add method allows the user to add a RomanNumeral to the list in an ordered fashion when called
     * @param n RomanNumeral that is being added to the SortedRomanNumeralList
     */
    public void add(RomanNumeral n) //method add
    {
        //since this is the SortedRomanNumeralList, we have to add nodes to the list in an ordered fashion.

        Node current = first; //first we set our current node to the first node in our list
        while (current.next != null && (n.compareTo(current.next.data) > 0)) //we sort through each node while we are not at the end of the list and our new node is greater then our current
        {
            current = current.next; //set current equal to the node in front
        } //once we end this while loop, that means we have found a spot to put our node

        Node newNode = new Node(n); //create a new node for the Roman Numeral passed through our parameters
        newNode.next = current.next; //set this new node to point to the node in front of its designated position
        current.next = newNode; //set the current node we are at to the new node to finally add it to the list
    } //end of add method

} //end of class SortedRomanNumeralList