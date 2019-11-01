package AirportDelays;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.util.Iterator;

public class AirportReducer extends Reducer<AirportKey, Text, Text, Text> {
    public void reduce(AirportKey key, Iterable<Text> values, Context context) throws IOException, InterruptedException {

        context.write(new Text(airportName), new Text("MIN time = "+minTime+" MAX time = "+maxTime+" Average time = "+averageTime));
    }
}
