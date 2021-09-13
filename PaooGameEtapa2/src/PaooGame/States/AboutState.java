package PaooGame.States;

import PaooGame.Graphics.Assets;
import PaooGame.RefLinks;

import java.awt.*;
import java.awt.image.BufferedImage;


public class AboutState extends State
{
    /*! \fn public AboutState(RefLinks refLink)
        \brief Constructorul de initializare al clasei.

        \param refLink O referinta catre un obiect "shortcut", obiect ce contine o serie de referinte utile in program.
     */
    private BufferedImage image;
    private boolean play = false;
    private Rectangle Level1;
    private Rectangle Level2;
    private Rectangle Back;
    Font mic;
    public static boolean lock = true;

    public static void setLock(boolean key){
        lock = key;
    }

    public AboutState(RefLinks refLink)
    {
            ///Apel al constructorului clasei de baza.
        super(refLink);
        ///Apel al constructorului clasei de baza.
        mic = new Font("arial",Font.BOLD,30);
        Level1 = new Rectangle(40,50,80,50);
        Level2 = new Rectangle(130,50,80,50);
        Back = new Rectangle(50,150,20,20);
        image = Assets.menu;
    }
    /*! \fn public void Update()
        \brief Actualizeaza starea curenta a meniu about.
     */
    @Override
    public void Update()
    {
        if(refLink.GetGame().GetMouse().getClick()) {

            Point point = new Point(refLink.GetGame().GetMouse().getMouseX(), refLink.GetGame().GetMouse().getMouseY());
            if(Level1.contains(point)) {
                System.out.println("menu");
                State.SetState(new PlayState(refLink));
                refLink.GetGame().GetGameWnd().GetWndFrame().requestFocusInWindow();
                // State.SetState(Game.getPlayState());
            }
            if(Back.contains(point)) {
                System.out.println("menu");
                State.SetState(new MenuState(refLink));
                refLink.GetGame().GetGameWnd().GetWndFrame().requestFocusInWindow();
                // State.SetState(Game.getPlayState());
            }

            if(Level2.contains(point)) {
                System.out.println("DOI");
                    if(lock == false) {
                        State.SetState(new PlayState(refLink));
                        refLink.GetMap().mapCount = 3;
                        refLink.GetMap().LoadWorld();
                        refLink.GetGame().GetGameWnd().GetWndFrame().requestFocusInWindow();
                    }



                // State.SetState(Game.getPlayState());
            }
        }
    }

    /*! \fn public void Draw(Graphics g)
        \brief Deseneaza (randeaza) pe ecran starea curenta a meniu about.

        \param g Contextul grafic in care trebuie sa deseneze starea jocului pe ecran.
     */
    @Override
    public void Draw(Graphics g)
    {
        Graphics2D g2d = (Graphics2D)g;
        g.drawImage(image,0,0,960,480,null);
        //g.drawImage(buton_Play,40,200,null);
        g.setFont(mic);
        g.setColor(Color.WHITE);
        g.drawString("1", Level1.x+30, Level1.y+40);

        g.setFont(mic);
            if(lock == true)
                g.setColor(Color.GRAY);
            else
                g.setColor(Color.WHITE);

        g.drawString("2", Level2.x+30, Level2.y+40);

        g.setFont(mic);
        g.setColor(Color.WHITE);
        g.drawString("<", Back.x, Back.y+20);
        g2d.draw(Back);
         g2d.draw(Level2);
         g2d.draw(Level1);

    }
}
