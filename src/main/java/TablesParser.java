import org.apache.hadoop.io.Text;

public class TablesParser {
    public static String[] parseAirportsTable(Text text) {
        //Code,Description
        //"10001","Afognak Lake, AK: Afognak Lake Airport"

        return text.toString().split(","); // a[0]="10001", a[1]="Afognak Lake, AK: Afognak Lake Airport"
    }

    public static String[] parse
}
