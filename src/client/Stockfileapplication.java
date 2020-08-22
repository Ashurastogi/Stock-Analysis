package client;

import java.io.IOException;
import java.util.*;
import fileprocessors.Stockfiledata;
import fileprocessors.Stockfilereader;

public class Stockfileapplication {
	
	public static void main(String[] args) throws IOException{ 
	
	Stockfilereader fr = new Stockfilereader("table.csv");
	
	List<HashMap<String,Double>> dataresult = populatestockfiledata(fr.getHeaders(),fr.readfiledata());
	Stockfiledata fileData = new Stockfiledata();
	fileData.addData(dataresult);
	fileData.printdata();
	System.out.println(dataresult.size());
	}

	private static List<HashMap<String, Double>> populatestockfiledata(List<String> headers, List<String> readfiledata) {
		List<HashMap<String, Double>> dataResult = new ArrayList<>();
		
		for(String filedata : readfiledata) {
			int c = 0;
			String[] lines = filedata.split(",");
			HashMap<String,Double> ourdata = new HashMap<>();
			for(String line :lines) {
				double d = Double.parseDouble(line);
				ourdata.put(headers.get(c), d);
				c++;

			}
			dataResult.add(ourdata);

		}
		return dataResult;
	}
}
