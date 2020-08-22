package fileprocessors;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Stockfilereader {
	
	String filepath = null;

	public Stockfilereader(String filepath2) {
		this.filepath = filepath2;
	}

	public List<String> getHeaders() throws FileNotFoundException, IOException {
		String line = readfirstline(filepath);
		String [] header = line.split(",");
		List<String> values = new ArrayList<String>();
		values = Arrays.asList(header);
		return values;
	}

	private static String readfirstline(String path) throws FileNotFoundException, IOException {
		try(BufferedReader br = new BufferedReader(new FileReader(path));){
			return br.readLine();
		} 
	}

	public List<String> readfiledata() throws FileNotFoundException, IOException {
		List<String> lines = new ArrayList<String>();
		
		try(BufferedReader br = new BufferedReader(new FileReader(filepath));){
			br.readLine();
			
			String line = null;
			
			while((line = br.readLine()) != null) {
				lines.add(line);
				
			}
			
		}
		
		return lines;
	}

}
