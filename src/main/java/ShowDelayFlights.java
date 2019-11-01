
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.input.MultipleInputs;

public class ShowDelayFlights {
    public static void main(String[] args) throws Exception {
        if (args.length != 3) {
            System.exit(-1);
        }
        Job job = Job.getInstance();
        job.setJarByClass(ShowDelayFlights.class);
        job.setJobName("Delay Flights");
        MultipleInputs.addInputPath(job, new Path(args[0]), TextInputFormat.class, sorryIdontKnowHowToNameIt.FlightsTableMapper.class);
        MultipleInputs.addInputPath(job, new Path(args[1]), TextInputFormat.class, sorryIdontKnowHowToNameIt.AirportsTableMapper.class);
        FileOutputFormat.setOutputPath(job, new Path(args[2]));
        job.setPartitionerClass(sorryIdontKnowHowToNameIt.AirportPartitioner.class); //партишнер в)
        job.setGroupingComparatorClass(sorryIdontKnowHowToNameIt.KeyComparator.class);//компаратор г)
        job.setReducerClass(sorryIdontKnowHowToNameIt.AirportReducer.class); //редьюс-функц д)
        job.setMapOutputKeyClass(sorryIdontKnowHowToNameIt.AirportKey.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(Text.class); //врайтбл менять
        job.setNumReduceTasks(2);
        System.exit(job.waitForCompletion(true) ? 0 : 1);
    }
}
