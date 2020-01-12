package fileManagement;

import imageIdent.ImageIdentifier;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class FileCopy {

    private ImageIdentifier imageIdentifier = new ImageIdentifier();



    public void copyAllAndRename(String source, String destination) throws Exception{
        ArrayList<File> filesFrom = addFilesToArrayList(new File(source));
        ArrayList<File> filesTo = new ArrayList<File>();
        for (int i=0;i<filesFrom.size();i++){
            filesTo.add(new File(destination+"\\"+filesFrom.get(i).getName()+"."+imageIdentifier.getFileFormat(filesFrom.get(i))));
            System.out.println(filesFrom.get(i).getPath()+"   "+filesTo.get(i).getPath());
        }

        for (int i = 0;i<filesFrom.size();i++){
            if (!filesTo.get(i).getName().contains(".not found"))
                copy(filesFrom.get(i),filesTo.get(i));
        }


    }

    private ArrayList<File> addFilesToArrayList(File source){
        ArrayList<File> filesInFolder = new ArrayList<File>();
        File[] listOfFiles = source.listFiles();
        for (File file : listOfFiles) {
            if (file.isFile()) {
                filesInFolder.add(file);
            }
        }
        return filesInFolder;
    }

    private void copy(File input, File output) throws Exception{
        FileInputStream fis = new FileInputStream(input);
        FileOutputStream fos = new FileOutputStream(output);

            byte[] buffer = new byte[1024];
            int length;

            while ((length = fis.read(buffer)) > 0) {

                fos.write(buffer, 0, length);
            }

    }
}
