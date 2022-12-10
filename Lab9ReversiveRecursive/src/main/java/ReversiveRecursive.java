import java.io.EOFException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

public class ReversiveRecursive {
	
	/**
	 * If the string is longer than one character, return the last character of the string plus the result of calling reverse
	 * on the substring of the string minus the last character. Otherwise, return the string
	 *
	 * @param s the string to reverse
	 * @return The last character of the string plus the reverse of the rest of the string.
	 */
	public static String reverse(String s) {
		if(s.length() > 1){
			return s.charAt(s.length()-1) + reverse(s.substring(0, s.length()-1));
		} else{
			return s;
		}
		
	}
	
	public static void wordCount(RandomAccessFile reader, ArrayList<Word> words) throws IOException {
		Word w = new Word(reader.readUTF());
		if (!words.contains(w)) {
			words.add(w);
		} else {

		}
	}
	
	
}
