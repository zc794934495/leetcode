class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        int x = coordinates[0][0];
        int y = coordinates[0][1];
        int len = coordinates.length;
        for(int i = 1;i < len;i++) {
            coordinates[i][0] -= x;
            coordinates[i][1] -= y;
        }
        int a = coordinates[1][1];
        int b = coordinates[1][0];
        for(int i = 2;i < len;i++) {
            if((a * coordinates[i][0]) - (b * coordinates[i][1]) != 0) {
                return false;
            }
        }
        return true;
    }
}