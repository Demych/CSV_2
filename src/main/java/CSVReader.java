import java.io.File;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Asus on 17.06.2017.
 */
public class CSVReader {
    private File inputFile;
    private String regExp;

    public CSVReader(String inputFile, String regExp) {
        this.regExp = regExp;
        this.inputFile = new File(inputFile);

    }

    public File getInputFile() {
        return inputFile;
    }

    public void setInputFile(String inputFile){
        this.inputFile = new File(inputFile);
    }

    public String getRegExp() {
        return regExp;
    }

    public void setRegExp(String regExp){
        this.regExp = regExp;
    }




    public  StringBuffer startFileAnalys(File file, String valueOfWord){
        StringBuffer sb = new StringBuffer();
        try {

            String[] valuesOfString;
            Scanner inputStream = new Scanner((file));

            while (inputStream.hasNext()) {
                String data = inputStream.next();
                valuesOfString = data.split(";");
                if (testString(valuesOfString, valueOfWord)) {
                    int index = (getIndexOfValue(valuesOfString, valueOfWord));
                    sb.append(getColomns(file, index));
                } else continue;


            }
            inputStream.close();
        } catch (Exception e) {
          throw  new RuntimeException("File not found");
        }

    return sb;
    }

    public static boolean testString(String[] values, String valueOfWord){
        boolean a = false;
        Pattern p = Pattern.compile(valueOfWord);
        for (String s : values) {
            Matcher m = p.matcher(s);
            if (m.matches()) {
                a = true;
            break;}
                else a = false;
            }
        return a;


    }

    private  int getIndexOfValue(String[] values, String s1) {
        return Arrays.asList(values).indexOf(s1);
    }

    private  StringBuffer getColomns(File file, int index) throws Exception {
        Scanner inputStream = new Scanner((file));
        StringBuffer sb = new StringBuffer();
        while (inputStream.hasNext()) {
            String data = inputStream.next();
            String[] values = data.split(";");
            sb.append(values[index]+";");
        }
        int i = sb.length();
        sb.replace(i - 1, i , "!");
        return sb;
    }


}
