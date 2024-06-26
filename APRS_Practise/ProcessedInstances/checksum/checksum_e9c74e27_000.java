package aprs_introclass;

class IntObj {
    public int value;
    public IntObj () {
    } public IntObj (int i) {
        value = i;
    }
    @Override
    public String toString() {
        return String.valueOf(this.value);
    }

}

class FloatObj {
    public float value;
    public FloatObj () {
    } public FloatObj (float i) {
        value = i;
    }
    @Override
    public String toString() {
        return String.valueOf(this.value);
    }

}

class LongObj {
    public long value;
    public LongObj () {
    } public LongObj (long i) {
        value = i;
    }
    @Override
    public String toString() {
        return String.valueOf(this.value);
    }

}

class DoubleObj {
    public double value;
    public DoubleObj () {
    } public DoubleObj (double i) {
        value = i;
    }
    @Override
    public String toString() {
        return String.valueOf(this.value);
    }

}

class CharObj {
    public char value;
    public CharObj () {
    } public CharObj (char i) {
        value = i;
    }
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
	String name = "checksum_e9c74e27_000";
        CharObj orig = new CharObj ();
        IntObj code = new IntObj (), accum = new IntObj ();
        CharObj checksum = new CharObj ();
        output +=
            (String.format
             ("Enter an abitrarily long string, ending with carriage return > "));
        accum.value = 0;
        checksum.value = 0;
        code.value = 0;
        orig.value = ' ';
        do {
            try {
                orig.value = scanner.findInLine (".").charAt (0);
            } catch (java.lang.NullPointerException e) {
                orig.value = '\n';
            };
            code.value = (int) orig.value;
            accum.value += code.value;
        } while (orig.value != '\n');
        checksum.value = (char) ((accum.value % 64) + 22);
        output += (String.format ("Check sum is %c\n", checksum.value));
        if (true)
            return;;
    }
}
