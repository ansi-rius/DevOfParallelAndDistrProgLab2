

import org.apache.hadoop.io.Text;

public class TablesParser {
    public static String[] parseAirportsTable(Text text) {
        //Code,Description
        //"10001","Afognak Lake, AK: Afognak Lake Airport"

        return text.toString().split(",(?=\")"); // a[0]="10001", a[1]="Afognak Lake, AK: Afognak Lake Airport"
    }

    public static String[] parseFlightsTable(Text text) {
        //2015,1,1,10,6,2015-01-10,"AA",19805,"AA","N790AA","1",12478,1247802,31703,12892,"1225","1235",0.00,0.00,0.00,"",345.00,2475.00,
        return text.toString().split(","); // a[14]=code, a[17] = delay
    }

    public static String getID(String text) {
        return text.replace("\"","");
    }

    public static boolean checkFlight(String val) {
        return (val.equals("") || val.equals("\"ARR_DELAY\""));
    }

    public static boolean checkAir(String val) {
        return val.equals("Code,Description");
    }

}
