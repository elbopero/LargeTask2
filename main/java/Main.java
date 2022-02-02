import java.io.File;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Program program = new Program();
        // program.dummyMethod();
        File file = new File("shapes.txt");

        //read.readFile();
     //readShape.readFile();
        program.shapeMenu();
    }
}
