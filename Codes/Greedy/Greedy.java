package Greedy;

import java.util.Arrays;

public class Greedy {

		int swaps = 0 ;
		int swapf = 0 ;
		
		public void sort (int [] s , int [] f){
		
			for(int i = 0 ; i < s.length-1 ; i++){
				for(int j = 0; j < s.length-1-i ; j++){
					 if(f[j] > f[j+1]){
							    	
						 swapf = f[j];
						 f[j] = f[j+1];
						 f[j+1] = swapf; 
						
						 swaps = s[j];
						 s[j] = s[j+1];
						 s[j+1] = swaps; 
					}
				}
			}	
			System.out.println("Arrays sorted rely on finish time : ");
			System.out.println(Arrays.toString(s));
			System.out.println(Arrays.toString(f));
		}
		
		public void activitySelection (int [] s , int [] f){
			
			sort(s, f);
			
			int i = 0 ; int j = 0 ;
			System.out.println("Index number : " + i);
		//	int k=0;

			
			for ( j = 1; j < s.length; j++) {
				if (s[j] > f[i]){
					System.out.println("Index number : " + j);
					i=j;
				}
			}	
		}
		
	public static void main(String[] args) {

			int [] s = {0,3,1,5,5,8};
			int [] f = {6,4,2,9,7,9};
			
			Greedy o = new Greedy() ;
			o.activitySelection(s, f);

		}
	}
