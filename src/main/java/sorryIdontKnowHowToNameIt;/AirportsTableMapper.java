package sorryIdontKnowHowToNameIt;

import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import java.io.IOException;

public class AirportsTableMapper extends Mapper<LongWritable, Text, sorryIdontKnowHowToNameIt.AirportKey, Text> {
    private static int CODE = 0, DESCRIPTION = 1;
    @Override protected
    void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        //читать таблицы..
        String codesAndAirports[] = sorryIdontKnowHowToNameIt.TablesParser.parseAirportsTable(value); //результат парсинга таблицы,
        //работа с ключами..
        if (key.get() == 0) {
            return;
        }
        sorryIdontKnowHowToNameIt.AirportKey ak = new sorryIdontKnowHowToNameIt.AirportKey(sorryIdontKnowHowToNameIt.TablesParser.getID(codesAndAirports[CODE]),0);
        Text des = new Text(codesAndAirports[DESCRIPTION]);
        context.write(ak, des);
    }
}
