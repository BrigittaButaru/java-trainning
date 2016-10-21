package tema2.ArrayShift;

//import java.lang.*;
import java.util.*;


public class StringArray {
	
	public static void ParseArray(int n, String[] sarray) throws IllegalArgumentException
	{ 		
		int len = sarray.length;
		if( n > len )
			throw new IllegalArgumentException("Input len should be smaller than the length of the string");
				
		System.out.println("The original array is : ");
		for( int i = 0; i < n; i++ )
			System.out.print(sarray[i]);
			
		
		String[] temp = new String[n];
		for( int i = 0; i < n; i++ )		
			temp[i] = sarray[i];
		
		
		System.out.println("The array shifted to the left is : ");
		String[] result = new String[len];
		
		for( int i = n; i < len ; i++ )	
		{
			result[i] = sarray[i];
			System.out.print(result[i]);
		}
		for( int i = 0; i < n; i++ )
		{
			result[i] = temp[i];			
			System.out.print(result[i]);
		}			
	}
	
	public static void ParseQueue(int n, String[] sarray) throws IllegalArgumentException
	{
		int len = sarray.length;
		if( n > len )
			throw new IllegalArgumentException("Input len should be smaller than the length of the string");
	
		Queue<String> queue = new LinkedList<String>();
		for(int i = 0; i < sarray.length; i++)
			queue.add(new String(sarray[i]));
		
		System.out.println("Initial queue: "+ queue.toString());
		
		for(int i = 0; i < n; i++ )
		{
			String str = queue.element();		
			queue.remove();
			queue.add(str);
		}
		
		System.out.println("Shifted queue: "+ queue.toString());		
	}


	public static void main(String[] args) {
		
		
		int n = Integer.parseInt(args[0]);
		
		String[] sarray = { "a", "b", "c", "d", "e"};
		
		try{
			//ParseArray(n, sarray);
			ParseQueue(n, sarray);
		}
		catch(IllegalArgumentException e)
		{
			System.out.println("Error caught: "+ e.getMessage());
					
		}			
	}
}
