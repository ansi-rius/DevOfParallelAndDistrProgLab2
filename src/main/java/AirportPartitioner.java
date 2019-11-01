
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

public class AirportPartitioner extends Partitioner<sorryIdontKnowHowToNameIt.AirportKey, Text> {
    public int getPartition(sorryIdontKnowHowToNameIt.AirportKey key, Text value, int numReduceTasks) {
        return (key.getAirportID().hashCode() & Integer.MAX_VALUE) % numReduceTasks;
    }
}
