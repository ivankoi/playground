package com.codingame.centauri;

public class Coder {
	
	private final static String ZEROES = "00000000";
	
	public static void main(String[] args) {
		int size = 32;

		int[] a = new int[size / 16];
		int[] b = new int[size / 16];

		String[] input = new String[] { "b0c152f9", "ebf2831f" };

		for (int i = 0; i < a.length; i++) {
			a[i] = Integer.parseUnsignedInt(input[i], 16);
		}

		for (int i = 0; i < size / 16; i++) {
			b[i] = 0;
		}

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				b[(i + j) / 32] ^= ((a[i / 32] >> (i % 32)) & (a[j / 32 + size / 32] >> (j % 32)) & 1) << ((i + j) % 32); // Magic centaurian operation
			}
		}
		
		
		for(int i = 0; i < size / 16; i++) {
		    if (i > 0) {
		      System.out.print(' ');
		    }
		    
		    String s = Integer.toHexString(b[i]);
		    String intAsString = s.length() <= ZEROES.length() ? ZEROES.substring(s.length()) + s : s;
		    System.out.print(intAsString);
		}
		  
		System.out.println();
		  
	}
}
