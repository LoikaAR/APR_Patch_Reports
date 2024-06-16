package aprs_introclass;

class IntObj {public int value; public IntObj(){} public IntObj(int i){value = i;}    
	@Override
    public String toString() {
        return String.valueOf(this.value);
    }
}
class FloatObj {public float value; public FloatObj(){} public FloatObj(float i){value = i;}    
	@Override
    public String toString() {
        return String.valueOf(this.value);
    }
}
class LongObj {public long value; public LongObj(){} public LongObj(long i){value = i;}    
	@Override
    public String toString() {
        return String.valueOf(this.value);
    }
}
class DoubleObj {public double value; public DoubleObj(){} public DoubleObj(double i){value = i;}    
	@Override
    public String toString() {
        return String.valueOf(this.value);
    }
}
class CharObj {public char value; public CharObj(){} public CharObj(char i){value = i;}    
	@Override
    public String toString() {
        if (this.value == 0) {
            return "null";
        } else {
            return Character.toString(this.value);
        }
    }
}
public class ClassDef {
	public java.util.Scanner scanner;
	public String output = "";

	public static void main(String[] args)  {
	ClassDef mainClass = new ClassDef();
		String output;
		if(args.length > 0) {
			mainClass.scanner = new java.util.Scanner(args[0]);
		} else {
			mainClass.scanner = new java.util.Scanner(System.in);
		}
		mainClass.exec();
		System.out.println(mainClass.output);
	}

    public void exec ()  {
	String name = "REF_digits";
        IntObj j = new IntObj(), k = new IntObj();
        output += (String.format("\nEnter an integer > "));
        j.value = scanner.nextInt();
        while(Math.abs(j.value) >= 10){
            k.value = j.value % 10;
            output += (String.format("\n%d", Math.abs(k.value)));
            j.value = j.value / 10;
        }
        ;
        output += (String.format("\n%d", j.value));
        output += (String.format("\nThat's all, have a nice day!\n"));
        if(true)return;;
    }
}