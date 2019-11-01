

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.util.Iterator;

public class AirportReducer extends Reducer<sorryIdontKnowHowToNameIt.AirportKey, Text, Text, Text> {
    public void reduce(sorryIdontKnowHowToNameIt.AirportKey key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
        int count = 0;
        double maxTime=Double.MIN_VALUE, minTime = Double.MAX_VALUE, time, averageTime=0;
        Iterator<Text> iter = values.iterator();
        Text airportName = new Text(iter.next());
        while(iter.hasNext()) {
            averageTime = Double.parseDouble(iter.next().toString());
            time = averageTime;
            maxTime = Math.max(maxTime, time);
            minTime = Math.min(minTime, time);
            count++;
            averageTime += time;
        }

        if (count == 0)
            return;
        averageTime=averageTime/count;
        context.write(new Text(airportName), new Text("MIN time = "+minTime+" MAX time = "+maxTime+"Average time = "+averageTime));
    }
}
