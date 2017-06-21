/**
 * Created by Asus on 21.06.2017.
 */
public class Facade {
    private String inputFile;
    private String regExp;
    private String outputFile;



    public String getInputFile() {
        return inputFile;
    }
    public void setInputFile(String inputFile) {
        this.inputFile = inputFile;
    }

    public String getRegExp() {
        return regExp;
    }
    public void setRegExp(String regExp) {
        this.regExp = regExp;
    }

    public String getOutputFile() {
        return outputFile;
    }
    public void setOutputFile(String outputFile) {
        this.outputFile = outputFile;
    }


    public Facade(String inputFile, String regExp, String outputFile) {
        this.inputFile = inputFile;
        this.regExp = regExp;
        this.outputFile = outputFile;

    }

    public void startProgram(String inputFile, String regExp, String outputFile) {

        CSVReader csvReader = new CSVReader(inputFile, regExp);
        StringBuffer sb = csvReader.startFileAnalys(csvReader.getInputFile(), csvReader.getRegExp());

        WriterFactory writerFactory = new WriterFactory(sb, outputFile);
        Writer writer = writerFactory.getWriter(writerFactory.getOutputFile());
        writer.startWriteResult(writer.getSb(), writer.getOutputFile());
    }
}
