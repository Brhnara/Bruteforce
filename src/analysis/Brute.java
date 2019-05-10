package analysis;

import java.io.File;

import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Brute {

	/*Student Name: Burhan Ara and Eyyüp Güzel
	Student ID: 1614084 1616643
	Operating System: {Windows[Version 10]}
	Compile Status: {Compiling} 
	Execution Status: {Partially Working}
	Bonus Part: {Not implemented} 
	Comments: hocam kodumuz herhangi bir hata vermemesine raðmen horspoolMatching metoduna girmiyor sorunu maalesef bulamadýk .
	*/


	    public static int brute(char[] pattern, char[] text) {
	    	 int m = pattern.length;
	         int n = text.length;
	         int comparasioncount=0;

	         for (int i = 0; i <= n - m; i++) {
	        	 int j=0;
	             while(j<m && text[i+j] == pattern[j]) {
	            	 j++;
	            	 comparasioncount++;
	             }
	           
	             
	               if (j == m) {
	            	   
	             System.out.println("pattern found at index "+i); 
	            // found at offset i
	         }
	              
	         }
	         System.out.println("Comparasion count is "+comparasioncount);
	         return -1;                 
	        }	            
	    public static int horspoolMatching(char pattern[], char text[]) throws Exception{
			
			int table[] = shiftTable(pattern);	
			int m = pattern.length;
			int n = text.length;
			int i = m-1;
			
			
			while (i<=n-1){
				//algCompareCt++;
				int k=0;
				//algArithCt = algArithCt + 2;
				while (k<=m-1 && pattern[m-1-k]==text[i-k]){
					k=k+1;
					//algCompareCt = algCompareCt + 2;
					
					if (k==m){
						return i-m+1;
						
					}
					else 
					i=i+table[text[i]];
			
					
					//algArithCt = algArithCt + 2;
				}
				
				//algArithCt = algArithCt + 3;
			}
			return -1;
		}
		public static int[] shiftTable(char pattern[]){
	
		
			int m = pattern.length;
			int alphabet = 127;
			int table[] = new int[alphabet];
			
			for (int i = 0; i < alphabet; i++){
				//algArithCt++;
				//algCompareCt++;
			
				table[i] =  m;
			}
			//algArithCt--;
			
			for (int j = 0; j < m - 1; j++){
				//updates shift table for values that are in the pattern.
				table[pattern[j]] =  m  - 1 - j;
				//algArithCt = algArithCt + 4;
				//algCompareCt++;
			}
			//algArithCt--;
		
			return table;

		}

	
	   

	   
	    public static void main(String[] args) throws Exception {
	    	int a;
	    	String txt,txt1,txt2;
	    	String file = new String(Files.readAllBytes(Paths.get("C:\\Users\\burhan\\eclipse-workspace\\analysis\\src\\the_truman_show_script.txt")));
	    	int comparisonCount;
			Scanner s=new Scanner(System.in);
		    char[] charText = file.toCharArray();
		    


			
			System.out.println("Enter a choice:");
			System.out.println("1-Brute Force String Matching");
			System.out.println("2-Horspool's String Matching");
			System.out.println("3-Compare Brute Force and Horpool's Alghoritm");
			System.out.println("0-Exit");
			a=s.nextInt();
			switch(a) {
			case 1: 
				System.out.println("Enter a text which you want to search");
				txt=s.next();
				char[] charPattern=txt.toCharArray();
				long started = System.nanoTime();
				int result = brute(charPattern,charText); 
				long diff = System.nanoTime() - started; 
				System.out.println("\nTime took: "+diff+" nanoseconds\n");
				if(result != -1){ 
					System.out.println("Pattern was located starting at index "+result); 
				}
				else{
					System.out.println("Pattern was not found in text!"); 
				}
				
				
				
				break;
			case 2:
				System.out.println("Enter a text which you want to search");
				txt1=s.next();
				char[] charPattern1=txt1.toCharArray();
				
				long started1 = System.nanoTime();
				
				int rslt = horspoolMatching(charPattern1,charText); 
				System.out.println("heh");
				long diff1 = System.nanoTime() - started1; 
				System.out.println("\nTime took: "+diff1+" nanoseconds\n");
				if(rslt != -1){ 
					System.out.println("Pattern was located starting at index "+rslt); 
				}
				else
					System.out.println("Pattern was not found in text!"); 
				break;
				
			case 3:
				System.out.println("Enter a text which you want to search");
			    txt2=s.next();
			    char[] charPattern2=txt2.toCharArray();
			    long started3 = System.nanoTime();
				int result3 = brute(charPattern2,charText); 
				long diff3= System.nanoTime() - started3; 
				System.out.println("\nBrute-force Time took: "+diff3+" nanoseconds\n");
				long started4 = System.nanoTime();
				int foundInd4 = horspoolMatching(charPattern2,charText); 
				long diff4 = System.nanoTime() - started4; 
				System.out.println("\nHorspool algorithms Time took: "+diff4+" nanoseconds\n");
				if(diff4<diff3){
					System.out.println("horspool better than brute force");
				}else
					System.out.println("brute-force better than horspool");
				
				break;
				
			case 0:
				System.exit(0);
				break;
			}
			
	    }
	}
