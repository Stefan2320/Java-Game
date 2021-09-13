package PaooGame.States;

import PaooGame.Graphics.Assets;
import PaooGame.Items.Monster;
import PaooGame.RefLinks;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ScoreState extends State {

    private BufferedImage image;
    private Rectangle Back;
    public static int totals;

    Font mic;
    Font siMaiMic;

    public ScoreState(RefLinks refLink) {
        super(refLink);
        image = Assets.menu;
        mic = new Font("arial", Font.BOLD, 30);
        siMaiMic = new Font("arial", Font.BOLD, 15);
        Back = new Rectangle(50, 440, 20, 20);
    }


    /*! \fn public void Update()
        \brief Actualizeaza starea curenta a meniului.
     */
    @Override
    public void Update() {

        if (refLink.GetGame().GetMouse().getClick()) {

            Point point = new Point(refLink.GetGame().GetMouse().getMouseX(), refLink.GetGame().GetMouse().getMouseY());
            if (Back.contains(point)) {
                System.out.println("menu");
                State.SetState(new MenuState(refLink));
                refLink.GetGame().GetGameWnd().GetWndFrame().requestFocusInWindow();
                //State.SetState(refLink.GetGame().getPlayState());
            }


        }


    }


    /*! \fn public void Draw(Graphics g)
        \brief Deseneaza (randeaza) pe ecran starea curenta a meniului.

        \param g Contextul grafic in care trebuie sa deseneze starea jocului pe ecran.
     */
    @Override
    public void Draw(Graphics g) {
        g.drawImage(image, 0, 0, 960, 480, null);
        g.setFont(mic);
        g.setColor(Color.WHITE);
        Graphics2D g2d = (Graphics2D) g;
        g.drawString("<", Back.x, 460);
        g2d.draw(Back);
        g.drawString("Level 1:", 20, 50 );
        Connection c = null;
        Statement stmt = null;
        g.setFont(siMaiMic);
        int i = 1;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:BazaDeDataJoc.db");
            stmt = c.createStatement();
            stmt.executeUpdate("SELECT * FROM SCOR ORDER BY SCORE ASC");
            ResultSet rs = stmt.executeQuery("SELECT * FROM SCOR ORDER BY SCORE ASC");
            while(rs.next() && i <= 10){
                String temp = "";
                temp = i+"."+rs.getString("NAME") + ": " + String.valueOf(rs.getInt("SCORE"));
                g.drawString(temp,20,50+15*i);
                System.out.println(temp);
                i++;
            }
            stmt.close();
            c.close();

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        g.drawString("Level 2:", 400, 50 );
         i = 1;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:BazaDeDataJoc.db");
            stmt = c.createStatement();
            stmt.executeUpdate("SELECT * FROM SCOR2 ORDER BY SCORE ASC");
            ResultSet rs = stmt.executeQuery("SELECT * FROM SCOR2 ORDER BY SCORE ASC");
            while(rs.next() && i <= 10){
                String temp = "";
                temp = i+"."+rs.getString("NAME") + ": " + String.valueOf(rs.getInt("SCORE"));
                g.drawString(temp,400,50+15*i);
                System.out.println(temp);
                i++;
            }
            stmt.close();
            c.close();

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }
}


