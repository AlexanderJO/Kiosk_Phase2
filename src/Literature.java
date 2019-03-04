import java.util.HashSet;

/**
 * Write a description of class Literature here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Literature
{
    // instance variables - replace the example below with your own
    private HashSet<String> mySet = new HashSet<>();

    /**
     * Constructor for objects of class Literature
     */
    public Literature()
    {
        // initialise instance variables
        this.mySet = new HashSet<>();
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void addMySet(int y)
    {
        // put your code here
        mySet.add("One");
        mySet.add("Two");
        
        int count = 0;
        for ( String element : mySet )
        {
            count++;
        }
        
        System.out.println(count);
    }
}
