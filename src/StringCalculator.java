
public class StringCalculator {

	public static void main(String[] args) {
		StringCalculator test = new StringCalculator();
		String input = new String("2,5");
		int i = test.Add(input);
		System.out.println(i);
	}

	int Add(String numbers) {
		if(numbers == null||numbers.equals("")) {
			return 0;
		}
		int sum=0;
		
		String[] numbers2 = numbers.split(",", 2);
		
		for(int i =0; i<numbers2.length;i++) {
			sum += Integer.parseInt(numbers2[i]);
		}
		
		return sum;
	}
}
