package PaooGame.Items;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.concurrent.TimeUnit;
import PaooGame.RefLinks;
import PaooGame.Graphics.Assets;
import PaooGame.States.AboutState;
import PaooGame.States.MenuState;
import PaooGame.States.ScoreState;

/*! \class public class Hero extends Character
    \brief Implementeaza notiunea de erou/player (caracterul controlat de jucator).

    Elementele suplimentare pe care le aduce fata de clasa de baza sunt:
        imaginea (acest atribut poate fi ridicat si in clasa de baza)
        deplasarea
        atacul (nu este implementat momentan)
        dreptunghiul de coliziune
 */
public class Hero extends Character {

    private ArrayList<Observer> observer = new ArrayList<Observer>();
    private BufferedImage image;    /*!< Referinta catre imaginea curenta a eroului.*/
    private boolean jump = true;
    private boolean stanga = true;
    private boolean platoforma = false;
    private boolean Go = false;
    public int currentLife ;
    private static Hero erou_singleton;
    private boolean damageTaken = false;
    private int damageTime = 0;
    public  int HeroScore = 0;


    public Hero(RefLinks refLink, float x, float y) {
        ///Apel al constructorului clasei de baza
        super(refLink, x, y, Character.DEFAULT_CREATURE_WIDTH, Character.DEFAULT_CREATURE_HEIGHT);
        ///Seteaza imaginea de start a eroului
        image = Assets.heroRight;
        currentLife = DEFAULT_LIFE;
        ///Stabilieste pozitia relativa si dimensiunea dreptunghiului de coliziune, starea implicita(normala)
        normalBounds.x = 0;
        normalBounds.y = 0;
        normalBounds.width = 20;
        normalBounds.height = 25;

        ///Stabilieste pozitia relativa si dimensiunea dreptunghiului de coliziune, starea de atac
        attackBounds.x = 10;
        attackBounds.y = 10;
        attackBounds.width = 16;
        attackBounds.height = 16;


    }
    public void addObserver(Observer observers)
    {
        observer.add(observers);
    }
    public ArrayList<Observer> getObservers(){
        return observer;
    }
    public void notifyObservers(){
        for(int i = 0; i < observer.size(); i++)
            observer.get(i).Update(refLink);
    }
    public static Hero getInstance(RefLinks reflink){
        if( erou_singleton == null)
            erou_singleton = new Hero(reflink,32, 410);

        return erou_singleton;
    }
    public int GetScore(){
        return HeroScore;
    }

    public void setPlatoformaAndGo(boolean atins,boolean go){

        platoforma = atins;
        Go = go;
    }

    /*! \fn public void Update()
        \brief Actualizeaza pozitia si imaginea eroului.
     */
    public void SetScore(){
        HeroScore = 0;
    }
    public boolean EnemyDamage()  {
        damageTaken = GetMonsterAttack();

        if(damageTaken == true)
            damageTime++;
//un fel de timer
//        if(damageTime == 5){
//            damageTime = 0;
//            damageTaken = true;
//        }
//        else
//        {
//            damageTaken = false;
//        }
        return damageTaken;
    }


    public boolean CollisionJos(){
        boolean z = false;

        //System.out.println(platoforma);
        // refLink.GetMap().GetTile((int)(x + xMove + 16)/32, (int)(y+ yMove+32)/32).IsSolid() == true

        if(refLink.GetMap().GetTile((int)(x)/32, (int)(y +yMove+32)/32).IsSolid() == true  || refLink.GetMap().GetTile2((int)(x+6)/32, (int)(y +yMove+32)/32).IsSolid() == true || refLink.GetMap().GetTile2((int)(x + 26)/32, (int)(y +yMove+32)/32).IsSolid() == true )
        {

            //System.out.println("Orice");
            z = true;

        }
        return z;
    }

    public boolean CollisionStanga(){
        boolean z = false;

        if(refLink.GetMap().GetTile((int)(x+xMove)/32, (int)(y+yMove)/32).IsSolid() == true || refLink.GetMap().GetTile2((int)(x+xMove+6)/32, (int)(y+5)/32).IsSolid() == true || refLink.GetMap().GetTile2((int)(x+xMove+6)/32, (int)(y + 16)/32).IsSolid() == true || refLink.GetMap().GetTile2((int)(x+xMove+6)/32, (int)(y + 32)/32).IsSolid() == true )
        {
            // System.out.println("Stanga");
            z = true;
        }

        return z;
    }

    public boolean CollisionDreapta(){
        boolean z = false;
        if(refLink.GetMap().GetTile((int)(x+xMove+26)/32, (int)(y+16)/32).IsSolid() == true || refLink.GetMap().GetTile2((int)(x+xMove+26)/32, (int)(y+7)/32).IsSolid() == true || refLink.GetMap().GetTile2((int)(x+xMove+26)/32, (int)(y+32)/32).IsSolid() == true || refLink.GetMap().GetTile2((int)(x+xMove+26)/32, (int)(y+16)/32).IsSolid() == true ) {
          //  System.out.println("Dreapta"+refLink.GetMap().GetTile((int)(x+xMove+26)/32, (int)(y+7)/32).GetId());
            z = true;
        }
        return z;
    }
    public boolean CollisionSus(){
        boolean z = false;
        if(refLink.GetMap().GetTile((int)(x+xMove)/32, (int)(y)/32).IsSolid() == true || refLink.GetMap().GetTile2((int)(x+xMove)/32, (int)(y)/32).IsSolid() == true || refLink.GetMap().GetTile2((int)(x+xMove)/32, (int)(y)/32).IsSolid() == true || refLink.GetMap().GetTile2((int)(x+xMove)/32, (int)(y)/32).IsSolid() == true ){
            z = true;
        }
        return z;
    }
    public boolean  Collision(){
        boolean z = false;
        //System.out.println(Get());
        if(refLink.GetMap().GetTile((int)(x+xMove+6)/32, (int)(y +yMove +16)/32).IsSolid() == true || refLink.GetMap().GetTile((int)(x+xMove+26)/32, (int)(y +yMove +16 )/32).IsSolid() == true  || refLink.GetMap().GetTile((int)(x+xMove+26)/32, (int)(y +yMove +32 )/32).IsSolid() == true || refLink.GetMap().GetTile((int)(x+xMove+6)/32, (int)(y +32 )/32).IsSolid() == true  || refLink.GetMap().GetTile2((int)(x+xMove+6)/32, (int)(y +yMove+16)/32).IsSolid() == true || refLink.GetMap().GetTile2((int)(x+xMove+26)/32, (int)(y +yMove+16)/32).IsSolid() == true  || refLink.GetMap().GetTile2((int)(x+xMove+26)/32, (int)(y +yMove +32 )/32).IsSolid() == true || refLink.GetMap().GetTile2((int)(x+xMove+6)/32, (int)(y +yMove +32 )/32).IsSolid() == true )
        {

            z = true;
            //System.out.println("AI GRIJA");

        }

        return z;
    }


    public void VerifyMap(){
        if( refLink.GetMap().mapCount == 3 && refLink.GetMap().GetTile2((int)(x+16)/32, (int)(y+16)/32).IsPortal() == true  ) {
            System.out.println("ORICE");
            y = 185;
            x = 32;
            normalBounds.y = (int)y;
            normalBounds.x =(int)x;
            refLink.GetMap().mapCount = 4;
        }

        if(refLink.GetMap().mapCount == 4 && refLink.GetMap().GetTile2((int)(x+16)/32, (int)(y+16)/32).IsPortal() == true &&Go ==true ){
            AddLevel2(HeroScore);
            refLink.GetMap().mapCount = 5;
        }
        //System.out.println(refLink.GetMap().GetTile2((int)(x+16)/32, (int)(y+16)/32).IsPortal()+"   "+Go);
        //INCA NU E IMPLEMENTAT INSA CAND JUCATORUL SE AFLA IN FATA PORTALULUI SI APASA ENTER SE SCHIMBA HARTA(MOMENTAN SE SCHIMBA ORIUNDE APESI ENTER)
        if (refLink.GetKeyManager().enter && Go == true && refLink.GetMap().GetTile2((int)(x+16)/32, (int)(y+16)/32).IsPortal() == true && refLink.GetMap().mapCount == 0 ){
            refLink.GetMap().mapCount = 1;
            refLink.GetMap().LoadWorld();
            if(currentLife < 60) {
                currentLife += 40;
                life = currentLife;
            }
        }

        if(refLink.GetMap().mapCount == 1 && Go == true && refLink.GetMap().GetTile2((int)(x+16)/32, (int)(y+16)/32).IsPortal() == true){
            refLink.GetMap().mapCount = 2;
            //save score here
            ScoreState.totals = HeroScore;
            AddLevel1(HeroScore);
            AboutState.lock = false;
        }

    }

    public void AddLevel1(int scor){

        Connection c = null;
        Statement stmt = null;
        Scanner scan= new Scanner(System.in);
        System.out.println("Numele tau este:");
        String text =scan.nextLine();
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:BazaDeDataJoc.db");
            stmt = c.createStatement();
            String sql = "INSERT INTO SCOR (NAME,SCORE) "+
                    "VALUES ('" + text + "'," + scor + ");";
            stmt.executeUpdate(sql);
            stmt.close();
            c.close();

        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }

    }

    public void AddLevel2(int scor){

        Connection c = null;
        Statement stmt = null;
        Scanner scan= new Scanner(System.in);
        System.out.println("Numele tau este:");
        String text =scan.nextLine();
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:BazaDeDataJoc.db");
            stmt = c.createStatement();
             String sql = "INSERT INTO SCOR2 (NAME,SCORE) "+
                    "VALUES ('" + text + "'," + scor + ");";
            stmt.executeUpdate(sql);
            stmt.close();
            c.close();

        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }

    }

    @Override
    public void Update()  {

        HeroScore++;
        normalBounds.x = (int) x + 10;
        normalBounds.y = (int) y +10;
//        System.out.println(normalBounds.y);
        VerifyMap();
        GetInput();
        CollisionStanga();
        notifyObservers();
        ///Actualizeaza pozitia
        if(Collision() == false && platoforma == false) {
            Move();

        }



        if(CollisionJos() == true && CollisionDreapta() == false && CollisionStanga() == false )
        {
            MoveX();

        }else if(platoforma == true){
            MoveX();
        }



        if(refLink.GetKeyManager().left == true)
        {

            for(Integer i = 0 ;i <= 7 ; i++)
            {
                image = Assets.heroLeft.getSubimage(i*32,6*32,32,32);

            }

        }

        if(refLink.GetKeyManager().right == true) {
            image = Assets.heroRight;
        }
        // System.out.println(normalBounds.y);
        ///Actualizeaza imaginea

        if(EnemyDamage() )
        {
            currentLife--;
            life = currentLife;

        }
    }
    public void SetLife(int viata){
        currentLife = viata;
        life = viata;
    }
    /*! \fn private void GetInput()
        \brief Verifica daca a fost apasata o tasta din cele stabilite pentru controlul eroului.
     */

    private void GetInput() {
        ///Implicit eroul nu trebuie sa se deplaseze daca nu este apasata o tasta
        xMove = 0;

//        yMove = 0;
        ///Verificare apasare tasta "sus"
//        if(refLink.GetKeyManager().up && CollisionJos() == false && jump == true)
//        {
//            // System.out.println("Aici");
//            System.out.println("WEE");
//            jump = false;
//        }

        if (refLink.GetKeyManager().up && CollisionJos() == true )
        {
            yMove = -yspeed-1;
            // jump = true;
           // System.out.println(yMove);
        }

        if (refLink.GetKeyManager().up && platoforma == true )
        {
            yMove = -yspeed-1;
            MoveY();
            // jump = true;
            // System.out.println(yMove);
        }


//        ///Verificare apasare tasta "jos"
//        if (refLink.GetKeyManager().up) {
//           System.out.println("UNDE");
//        }
        ///Verificare apasare tasta "left"
        if (refLink.GetKeyManager().left) {
            xMove = -xspeed;
            if(CollisionStanga() == true && CollisionSus() == false) {
                xMove = +xspeed;
                System.out.println("AICI");
            }

            // System.out.println("Left1");
        }
        ///Verificare apasare tasta "dreapta"
        if (refLink.GetKeyManager().right ) {
            xMove = xspeed;
            if(CollisionDreapta() == true && CollisionSus() == false) {
                xMove = -xspeed;

            }
        }

        if(CollisionJos() == false && platoforma == false) {
            yMove += 0.25 ;
           // System.out.println(yMove + " "+x+" "+y);
        }



    }

    public Rectangle getRectangle(){
        return normalBounds;
    }
//    public void MoveBack() {
////        xMove = 0;
////        yMove = 0;
//
//        if (refLink.GetKeyManager().up) {
//            yMove = +xspeed;
//            System.out.println("Up");
//        }
//        ///Verificare apasare tasta "jos"
//        if (refLink.GetKeyManager().down) {
//            yMove = -xspeed;
//            System.out.println("Down");
//        }
//        ///Verificare apasare tasta "left"
//        if (refLink.GetKeyManager().left) {
//            xMove = +xspeed;
//            System.out.println("Left");
//        }
//        ///Verificare apasare tasta "dreapta"
//        if (refLink.GetKeyManager().right) {
//            xMove = -xspeed;
//            System.out.println("Right");
//        }
//
//        x += xMove ;
//        y += yMove ;
//    }
    /*! \fn public void Draw(Graphics g)
        \brief Randeaza/deseneaza eroul in noua pozitie.

        \brief g Contextul grafi in care trebuie efectuata desenarea eroului.
     */


    @Override
    public void Draw(Graphics g) {
        g.drawImage(image, (int) x, (int) y, width, height, null);
        //System.out.println(DEFAULT_LIFE);
//        String totalLife = String.valueOf(DEFAULT_LIFE);
//        String currentLifeString = String.valueOf(currentLife);
//        Font f = new Font("Dialog", Font.PLAIN, 25);
//       g.setFont(f);
//        g.setColor(Color.RED);
//       g.drawString(currentLifeString + "/" + totalLife, 10, 20);

    }



}