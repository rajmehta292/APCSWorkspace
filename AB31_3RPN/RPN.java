import java.util.*;


/**
 * RPN Calculator
 *
 * @author Jessica Jiang
 * @version January 14th
 * @author Period: 4
 * @author Assignment: AB31RPN Calculator
 *
 * @author Sources: TODO List Collaborators
 */
public class RPN
{
    Scanner scan = new Scanner( System.in );

    private Stack<Integer> myStack;

    private Queue<String> myQ;


    /**
     * Constructs an RPN Calculator
     */
    public RPN()
    {
        myStack = new Stack<Integer>();
        myQ = new LinkedList<String>();
    }


    /**
     * **** Used for testing - Do Not Remove ***
     * 
     * Constructs an RPN Calculator and then redirects the Scanner scan to the
     * supplied string.
     * 
     * @param console
     *            replaces console scan
     */
    public RPN( String console )
    {
        this();
        scan = new Scanner( console );
    }


    /**
     * TODO Write your method description here.
     */
    public void calculate()
    {
        while ( scan.hasNext() )
        {
            String s = scan.next();
            int counter = 0;
            while( counter < s.length())
            {
                
                char a = s.charAt( counter );
                if ( !( a == 'q' ) && !( a == 'Q' ) )
                {
                    myQ.add( a + "" );
                }
                
                if ( a == 'q' || a == 'Q' )
                {
                    System.out.println( returnString() + "= "
                        + myStack.pop() );
                }
                else if ( a == '*' )
                {
                    multiply();
                }
                else if ( a == '/' )
                {
                    divide();
                }
                else if ( a == '+' )
                {
                    add();
                }
                else if ( a == '-' )
                {
                    subtract();
                }
                else
                {
                    myStack.push( Character.getNumericValue( a ) );
                }
                
                counter++;
            }
        }
   
    }
 
    /**
     * add
     */
    public void add()
    {
       myStack.push( myStack.pop() + myStack.pop() );
    }
    
    /**
     * multiply
     */
    public void multiply()
    {
        myStack.push( myStack.pop() * myStack.pop() );
    }
     
    /**
     * subtract
     */
    public void subtract()
    {
        //int first = myStack.pop();
        //int second = myStack.pop();
        myStack.push( -myStack.pop() + myStack.pop() );   
    }
    
    /**
     * divide
     */
    public void divide()
    {
        int first = myStack.pop();
        int second = myStack.pop();   
        myStack.push( second / first );
    }

    /**
     * turns the Queue into a string
     * @return result the result of the myQ
     */
    public String returnString()
    {
        String print = "";
        while ( !myQ.isEmpty() )
        {
            print += myQ.remove() + " ";
        }
        return print;
    }
    
    /**
     * Instantiates an RPN Calculator and invokes it calculate method
     * 
     * @param args
     *            command-line arguments (not used)
     */
    public static void main( String[] args )
    {
        RPN rpn = new RPN();
        rpn.calculate();
    }
}