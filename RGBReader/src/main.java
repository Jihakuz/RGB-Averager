//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import javax.imageio.ImageIO;

public class main {
    public main() {
    }

    public static void main(String[] var0) {
        File var1 = new File("E:\\Files\\Code\\rgbReaderL\\src\\input\\");
        File[] var2 = var1.listFiles();

        for(int var3 = 0; var3 < var2.length; ++var3) {
            String var4 = var2[var3].getName();
            String var5 = var4.substring(var4.length() - 4);
            System.out.println(var4);
            if (var5.equals(".png")) {
                System.out.println(var4);
                BufferedImage var6 = null;

                try {
                    var6 = ImageIO.read(new File("src\\input\\" + var4));
                } catch (IOException var26) {
                    var26.printStackTrace();
                }

                int var7 = var6.getWidth();
                int var8 = var6.getHeight();
                int[] var9 = new int[var7 * var8];
                int[] var10 = var6.getRGB(0, 0, var7, var8, var9, 0, var7);
                String var11 = Arrays.toString(var10);

                try {
                    BufferedWriter var12 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("currentRGB.txt"), "utf-8"));
                    var12.write(var11);
                    var12.close();
                } catch (IOException var25) {
                    var25.printStackTrace();
                }

                long var28 = 0L;
                long var14 = 0L;
                long var16 = 0L;

                int var18;
                for(var18 = 0; var18 < 256; ++var18) {
                    var14 += (long)(var10[var18] & 255);
                    var16 += (long)(var10[var18] >>> 8 & 255);
                    var28 += (long)(var10[var18] >>> 16 & 255);
                }

                var18 = (int)var28 / (var7 * var8);
                int var19 = (int)var14 / (var7 * var8);
                int var20 = (int)var16 / (var7 * var8);
                Color var21 = new Color(var18, var20, var19);
                BufferedImage var22 = new BufferedImage(var7, var8, 2);
                Graphics2D var23 = var22.createGraphics();
                var23.setColor(var21);
                var23.fill(new Rectangle(0, 0, var7, var8));
                var23.dispose();

                try {
                    File var24 = new File("src\\output\\" + var4);
                    ImageIO.write(var22, "png", var24);
                } catch (IOException var27) {
                    var27.printStackTrace();
                }
            }
        }

    }
}
