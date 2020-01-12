import fileManagement.FileCopy;

public class Manager {
    public static void main(String[] args) {
        try {
            new FileCopy().copyAllAndRename(args[0],args[1]);
        } catch (Exception e) {
            e.printStackTrace();

            System.out.println("Plz enter path");
        }
    }
}
