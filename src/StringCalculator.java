import java.util.ArrayList;

public class StringCalculator {

	public static void main(String[] args) {
		StringCalculator test = new StringCalculator();
		String input = new String("//[hhh]\n2,5\n3,-100hhh900,1001");
		int i = test.Add(input);
		System.out.println(i);
	}
	
	class NegativeNumberException extends Exception
	{

	      public NegativeNumberException() {}

	      public NegativeNumberException(String message)
	      {
	         super(message);
	      }
	 }

	String[] Split(String[] tab, String delimeter) {
		ArrayList<String> stringArr = new ArrayList<String>();
		for (int i = 0;i<tab.length;i++) {	
			String[] numbers3 = tab[i].split(delimeter);
			for(int j=0;j<numbers3.length;j++) {
				stringArr.add(numbers3[j]);
			}
		}
		
		return stringArr.toArray(new String[stringArr.size()]);
	}
	
	
	int Add(String numbers) {
		if(numbers == null||numbers.equals("")) {
			return 0;
		}
		if( numbers.contains("\n,")||numbers.contains(",\n")) {
			return 0;
		}
		String defaultDelimeter = null;
		if(numbers.startsWith("//")) {
			for(int i =2;i<numbers.indexOf("\n");i++) {
				if(numbers.charAt(i) ==']') {
					defaultDelimeter = (numbers.substring(3,i));
					numbers = numbers.substring(0,2)+numbers.substring(i+1);
				}
			}
			numbers = numbers.substring(numbers.indexOf("\n")+1);
		}
		
		
		int sum=0;
		ArrayList<Integer> list = new ArrayList<Integer>();
		String[] numbers2 = numbers.split(",");
		

		numbers2 = Split(numbers2,"\n");
		numbers2 = Split(numbers2, defaultDelimeter);
		
		
		
		
		for(String i:numbers2) {
			list.add(Integer.parseInt(i));
		}
		
		for(Integer i:list) {
		
			try{
				if(i>0) {
					if(i<=1000) {
						sum += i;
					}
				}else {
					throw new NegativeNumberException("Negatives not allowed "+ i.toString());
				}
				
			}catch(NegativeNumberException e) {
				System.err.println(e.getMessage());
			}
			
		}
		
		return sum;
	}
}
