import java.util.ArrayList;

public class StringCalculator {

	public static void main(String[] args) {
		StringCalculator test = new StringCalculator();
		String input = new String("2,5\n3,100");
		int i = test.Add(input);
		System.out.println(i);
	}

	int Add(String numbers) {
		if(numbers == null||numbers.equals("")) {
			return 0;
		}
		if( numbers.contains("\n,")||numbers.contains(",\n")) {
			return 0;
		}
		int sum=0;
		ArrayList<Integer> list = new ArrayList<Integer>();
		String[] numbers2 = numbers.split(",");
		
		
		for (int i = 0;i<numbers2.length;i++) {	
			if(numbers2[i].contains("\n")) {
				String[] numbers3 = numbers2[i].split("\n");
				for(int j =0; j<numbers3.length;j++) {
					list.add(Integer.parseInt(numbers3[j]));
				}
			}else {
				list.add(Integer.parseInt(numbers2[i]));
			}
		}
		
		for(Integer i:list) {
			sum += i;
		}
		
		return sum;
	}
}
