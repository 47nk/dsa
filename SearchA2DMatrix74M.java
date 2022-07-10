class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int m = matrix.length;
        int n = matrix[0].length;
        //INITIAL APPROACH -> time complexity nlogm
        // for(int i = 0; i<m; i++)
        // {
        //     if(matrix[i][0]<=target && matrix[i][n-1]>=target)
        //     {
        //         int start = 0;
        //         int end = n-1;
        //         while(start<=end)
        //         {
        //             int mid = start+(end-start)/2;
        //             if(matrix[i][mid] == target)
        //             {
        //                 return true;
        //             }else{
        //                 if(matrix[i][mid]>target)
        //                 {
        //                     end = mid-1;
        //                 }else{
        //                     start = mid+1;
        //                 }
        //             }
        //         }
        //         break;
        //     }
        // }
        // return false;
        
        //time complexity log(m+n)
        int start = 0;
        int end = (m*n)-1;
        while(start<=end)
        {
            int mid = start + (end-start)/2;
            int row = mid/n;
            int col = mid%n;
           
            if(matrix[row][col] == target)
            {
                return true;
            }else{
                if(matrix[row][col]<target)
                {
                    start = mid+1;
                }else{
                    end = mid-1;
                }
            }
            
        }
        return false;
    }
}
