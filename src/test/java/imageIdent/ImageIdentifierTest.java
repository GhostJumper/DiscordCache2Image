package imageIdent;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

public class ImageIdentifierTest {

    private ArrayList<File> files = new ArrayList<File>();
    private ImageIdentifier imageIdentifier = new ImageIdentifier();

    @Before
    public void setUp() {
        files.add(new File("TestFiles/TestGif.gif"));
    }

    @Test
    public void getFileFormat() throws Exception{
        assertThat(imageIdentifier.getFileFormat(files.get(0))).isEqualTo("gif");
    }
}