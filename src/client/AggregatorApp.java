package client;

import java.io.FileNotFoundException;
import java.io.IOException;

import aggregators.AggregatorProcessor;
import aggregators.MinAggregators;

public class AggregatorApp {

	public static void main(String[] args) throws FileNotFoundException, IOException {

		MinAggregators agg = new MinAggregators();
		AggregatorProcessor<MinAggregators> aggsProcessor = new AggregatorProcessor<MinAggregators>(agg, "table.csv");
		double value = aggsProcessor.runAggregator(5);
		System.out.println(value);

	}

}
