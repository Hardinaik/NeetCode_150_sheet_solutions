// Time : O(logm) + O(logn)
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        int m=matrix.length;
        int n=matrix[0].length;

        int lrow=0;
        int hrow=m-1;

        int lcol=0;
        int hcol=n-1;

        int row=-1;

        while(lrow<=hrow){
            int mrow=lrow+(hrow-lrow)/2;

            
            if(matrix[mrow][0]<=target && matrix[mrow][n-1]>=target){
                row=mrow;
                break;
            }
            else if(matrix[mrow][0]>target){
                hrow=mrow-1;
            }else{
                lrow=mrow+1;
            }
        }

        if(row==-1)return false;

        while(lcol<=hcol){
            int mcol=lcol+(hcol-lcol)/2;

            if(matrix[row][mcol]==target){
                return true;
            }
            else if(matrix[row][mcol]>target){
                hcol=mcol-1;
            }else{
                lcol=mcol+1;
            }
        }

        return false;
    }
}


// same complexity but better version

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        int m=matrix.length;
        int n=matrix[0].length;

        int low=0;
        int high=m*n-1;

        while(low<=high){
            int mid=low+(high-low)/2;

            int r=mid/n;
            int c=mid%n;

            if(matrix[r][c]==target){
                return true;
            }else if(matrix[r][c]>target){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }

        return false;
    }
}
