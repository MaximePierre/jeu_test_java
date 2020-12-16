package map;

import java.awt.Graphics;
//import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
//import java.awt.image.DataBufferInt;
//import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JFrame;


public class map {

    public void createmap() throws IOException {
    JFrame frame = new JFrame("Test");

    frame.add(new JComponent() {

         BufferedImage map = ImageIO.read(new File("./public/images/texture_map/grass.jpg"));
           
         @Override
         protected void paintComponent(Graphics g) {
              super.paintComponent(g);

              // create the transform, note that the transformations happen
              // in reversed order (so check them backwards)
              AffineTransform at = new AffineTransform();

              // 4. translate it to the center of the component
              at.translate(getWidth() / 2, getHeight() / 2);

              // 3. do the actual rotation
              at.rotate(Math.PI/4);

                // do 3d isometrique
              at.shear(-0.5, -0.5);

              // 2. just a scale because this image is big
              at.scale(0.5, 0.5);

              // 1. translate the object so that you rotate it around the 
              //    center (easier :))
              at.translate(-map.getWidth()/2, -map.getHeight()/2);

              // draw the image
              Graphics2D g2d = (Graphics2D) g;
              g2d.drawImage(map, at, null);

              // continue drawing other stuff (non-transformed)
              //...

         }
    });

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(1000, 1000);
    frame.setVisible(true);
}
}