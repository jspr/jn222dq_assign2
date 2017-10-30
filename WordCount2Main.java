package jn222dq_assign2;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class WordCount2Main {

	public static void main(String[] args) {
		
		HashWordSet hashSet = new HashWordSet();
		TreeWordSet treeSet = new TreeWordSet();
		
		//create a file object for the input file
		File file = null;
		try {
			file = new File(args[0]);
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("A file name must be provided as an argument.");
			System.exit(1);
		}catch(Exception e) {
			System.out.println("An exception was encountered: " + e.getMessage());
			System.exit(1);
		}
		
		//create scanner
		Scanner scanner = null;		
		try {
			scanner = new Scanner(file);		
			while (scanner.hasNext()){
				Word word = new Word(scanner.next());
				hashSet.add(word);
				treeSet.add(word);
			}	
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}finally {
			if(scanner != null) //do not try to "close" a null pointer
				scanner.close();
		}
		
		System.out.println("Number of elements in the HashSet: " + hashSet.size());
		System.out.println("Number of elements in the TreeSet: " + treeSet.size());
		
		System.out.println();
		
		System.out.println("Iterating over the TreeSet:");
		for(Word word : treeSet) {
			System.out.println("  " + word);
		}
		
		System.out.println();
		
		System.out.println(hashSet);
		System.out.println(treeSet);

	}

}
