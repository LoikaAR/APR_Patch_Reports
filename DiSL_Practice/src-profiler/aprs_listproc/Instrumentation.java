package aprs_listproc;

import java.util.Map;
import java.util.HashMap;
import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;
import ch.usi.dag.disl.annotation.After;
import ch.usi.dag.disl.annotation.Before;
import ch.usi.dag.disl.annotation.ThreadLocal;
import ch.usi.dag.disl.annotation.SyntheticLocal;
import ch.usi.dag.disl.annotation.AfterReturning;
import ch.usi.dag.disl.marker.BodyMarker;
import ch.usi.dag.disl.marker.BytecodeMarker;
import ch.usi.dag.disl.marker.BasicBlockMarker;
import ch.usi.dag.disl.dynamiccontext.DynamicContext;
import ch.usi.dag.disl.staticcontext.MethodStaticContext;
import ch.usi.dag.disl.staticcontext.BasicBlockStaticContext;
import ch.usi.dag.disl.staticcontext.InstructionStaticContext;
import org.junit.Ignore;

public class Instrumentation {
    @SyntheticLocal
    static long entryTime;

    @SyntheticLocal
    static long nInvocations = 0;

    @SyntheticLocal
    static long nAllocations = 0;

    @SyntheticLocal
    static long nFieldAccesses = 0;

    @SyntheticLocal
    static long nBytecodesExecd = 0;

    // Before entering the body of main method:
    @Before(marker = BodyMarker.class, scope = "aprs_listproc.Main.main")
    static void onMainEntry(MethodStaticContext msc, BasicBlockStaticContext bbsc) {
        System.out.format("Method executed:\n %s\n",
                msc.thisMethodName());
    }

    // After exiting the body of main method:
    @After(marker = BodyMarker.class, scope = "aprs_listproc.Main.main")
    static void onMainExit(MethodStaticContext msc, BasicBlockStaticContext bbsc) {

        Profiler.afterBodyOutput.put("#Objects_allocated", nAllocations);
        Profiler.afterBodyOutput.put("#Methods_invoked", nInvocations);
        Profiler.afterBodyOutput.put("#Field_accesses", nFieldAccesses);
        Profiler.afterBodyOutput.put("Methods_invoked", Profiler.methodsInvoked);

        System.out.println("============================================");
        System.out.println("End of main:");
        System.out.format("#Methods invoked: %d\n#Objects allocated: %d\n#Field accesses: %d\n",
                nInvocations, nAllocations, nFieldAccesses);
    }

    @Before(marker = BodyMarker.class, scope = "aprs_listproc.Main.*")
    static void onMethodExit(MethodStaticContext msc, BasicBlockStaticContext bbsc) {
        String info = "{ \"descriptor\": " + "\"" + msc.thisMethodDescriptor() + "\", \"#Basic_blocks\": " + "\"" + bbsc.getCount() + "\" }";
        Profiler.methodsInvoked.put(msc.thisMethodName(), info);
    }

    @After(marker = BasicBlockMarker.class, scope = "aprs_listproc.Main.*")
    static void afterAllBasicBlocks(BasicBlockStaticContext bbsc) {
        Profiler.incrementBytecodeCounter(bbsc.getSize());
    }

    @After(marker = BytecodeMarker.class,
            args = "invokestatic, invokespecial, invokeinterface, invokevirtual, invokedynamic",
            scope = "aprs_listproc.Main.*")
    public static void afterMethodInvocation() {
        nInvocations++;
    }

    @After(marker = BytecodeMarker.class,
            args = "new", scope = "aprs_listproc.Main.*")
    public static void afterObjectAllocation() {
        nAllocations++;
    }

    @After(marker = BytecodeMarker.class,
            args = "getfield, putfield, getstatic, putstatic",
            scope = "aprs_listproc.Main.*")
    public static void afterFieldAccess() {
        nFieldAccesses++;
    }

    // At entering the body of binarySearch method:
    // this only has access to args
    // if one argument is array, always stores its length at the next index
    @Before(marker = BodyMarker.class, scope = "aprs_listproc.Main.binarySearch")
    static void onBinSearchEntry(MethodStaticContext msc, BasicBlockStaticContext bbsc, DynamicContext dc) {
        int nBasicBlocks = bbsc.getCount();
        Profiler.beforeBodyOutput.put("#Basic_blocks", nBasicBlocks);
    }

    // get all variable values after the execution of the first basic block of the instrumented method
    @After(marker = BasicBlockMarker.class, scope = "aprs_listproc.Main.binarySearch", guard=BasicBlockGuardZero.class)
    static void afterBinarySearchBB(DynamicContext dc, MethodStaticContext msc, BasicBlockStaticContext bbsc) {
        Profiler.varsBeforeBody.put("0", dc.getLocalVariableValue(0, Object.class).toString());
        Profiler.varsBeforeBody.put("1", dc.getLocalVariableValue(1, Integer.class).toString());
        Profiler.varsBeforeBody.put("2", dc.getLocalVariableValue(2, int.class).toString());
        Profiler.varsBeforeBody.put("3", dc.getLocalVariableValue(3, String.class).toString());
        Profiler.varsBeforeBody.put("4", dc.getLocalVariableValue(4, int.class).toString());
        Profiler.varsBeforeBody.put("5", dc.getLocalVariableValue(5, int.class).toString());
        Profiler.varsBeforeBody.put("6", dc.getLocalVariableValue(6, int.class).toString());
        Profiler.varsBeforeBody.put("7", "not_declared");
        Profiler.varsBeforeBody.put("8", "not_declared");
    }

    @After(marker = BasicBlockMarker.class, scope = "aprs_listproc.Main.binarySearch", guard=BasicBlockGuardSix.class)
    static void afterBinarySearchBBInner(DynamicContext dc, MethodStaticContext msc, BasicBlockStaticContext bbsc) {
        Profiler.varsAfterBody.put("7", dc.getLocalVariableValue(7, int.class).toString());
        Profiler.varsAfterBody.put("8", dc.getLocalVariableValue(8, String.class).toString());
    }

    // After return of binarySearch method:
    @AfterReturning(marker = BodyMarker.class, scope = "aprs_listproc.Main.binarySearch")
    static void afterBinarySearchMethod(DynamicContext dc, MethodStaticContext msc) {
        Profiler.varsAfterBody.put("0", dc.getLocalVariableValue(0, Object.class).toString());
        Profiler.varsAfterBody.put("1", dc.getLocalVariableValue(1, Integer.class).toString());
        Profiler.varsAfterBody.put("2", dc.getLocalVariableValue(2, int.class).toString());
        Profiler.varsAfterBody.put("3", dc.getLocalVariableValue(3, String.class).toString());
        Profiler.varsAfterBody.put("4", dc.getLocalVariableValue(4, int.class).toString());
        Profiler.varsAfterBody.put("5", dc.getLocalVariableValue(5, int.class).toString());
        Profiler.varsAfterBody.put("6", dc.getLocalVariableValue(6, int.class).toString());

        String output = dc.getStackValue(0, Integer.class).toString();
        Profiler.afterBodyOutput.put("output", output);
    }
}