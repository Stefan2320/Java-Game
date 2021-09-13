package PaooGame.Maps;

import PaooGame.RefLinks;
import PaooGame.Tiles.Tile;
import PaooGame.Tiles.TileError;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

/*! \class public class Map
    \brief Implementeaza notiunea de harta a jocului.
 */
public class Map
{
    private RefLinks refLink;   /*!< O referinte catre un obiect "shortcut", obiect ce contine o serie de referinte utile in program.*/
    private int width;          /*!< Latimea hartii in numar de dale.*/
    private int height;         /*!< Inaltimea hartii in numar de dale.*/
    private int [][] tiles;     /*!< Referinta catre o matrice cu codurile dalelor ce vor construi harta.*/
    private int [][] tiles2;
    public int mapCount = 0;

    /*! \fn public Map(RefLinks refLink)
        \brief Constructorul de initializare al clasei.

        \param refLink O referinte catre un obiect "shortcut", obiect ce contine o serie de referinte utile in program.
     */
    public Map(RefLinks refLink)
    {
        /// Retine referinta "shortcut".
        this.refLink = refLink;
        ///incarca harta de start. Functia poate primi ca argument id-ul hartii ce poate fi incarcat.
        LoadWorld();
    }

    /*! \fn public  void Update()
        \brief Actualizarea hartii in functie de evenimente (un copac a fost taiat)
     */
    public  void Update()
    {

    }

    /*! \fn public void Draw(Graphics g)
        \brief Functia de desenare a hartii.

        \param g Contextl grafi in care se realizeaza desenarea.
     */
    public void Draw(Graphics g)
    {   var i = 0;
        ///Se parcurge matricea de dale (codurile aferente) si se deseneaza harta respectiva
        for(int y = 0; y < refLink.GetGame().GetHeight()/Tile.TILE_HEIGHT; y++)
        {
            for(int x = 0; x < refLink.GetGame().GetWidth()/Tile.TILE_WIDTH; x++)
            {
                GetTile(x, y).Draw(g, (int)x * Tile.TILE_HEIGHT, (int)y * Tile.TILE_WIDTH);
                GetTile2(x, y).Draw(g, (int)x * Tile.TILE_HEIGHT, (int)y * Tile.TILE_WIDTH);
                // System.out.println((int)x * Tile.TILE_HEIGHT+" "+(int)y * Tile.TILE_WIDTH+" "+GetTile(x,y).GetId());

            }
        }
        //System.out.println(i+" AM IESIT");
    }

    /*! \fn public Tile GetTile(int x, int y)
        \brief Intoarce o referinta catre dala aferenta codului din matrice de dale.

        In situatia in care dala nu este gasita datorita unei erori ce tine de cod dala, coordonate gresite etc se
        intoarce o dala predefinita (ex. grassTile, mountainTile)
     */
    public Tile GetTile(int x, int y)
    {
        if(x < 0 || y < 0 || x >= width || y >= height)
        {
            return Tile.topClimbTile;
        }

        Tile t = Tile.tiles[tiles[x][y]];
        if(t == null)
        {

            return Tile.wall1;
        }
        return t;
    }

    public Tile GetTile2(int x, int y)
    {
        if(x < 0 || y < 0 || x >= width || y >= height)
        {
            return Tile.topClimbTile;
        }

        Tile t = Tile.tiles[tiles2[x][y]];
        if(t == null)
        {

            return Tile.wall1;
        }
        return t;
    }


    /*! \fn private void LoadWorld()
        \brief Functie de incarcare a hartii jocului.
        Aici se poate genera sau incarca din fisier harta. Momentan este incarcata static.
     */
    public void LoadWorld()
    {
        width = 30;
        height = 15;
        tiles = new int[width][height];

        tiles2 = new int[width][height];
        for(int y = 0; y < height; y++)
        {
            for(int x = 0; x < width; x++)
            {
                tiles[x][y] = MiddleEastMap(y, x);
                tiles2[x][y] = Layer2(y,x);
            }
        }
    }


    private int MiddleEastMap(int x ,int y)
    {
        ///Definire statica a matricei de coduri de dale.
        // System.out.println(mapCount);
        Connection c = null;
        Statement stmt = null;
        String FileMAP = "";
        try {
                    Class.forName("org.sqlite.JDBC");
                    c = DriverManager.getConnection("jdbc:sqlite:BazaDeDataJoc.db");
                    c.setAutoCommit(false);
                    stmt = c.createStatement();
                    c.commit();
                    ResultSet rs = stmt.executeQuery("SELECT * FROM LABORATOR");
                        while ( rs.next() ) {
                            int id = rs.getInt("ID");
                            String file = rs.getString("FILE");
                            if( id == mapCount)
                                FileMAP=file;
                        }
                    rs.close();
                    stmt.close();
                    c.close();
                } catch (Exception e) {
                    System.err.println(e.getClass().getName() + ": " + e.getMessage());
                    System.exit(0);
                }

            //System.out.println(FileMAP +"AAAAAAAAAAAAAAAA");
        if(mapCount == 0) {
            final int map[][] = new int[15][30];
            try {
                Scanner scanner=new Scanner(new File(FileMAP));
                for(int i = 0; i < 15;  i++){
                    for(int j = 0; j < 30; j++){
                        int id = scanner.nextInt();
                        if(id < 0 || id > 19)
                            throw new TileError("Nu exista acest tile!");
                        else
                            map[i][j] = id;
                    }
                }

            } catch (FileNotFoundException | TileError e) {
                e.printStackTrace();
            }
            return map[x][y];
        }
        else if(mapCount == 1) {
            // CAMERA DIN LVL 1
            final int map[][] = new int[15][30];
            try {
                Scanner scanner=new Scanner(new File(FileMAP));
                for(int i = 0; i < 15;  i++){
                    for(int j = 0; j < 30; j++){
                        int id = scanner.nextInt();
                        if(id < 0 || id > 19)
                            throw new TileError("Nu exista acest tile!");
                        else
                            map[i][j] = id;
                    }
                }

            } catch (FileNotFoundException | TileError e) {
                e.printStackTrace();
            }
            return map[x][y];
        }
        else {
            //mapCount == 3
            System.out.println(mapCount);
            final int map[][] = new int[15][30];
            try {
                Scanner scanner=new Scanner(new File(FileMAP));
                for(int i = 0; i < 15;  i++){
                    for(int j = 0; j < 30; j++){
                        int id = scanner.nextInt();
                        if(id < 0 || id > 19)
                            throw new TileError("Nu exista acest tile!");
                        else
                            map[i][j] = id;
                    }
                }

            } catch (FileNotFoundException | TileError e) {
                e.printStackTrace();
            }
            return map[x][y];
        }

    }

    private int Layer2(int x ,int y)
    {
        ///Definire statica a matricei de coduri de dale.
        Connection c = null;
        Statement stmt = null;
        String FileMAP = "";
        System.out.println(mapCount+"MAPCOUNT");
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:BazaDeDataJocLayer2.db");
            c.setAutoCommit(false);
            stmt = c.createStatement();
            c.commit();
            ResultSet rs = stmt.executeQuery("SELECT * FROM LAYER2");
            while ( rs.next() ) {
                int id = rs.getInt("ID");
                String file = rs.getString("FILE");
                if( id == mapCount) {
                    //System.out.println(file+"ION BAZA DE DATE");
                    FileMAP = file;
                }
            }
            rs.close();
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }

       // System.out.println(FileMAP + "AAAAAAAAAAAAAAAAAA");
        if(mapCount == 0) {
             int map[][] = new int[15][30];
            try {
                Scanner scanner=new Scanner(new File(FileMAP));
                for(int i = 0; i < 15;  i++){
                    for(int j = 0; j < 30; j++){
                        int id = scanner.nextInt();
                        if(id < 0 || id > 19)
                            throw new TileError("Nu exista acest tile!");
                        else
                            map[i][j] = id;
                    }
                }

            } catch (FileNotFoundException | TileError e) {
                e.printStackTrace();
            }
            return map[x][y];


        }
        else if(mapCount == 1)
        {
            int map[][] = new int[15][30];
            try {
                Scanner scanner=new Scanner(new File(FileMAP));
                for(int i = 0; i < 15;  i++){
                    for(int j = 0; j < 30; j++){
                        int id = scanner.nextInt();
                        if(id < 0 || id > 19)
                            throw new TileError("Nu exista acest tile!");
                        else
                            map[i][j] = id;
                    }
                }

            } catch (FileNotFoundException | TileError e) {
                e.printStackTrace();
            }
            return map[x][y];
        } else{
            int map[][] = new int[15][30];
            System.out.println(mapCount+" LEVEL 2222");
            try {
                Scanner scanner=new Scanner(new File(FileMAP));
                for(int i = 0; i < 15;  i++){
                    for(int j = 0; j < 30; j++){
                        int id = scanner.nextInt();
                        if(id < 0 || id > 19)
                            throw new TileError("Nu exista acest tile!");
                        else
                            map[i][j] = id;
                    }
                }

            } catch (FileNotFoundException | TileError e) {
                e.printStackTrace();
            }
            return map[x][y];
        }

    }




}