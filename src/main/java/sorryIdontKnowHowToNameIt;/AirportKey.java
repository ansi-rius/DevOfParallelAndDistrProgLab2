package ru.bmstu.hadoop.example.book;
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
    private IntWritable tableCode;

    public AirportKey() {
    }

    public AirportKey(String airName, int tableCode) {
        this.airportName = new Text(airName);
        this.tableCode = new IntWritable(tableCode);
    }

    public int compareTo(AirportKey ak) {
        int cmp = airportName.compareTo(ak.airportName);
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

