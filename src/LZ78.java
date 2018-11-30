import java.util.Vector;
import java.util.Scanner;
public class LZ78 {
	public static void main(String[] args) {
		Vector<Short> t1= new Vector<Short>();
		Vector<Character> t2= new Vector<Character>();
		Vector<String> d = new Vector<String>();
		
		d.add(null);
		
		String x;
		System.out.print("Please Enter a string: ");
		Scanner n = new Scanner (System.in);
		x = n.nextLine();
		
		int counter = 0;
		String tmp ="";
		short numtmp=0;
		while (counter < x.length())
		{
			//
			tmp += x.charAt(counter);
			if (!d.contains(tmp))
			{
				d.add(tmp);
				t1.add(numtmp);
				t2.add(tmp.charAt(tmp.length()-1));				
				tmp = "";
			}
			else 
			{
				numtmp = (short)d.indexOf(tmp);
				if (counter == x.length()-1)
				{
					d.add(tmp);
					t1.add(numtmp);
					t2.add(null);
				}
					
				
			}
			counter++;
		}
//		System.out.println("*****************Printing tags*****************");
//		for (int i = 0; i < t1.size(); i++)
//		{
//			System.out.print("<"+t1.get(i)+","+t2.get(i)+"> - ");
//		}
//		System.out.println("\n*****************Printing Dictionary*****************");
//		for (int i = 0; i < t1.size(); i++)
//		{
//			System.out.println(d.get(i));
//		}
		
		
		
		// Decompression 
		
		String newString="", tmp2 ="";
		Vector<String> d2 = new Vector<String>();
		d2.add(null);
		
		for (int i = 0; i < t1.size(); i++)
		{
			if (t1.get(i) == 0) 
			{
				newString+=t2.get(i);
				tmp2+=t2.get(i);
				d2.add(tmp2);
				tmp2="";
			}
			else
			{
				newString+=d2.get(t1.get(i));
				tmp2= d2.get(t1.get(i)) + t2.get(i);
				if (t2.get(i)!=null)
				{
					newString+=t2.get(i);
					d2.add(tmp2);
				}
				tmp2="";
			}
		}
		
		System.out.println(newString);
		
		System.out.println("\n*****************Printing Dictionary*****************");
		for (int i = 0; i < d2.size(); i++)
		{
			System.out.println(d2.get(i));
		}
		
		
	}

}
