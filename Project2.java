//Justin Espinal Project2
import java.util.*;

/**
 * This project will take a text file filled with Roman Numerals, print them to a GUI, then print their sorted and unsorted Arabic counterparts
 * @author Justin Espinal
 */
public class Project2 { //start of project 2
    public static StringTokenizer myTokens; //Initialize myTokens globally so it can be changed anywhere
    //in the program

    /**
     * Main is where the TextFileInput is initialized and RomanNumeralGUI is called
     * @param args command line arguments from the user
     */
    public static void main(String[] args) //start of main
    {
        //initialize a TextFileInput variable to take in input from a file on the computer
        TextFileInput myFile = new TextFileInput("input.txt");

        //create an UnsortedRomanNumeralList and SortedRomanNumeralList to store the
        //Roman value from the text file
        UnsortedRomanNumeralList unSort = new UnsortedRomanNumeralList();
        SortedRomanNumeralList sorted = new SortedRomanNumeralList();

        String line = myFile.readLine(); //create a string variable to store a line from the text file and later tokenize
        myTokens = new StringTokenizer(line, ","); //set the StringTokenizer to tokenize our previously initialized String

        while (line != null) //we continue the while loop until we hit a line with no tokens/characters on it
        {
            if (myTokens.hasMoreTokens()) //if my current line contains tokens we enter that token into the current index(i)
            {
                RomanNumeral rom = new RomanNumeral(myTokens.nextToken()); //Create a RomanNumeral variable and set it equal to the current token
                unSort.append(rom); //append this new RomanNumeral (rom) to the UnsortedRomanNumeralList using the appen method
                sorted.add(rom); //add this new RomanNumeral(rom) to the SortedRomanNumeralList using the add method
            }
            if (!myTokens.hasMoreTokens()) //if after entering a numeral and we are now out of tokens, go to the next line!
            {
                line = myFile.readLine(); //reinitialize line to the next line, this must be done each time we go to another line
                //if we do this and hit a line thats null then we are done, but if we don't, we recall the myTokens and enter the new line
                if (line != null) myTokens = new StringTokenizer(line, ",");
                //this is done to avoid an error occurring! When line == null, then there are no more tokens in the text file and we can stop
            }
        } //end of while loop

        RomanNumeralGUI myGUI = new RomanNumeralGUI(unSort, sorted); //Initialize a new RomanNumeralGUI and pass the new linked list

        myGUI.setVisible(true);
        myFile.close();
    }
}