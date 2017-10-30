package jn222dq_assign2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class IdentifyWordsMain {

	public static void main(String[] args){
		
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
		
		//create a file object for the output file
		File outputFile = null;
		try {
			String fileName = "words.txt";
			outputFile = new File(file.getParent() + File.separator + fileName);
			outputFile.createNewFile();
			writeToFile(outputFile,"",false); //clear the file content
		}catch ( IOException e) {
            System.err.println("IOException: " + e.getMessage());
            System.exit(1);
        }catch(Exception e) {
			System.out.println("An exception was encountered: " + e.getMessage());
			System.exit(1);
		}
		
		//create scanners
		Scanner scanner = null;
		Scanner lineScanner = null;
		
		try {
			scanner = new Scanner(file);
			/*
			 * In the assignment an example is provided showing how the text should be transformed,
			 * the example looks like this:
			 * 
			 *   Text
			 *	 ====
			 *	 Computer programming, History of programming
			 *	 From Wikipedia, the free encyclopedia (081110)
			 *	 The earliest known programmable machine (that is a machine whose
			 *	 behavior can be controlled by changes to a
			 *	 "program") was Al-Jazari's programmable humanoid robot in 1206.
			 *	
			 *	 Sequence of words
			 *	 =================
			 *	 Computer programming History of programming
			 *	 From Wikipedia the free encyclopedia
			 *	 The earliest known programmable machine that is a machine whose
			 *	 behavior can be controlled by changes to a
			 *	 program was Al Jazaris programmable humanoid robot in
			 *
			 * It looks like the word-wrapping is to be preserved and everything
			 * but letters to be removed. We do however have an interesting exception
			 * in the case of the string "Al-Jazari's" which is transformed to "Al Jazaris".
			 * How should something like "e.g." be handled? I would argue that "eg" makes
			 * more sense than "e" and "g".
			 * My approach is to split every line into substrings on whitespace or "-" and then
			 * remove everything but letters from each substring.
			 * Finally the line is put back together.
			 * 
			 */
			
			StringBuilder line = new StringBuilder();
			
			while (scanner.hasNextLine()){
				line.setLength(0); //clear the StringBuilder
				lineScanner = new Scanner(scanner.nextLine()).useDelimiter("\\s+|-"); //split on whitespace or "-"
				while (lineScanner.hasNext()){
					String s = lineScanner.next();
					s = s.replaceAll("[^a-zA-Z]", ""); //remove everything but a-z or A-Z
					if(s.length()>0) {
						if(line.length()>0) line.append(" "); //add a space if not first word on the line 
						line.append(s); //append the word to the fixed line
					}
				}
				line.append(System.lineSeparator()); //add a newline (or whatever line separators that are used)
				writeToFile(outputFile,line.toString(),true);
			}	
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}finally {
			if(scanner != null) //do not try to "close" a null pointer
				scanner.close();
			if(lineScanner != null) //do not try to "close" a null pointer
				lineScanner.close();
		}
		
	}
	
	private static void writeToFile(File file, String s, boolean append) throws IOException {
		//this is the "new" approach to handling try where
		//closing resources in a finally statement isn't necessary
		try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file,append))) {
			bufferedWriter.write(s);
		} catch (IOException e) {
			System.out.println("Exception when writing to file: " + e.getMessage());
			throw e; //re-throw the exception and let the calling method handle it
		}
	}

}
