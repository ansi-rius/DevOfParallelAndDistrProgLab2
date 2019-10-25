//a)
package DevOfParallelAndDistrProg;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.Writable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class AirWritable implements Writable {
    private Text file;

    public AirWritable() {
        file = new Text();
    }
    public void setFile(String file) {
        this.file = new Text(file);
    }

    public void readFields(DataInput in) throws IOException {
        file.readFields(in);
    }
    public void write(DataOutput out) throws IOException {
        file.write(out);
    }
    //compareTo??
}
