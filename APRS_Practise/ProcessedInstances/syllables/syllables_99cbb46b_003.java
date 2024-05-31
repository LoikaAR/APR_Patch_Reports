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
	String name = "syllables_99cbb46b_003";
        char[] str = new char[20];
        IntObj i = new IntObj (), syl = new IntObj (), len = new IntObj ();
        output += (String.format ("Please enter a string > "));
        str = scanner.next ().toCharArray ();
        len.value = str.length;
        syl.value = 0;
        for (i.value = 0; i.value < len.value; i.value++) {
            if (str[i.value] == 'a' || str[i.value] == 'e' || str[i.value] == 'i'
                    || str[i.value] == 'o' || str[i.value] == 'u'
                    || str[i.value] == 'y') {
                syl.value++;
            }
        }
	ClassDef mainClass = new ClassDef();
        if (true)
            return;;
    }
}
