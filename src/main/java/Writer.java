/**
 * Created by Asus on 21.06.2017.
 */
abstract public class Writer {
    private StringBuffer sb;
    private String outputFile;

    public Writer(StringBuffer sb, String outputFile) {
        this.sb = sb;
        this.outputFile = outputFile;
    }

    public StringBuffer getSb() {
        return sb;
    }

    public void setSb(StringBuffer sb) {
        this.sb = sb;
    }

    public String getOutputFile() {
        return outputFile;
    }

    public void setOutputFile(String outputFile) {
        this.outputFile = outputFile;

    }

    abstract void startWriteResult(StringBuffer sb, String outputFile);
}
