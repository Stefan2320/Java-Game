package PaooGame.Items;

import PaooGame.Graphics.Assets;
import PaooGame.RefLinks;
import PaooGame.States.PlayState;

import java.awt.*;
import java.awt.image.BufferedImage;

public class FloatingPlatform extends Item{
    private BufferedImage image = Assets.platformWall;
    private Rectangle colErouDinManager = new Rectangle();
    private boolean inapoi = false;
    private boolean col = false;
    private int move;
    private boolean dreapta = false;
    int poz;
    public FloatingPlatform(RefLinks refLink, float x, float y, int width, int height,int distanta, boolean directie){
        super(refLink, x,y, width, height);
        normalBounds.x = (int) x;
        normalBounds.y = (int) y;
        move = distanta;
        poz = (int)x;
        dreapta = directie;
    }

    public void setColisionRectangle(Rectangle pozitie){
        colErouDinManager = pozitie;
    }

    @Override
    public void Update(){
        //colErouDinManager.width = 32;
        if(dreapta == true)
        {
            if (inapoi == false) {
                if (x < Math.abs(poz + move)) {
                    x++;
                    normalBounds.x++;
                } else
                    inapoi = true;
            }

            if (inapoi == true)
                if (x > Math.abs(poz)) {
                    x--;
                    normalBounds.x--;
                } else
                    inapoi = false;
        }else
            {
            if (inapoi == true) {
                if (x > Math.abs(poz - move)) {
                    x--;
                    normalBounds.x--;
                } else
                    inapoi = false;
            }

            if (inapoi == false) {
                if (x < Math.abs(poz)) {
                    x++;
                    normalBounds.x++;
                } else
                    inapoi = true;
            }
        }




      //colErouDinManager.y += 10;
       //System.out.println(normalBounds.x+ "     "+colErouDinManager.x);
        //System.out.println(normalBounds.width);

        if(normalBounds.intersects(colErouDinManager)) {
            System.out.println("atingeee");
            CollisionPlatforma(true);
        }
        else
        {
            CollisionPlatforma(false);
        }

    }

    public  void CollisionPlatforma(boolean x){
        //System.out.println(x);
        col = x;
    }
    public  boolean GetCollisionPlatforma(){
         return col ;
    }

    @Override
    public void Draw(Graphics g){

        g.drawImage(image, (int) x, (int) y, 32, 32, null);
        Graphics2D g2d = (Graphics2D) g;
        g2d.draw(normalBounds);
        g2d.draw(colErouDinManager);
    }
}
