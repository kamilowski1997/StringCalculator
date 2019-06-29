import java.util.ArrayList;

public class StringCalculator {

	public static void main(String[] args) {
		StringCalculator test = new StringCalculator();
		String input = new String("//h\n2,5\n3,-100h-900,1001");
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

	int Add(String numbers) {
		if(numbers == null||numbers.equals("")) {
			return 0;
		}
		if( numbers.contains("\n,")||numbers.contains(",\n")) {
			return 0;
		}
		String defaultDelimeter = null;
		boolean isDefaultDelimeterSet = false;
		if(numbers.startsWith("//")) {
			defaultDelimeter = numbers.substring(2,numbers.indexOf("\n"));
			numbers = numbers.substring(numbers.indexOf("\n")+1);
			isDefaultDelimeterSet = true;

		}
		
		int sum=0;
		ArrayList<Integer> list = new ArrayList<Integer>();
		String[] numbers2 = numbers.split(",");
		
		
		for (int i = 0;i<numbers2.length;i++) {	
			if(numbers2[i].contains("\n")||isDefaultDelimeterSet&&numbers2[i].contains(defaultDelimeter)) {
				String[] numbers3 = numbers2[i].split("\n");
				for(int j =0; j<numbers3.length;j++) {
					
					if(isDefaultDelimeterSet) {
						if(numbers3[j].contains(defaultDelimeter)) {
							String[] numbers4 = numbers3[j].split(defaultDelimeter);
							
							for(int p =0; p<numbers4.length;p++) {
								list.add(Integer.parseInt(numbers4[p]));
							}
						}else {
							list.add(Integer.parseInt(numbers3[j]));
						}
					}
				}
			}else {
				list.add(Integer.parseInt(numbers2[i]));
			}
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
