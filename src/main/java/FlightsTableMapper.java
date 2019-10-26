package sorryIdontKnowHowToNameIt;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class FlightsTableMapper extends Mapper<LongWritable, Text, sorryIdontKnowHowToNameIt.AirportKey, Text> {
    private static int CODE = 14, DELAY = 17;
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        if (key.get() == 0) {
            return;
        }
        String codesAndAirports[] = sorryIdontKnowHowToNameIt.TablesParser.parseAirportsTable(value); //результат парсинга таблицы
        sorryIdontKnowHowToNameIt.AirportKey ak = new sorryIdontKnowHowToNameIt.AirportKey(sorryIdontKnowHowToNameIt.TablesParser.getID(codesAndAirports[CODE]),1);
        Text delay = new Text(codesAndAirports[DELAY]);
        context.write(ak, delay);
    }
}
