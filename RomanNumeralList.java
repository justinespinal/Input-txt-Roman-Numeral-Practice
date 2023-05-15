import java.util.Iterator;
/**
 * This class will act as a umbrella class for our later defined classes of UnsortedRomanNumeralList and SortedRomanNumeralList through inheritance so we can define variable types of them
 * @author Justin Espinal
 */
public class RomanNumeralList { //class RomanNumeralList

    //here we initialize instance variables of type Node for first, last, and length of the list. These are protected so they can later be accessed by child classes
    protected Node first;
    protected Node last;
    protected int length;

    /**
     * This class allows the user to iterate through a linked list, and do operations on the node found through the iterator
     *
     */
    private class IteratorClass implements Iterator < RomanNumeral > { //we now add an Iterator so that we can later iterate through each part of the List and print it to the GUI
        private Node firstNode;

        /**
         * constructor to set the first node to the node after our dummy node
         */
        public IteratorClass() //add a constructor to set the firstNode of our iterator to the next node in the list, as the first node in our list is a dummy node containing null
        {
            firstNode = first.next;
        }

        /**
         * allows the user to check if there are more nodes in a list
         * @return boolean returns true if the iterator has another node, false if not
         */
        public boolean hasNext() { //method hasNext check if the next part of the list points to anything. if it does not then that list does not have another node
            return (firstNode.next != null);
        }

        /**
         * allows the user to get the value of a node
         * @return RomanNumeral returns the data in our current node when called
         */
        public RomanNumeral next() { //method next is of type RomanNumeral, and returns the current data in our node when called
            RomanNumeral currentData = firstNode.data;
            firstNode = firstNode.next;
            return currentData;
        }
    }

    /**
     * constructor for RomanNumeralList that adds a dummy node to the current list and sets length to 0
     */
    public RomanNumeralList() { //constructor for RomanNumeralList
        Node ln = new Node(null); //we first initialize a dummy node using the dummy class by passing null
        first = ln;
        last = ln;
        length = 0;
        //we then set the first and last node of the list to the dummy node as nothing has been stored yet
    }

    /**
     * This method allows users to identify if two RomanNumeralLists are equal to each other
     * @param other passes a RomanNumeralList object as a parameter to compare
     * @return boolean if a RomanNumeralList is equal to another RomanNumeralList, return true and if not return false
     */
    public boolean equals(Object other) { //equals method for RomanNumeralList to check if two lists are equal to one another
        if (other == null || getClass() != other.getClass() ||
            length != ((RomanNumeralList) other).length)
            return false; //if the parameter is equal to null, the classes are not equal, or length is not equal then return null as they are not equal

        Node nodeThis = first; //grab the first node of one list
        Node nodeOther = ((RomanNumeralList) other).first; // grab the first node of the second list
        while (nodeThis != null) {
            // Since the two linked lists are the same length,
            // they should reach null on the same iteration.

            if (nodeThis.data != nodeOther.data) //sort through both list until we find data that is not equal, if so we return false
                return false;

            //then we make both list point to their next node and repeat until both lists = null
            nodeThis = nodeThis.next;
            nodeOther = nodeOther.next;
        } // while

        return true; //if we reach this point we return true because both lists are equal
    } // method equals

    /**
     * This method allows the user to store an entire list as a string
     * @return String returns the entire list as a string
     */
    public String toString() { //method toString to RomanNumeralList
        //this method is simply just to test if the lists were sorted correctly by being able to print them to the console
        Node p = first.next;
        String returnString = "";
        while (p != null) {
            returnString += p.data + " ";
            p = p.next;
        }
        return returnString; //this would print (firstNumeral) (secondNumeral) ... (NthNumeral)
    }

    /**
     * Allows the user to iterate through a list to access the list's nodes
     * @return Iterator<RomanNumeral> returns a new iterator for the user to use
     */
    public Iterator < RomanNumeral > travIterator() { //this method is used to traverse the Iterator, and when called returns the IteratorClass
        return new IteratorClass();
    }

} //end of RomanNumeralList