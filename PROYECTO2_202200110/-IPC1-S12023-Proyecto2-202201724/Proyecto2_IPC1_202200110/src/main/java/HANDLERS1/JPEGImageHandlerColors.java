
package HANDLERS1;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import org.apache.commons.io.FilenameUtils;

public class JPEGImageHandlerColors extends ImageHandler{
    
    String nombreCorto;
    BufferedImage jpg;
    BufferedImage bmp;
    BufferedImage bmp1;
    BufferedImage bmp2;
    BufferedImage bmp3;
    File bmpTemporal;
    
    public JPEGImageHandlerColors(String filename) {
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
        bmp2 = ImageIO.read(bmpTemporal);
        bmp3 = ImageIO.read(bmpTemporal);
    }

    @Override
    public void generateFiles() throws Exception {
        
        for(int x = 0; x < bmp.getWidth(); x++){
            for(int y = 0; y < bmp.getHeight(); y++){
                Color color = new Color(bmp.getRGB(x,y));
                int promedio = color.getRed();
                Color newColor = new Color(promedio, 0, 0);
                bmp.setRGB(x, y, newColor.getRGB());
            }
        }
        
        for(int x = 0; x < bmp1.getWidth(); x++){
            for(int y = 0; y < bmp1.getHeight(); y++){
                Color color = new Color(bmp1.getRGB(x,y));
                int promedio = color.getGreen();
                Color newColor = new Color(0, promedio, 0);
                bmp1.setRGB(x, y, newColor.getRGB());
            }
        }
        
        for(int x = 0; x < bmp2.getWidth(); x++){
            for(int y = 0; y < bmp2.getHeight(); y++){
                Color color = new Color(bmp2.getRGB(x,y));
                int promedio = color.getBlue();
                Color newColor = new Color(0, 0, promedio);
                bmp2.setRGB(x, y, newColor.getRGB());
            }
        }

        for (int x = 0; x < bmp3.getWidth(); x++) {
            for (int y = 0; y < bmp3.getHeight(); y++) {
            Color color = new Color(bmp3.getRGB(x, y));
            int red = color.getRed();
            int green = color.getGreen();
            int blue = color.getBlue();

            int newRed = (int) (red * 0.393 + green * 0.769 + blue * 0.189);
            int newGreen = (int) (red * 0.349 + green * 0.686 + blue * 0.168);
            int newBlue = (int) (red * 0.272 + green * 0.534 + blue * 0.131);

            newRed = Math.min(newRed, 255);
            newGreen = Math.min(newGreen, 255);
            newBlue = Math.min(newBlue, 255);

            Color newColor = new Color(newRed, newGreen, newBlue);
            bmp3.setRGB(x, y, newColor.getRGB());
        }
    }
                 
        ImageIO.write(bmp, "jpg", new File("./Red-" + nombreCorto + ".jpeg"));
        ImageIO.write(bmp1, "jpg", new File("./Green-" + nombreCorto + ".jpeg"));
        ImageIO.write(bmp2, "jpg", new File("./Blue-" + nombreCorto + ".jpeg"));
        ImageIO.write(bmp3, "jpg", new File("./Sepia-" + nombreCorto + ".jpeg"));
        bmpTemporal.delete();
    }  
    
}
