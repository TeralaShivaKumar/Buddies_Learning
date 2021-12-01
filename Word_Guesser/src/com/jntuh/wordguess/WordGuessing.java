package com.jntuh.wordguess;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class WordGuessing {
	static ArrayList<String> generateWord() throws IOException {
		String word=null;
		StringBuilder sb =null;
		int max=0;
		FileInputStream fis=new FileInputStream("D:\\WorkSpaces\\Advjava\\NTAJ415\\Word_Guesser\\src\\com\\jntuh\\words.txt"); 
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(fis);    //file to be scanned  
		//returns true if there is another line to read  
		ArrayList<String> al=new ArrayList<String>();
		while(sc.hasNextLine())  {  
			word=sc.nextLine();//returns the line that was skipped 
			sb = new StringBuilder(word);
			Random rand =new Random();
			int len=word.length();
			max=len/2;
			for(int i=0;i<max;i++) {
				int randInt = rand.nextInt(len);
				if(!(sb.charAt(randInt)=='_')) {
					sb.replace(randInt,randInt+1, "_");
				}
				else {
					i=i-1;
				}
			}
			word=sb.toString();
			al.add(word);	
		}
		return al;
	}

}


class test{
	public static void main(String[] args) throws IOException {
		int count=0;
		int i,j=0;
		FileInputStream fis =null;
		Scanner sc1=null;
		ArrayList<String> al=new ArrayList<String>();
		ArrayList<String> wordlist=new ArrayList<String>();
		al=WordGuessing.generateWord();
		fis=new FileInputStream("D:\\WorkSpaces\\Advjava\\NTAJ415\\Word_Guesser\\src\\com\\jntuh\\words.txt");
		sc1=new Scanner(fis);
		while(sc1.hasNextLine()) {
			wordlist.add(sc1.next());
		}
		System.out.println(al);
		Scanner sc=new Scanner(System.in);
		for(i=0;i<al.size();i++) {
			System.out.println(al.get(i));
			System.out.println("Guess the word in 10 chances");
			for(j=10;j>=0;j--) {
				String test=sc.next().toLowerCase();
				if(test.equals(wordlist.get(i))) {
					count++;
					System.out.println("Superb Guess next word!! :)");
					break;
				}
				else {
					System.out.println("try again . You Left with "+j+"chances");
				}
				if(j==0)
					break;
			}
			if(j==0)
				break;
		}
		if(count==al.size()) {
			System.out.println("\n");
			System.out.println("Hurrah!!");
			System.out.println("You Are Intelligent :)");
			System.out.println("Your Score is "+count);
		}
		else {
			System.out.println('\n');
			System.out.println("You Tried Well");
			System.out.println("Your Score is "+count);
		}

		sc.close();
		sc1.close();
	}
}