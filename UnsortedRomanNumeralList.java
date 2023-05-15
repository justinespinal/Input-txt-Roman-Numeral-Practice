/**
 * UnsortedRomanNumeralList extends RomanNumeralList and allows the user store RomanNumerals in a list in an unordered fashion
 * @author Justin Espinal
 */
public class UnsortedRomanNumeralList extends RomanNumeralList { //class UnsortedRomanNumeralList
    //we extend RomanNumeralList so that we can access the variables initialized in RomanNumeralList, and use its methods

    /**
     * This method takes a RomanNumeral as a parameter, and appends it to the UnsortedRomanNumeralList in an unordered fashion
     * @param s RomanNumeral as a parameter is being added to the list
     */
    public void append(RomanNumeral s) { //method append
        //since this is UnsortedRomanNumeralList, we used append method to add to the list in no particular order

        Node n = new Node(s); //create a new node to add to the list
        last.next = n; //point the last node to this new node
        last = n; //have the new last node of the list equal to our newly added node
        length++; //increment length by one because we have added one node
    } //end of method append
} //end of class UnsortedRomanNumeralList