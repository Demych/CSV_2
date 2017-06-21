/**
 * Created by Asus on 17.06.2017.
 */


public class Main {
    public static void main(String[] args) {


        Facade facade = new Facade(args[0], args[1], args[2]);
        facade.startProgram(facade.getInputFile(), facade.getRegExp(), facade.getOutputFile());
    }
}
