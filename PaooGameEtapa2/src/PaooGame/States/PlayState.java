package PaooGame.States;

import PaooGame.Items.*;
import PaooGame.RefLinks;
import PaooGame.Maps.Map;
import PaooGame.Tiles.Tile;

import java.awt.*;

/*! \class public class PlayState extends State
    \brief Implementeaza/controleaza jocul.
 */
public class PlayState extends State
{
    private Hero hero;  /*!< Referinta catre obiectul animat erou (controlat de utilizator).*/
    private Map map;    /*!< Referinta catre harta curenta.*/
    private Coins banuti;
    private ItemManager manager;
    private ItemManager manager2;
    private ItemManager manager3;
    private RefLinks reflinkTemp;
    boolean alreadyExecuted = false;
    boolean alreadyExecuted2 = false;
    public LifeObserver lifeObs ;
    public ScoreObserver scoreObs;
    /*! \fn public PlayState(RefLinks refLink)
        \brief Constructorul de initializare al clasei

        \param refLink O referinta catre un obiect "shortcut", obiect ce contine o serie de referinte utile in program.
     */
    public PlayState(RefLinks refLink)
    {
            ///Apel al constructorului clasei de baza
        super(refLink);
        reflinkTemp = refLink;
            ///Construieste harta jocului
        map = new Map(refLink);
            ///Referinta catre harta construita este setata si in obiectul shortcut pentru a fi accesibila si in alte clase ale programului.
        refLink.SetMap(map);
           //POZITIA INITIALA A EROULUI
        hero = Hero.getInstance(refLink);
        hero.SetX(34);
        hero.SetY(410);
        hero.SetLife(100);
        hero.SetScore();
        lifeObs = new LifeObserver();
        scoreObs = new ScoreObserver();
        hero.addObserver(lifeObs);
        hero.addObserver(scoreObs);
        //de facut un hero reset!!!
        //PENTRU CAMERA UNU DIN LEVEL 1

        manager = new ItemManager(refLink,0,0,0,0,16,1);



    }

    /*! \fn public void Update()
        \brief Actualizeaza starea curenta a jocului.
     */
    @Override
    public void Update()
    {


        map.Update();
        int x = Math.round(hero.GetX()/32);
        int y = Math.round(hero.GetY()/32);
        hero.Update();
       // System.out.println(refLink.GetMap().mapCount);
        if(refLink.GetMap().mapCount == 0){
            hero.setPlatoformaAndGo(manager.GetPlatformCollision(),manager.Go());
            manager.setHeroPozition(hero);
            manager.Update();

        }else if(refLink.GetMap().mapCount == 1){
            if(!alreadyExecuted) {
                manager.Reset();
                manager2 = new ItemManager(reflinkTemp,0,0,0,0,6,2);
                manager = manager2;
                alreadyExecuted = true;
            }
            hero.setPlatoformaAndGo(manager2.GetPlatformCollision(),manager.Go());
            manager.setHeroPozition(hero);
            manager.Update();
           // System.out.println("Update");
        }else if(refLink.GetMap().mapCount == 3 || refLink.GetMap().mapCount == 4){
            if(!alreadyExecuted2) {
                manager.Reset();
                manager3 = new ItemManager(reflinkTemp,0,0,0,0,6,3);
                manager = manager3;
                alreadyExecuted2 = true;
            }
            hero.setPlatoformaAndGo(manager2.GetPlatformCollision(),manager.Go());
            manager.setHeroPozition(hero);
            manager.Update();
          //  System.out.println("new map LEVEL 2");
        }

        if(refLink.GetKeyManager().esc == true || hero.GetLife() == 0 || refLink.GetMap().mapCount == 2 ||refLink.GetMap().mapCount == 5)
        {   manager.Reset();
            State.SetState(new MenuState(refLink));
        }


    }


    /*! \fn public void Draw(Graphics g)
        \brief Deseneaza (randeaza) pe ecran starea curenta a jocului.

        \param g Contextul grafic in care trebuie sa deseneze starea jocului pe ecran.
     */
    @Override
    public void Draw(Graphics g)
    {
        map.Draw(g);
        manager.Draw(g);
        hero.Draw(g);
        lifeObs.Draw(g,reflinkTemp);
        scoreObs.Draw(g,reflinkTemp);
    }



}
