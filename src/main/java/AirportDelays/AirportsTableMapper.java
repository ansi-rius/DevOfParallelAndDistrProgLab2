package AirportDelays;

import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import java.io.IOException;

public class AirportsTableMapper extends Mapper<LongWritable, Text, AirportKey, Text> {
    private static int CODE = 0, DESCRIPTION = 1;
    @Override protected
    void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        //читать таблицы..
        String codesAndAirports[] = TablesParser.parseAirportsTable(value); //результат парсинга таблицы,
        //работа с ключами..
        if (TablesParser.checkAir(codesAndAirports[CODE])) {
            return;
        }
        AirportKey ak = new AirportKey(TablesParser.getID(codesAndAirports[CODE]),0);
        Text des = new Text(codesAndAirports[DESCRIPTION]);
        context.write(ak, des);
    }
}
