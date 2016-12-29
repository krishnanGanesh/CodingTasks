package pc.user.puneetchugh;

import java.util.concurrent.Callable;

public class CountWordsInALine implements Callable<Integer> {

	private String currentLine;
	public CountWordsInALine(String currentLine){
		this.currentLine = currentLine;
	}
	@Override
	public Integer call() throws Exception {
		String[] stringsInALine = currentLine.split(" ");
		return stringsInALine.length;
	}

}
