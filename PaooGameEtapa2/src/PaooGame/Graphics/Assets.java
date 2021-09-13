package PaooGame.Graphics;

import java.awt.image.BufferedImage;

/*! \class public class Assets
    \brief Clasa incarca fiecare element grafic necesar jocului.

    Game assets include tot ce este folosit intr-un joc: imagini, sunete, harti etc.
 */
public class Assets
{
        /// Referinte catre elementele grafice (dale) utilizate in joc.
    public static BufferedImage heroLeft;
    public static BufferedImage heroLeft1;
    public static BufferedImage heroLeft2;
    public static BufferedImage heroLeft3;
    public static BufferedImage heroLeft4;
    public static BufferedImage heroLeft5;
    public static BufferedImage heroLeft6;
    public static BufferedImage heroLeft7;
    public static BufferedImage heroRight;
    public static BufferedImage heroRight1;
    public static BufferedImage heroRight2;
    public static BufferedImage heroRight3;
    public static BufferedImage heroRight4;
    public static BufferedImage heroRight5;
    public static BufferedImage heroRight6;
    public static BufferedImage heroRight7;



    public static BufferedImage wall1;
    public static BufferedImage topClimb;
    public static BufferedImage wallBlue;
    public static BufferedImage wallBrown;
    public static BufferedImage wallBlueRomb;
    public static BufferedImage platformBlue;
    public static BufferedImage portal;
    public static BufferedImage wall1Int;
    public static BufferedImage platformWall;
    public static BufferedImage wallExt;
    public static BufferedImage coin;
    public static BufferedImage wall2;
    public static BufferedImage wall2Int;
    public static BufferedImage steleSpeciale;
    public static BufferedImage steleMariGalbene;
    public static BufferedImage steleMariAlbe;
    public static BufferedImage luna;
    public static BufferedImage steleAlbe;
    public static BufferedImage steleGalbene;
    public static BufferedImage gol;

    public static BufferedImage menu;
    public static BufferedImage button;

    public static  BufferedImage monsterLeft;
    public static  BufferedImage monsterRight;
    public static BufferedImage tepi;








    /*! \fn public static void Init()
        \brief Functia initializaza referintele catre elementele grafice utilizate.

        Aceasta functie poate fi rescrisa astfel incat elementele grafice incarcate/utilizate
        sa fie parametrizate. Din acest motiv referintele nu sunt finale.
     */
    public static void Init()
    {
            /// Se creaza temporar un obiect SpriteSheet initializat prin intermediul clasei ImageLoader
        SpriteSheet sheet = new SpriteSheet(ImageLoader.LoadImage("/textures/chestii12v2.png"));
        SpriteSheet fundal = new SpriteSheet(ImageLoader.LoadImage("/textures/imagini_fundal.png"));
        SpriteSheet jucator = new SpriteSheet(ImageLoader.LoadImage("/textures/dwarf.png"));
        SpriteSheet jucator1 = new SpriteSheet(ImageLoader.LoadImage("/textures/dwarf.png"));
        SpriteSheet inamic = new SpriteSheet(ImageLoader.LoadImage("/textures/inamic.png"));


         menu = ImageLoader.LoadImage("/textures/menu.jpeg");
         button = ImageLoader.LoadImage("/textures/buton3.png");
         tepi = ImageLoader.LoadImage("/textures/tepi.png");

         monsterLeft =inamic.crop(0,0,-1);
                 monsterRight=inamic.crop(3,0,-1);
        heroLeft = jucator1.crop(0,0,3);
        heroLeft1 = jucator1.crop(1,6,0);
        heroLeft2 = jucator1.crop(2,6,0);
        heroLeft3 = jucator1.crop(3,6,0);
        heroLeft4 = jucator1.crop(4,6,0);
        heroLeft5 = jucator1.crop(5,6,0);
        heroLeft6 = jucator1.crop(6,6,0);
        heroLeft7 = jucator1.crop(7,6,0);

        heroRight = jucator.crop(0, 1,0);
        heroRight1 = jucator.crop(1, 1,0);
        heroRight2 = jucator.crop(2, 1,0);
        heroRight3 = jucator.crop(3, 1,0);
        heroRight4 = jucator.crop(4, 1,0);
        heroRight5 = jucator.crop(5, 1,0);
        heroRight6 = jucator.crop(6, 1,0);
        heroRight7 = jucator.crop(7, 1,0);


        topClimb = sheet.crop(0, 0,1);
        wall1 = sheet.crop(1, 0,1);
        wallBlue = sheet.crop(2, 0,1);
        wallBrown = sheet.crop(3, 0,1);
        wallBlueRomb = sheet.crop(0, 1,1);
        platformBlue = sheet.crop(1, 1,1);
        portal = sheet.crop(2, 1,1);
        wall1Int = sheet.crop(3, 1,1);
        platformWall = sheet.crop(0, 2,1);
        wallExt = sheet.crop(1, 2,1);
        coin = sheet.crop(2, 2,1);
        wall2 = sheet.crop(3, 2,1);
        wall2Int = sheet.crop(3, 3,1);
        gol = sheet.crop(0,3,1);

        steleGalbene = fundal.crop(0, 0,1);
        steleAlbe = fundal.crop(1, 0,1);
        luna = fundal.crop(2, 0,1);

        steleMariAlbe = fundal.crop(0, 1,1);
        steleMariGalbene = fundal.crop(1, 1,1);
        steleSpeciale = fundal.crop(2, 1,1);





    }
}
