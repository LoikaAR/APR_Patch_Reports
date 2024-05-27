package aprs_introclass;

class IntObj {
    public int value;
    public IntObj () {
    } public IntObj (int i) {
        value = i;
    }
}

class FloatObj {
    public float value;
    public FloatObj () {
    } public FloatObj (float i) {
        value = i;
    }
}

class LongObj {
    public long value;
    public LongObj () {
    } public LongObj (long i) {
        value = i;
    }
}

class DoubleObj {
    public double value;
    public DoubleObj () {
    } public DoubleObj (double i) {
        value = i;
    }
}

class CharObj {
    public char value;
    public CharObj () {
    } public CharObj (char i) {
        value = i;
    }
}

public class ClassDef {
    public java.util.Scanner scanner;
    public String output = "";

    public static void main (String[]args)  {
	ClassDef mainClass = new ClassDef();
        String output;
        if (args.length > 0) {
            mainClass.scanner = new java.util.Scanner (args[0]);
        } else {
            mainClass.scanner = new java.util.Scanner (System.in);
        }
        mainClass.exec ();
        System.out.println (mainClass.output);
    }

    public void exec ()  {
	String name = "digits_1b31fa5c_002";
        IntObj test = new IntObj (), remainder = new IntObj (), status =
            new IntObj (), n = new IntObj ();
        output += (String.format ("\nEnter an integer > "));
        n.value = scanner.nextInt ();
        status.value = n.value;
        test.value = status.value;
        output += (String.format ("\n"));
        if (n.value < 0) {
            n.value = n.value * -1;
        }
        while (test.value != 0) {
            remainder.value = n.value % 10;
            n.value = n.value / 10;
            test.value = n.value;
            if ((status.value < 0) && (n.value == 0)) {
                remainder.value = -1 * remainder.value;
            }
            output += (String.format ("%d\n", remainder.value));
        }
        output += (String.format ("That's all, have a nice day!\n"));
        if (true)
            return;;
    }
}
