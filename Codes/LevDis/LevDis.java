package Other;

import java.util.Scanner;

/** @author MSaber
 *
 * Given two strings how many minimum edits(update, delete or add) is 
 * needed to convert one string to another
 *
 * Solution :
 *
 * if(str1[i-1] == str2[j-1]){ temp[i][j] = temp[i-1][j-1];}  				  << Diagonally 
 * else{ temp[i][j] = 1 + min(temp[i-1][j-1], temp[i-1][j], temp[i][j-1]);}   << Min(From 3 Diagonally )
 *             
 * Time complexity is O(m*n)
 * Space complexity is O(m*n)
 *
 * **/


// --------------------------- levenshtein Distance / Minimum Edit Distance ----------------------

public class LevDis {

    /** Uses recursion to find minimum edits */

// --------------------------- levenshtein Distance Recursion ------------------------------    
	
    public int LevDisRec(char[]  str1, char str2[], int len1,int len2){
        
        if(len1 == str1.length){
            return str2.length - len2;
        }
        if(len2 == str2.length){
            return str1.length - len1;
        }
        return min(LevDisRec(str1, str2, len1 + 1, len2 + 1) + str1[len1] == str2[len2] ? 0 : 1, 
        		   LevDisRec(str1, str2, len1, len2 + 1) + 1, 
        		   LevDisRec(str1, str2, len1 + 1, len2) + 1);
    }
    
// ----------------------------------------------------------------------------------------
    
    /** Uses bottom up DP to find the edit distance */
    
// --------------------------- levenshtein Distance Dynamic Programming -------------------  
    
    public int LevDisDP (char[] str1, char[] str2){
        int temp[][] = new int[str1.length+1][str2.length+1];
        
        for(int i=0; i < temp[0].length; i++){
            temp[0][i] = i;
        }
        
        for(int i=0; i < temp.length; i++){
            temp[i][0] = i;
        }
        
        for(int i=1;i <=str1.length; i++){
            for(int j=1; j <= str2.length; j++){
                if(str1[i-1] == str2[j-1]){
                    temp[i][j] = temp[i-1][j-1];
                }else{
                    temp[i][j] = 1 + min(temp[i-1][j-1], temp[i-1][j], temp[i][j-1]);
                }
            }
        }
        LevDisPrint(temp, str1, str2);
        return temp[str1.length][str2.length];
        
    }

// ----------------------------- Print Actual Edits ------------------------------------------------------ 
    
    public void LevDisPrint(int T[][], char[] str1, char[] str2) {
        int i = T.length - 1;
        int j = T[0].length - 1;
        while(true) {
            if (i == 0 || j == 0) {
                break;
            }
            if (str1[i-1] == str2[j-1]) {
                i = i-1;
                j = j-1;
            } else if (T[i][j] == T[i-1][j-1] + 1){
           //   System.out.println("Edit (" + str2[j-1] + ")" + " in Second String to (" + str1[i-1] + ") in First String");
                i = i-1;
                j = j-1;
            } else if (T[i][j] == T[i-1][j] + 1) {
         //     System.out.println("Delete in First String (" + str1[i-1] + ")");
                i = i-1;
            } else if (T[i][j] == T[i][j-1] + 1){
         //     System.out.println("Delete in Second String (" + str2[j-1] + ")");
                j = j -1;
            } else {
                throw new IllegalArgumentException("Some wrong with given data");
            }

        }
    }

    private int min(int a,int b, int c){
        int l = Math.min(a, b);
        return Math.min(l, c);
    }

    public static void main(String args[]){
    	
    	Scanner in = new Scanner(System.in);       
        String str1 = in.next();
        String str2 = in.next();
        LevDis editDistance = new LevDis();
        int result = editDistance.LevDisDP(str1.toCharArray(), str2.toCharArray());
        System.out.print(result);
    	
    	
    	
     /*   String str1 = "azced";
        String str2 = "abcdef";
    	System.out.println("First String : [azced]");
    	System.out.println("Second String : [abcdef]");
        LevDis editDistance = new LevDis();
        int result = editDistance.LevDisDP(str1.toCharArray(), str2.toCharArray());
        System.out.print("The Number of Minimum Edit Distance : " + result );   */
        
  
    }

}