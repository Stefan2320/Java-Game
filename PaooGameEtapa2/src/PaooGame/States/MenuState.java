package PaooGame.States;

import PaooGame.Game;
import PaooGame.Graphics.Assets;
import PaooGame.Input.Mouse;
import PaooGame.RefLinks;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.awt.event.MouseListener;
import java.nio.channels.SeekableByteChannel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/*! \class public class MenuState extends State
    \brief Implementeaza notiunea de menu pentru joc.
 */
public class MenuState extends State
{

    private BufferedImage image;
  //  private BufferedImage buton_Play;
    private boolean play = false;
    private Rectangle playButton;
    private Rectangle levels;
    private Rectangle scores;
    private Rectangle settings;
    Font titlu;
    Font mic;
    /*! \fn public MenuState(RefLinks refLink)
        \brief Constructorul de initializare al clasei.

        \param refLink O referinta catre un obiect "shortcut", obiect ce contine o serie de referinte utile in program.
     */
    public MenuState(RefLinks refLink)
    {   super(refLink);
            ///Apel al constructorului clasei de baza.
        mic = new Font("arial",Font.BOLD,30);
        playButton = new Rectangle(40,50,80,50);
        levels = new Rectangle(40,110,80,50);
        scores = new Rectangle(40,170,160,50);
        titlu = new Font("arial",Font.BOLD,40);
        settings = new Rectangle(40,240,120,40);
        image = Assets.menu;

    }



    /*! \fn public void Update()
        \brief Actualizeaza starea curenta a meniului.
     */
    @Override
    public void Update()
    {

        //System.out.println("Table created successfully");
            if(refLink.GetGame().GetMouse().getClick()) {

                    Point point = new Point(refLink.GetGame().GetMouse().getMouseX(), refLink.GetGame().GetMouse().getMouseY());
                    if(playButton.contains(point)) {
                        System.out.println("menu");
                        State.SetState(new PlayState(refLink));
                        refLink.GetGame().GetGameWnd().GetWndFrame().requestFocusInWindow();
                       //State.SetState(refLink.GetGame().getPlayState());
                    }

                    if(levels.contains(point)){
                        System.out.println("Setari");
                        State.SetState(new AboutState(refLink));
                    }
                    if(scores.contains(point)){
                        System.out.println("Setari");
                        State.SetState(new ScoreState(refLink));
                    }
                if(settings.contains(point)){
                    System.out.println("Setari");
                    State.SetState(new SettingsState(refLink));
                }
                }



    }

    /*! \fn public void Draw(Graphics g)
        \brief Deseneaza (randeaza) pe ecran starea curenta a meniului.

        \param g Contextul grafic in care trebuie sa deseneze starea jocului pe ecran.
     */
    @Override
    public void Draw(Graphics g)
    {
        g.drawImage(image,0,0,960,480,null);
        //g.drawImage(buton_Play,40,200,null);
        g.setFont(titlu);
        g.setColor(Color.WHITE);
        g.drawString("Play", playButton.x, playButton.y+40);
        g.setFont(mic);
        g.setColor(Color.WHITE);
        g.drawString("Levels", levels.x, levels.y+40);
        g.drawString("HighScores", scores.x, scores.y+40);
        Graphics2D g2d = (Graphics2D)g;
        g.drawString("Settings", settings.x, settings.y+20);
        // g2d.draw(settings);
        // g2d.draw(scores);

    }
}
