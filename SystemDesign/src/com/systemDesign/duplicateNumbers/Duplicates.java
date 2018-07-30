package com.systemDesign.duplicateNumbers;

public class Duplicates {
	static byte[] byteArray = new byte[32000/8];
	public static void checkDuplicates(int[] array) {
		
		
		for(int i=0;i<array.length;i++){
			if(byteArrayContains(array[i])){
				
				System.out.println(array[i]);
			}else{
				
				byteArray[array[i]/8] |= 1<<(array[i]%8);
			}
		}
	}
	
	public static void main(String[] args) {
		int[] array = {30, 1, 30,29,28,1};
		
		checkDuplicates(array);
	}
	
	public static boolean byteArrayContains(int data){
		
		if((byteArray[data/8] & (1<<data%8)) !=0){
			return true;
		}else{
			
			return false;
		}
	} 
	
}
