import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Asus on 19.06.2017.
 */
public class TXTWriter extends Writer {
    public TXTWriter(StringBuffer sb, String nameOfFile) {
        super(sb, nameOfFile);
    }

    @Override
    public void startWriteResult(StringBuffer sb, String outputFile){
        System.out.println("Start recording " + outputFile);
        try {
            String text = getString(sb);
            writeResult(text, outputFile);

       } catch (IOException e) {
           System.out.println("Recording is impossible.\nSelect another file");
        throw new RuntimeException();
        }
        System.out.println("Recording " + outputFile + " finished");

    }

    private String getString(StringBuffer sb) {

        String text = sb.toString();
        text = text.replace("!", ";");
        text = text.replace(";", "\n");

        return text;
    }

    private void writeResult(String text, String outputFile) throws IOException {

        FileWriter writer = new FileWriter(outputFile, true);
        writer.write(text);
        writer.flush();
        writer.close();
    }
}