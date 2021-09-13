package PaooGame.Items;

import PaooGame.Graphics.Assets;
import PaooGame.RefLinks;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Spikes extends Item {
    private BufferedImage image = Assets.tepi;
    public boolean touched = false;
    private Rectangle colErouDinManager = new Rectangle();


    public Spikes(RefLinks refLink, float x, float y, int width, int height){
        super(refLink, x,y, width, height);
        normalBounds.x = (int) x;
        normalBounds.y = (int) y;
    }

    public void setColisionRectangle(Rectangle pozitie){
        colErouDinManager = pozitie;
    }

    @Override
    public void Update(){

        touched = false;
        if(normalBounds.intersects(colErouDinManager)) {

            touched = true;

        }
        //System.out.println(touched);

    }

    public boolean getTouched(){
        System.out.println(touched);
        return touched;
    }

    @Override
    public void Draw(Graphics g){

            Graphics2D g2d = (Graphics2D) g;
            g2d.draw(normalBounds);
            g.drawImage(image, (int) x, (int) y, 32, 32, null);



    }
}
