package AirportDelays;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class FlightsTableMapper extends Mapper<LongWritable, Text, AirportKey, Text> {
    private static int CODE = 14, DELAY = 17;
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String codesAndAirports[] = TablesParser.parseFlightsTable(value); //результат парсинга таблицы
        if (TablesParser.checkFlight(codesAndAirports[DELAY])) {
            return;
        }
        AirportKey ak = new AirportKey(TablesParser.getID(codesAndAirports[CODE]),1);
        Text delay = new Text(codesAndAirports[DELAY]);
        context.write(ak, delay);
    }
}
