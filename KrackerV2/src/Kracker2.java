import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Kracker2 {

	public static void main(String[] args) throws IOException {
		//Phase 1: obtain password file
		 ArrayList<String> wordsFromPass = new ArrayList<>(); 
		Kracker2.readPassFile(wordsFromPass); //The password file is now in an array, split and stored approprietly
		String dictionary = readDictionaryFile();
		System.out.println(Arrays.toString(wordsFromPass.toArray()));
		System.out.println(dictionary);
	}
	
	

	//Functions 
	
	public static ArrayList<String> readPassFile(ArrayList<String> wordsFromPass) {

		//Following is based on code found on https://stackoverflow.com/questions/19575308/read-a-file-separated-by-tab-and-put-the-words-in-an-arraylist
	      try{
	            BufferedReader buf = new BufferedReader(new FileReader("C:\\Users\\Owner\\Documents\\Coure Material\\Cyber\\passwd.txt"));
	            String lineJustFetched = null;
	            String[] wordsArray;
	            while(true){
	                lineJustFetched = buf.readLine();
	                if(lineJustFetched == null){  
	                    break; 
	                }else{
	                    wordsArray = lineJustFetched.split(":");
	                    for(String each : wordsArray){
	                        if(!"".equals(each)){
	                        	if(each.equals(wordsArray[1]))
	                            wordsFromPass.add(each);
	                        	else if(each.contentEquals(wordsArray[4])) {
	                        		for(int i=0; i<1; i++) {
	                        			wordsFromPass.add(each.split(" ")[i]); 
	                        		}
	                        	}
	                        }
	                    }	
	                }
	            }
	            buf.close();

	        }catch(Exception e){
	            e.printStackTrace();
	        } //end borrowed code
	      return (wordsFromPass);
	}
	
	public static String readDictionaryFile() {
		String dictionary = "";
		try {
			dictionary = new String(Files.readAllBytes(Paths.get("C:\\Users\\Owner\\Documents\\Coure Material\\Cyber\\shortOne.txt")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return dictionary;
	}
	
	public static String Prepend(String line) {
		String characterString = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ123467890-_=+)(*&^%$#@!`~,./<>?;':[]{}|";
		for(int i=0; i<characterString.length(); i++) {
			String prependedString = (characterString.charAt(i) + line);
			try (FileWriter fw = new FileWriter("C:\\Users\\Owner\\Documents\\Coure Material\\Cyber\\BlackList.txt", true);
					BufferedWriter bw = new BufferedWriter(fw);
					PrintWriter out = new PrintWriter(bw)) {
				out.println(prependedString);
			} catch (IOException e) {
				//exception handling to be done I guess?
				//End of code from Stackoverflow
			}	
		}
		return null;
	}
}
	
