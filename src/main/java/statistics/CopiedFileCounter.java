package statistics;

public class CopiedFileCounter {

    private static int copiedFiles = 0;

    public static void inc() {
        copiedFiles++;
    }

    public static int get() {
        return copiedFiles;
    }

}
