class Solution {
    public String multiply(String num1, String num2) {
        if("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        int[] res = new int[num1.length() + num2.length()];
        for(int i = num1.length() - 1;i >= 0;i--) {
            for(int j = num2.length() - 1;j >= 0;j--) {
                int a = num1.charAt(i) - '0';
                int b = num2.charAt(j) - '0';
                int temp = res[i + j + 1] + a * b;
                res[i + j + 1] = temp % 10;  //保留本位结果
                res[i + j] += temp / 10; //进位
            }
        }
        StringBuffer s = new StringBuffer();
        for(int i = 0;i < res.length;i++) {
            if(i == 0 && res[i] == 0) {
                continue;
            }
            s.append(res[i]);
        }
        return new String(s);
    }
}