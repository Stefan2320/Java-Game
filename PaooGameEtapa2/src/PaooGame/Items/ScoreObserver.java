package PaooGame.Items;

import PaooGame.RefLinks;

import java.awt.*;

public class ScoreObserver implements Observer{
    Integer score;

    public ScoreObserver(){
        super();
        score = 0;
    }

    @Override
    public void Update(RefLinks refLink) {
        score = Hero.getInstance(refLink).GetScore();

    }
    public void Draw(Graphics g, RefLinks reflink) {

        String scoreString = String.valueOf(score);
        Font f = new Font("Dialog", Font.PLAIN, 25);
        g.setFont(f);
        g.setColor(Color.BLACK);
        g.drawString(scoreString, 0, 480);
    }
}
