class Solution {
    public void binarySequence() {
        Scanner sc=new Scanner(System.in);
        int num=sc.nextInt();
        System.out.print("odd:");
        for(int i = 30;i >= 0;i -= 2){
            //按位与1，省去奇数位前的0
            System.out.print((num >> i) & 1);
        }
        System.out.print("   even:");
        for(int i = 31;i > 0;i -= 2){
            System.out.print((num >> i) & 1);
        }
        sc.close();
    }