import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class ShowDelayFlights {
    public static void main(String[] args) throws Exception {
        if (args.length != 2) {
            System.exit(-1);
        }
        Job job = Job.getInstance();
        job.setJarByClass(ShowDelayFlights.class);
        job.setJobName("Delay Flights");

    }
}
