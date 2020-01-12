package fileManagement;

import org.junit.Before;
import org.junit.Test;

public class FileCopyTest {

    FileCopy fileCopy;

    @Before
    public void setUp() throws Exception {
        fileCopy = new FileCopy();
    }

    @Test
    public void copyAll() throws Exception{
        fileCopy.copyAllAndRename("C:\\Users\\GhostJumper\\AppData\\Roaming\\Discord\\Cache","C:\\Users\\GhostJumper\\Desktop\\TestFolder");
    }

}