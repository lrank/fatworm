package fatworm.util;

public class parseprinter{
	
	String ret = "";
	
	public parseprinter() {
		
	}
	
	public parseprinter(String input) {
		int count = 0;
		for (int i = 0; i < input.length(); ++i) {
			if (input.charAt(i) == '(')
				++count;
			else if (input.charAt(i) == ')')
				--count;
			else if (input.charAt(i) == ' ') {
				ret += '\n';
				for (int j = 0; j < count; ++j)
					ret += "    ";
			}
			else ret += input.charAt(i);
		}
	}
	
	public String tostring() {
		return ret;
	}

}
