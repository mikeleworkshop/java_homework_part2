
public class SmsMessage {
	public static void main(String[] args) {		
		System.out.println(solution("SMS messages are really short", 12));
	}
	
	public static int solution(String S, int K) {
		String[] words = S.split(" ");
		
		int splittedMessage = 1;
		int countWordLength = 0;
		
		// On
		for (String string : words) {
			int stringLength = string.length();
			
			if (stringLength > K) {
				return -1;
			}
			
			if (countWordLength == 0) {
				countWordLength = stringLength;
			} else if (countWordLength + 1 + stringLength <= K) {
				countWordLength += 1 + stringLength;
			} else {
				splittedMessage++;
				countWordLength = stringLength;
			}
		}
		
		return splittedMessage;
    }
}
