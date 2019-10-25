package sorryIdontKnowHowToNameIt;

import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;


public class KeyComparator extends WritableComparator{
    protected KeyComparator() {
        super(sorryIdontKnowHowToNameIt.AirportKey.class, true);
    }

    public int compare(WritableComparable a, WritableComparable b) {
        sorryIdontKnowHowToNameIt.AirportKey a1 = (sorryIdontKnowHowToNameIt.AirportKey)a;
        sorryIdontKnowHowToNameIt.AirportKey b1 = (sorryIdontKnowHowToNameIt.AirportKey)b;
        return a1.getAirportName().compareTo(b1.getAirportName());
    }
}
