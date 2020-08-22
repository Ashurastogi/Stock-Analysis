package aggregators;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import fileprocessors.Stockfilereader;

public class AggregatorProcessor<E extends Aggregator> {
	E agg;
	String filepath;
	

	public AggregatorProcessor(E agg, String filepath) {
		this.agg = agg;
		this.filepath = filepath;
	}
	
	
	public double runAggregator(int i) throws FileNotFoundException, IOException {
		
		Stockfilereader read = new Stockfilereader(filepath);
		List<String> lines = read.readfiledata();
		
		i--;
		for(String line : lines) {
			String[] num = line.split(",");
			double val =Double.parseDouble(num[i]);
			
			agg.add(val);
		}
		
		double res = agg.calculate();
		
		return res;
	}
	
	
	
}
