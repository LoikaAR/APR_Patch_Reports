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
	String name = "grade_af81ffd4_007";
        FloatObj a = new FloatObj (), b = new FloatObj (), c =
            new FloatObj (), d = new FloatObj ();
        DoubleObj per = new DoubleObj ();
        output += (String.format ("Enter thresholds for A, B, C, D\n"));
        output += (String.format ("in that order, decreasing percentages > "));
        a.value = scanner.nextFloat ();
        b.value = scanner.nextFloat ();
        c.value = scanner.nextFloat ();
        d.value = scanner.nextFloat ();
        per.value = (a.value + b.value + c.value + d.value) / 4;
        if (per.value < 60) {
            output +=
                (String.format
	ClassDef mainClass = new ClassDef();
        } else if (per.value >= 60 && per.value < 70) {
            output +=
                (String.format
	ClassDef mainClass = new ClassDef();
        } else if (per.value >= 70 && per.value < 80) {
            output +=
                (String.format
	ClassDef mainClass = new ClassDef();
        } else if (per.value >= 80) {
            output +=
                (String.format
	ClassDef mainClass = new ClassDef();
        }
        if (true)
            return;;
    }
}
