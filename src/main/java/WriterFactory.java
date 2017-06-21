/**
 * Created by Asus on 20.06.2017.
 */
public class WriterFactory {

    private StringBuffer sb;
    private String outputFile;

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


    public WriterFactory(StringBuffer sb, String outputFile) {
        this.sb = sb;
        this.outputFile = outputFile;
    }

    public Writer getWriter(String outputFile) {
        int i = outputFile.length();
        String fileType = outputFile.substring((i - 3));
        if (fileType.equalsIgnoreCase("TXT")) {
            return new TXTWriter(sb, outputFile);}
            else if (fileType.equalsIgnoreCase("CSV")) {
          return new CSVWriter(sb, outputFile);

        }else throw new RuntimeException(fileType + "is not supperted");
        }
    }
