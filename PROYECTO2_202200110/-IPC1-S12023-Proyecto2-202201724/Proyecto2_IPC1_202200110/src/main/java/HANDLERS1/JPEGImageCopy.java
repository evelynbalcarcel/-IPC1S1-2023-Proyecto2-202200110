
package HANDLERS1;

import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import org.apache.commons.io.FilenameUtils;

public class JPEGImageCopy extends ImageHandler{

    String nombreCorto;
    BufferedImage jpg;
    BufferedImage bmp;
    File bmpTemporal;
    
    public JPEGImageCopy(String filename) {
        super(filename);
        File f = new File(filename);
        this.nombreCorto = FilenameUtils.removeExtension(f.getName());
    }

    @Override
    public void readFile() throws Exception {
        File file = new File(getFileName());
        jpg = ImageIO.read(file);
        bmpTemporal = new File("./bmpTemporal.bmp");
        ImageIO.write(jpg, "bmp", bmpTemporal);
        bmp = ImageIO.read(bmpTemporal);
    }

    @Override
    public void generateFiles() throws Exception {
        
        ImageIO.write(bmp, "jpg", new File("./Copia-" + nombreCorto + ".jpeg"));
        bmpTemporal.delete();
        
    }
    
}
