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
	String name = "syllables_b6fd408d_000";
        char[] word = new char[40];
        IntObj i = new IntObj (0);
        IntObj count = new IntObj (0);
        output += (String.format ("Please enter a string > "));
        word = (scanner.nextLine () + "\n").toCharArray ();
        while (i.value < word.length) {
            if (word[i.value] == 'a' || word[i.value] == 'o'
                    || word[i.value] == 'e' || word[i.value] == 'u'
                    || word[i.value] == 'y') {
                count.value++;
            }
            i.value++;
        }
        output +=
	ClassDef mainClass = new ClassDef();
        if (true)
            return;;
    }
}
