
package HANDLERS1;

import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import org.apache.commons.io.FilenameUtils;


public class BMPtoJPEGImage extends ImageHandler{
    
    String nombreCorto;
    BufferedImage jpg;
    BufferedImage bmp;
    File bmpTemporal;
    File jpegTemporal;    

    public BMPtoJPEGImage(String filename) {
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
         
        if (extension.equals("bmp")) {
            bmp = ImageIO.read(file);
         
            jpegTemporal = new File("./bmpTemporal.bmp");
            ImageIO.write(bmp, "jpeg", jpegTemporal);
            jpg = ImageIO.read(jpegTemporal);
            ImageIO.write(bmp, "jpg", new File("./Temporal/Converted-" + nombreCorto + ".jpg"));
            jpegTemporal.delete();
        } else {
            //throw new Exception("Formato de archivo no soportado");
        }
    }
}
