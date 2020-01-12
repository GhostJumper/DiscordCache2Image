package conversion;

import filesAndFolders.FileManager;
import imageIdent.ImageIdentifier;
import statistics.CopiedFileCounter;

import java.io.File;
import java.util.ArrayList;

public class Converter {

    private ImageIdentifier imageIdentifier = new ImageIdentifier();
    private FileManager fileManager = new FileManager();

    public void copyAllAndRename(String source, String destination) {
        ArrayList<File> filesFrom = fileManager.folderToFiles(new File(source));
        ArrayList<File> filesTo = createFilesToList(filesFrom, destination);

        initCopyForArrayList(filesFrom, filesTo);
    }

    private ArrayList<File> createFilesToList(ArrayList<File> filesFrom, String destination) {
        ArrayList<File> filesTo = new ArrayList<File>();

        for (int i = 0; i < filesFrom.size(); i++)
            filesTo.add(new File(destination + "\\" + filesFrom.get(i).getName() + "." + imageIdentifier.getFileFormat(filesFrom.get(i))));

        return filesTo;
    }

    /**
     * @param filesFrom ArrayList<File> to copy from
     * @param filesTo   ArrayList<File> to copy to
     */
    private void initCopyForArrayList(ArrayList<File> filesFrom, ArrayList<File> filesTo) {
        for (int i = 0; i < filesFrom.size(); i++) {
            if (!filesTo.get(i).getName().contains(".not found"))
                initCopyForSingleFile(filesFrom.get(i), filesTo.get(i));
        }
    }

    /**
     * @param fileFrom File to copy from
     * @param fileTo   File to copy to
     */
    private void initCopyForSingleFile(File fileFrom, File fileTo) {
        try {
            fileManager.copy(fileFrom, fileTo);
            CopiedFileCounter.inc();
        } catch (Exception e) {
            System.out.println("----Error from Converter----");
            e.printStackTrace();
            System.out.println("----------------------------");
        }

    }
}
