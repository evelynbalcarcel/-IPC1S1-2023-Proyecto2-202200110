
package HANDLERS1;

import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import org.apache.commons.io.FilenameUtils;


public class JPEGImageHandlerRotator extends ImageHandler{
    
    String nombreCorto;
    BufferedImage jpg;
    BufferedImage bmp;
    BufferedImage bmp1;
    File bmpTemporal;
    
    public JPEGImageHandlerRotator(String filename) {
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
        bmp1 = ImageIO.read(bmpTemporal);
    }

    @Override
    public void generateFiles() throws Exception {
        
        int filas = bmp.getWidth();
        int columnas = bmp.getHeight();
        BufferedImage invertedBmp = new BufferedImage(filas, columnas, BufferedImage.TYPE_INT_RGB);
        BufferedImage invertedBmp1 = new BufferedImage(filas, columnas, BufferedImage.TYPE_INT_RGB);
        
        //invertidaHorizontal
        for(int y = 0; y < columnas; y++){
            for(int x = 0; x < filas ; x++){
                int pixel = bmp.getRGB(x,y);
                invertedBmp.setRGB(filas - x - 1, y, pixel);
            }
        }
        
        //invertidaVertical
        for(int x = 0; x < filas ; x++){
            for(int y = 0; y < columnas; y++){
                int pixel = bmp1.getRGB(x,y);
                invertedBmp1.setRGB(x, columnas - y - 1, pixel);
            }
        }
        
        ImageIO.write(invertedBmp, "jpg", new File("./Hrotation" + nombreCorto + ".jpeg"));
        ImageIO.write(invertedBmp1, "jpg", new File("./Vrotation" + nombreCorto + ".jpeg"));
        bmpTemporal.delete();
    }
    
}
