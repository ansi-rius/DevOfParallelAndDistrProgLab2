package AirportDelays;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.util.Iterator;

public class AirportReducer extends Reducer<AirportKey, Text, Text, Text> {
    public void reduce(AirportKey key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
        int count = 0;
        double maxTime=Double.MIN_VALUE, minTime = Double.MAX_VALUE, time, averageTime=0;
        Iterator<Text> iter = values.iterator();
        String airportName = iter.next().toString();
        while(iter.hasNext()) {
            String str = iter.next().toString();
            time = Double.parseDouble(str);
            maxTime = Math.max(maxTime, time);
            minTime = Math.min(minTime, time);
            count++;
            averageTime += time;
        }

        if (count == 0)
            return;
        averageTime=averageTime/count;
        context.write(new Text(airportName), new Text("MIN time = "+minTime+" MAX time = "+maxTime+" Average time = "+averageTime));
    }
}
