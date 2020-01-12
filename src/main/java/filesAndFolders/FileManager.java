package filesAndFolders;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

/**
 * is used for creating File lists and copying files
 */
public class FileManager {

    /**
     * @param folder Directory file to search in
     * @return ArrayList<File> with Files from that folder
     */
    public ArrayList<File> folderToFiles(File folder) {
        ArrayList<File> filesInFolder = new ArrayList<File>();
        File[] listOfFiles = folder.listFiles();
        if (listOfFiles != null)
            for (File file : listOfFiles) {
                if (file.isFile()) {
                    filesInFolder.add(file);
                }
            }
        return filesInFolder;
    }

    /**
     * @param input  File to copy from
     * @param output File to copy to
     */
    public void copy(File input, File output) {
        try {
            FileInputStream fis = new FileInputStream(input);
            FileOutputStream fos = new FileOutputStream(output);

            byte[] buffer = new byte[1024];
            int length;

            while ((length = fis.read(buffer)) > 0) {

                fos.write(buffer, 0, length);
            }
        } catch (IOException e) {
            System.out.println("---Error from FileManager---");
            e.printStackTrace();
            System.out.println("----------------------------");
        }

    }
}
