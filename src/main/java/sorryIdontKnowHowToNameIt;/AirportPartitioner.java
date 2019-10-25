package ru.bmstu.hadoop.example.book;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

public class AirportPartitioner extends Partitioner<AirportKey, Text> {
    public int getPartition(AirportKey key, Text value, int numReduceTasks) {
        return (key.getAirportName().hashCode() & Integer.MAX_VALUE) % numReduceTasks;
    }
}
