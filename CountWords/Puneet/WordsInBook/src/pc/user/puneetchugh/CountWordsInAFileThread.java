package pc.user.puneetchugh;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CountWordsInAFileThread implements Callable<Integer>{

	private String book;
	private int wordsCount;
	public CountWordsInAFileThread(String book){
		this.book = book;
	}
	
	@Override
	public Integer call() {
		
		BufferedReader br = null;
		FileReader fr = null;

		try {

			fr = new FileReader(book);
			br = new BufferedReader(fr);

			String sCurrentLine;

			ExecutorService executor = Executors.newFixedThreadPool(5);
			
			while ((sCurrentLine = br.readLine()) != null) {
				//System.out.println(sCurrentLine);
				if("".equals(sCurrentLine.trim())){
					continue;
				}
				Callable<Integer> callable = new CountWordsInALine(sCurrentLine);
				Future<Integer> wordCountReturned = executor.submit(callable);
				try {
					wordsCount = wordsCount + wordCountReturned.get();
				} catch (InterruptedException | ExecutionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				if (br != null)
					br.close();

				if (fr != null)
					fr.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}

		}

		return wordsCount;
	}

}
