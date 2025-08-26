class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int m = dimensions.length;
        double maxDiagonal = 0;
        int area = 0;

        for(int i = 0; i < m; i++){
            double diagonalSqSum = dimensions[i][0]*dimensions[i][0] + dimensions[i][1]*dimensions[i][1];
            double diagonal = Math.sqrt(diagonalSqSum);
            // System.out.println("diagonal: " + diagonal);

            if(maxDiagonal < diagonal){
                maxDiagonal = diagonal;
                area = dimensions[i][0]*dimensions[i][1];
                // System.out.println("MaxDiagonal 1: " + maxDiagonal);
                // System.out.println("Area 1: " + area);
            }
            else if(maxDiagonal == diagonal){
                int curArea = dimensions[i][0]*dimensions[i][1];
                area = Math.max(curArea, area);
                // System.out.println("MaxDiagonal 2: " + maxDiagonal);
                // System.out.println("Area 2: " + area);
            }
        }

        return area;
    }
}