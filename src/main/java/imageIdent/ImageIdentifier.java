package imageIdent;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import java.io.File;
import java.util.Iterator;

public class ImageIdentifier {

    public String getFileFormat(File file){
        try {
            ImageInputStream iis = ImageIO.createImageInputStream(file);

            Iterator<ImageReader> imageReaders = ImageIO.getImageReaders(iis);

            while (imageReaders.hasNext()) {
                ImageReader reader = (ImageReader) imageReaders.next();
                return (reader.getFormatName());
            }
        } catch (Exception e){

        }
        return "not found";
    }
}
