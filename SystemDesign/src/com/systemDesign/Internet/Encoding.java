package com.systemDesign.Internet;

import java.util.ArrayList;
import java.util.Collections;

public class Encoding {

	public static void main(String[] args) {
		
		/*def base_encode(num, base=62):
		    digits = []
		    while num > 0
		      remainder = modulo(num, base)
		      digits.push(remainder)
		      num = divide(num, base)
		    digits = digits.reverse*/
		
		int number = 125;
		int base =62;
		encode(number,base);

	}

	public static void encode(int number, int base){
		//Once the number is decimal convert to base 62 /base 64 based on type of encoding
		ArrayList<Integer> list = new ArrayList<Integer>();
		while(number>base){
			int reminder = number%base;
			list.add(reminder);
			number = number/base;
			
		}
		list.add(number);
		Collections.reverse(list);
		System.out.println("******");
	}
	
}
