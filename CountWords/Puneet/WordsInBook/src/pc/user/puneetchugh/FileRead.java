package pc.user.puneetchugh;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FileRead {

	String books[];
	
	public FileRead(){
		
		
	}
	

	public static void main(String[] args) {

		ExecutorService executor = Executors.newFixedThreadPool(10);
		//File dir = new File(".");
		//File[] files = dir.listFiles();
		//String[] books = files.
		String[] books = new File("/Users/puneetchugh/Desktop/MyCodingExercise/WordsInBook/src/pc/user/puneetchugh/").list();
		for(String bookName : books){
			if(bookName.contains("txt")){
				
				Callable<Integer> callable = new CountWordsInAFileThread("/Users/puneetchugh/Desktop/MyCodingExercise/WordsInBook/src/pc/user/puneetchugh/"+bookName);
				Future<Integer> words = executor.submit(callable);
				try {
					System.out.println(bookName+" word count = "+words.get());
				} catch (InterruptedException | ExecutionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}
}
