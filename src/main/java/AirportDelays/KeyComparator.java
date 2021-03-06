package AirportDelays;

import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;


public class KeyComparator extends WritableComparator{
    protected KeyComparator() {
        super(AirportKey.class, true);
    }

    public int compare(WritableComparable a, WritableComparable b) {
        AirportKey a1 = (AirportKey)a;
        AirportKey b1 = (AirportKey)b;
        return a1.getAirportID().compareTo(b1.getAirportID());
    }
}
