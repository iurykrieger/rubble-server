package br.edu.ifc.fraiburgo.rubble.utils;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.OutputStream;
import javax.imageio.ImageIO;
import sun.misc.BASE64Decoder;

/**
 *
 * @author iuryk
 */
public class ImageUtils {
    
    public static void writeOutputStream(String value, OutputStream outputStream) throws IOException {
        BASE64Decoder decoder = new BASE64Decoder();
        byte[] imgBytes = decoder.decodeBuffer(value);
        BufferedImage bufImg = ImageIO.read(new ByteArrayInputStream(imgBytes));
        ImageIO.write(bufImg, "jpg", outputStream);
    }
}
