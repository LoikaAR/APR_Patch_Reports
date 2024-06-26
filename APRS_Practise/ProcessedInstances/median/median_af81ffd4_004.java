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
	String name = "median_af81ffd4_004";
        DoubleObj first = new DoubleObj (), second = new DoubleObj (), third =
            new DoubleObj ();
        DoubleObj median = new DoubleObj ();
        DoubleObj comp_fir = new DoubleObj (), comp_sec =
            new DoubleObj (), comp_thi = new DoubleObj ();
        output +=
            (String.format ("Please enter 3 numbers separated by spaces > "));
        first.value = scanner.nextDouble ();
        second.value = scanner.nextDouble ();
        third.value = scanner.nextDouble ();
        median.value =
            (Math.abs (first.value) + Math.abs (second.value) +
             Math.abs (third.value)) / 3;
        comp_fir.value = Math.abs (first.value - median.value);
        comp_sec.value = Math.abs (second.value - median.value);
        comp_thi.value = Math.abs (third.value - median.value);
        if (comp_fir.value < comp_sec.value && comp_fir.value < comp_thi.value) {
            output += (String.format ("%.0f is the median\n", first.value));
        } else if (comp_sec.value < comp_fir.value
                   && comp_sec.value < comp_thi.value) {
            output += (String.format ("%.0f is the median\n", second.value));
        } else if (comp_thi.value < comp_fir.value
                   && comp_thi.value < comp_sec.value) {
            output += (String.format ("%.0f is the median\n", third.value));
        }
        if (true)
            return;;
    }
}
