package fileprocessors;

import java.util.*;

public class Stockfiledata {
	
	List<HashMap<String,Double>> data = new LinkedList<>();
	
	public void printdata() {
		System.out.println(data);
	}
	
	public void addData(List<HashMap<String,Double>> datain) {
		data = datain;
	}


	
	

}
