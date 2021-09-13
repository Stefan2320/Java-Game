package PaooGame.States;

import PaooGame.Audio;
import PaooGame.Graphics.Assets;
import PaooGame.RefLinks;

import java.awt.*;
import java.awt.image.BufferedImage;


public class SettingsState extends State
{
    private BufferedImage image;
    private Rectangle sound;
    private Rectangle Back;

    Font mic;
    public SettingsState(RefLinks refLink)
    {

        super(refLink);
        ///Apel al constructorului clasei de baza.
        mic = new Font("arial",Font.BOLD,30);
        sound = new Rectangle(160,30,20,20);
        Back = new Rectangle(50,150,20,20);
        image = Assets.menu;
    }

    /*! \fn public void Update()
        \brief Actualizeaza starea setarilor.
     */
    @Override
    public void Update()
    {
        if(refLink.GetGame().GetMouse().getClick()) {

            Point point = new Point(refLink.GetGame().GetMouse().getMouseX(), refLink.GetGame().GetMouse().getMouseY());
            if(sound.contains(point)) {
                Audio.on_off = !Audio.on_off;
                Audio.setAudioOnOff(Audio.on_off);
                refLink.GetGame().GetGameWnd().GetWndFrame().requestFocusInWindow();
                // State.SetState(Game.getPlayState());
            }
            if(Back.contains(point)) {
                System.out.println("menu");
                State.SetState(new MenuState(refLink));
                refLink.GetGame().GetGameWnd().GetWndFrame().requestFocusInWindow();
                // State.SetState(Game.getPlayState());
            }
        }
    }

    /*! \fn public void Draw(Graphics g)
        \brief Deseneaza (randeaza) pe ecran setarile.

        \param g Contextul grafic in care trebuie sa deseneze starea setarilor pe ecran.
     */
    @Override
    public void Draw(Graphics g)
    {   Graphics2D g2d = (Graphics2D)g;
        g.setFont(mic);
        g.setColor(Color.WHITE);
        g.drawImage(image,0,0,960,480,null);
        g.drawString("<", Back.x, Back.y+20);
        g2d.draw(Back);
        g2d.draw(sound);
        g.drawString("Sound: ", 50,50);
        if(Audio.on_off == false)
            g.drawString("X",sound.x,sound.y+20);
    }
}
