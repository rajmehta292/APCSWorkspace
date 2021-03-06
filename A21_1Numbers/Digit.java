/**
 * Each individual component of a number
 * 
 * Write a digit class that represents a single digit with a given base. The
 * digit class has two constructors. The default constructor sets the base at 10
 * and the value to 0. The other constructor accepts a decimal value and a base.
 * Create a toString method and an increment method. The increment method should
 * return a boolean: true if there is a carry and false if not.
 * 
 * For both classes, you can assume that the bases are restricted to binary,
 * octal, decimal or hexadecimal and the values are non-negative.
 * 
 * @author Jessica Jiang
 * @version April 1, 2015
 * @author Period - 4
 * @author Assignment - TODO Assignment Name
 * @author Sources - TODO list collaborators
 */
public class Digit
{
    int base;
    int value;



    public Digit( int myValue, int myBase )
    {
        value = myValue;
        base = myBase;
    }
    
    public Digit()
    {
        new Digit( 0, 10 );
    }


    public boolean increment()
    {
        if ( value == base - 1 )
        {
            value = 0;
            return true;
        }
        else
        {
            value++;
            return false;
        }
    }


    public String toString()
    {
        if ( value < 10 )
            return "" + value;
        char c = (char)( value - 10 + 'A' );
        return "" + c;
    }

}
