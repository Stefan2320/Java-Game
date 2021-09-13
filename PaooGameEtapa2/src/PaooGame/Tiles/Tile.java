package PaooGame.Tiles;

import java.awt.*;
import java.awt.image.BufferedImage;

/*! \class public class Tile
    \brief Retine toate dalele intr-un vector si ofera posibilitatea regasirii dupa un id.
 */
public class Tile
{
    private static final int NO_TILES   = 32;
    public static Tile[] tiles = new Tile[NO_TILES];       /*!< Vector de referinte de tipuri de dale.*/

        /// De remarcat ca urmatoarele dale sunt statice si publice. Acest lucru imi permite sa le am incarcate
        /// o singura data in memorie
    public static Tile topClimbTile  = new topClimb(0);
    public static Tile wall1Int = new wall1Int(1);
    public static Tile wall1   = new wall1(2);
    public static Tile wall2 = new wall2(4);
    public static Tile wall2Int = new wall2Int(3);
    public static Tile wallExt = new wallExt(5);
    public static Tile wallBlue = new wallBlue(6);
    public static Tile wallBrown = new wallBrown(7);
    public static Tile wallBlueRomb = new wallBlueRomb(8);
    public static Tile platformBlue = new platformBlue(9);
    public static Tile portal = new portal(10);
    public static Tile coin = new coin(11);
    public static Tile platformWall = new platformWall(12);
    public static Tile steleGalbene = new steleGalbene(13);
    public static Tile steleAlbe = new steleAlbe(14);
    public static Tile steleMariAlbe = new steleMariAlbe(15);
    public static Tile steleMariGalbene = new steleMariGalbene(16);
    public static Tile luna = new luna(17);
    public static Tile steleSpeciale = new steleSpeciale(18);
    public static Tile gol = new gol(19);



    public static final int TILE_WIDTH  = 32;                       /*!< Latimea unei dale.*/
    public static final int TILE_HEIGHT = 32;                       /*!< Inaltimea unei dale.*/

    protected BufferedImage img;                                    /*!< Imaginea aferenta tipului de dala.*/
    protected final int id;                                         /*!< Id-ul unic aferent tipului de dala.*/

    /*! \fn public Tile(BufferedImage texture, int id)
        \brief Constructorul aferent clasei.

        \param image Imaginea corespunzatoare dalei.
        \param id Id-ul dalei.
     */
    public Tile(BufferedImage image, int idd)
    {
        img = image;
        id = idd;
        tiles[id] = this;
    }

    /*! \fn public void Update()
        \brief Actualizeaza proprietatile dalei.
     */
    public void Update()
    {

    }

    /*! \fn public void Draw(Graphics g, int x, int y)
        \brief Deseneaza in fereastra dala.

        \param g Contextul grafic in care sa se realizeze desenarea
        \param x Coordonata x in cadrul ferestrei unde sa fie desenata dala
        \param y Coordonata y in cadrul ferestrei unde sa fie desenata dala
     */
    public void Draw(Graphics g, int x, int y)
    {
            /// Desenare dala
        g.drawImage(img, x, y, TILE_WIDTH, TILE_HEIGHT, null);
    }

    /*! \fn public boolean IsSolid()
        \brief Returneaza proprietatea de dala solida (supusa coliziunilor) sau nu.
     */
    public boolean IsSolid()
    {
        return false;
    }
    public boolean IsPortal() {return false;}

    /*! \fn public int GetId()
        \brief Returneaza id-ul dalei.
     */
    public int GetId()
    {

        return id;
    }


}
