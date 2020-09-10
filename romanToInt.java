class Solution {
    public int romanToInt(String s) {
        int sum = 0;
        int num1 = getValue(s.charAt(0));
        for(int i = 1;i < s.length();i++){
            int num2 = getValue(s.charAt(i));
            if(num1 >= num2){
                sum = sum + num1;
            }else{
                sum = sum - num1;
            }
            num1 = num2;
        }
        sum = sum + num1;
        return sum;

    }

    public int getValue(char m){
        switch(m){
            case 'I' : return 1;
            case 'V' : return 5;
            case 'X' : return 10;
            case 'L' : return 50;
            case 'C' : return 100;
            case 'D' : return 500;
            case 'M' : return 1000;
            default : return 0;

        }
    }
}