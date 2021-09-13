package PaooGame.Items;

import PaooGame.Graphics.Assets;
import PaooGame.RefLinks;
import PaooGame.States.PlayState;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Coins extends Item{
    private BufferedImage image = Assets.coin;
    private boolean touched = false;
    private Rectangle colErouDinManager = new Rectangle();


    public Coins(RefLinks refLink, float x, float y, int width, int height){
        super(refLink, x,y, width, height);
        normalBounds.x = (int) x;
        normalBounds.y = (int) y;
    }

    public void setColisionRectangle(Rectangle pozitie){
        colErouDinManager = pozitie;
    }

    @Override
    public void Update(){
       // System.out.println(colErouDinManager.x+" "+normalBounds.x);
       // colErouDinManager.width = 8;
        if(normalBounds.intersects(colErouDinManager)) {
            touched = true;
        }

    }

    public boolean getTouched(){
        return touched;
    }

    @Override
    public void Draw(Graphics g){
        if(touched == false) {
            Graphics2D g2d = (Graphics2D) g;
            g2d.draw(normalBounds);
            g2d.draw(colErouDinManager);
            g.drawImage(image, (int) x, (int) y, 32, 32, null);


        }
    }
}
