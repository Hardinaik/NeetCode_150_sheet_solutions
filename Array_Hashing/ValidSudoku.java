class Solution {
    public boolean isValidRow(char[][] board,int i){
        boolean row[]=new boolean[10];

        for(int j=0;j<9;j++){

            if(board[i][j]=='.'){
                continue;
            }

            int num=board[i][j]-'0';

            if(row[num]){
                return false;
            }

            row[num]=true;
        }

        return true;
    }

    public boolean isValidCol(char[][] board,int i){
        boolean col[]=new boolean[10];

        for(int j=0;j<9;j++){

            if(board[j][i]=='.'){
                continue;
            }
            int num=board[j][i]-'0';

            if(col[num]){
                return false;
            }

            col[num]=true;
        }

        return true;
    }

    public boolean isValidGrid(char[][] board,int grid){
        int srow=(grid/3)*3;
        int scol=(grid%3)*3;

        boolean arr[]=new boolean[10];

        for(int i=srow;i<srow+3;i++){
            for(int j=scol;j<scol+3;j++){

                if(board[i][j]=='.'){
                    continue;
                }
                int num=board[i][j]-'0';

                if(arr[num]){
                    return false;
                }

                arr[num]=true;
            }
        }

        return true;
    }


    public boolean isValidSudoku(char[][] board) {
        int n=board.length;

        for(int i=0;i<n;i++){
            if(!isValidRow(board,i)){
                return false;
            }
        }

        for(int i=0;i<n;i++){
            if(!isValidCol(board,i)){
                return false;
            }
        }

        for(int i=0;i<n;i++){
            if(!isValidGrid(board,i)){
                return false;
            }
        }

        return true;
    }
}
