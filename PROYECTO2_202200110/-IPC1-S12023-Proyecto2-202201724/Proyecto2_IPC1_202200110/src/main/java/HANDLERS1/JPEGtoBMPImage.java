
package HANDLERS1;

import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import org.apache.commons.io.FilenameUtils;

/**
 *
 * @author DELL
 */
public class JPEGtoBMPImage extends ImageHandler{
    
    String nombreCorto;
    BufferedImage jpg;
    BufferedImage bmp;
    File bmpTemporal;
    File jpegTemporal;

    public JPEGtoBMPImage(String filename) {
        super(filename);
        File f = new File(filename);
        this.nombreCorto = FilenameUtils.removeExtension(f.getName());
    }

    @Override
    public void readFile() throws Exception {

}

    @Override
    public void generateFiles() throws Exception {
        File file = new File(getFileName());
        String extension = FilenameUtils.getExtension(getFileName());
        File carpeta = new File("./Temporal");
        if (!carpeta.exists()) {
            carpeta.mkdirs();
        }        
        
        if (extension.equals("jpg") || extension.equals("jpeg")) {
            jpg = ImageIO.read(file);
            bmpTemporal = new File("./bmpTemporal.bmp");
            ImageIO.write(jpg, "bmp", bmpTemporal);
            bmp = ImageIO.read(bmpTemporal);
            ImageIO.write(jpg, "bmp", new File("./Temporal/Converted-" + nombreCorto + ".bmp"));
            bmpTemporal.delete();
        } else {
            //throw new Exception("Formato de archivo no soportado");
        }
    }
}
