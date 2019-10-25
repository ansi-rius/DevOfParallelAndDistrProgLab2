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
    private int airportID;
    private int tableCode;

    public AirportKey() {
    }

    public AirportKey(int airName, int tableCode) {
        airportID = airName;
        tableCode = tableCode;
    }

    public int compareTo(AirportKey ak) {
        int cmp = compare(this.get);
        if (cmp != 0)
            return cmp;
        return this.tableCode.compareTo(ak.tableCode);
    }

    public void write(DataOutput out) throws IOException {
        airportName.write(out);
        tableCode.write(out);
    }

    public void readFields(DataInput inp) throws IOException {
        airportName.readFields(inp);
        tableCode.readFields(inp);
    }

    public Text getAirportName() {
        return airportName;
    }

    public IntWritable getAirportCode() {
        return tableCode;
    }
}

