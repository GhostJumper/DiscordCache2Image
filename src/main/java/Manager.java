import conversion.Converter;
import filesAndFolders.GetDirs;
import statistics.CopiedFileCounter;
import java.io.File;


public class Manager {
    public static void main(String[] args) {
        new Manager(args);
    }

    public Manager(String[] args) {
        argsManager(args);
    }

    private void argsManager(String[] args) {
        if (args.length == 1) {

            if (args[0].equals("-h") || args[0].equals("--help")) {
                System.out.println("Enter the folderpath of the folder you want the images to be in");
                System.out.println("Example: java -jar thisJar.jar \"/path/to/the/folder\"");
            } else {
                if (new File(args[0]).exists()){
                    copy(args[0]);
                } else {
                    System.out.println("path is not valid");
                }
            }

        } else System.out.println("Too many arguments.\r\nUse -h or --help for help");
    }

    private void copy(String path) {
        new Converter().copyAllAndRename(GetDirs.getDiscordCachePath(), path);
        System.out.println("Copied " + CopiedFileCounter.get() + " images");
    }
}
