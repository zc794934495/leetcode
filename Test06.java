package Test;

public class Test06 {

	public static void main(String[] args) {
		int n = 2;
		int res = 1;
		while((getOnly(n) + res) != n) {
			res += getOnly(n);
			++n;
		}
		System.out.println(n);
	}

	static int getOnly(int num) {
		// TODO Auto-generated method stub
		int number = 0;
		String s = num + "";
		int len = s.length();
		System.out.println(len);
		if(len != 0) {
			for(int i = 0;i < len;i++) {
				char a = s.charAt(i);
				if(a == '1') {
					number++;
				}
			}
		}
		return number;
	}
}
