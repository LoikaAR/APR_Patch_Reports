package aprs_introclass;
import aprs_introclass.ClassDef;
public class MainInstance {
	public static void main(String[] args) {
	ClassDef mainClass = new ClassDef();
        String expected =
	ClassDef mainClass = new ClassDef();
        mainClass.scanner = new java.util.Scanner ("2 0 1");
	mainClass.exec();
    }
}