import java.awt.*; //import the necessary libraries so we can utilize them in the class RomanNumeralGUI
import java.util.*;
import javax.swing.*;

/**
 * This RomanNumeralGUI class extends JFrame, and sets up a grid layout of 1 row and 3 columns. It also traverses through two list and prints them to the GUI, along with a text file
 * @author Justin Espinal
 */
public class RomanNumeralGUI extends JFrame { //RomanNumeralGUI class. extend JFrame to our new class so it takes on all attributes of JFrame through inheritance

    TextFileInput myFile = new TextFileInput("input.txt"); //take in TextFileInput by creating a new TextFileInput variable

    /**
     * This constructor takes two lists as parameters and prints them to a GUI. It also prints the tokens of a text file
     * @param unsort unsort holds the filled UnsortedRomanNumeralList to be printed to the GUI
     * @param sort sort holds the filled SortedRomanNumeralLit to be printed to the GUI
     */
    public RomanNumeralGUI(UnsortedRomanNumeralList unsort, SortedRomanNumeralList sort) //now we make a constructor for our new class and pass the unsorted and sorted list!
    { //here we will recount the amount of tokens in our text file and append them to our GUI, while also appending the two lists

        GridLayout grid = new GridLayout(1, 3); //set the GridLayout to (1,3) so we have 3 slots for the Roman Numerals, converted unsorted list, and converted sorted list
        setLayout(grid); //setting the layout of the GUI using the GridLayout we initialized above called grid
        setSize(800, 500); //we set a random size with good readability for the user
        setTitle("Roman Numeral to Arabic Numbering"); //set a title that talks about what we are doing
        setLocation(500, 100); //make the GUI appear at (500,100) on the screen

        String line = myFile.readLine(); //take in a line from the text file and store it in line
        StringTokenizer myTokens = new StringTokenizer(line, ","); //have the StringTokenizer tokenize our current line and separate each token by a ,

        Iterator < RomanNumeral > myIteratorUnSort = unsort.travIterator(); //create a new iterator to iterate through the unsorted RomanNumeralList
        Iterator < RomanNumeral > myIteratorSort = sort.travIterator(); //create a new iterator to iterate through the sorted RomanNumeralList

        Container myContentPane = getContentPane(); //make a Container to store the Roman Numerals and Arabic Values we want to print

        TextArea myNumerals = new TextArea(); //make a TextArea to store myNumerals
        TextArea myUnsort = new TextArea(); //make a TextArea to store the unsorted RomanNumerals
        TextArea mySort = new TextArea(); //make a TextArea to store the sorted RomanNumerals

        //now we add these new text areas to our previously defined content pane
        myContentPane.add(myNumerals);
        myContentPane.add(myUnsort);
        myContentPane.add(mySort);

        //append title lines to each column of the GUI that corresponds to what will be shown
        myNumerals.append("My Roman Numerals \n---------------------------- \n");
        myUnsort.append("Unsorted Arabic \n--------------------- \n");
        mySort.append("Sorted Arabic \n------------------ \n");

        while (line != null) { //now we sort through the text file until we are out of tokens and line is equal to null

            //set new RomanNumera values to the next node in the iterator using .next
            RomanNumeral myNumUnSort = myIteratorUnSort.next();
            RomanNumeral myNumSort = myIteratorSort.next();

            if (myTokens.hasMoreTokens()) //if my current line has more tokens then we print to the GUI those tokens
            {
                myNumerals.append(myTokens.nextToken() + "\n"); //append the current token to the numeral column
                myUnsort.append(myNumUnSort.getArabic() + "\n"); //append the current RomanNumeral in the unsorted list to the unsorted numeral column and convert to Arabic with getArabic()
                mySort.append(myNumSort.getArabic() + "\n"); //append the current RomanNumeral in the sorted list to the sorted numeral column and convert to Arabic with getArabic()
            }
            if (!myTokens.hasMoreTokens()) //if after entering a numeral and we are now out of tokens, go to the next line!
            {
                line = myFile.readLine(); //this must be done each time we go to another line
                //if we do this and hit a line thats null then we are done, but if we don't, we recall the myTokens and enter the new line
                if (line != null) myTokens = new StringTokenizer(line, ",");
                //this is done to avoid an error occurring!
            }
        }

        //now we have append all of our information and have finished
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //EXITS the program once the GUI is closed
        myFile.close();

    } //end of constructor
} //end of class RomanNumeralGUI