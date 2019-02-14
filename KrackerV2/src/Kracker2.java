import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Kracker2 {

	public static void main(String[] args) {
		//Phase 1
		 ArrayList<String> wordsFromPass = new ArrayList<>();
		 
		Kracker2.readPassFile(wordsFromPass);
		System.out.println(Arrays.toString(wordsFromPass.toArray()));
		}
	
	
	
	
	
	
	
	
	
	
	//Functions 
	
	public static ArrayList<String> readPassFile(ArrayList<String> wordsFromPass) {

		//Following code found on https://stackoverflow.com/questions/19575308/read-a-file-separated-by-tab-and-put-the-words-in-an-arraylist
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
	                            wordsFromPass.add(each);
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
}
