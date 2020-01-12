import conversion.Converter;
import filesAndFolders.GetDirs;
import statistics.CopiedFileCounter;

public class Manager {
    public static void main(String[] args) {
        new Manager(args);
    }

    public Manager(String[] args) {
        argsManager(args);
    }

    private void argsManager(String[] args) {
        if (args.length == 1) {

            if (args[0].equals("-h") || args[0].equals("-help")) {
                System.out.println("Enter the folderpath of the folder you want the images to be in");
            } else {
                copy(args[0]);
            }

        } else System.out.println("use -h or -help for help");
    }

    private void copy(String path) {
        new Converter().copyAllAndRename(GetDirs.getDiscordCachePath(), path);
        System.out.println("Copied " + CopiedFileCounter.get() + " images");
    }
}
