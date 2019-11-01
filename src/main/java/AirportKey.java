
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
    private Text airportID;
    private IntWritable tableCode;

    public AirportKey() {
    }

    public AirportKey(String airName, int tableCod) {
        this.airportID = new Text(airName);
        this.tableCode = new IntWritable(tableCod);
    }

    @Override
    public int compareTo(AirportKey ak) {
        int cmp = airportID.compareTo(ak.airportID);
        if (cmp != 0)
            return cmp;
        return this.tableCode.compareTo(ak.tableCode);
    }

    @Override
    public void write(DataOutput out) throws IOException {
        airportID.write(out);
        tableCode.write(out);
    }

    @Override
    public void readFields(DataInput inp) throws IOException {
        airportID.readFields(inp);
        tableCode.readFields(inp);
    }


}

