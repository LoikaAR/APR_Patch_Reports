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
	String name = "REF_smallest";
        IntObj num1 = new IntObj(), num2 = new IntObj(), num3 = new IntObj(), num4 = new IntObj(), bigger = new IntObj(), bigger2 = new IntObj(), biggest = new IntObj();
        output += (String.format("Please enter 4 numbers separated by spaces > "));
        num1.value = scanner.nextInt();
        num2.value = scanner.nextInt();
        num3.value = scanner.nextInt();
        num4.value = scanner.nextInt();
        if(num1.value < num2.value){
            bigger.value = num1.value;
        } else {
            bigger.value = num2.value;
        }
        if(num4.value < num3.value){
            bigger2.value = num4.value;
        } else {
            bigger2.value = num3.value;
        }
        if(bigger.value < bigger2.value){
            biggest.value = bigger.value;
        } else {
            biggest.value = bigger2.value;
        }
        output += (String.format("%d is the smallest\n", biggest.value));
        if(true)return;;
    }
}
