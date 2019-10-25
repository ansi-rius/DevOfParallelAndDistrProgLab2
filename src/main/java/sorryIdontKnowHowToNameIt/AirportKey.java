package sorryIdontKnowHowToNameIt;
//в)  в.разрабатываем map функцию для каждого из набора данных, которая
//генерирует WritableComparable ключа и Writable данных
// для списка аэропортов эта функция в качестве value отправляет имя аэропорта.
//для списка рейсов в качестве value эта функция отправляет время задержки (в
//виде строки)

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.Text;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class AirportKey implements WritableComparable<AirportKey> {
    private Text airportName;
    private IntWritable airportCode;

    public AirportKey() {
    }

    public AirportKey(Text airName, int airCode) {
        this.airportName = new Text(airName);
        this.airportCode = new IntWritable(airCode);
    }

    public int compareTo(AirportKey ak) {
        int cmp = airportName.compareTo(ak.airportName);
        if (cmp != 0)
            return cmp;
        return this.airportCode.compareTo(ak.airportCode);
    }

    public void write(DataOutput out) throws IOException {
        airportName.write(out);
        airportCode.write(out);
    }

    public void readFields(DataInput inp) throws IOException {
        airportName.readFields(inp);
        airportCode.readFields(inp);
    }

    public Text getAirportName() {
        return airportName;
    }

    public IntWritable getAirportCode() {
        return airportCode;
    }
}

