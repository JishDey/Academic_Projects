public class DeyIsbnMethod{
	public static boolean isValidIsbn(String isbn){
		int length = isbn.length();
		int sum = 0;
		int num;
		boolean flag = true;
		for(int i = 0; i<length; i++){
			Character currentChar = isbn.charAt(i);
			num = Character.digit(currentChar, 10);
			//System.out.println(num);
			if (num >= 0 && flag){
				sum += num;
				//System.out.println(flag);
				flag = !flag;
			}
			else if (num >= 0) {
				sum += (3 * num);
				//System.out.println(flag);
				flag = !flag;
			}
		}
		return sum%10 == 0;
	}
	
	public static void main(String[] args){
		System.out.println(isValidIsbn("978-0-2625374-4-5"));
	}
}
