package PaooGame.Items;

import PaooGame.RefLinks;

import java.awt.*;

public class LifeObserver implements Observer{
    Integer life;

    public LifeObserver(){
        super();
        life = 100;
    }

    @Override
    public void Update(RefLinks refLink) {
        life = Hero.getInstance(refLink).GetLife();

    }
    public void Draw(Graphics g,RefLinks reflink) {

        String totalLife = String.valueOf(Hero.getInstance(reflink).DEFAULT_LIFE);
        String currentLifeString = String.valueOf(Hero.getInstance(reflink).currentLife);
        Font f = new Font("Dialog", Font.PLAIN, 25);
        g.setFont(f);
        g.setColor(Color.RED);
        g.drawString(currentLifeString + "/" + totalLife, 10, 20);
    }
}
