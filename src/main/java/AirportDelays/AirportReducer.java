package AirportDelays;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.awt.geom.Arc2D;
import java.io.IOException;
import java.util.Iterator;

public class AirportReducer extends Reducer<AirportKey, Text, Text, Text> {
    public void reduce(AirportKey key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
        Iterator<Text> iter = values.iterator();
        Text it = new Text(iter.next());
        int count=0;
        double maxTime=0, minTime=Double.MAX_VALUE, averageTime=0, sum=0, delay;

        while(iter.hasNext()) {
            delay = Double.parseDouble(iter.next().toString());
            if (delay > maxTime)
                maxTime
        }

        context.write(new Text(airportName), new Text("MIN time = "+minTime+" MAX time = "+maxTime+" Average time = "+averageTime));
    }
}
