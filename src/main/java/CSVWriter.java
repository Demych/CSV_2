import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Asus on 20.06.2017.
 */
public class CSVWriter extends Writer {
    public CSVWriter(StringBuffer sb, String outputFile) {
        super(sb, outputFile);
    }


    @Override
    public void startWriteResult(StringBuffer sb, String outputFile) {
        System.out.println("Start recording " + outputFile);

        try {
            String text = getArray(sb);
            writeResult(text, outputFile);
        } catch (IOException e) {
            System.out.println("Recording is impossible.\nSelect another file");
            throw new RuntimeException();
        }
        System.out.println("Recording " + outputFile + " finished");


    }

    private String getArray(StringBuffer sb) {
        String text = sb.toString();
        text = text.replace("!", "\n");
        return text;
    }

    private void writeResult(String text, String outputFile) throws IOException {
        try (FileWriter writer = new FileWriter(outputFile, true);) {
            writer.write(text);
            writer.flush();
            writer.close();
        } catch (IOException e) {


        }
    }
}
