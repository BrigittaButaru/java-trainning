package tema1;
asd
public class Palindrome {

	static boolean IsPalindrom(String input)
	{		
		boolean palindrom = true;
		int length = input.length();
		for(int i = 0; i < length; i++ )
			System.out.print(input.charAt(i));
		System.out.println("");
		for(int i = 0; i < length/2; i++ )
			if( input.charAt(i) != input.charAt(length -1 - i))
			{
				palindrom = false;
				break;
			}
		
		return palindrom;	
	}
	
	public static void main(String[] args) 
	{
		String input = args[0];
		if( IsPalindrom(input) )
			System.out.println("Este palindrom");
		else
			System.out.println("Nu este palindrom");
	}	
}
