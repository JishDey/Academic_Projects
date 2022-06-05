public class DeyReversingWordsPhrase{
	
	public static String reversePhrase(String in){
		String out = "";
		int flag = in.lastIndexOf(' ');
		while(!in.equals("") && !(flag == -1)){
			out += in.substring(flag);
			in = in.substring(0, flag);
			in = in.trim();
			flag = in.lastIndexOf(' ');
		}
		out += " " + in.substring(0);
		return out;
	}
	public static String formaString(String in){
		String firstLetter = in.substring(0,1);
		in = in.toLowerCase();
		in = firstLetter.toUpperCase() + in.substring(1);
		int split = in.indexOf('.');
		in = in.substring(0, split) + in.substring(split+1, in.length()) + ".";
		return in;
		
	}
	public static void main(String[] args){
		String monkeyString = "This string contains monkeys.";
		monkeyString = formaString(reversePhrase(monkeyString));
		System.out.println(monkeyString);
	}
}
