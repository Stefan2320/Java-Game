package PaooGame.Items;

import PaooGame.Graphics.Assets;
import PaooGame.RefLinks;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.concurrent.TimeUnit;

public class Monster extends Item{


    private BufferedImage imageLeft = Assets.monsterLeft;
    private BufferedImage imageRight = Assets.monsterRight;

    private Rectangle colErouDinManager = new Rectangle();
    private boolean inapoi = false;
    public static boolean col = false;
    private boolean dreapta = false;
    private boolean stanga = false;
    public  int life;
    private boolean damageTaken = false;
    private int damageTime = 0;
    int mergDreapta;
    int walk ;

    public Monster(RefLinks refLink, float x, float y, int width, int height, int viata,int distanta){
        super(refLink, x,y, width, height);
        normalBounds.x = (int) x +5;
        normalBounds.y = (int) y + 10;
        mergDreapta = (int)x;
        life = viata;
        walk = distanta;
    }

    public void setColisionRectangle(Rectangle pozitie){
        colErouDinManager = pozitie;
    }

    @Override
    public void Update(){
        //colErouDinManager.width = 32;
        if(life > 0) {
            if (inapoi == false) {
                if (x < mergDreapta+walk) {
                    x++;
                    normalBounds.x++;
                    dreapta = true;
                    stanga = false;
                } else
                    inapoi = true;
            }

            if (inapoi == true)
                if (x > mergDreapta) {
                    x--;
                    normalBounds.x--;
                    dreapta = false;
                    stanga = true;
                } else
                    inapoi = false;


            //colErouDinManager.y += 32;
            //System.out.println(normalBounds.x+ "     "+colErouDinManager.x);
            //System.out.println(normalBounds.width);


            if (normalBounds.intersects(colErouDinManager)) {
               // System.out.println("atingeee");

                if (refLink.GetKeyManager().space) {
                    damageTime++;
                    if (damageTime == 5) {
                        damageTime = 0;
                        damageTaken = true;
                    } else {
                        damageTaken = false;
                    }
                    if (damageTaken == true) {
                       // System.out.println("Ataca");
                        life--;
                    }
                }

                col = true;

            }
            else
                {

                 col =false;
                //System.out.println("aici");
            }
        }else {

            col =false;
        }
    }




    public  static boolean GetCollisionMonster(){

        return col ;
    }

    @Override
    public void Draw(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        g2d.draw(colErouDinManager);
        g2d.draw(normalBounds);
        if(stanga == true)
            g.drawImage(imageLeft, (int) x, (int) y, 32, 32, null);
        else
            g.drawImage(imageRight, (int) x, (int) y, 32, 32, null);
    }
}
