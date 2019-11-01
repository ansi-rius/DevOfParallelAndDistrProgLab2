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
    private Text airportID;
    private int tableCode;

    public AirportKey() {
    }

    public AirportKey(int airName, int tableCod) {
        airportID = airName;
        tableCode = tableCod;
    }

    public static int compare(int a, int b) {
        return Integer.compare(a,b);
    }

    public int compareTo(AirportKey ak) {
        int cmp = compare(this.getAirportID(), ak.getAirportID());
        if (cmp != 0)
            return cmp;
        return compare(this.gettableCode(), ak.gettableCode());
    }

    public void write(DataOutput out) throws IOException {
        out.write(airportID);
        out.write(tableCode);
    }

    public void readFields(DataInput inp) throws IOException {
        airportID = inp.readInt();
        tableCode = inp.readInt();
    }

    public int getAirportID() {
        return airportID;
    }

    public int gettableCode() {
        return tableCode;
    }
}

