class Solution {
    public boolean isValidSudoku(char[][] board) {
        //APPROACH
        //for each non-empty entry check whether valid or not
        //if any invalid entry found return false
        //else return true
        
        //where to check?
        //corrosponding row and col
        //corrosponding box
        
        //time complexity analysis
        //for each box n*n
        //for each entry n+n+n
        //O(n^3);
        
        int n = board.length;
        
        for(int i = 0; i<n; i++)
        {
            for(int j = 0; j<n; j++)
            {
                if(board[i][j] != '.' && !isValid(board, i, j, n)) return false;
            }
        }
        return true;
    }
    
    public boolean isValid(char[][] board, int row , int col, int n)
    {
        char curr = board[row][col];
        
        //scan row
        for(int i = 0; i<n; i++)
        {
            if(i == col) continue;
            if(board[row][i] == curr) return false;
        }
        
        //scan col
        for(int i = 0; i<n; i++)
        {
            if(i == row) continue;
            if(board[i][col] == curr) return false;
        }
        
        //search in box
        for(int i = (row/3)*3; i<(row/3)*3+3 ; i++)
        {
            for(int j = (col/3)*3; j<(col/3)*3+3 ; j++)
            {
                
                if(i == row && j == col) continue;
                if(board[i][j] == curr) return false;
            }
        }
        
        
        
        return true;
    }
}
