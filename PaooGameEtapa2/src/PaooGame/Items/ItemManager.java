package PaooGame.Items;

import PaooGame.RefLinks;

import java.awt.*;
import java.util.ArrayList;

public class ItemManager extends Item{
    private ArrayList<Coins> bani = new ArrayList<>();
    private static ArrayList<Spikes> spike = new ArrayList<>();
    private static ArrayList<FloatingPlatform>  platforma = new ArrayList<>() ;
    private static ArrayList<Monster> monster = new ArrayList<>() ;
    private Rectangle colErou = new Rectangle();
    private int coins_numbers = 0;
    private int Total_coins = 0;
    public static boolean  take_damage = false;


    public ItemManager(RefLinks refLink, float x, float y, int width, int height,int total_coins, int level) {
        super(refLink, x,y, width, height);
        Total_coins = total_coins;
        if(level == 1) {
            bani.add(new Coins(refLink, 40, 192, 32, 32));
            bani.add(new Coins(refLink, 72, 192, 32, 32));
            bani.add(new Coins(refLink, 104, 192, 32, 32));
            bani.add(new Coins(refLink, 136, 192, 32, 32));

            bani.add(new Coins(refLink, 224, 416, 32, 32));
            bani.add(new Coins(refLink, 544, 320, 32, 32));

            bani.add(new Coins(refLink, 480, 192, 32, 32));
            bani.add(new Coins(refLink, 544, 192, 32, 32));
            bani.add(new Coins(refLink, 608, 192, 32, 32));
            bani.add(new Coins(refLink, 672, 192, 32, 32));
            bani.add(new Coins(refLink, 736, 192, 32, 32));

            bani.add(new Coins(refLink, 64, 64, 32, 32));
            bani.add(new Coins(refLink, 128, 32, 32, 32));
            bani.add(new Coins(refLink, 256, 32, 32, 32));
            bani.add(new Coins(refLink, 416, 64, 32, 32));
            bani.add(new Coins(refLink, 864, 32, 32, 32));

            spike.add(new Spikes(refLink, 510, 416, 32, 20));
            spike.add(new Spikes(refLink, 478, 416, 32, 20));
            spike.add(new Spikes(refLink, 446, 416, 32, 20));
            spike.add(new Spikes(refLink, 542, 416, 32, 20));
            spike.add(new Spikes(refLink, 574, 416, 32, 20));
            spike.add(new Spikes(refLink, 606, 416, 32, 20));
            spike.add(new Spikes(refLink, 638, 416, 32, 20));
            spike.add(new Spikes(refLink, 670, 416, 32, 20));

            spike.add(new Spikes(refLink, 192, 192, 32, 20));
            spike.add(new Spikes(refLink, 224, 192, 32, 20));
            spike.add(new Spikes(refLink, 256, 192, 32, 20));

            spike.add(new Spikes(refLink, 512, 192, 32, 20));
            spike.add(new Spikes(refLink, 576, 192, 32, 20));
            spike.add(new Spikes(refLink, 640, 192, 32, 20));
            spike.add(new Spikes(refLink, 704, 192, 32, 20));


            //System.out.println(spike.size() + "ce");

            platforma.add(new FloatingPlatform(refLink, 448, 350, 30, 16, 160,true));
            platforma.add(new FloatingPlatform(refLink, 160, 96, 30, 16, 128,true));
            monster.add(new Monster(refLink, 736, 416, 20, 20, 3, 32));
            monster.add(new Monster(refLink, 318, 192, 20, 20, 3, 160));
        }else if(level == 2){

            bani.add(new Coins(refLink, 96, 416, 32, 32));
            monster.add(new Monster(refLink, 128, 416, 20, 20, 3, 64));
            bani.add(new Coins(refLink, 512, 416, 32, 32));
            bani.add(new Coins(refLink, 640, 416, 32, 32));
            bani.add(new Coins(refLink, 832, 64, 32, 32));
            bani.add(new Coins(refLink, 448, 288, 32, 32));
            bani.add(new Coins(refLink, 448, 160, 32, 32));
            monster.add(new Monster(refLink, 736, 64, 20, 20, 3, 64));
            spike.add(new Spikes(refLink, 736, 416, 20, 20));
            spike.add(new Spikes(refLink, 608, 416, 20, 20));
            spike.add(new Spikes(refLink, 480, 416, 20, 20));

        }else if(level == 3){
            platforma.add(new FloatingPlatform(refLink, 160, 352, 30, 16, 160,true));
            platforma.add(new FloatingPlatform(refLink, 512, 384, 30, 16, 160,false));

            platforma.add(new FloatingPlatform(refLink, 672, 352, 30, 16, 180,false));
            platforma.add(new FloatingPlatform(refLink, 160, 158, 30, 16, 100,true));
            for(Integer i = 160 ; i < 928 ;i+=32)
                spike.add(new Spikes(refLink, i, 416, 20, 20));
            monster.add(new Monster(refLink, 800, 320, 20, 20, 4, 64));
            bani.add(new Coins(refLink, 896, 320, 32, 32));
            bani.add(new Coins(refLink, 160, 126, 32, 32));
            spike.add(new Spikes(refLink, 352, 96, 20, 20));
            spike.add(new Spikes(refLink, 544, 96, 20, 20));
            //  spike.add(new Spikes(refLink, 832, 64, 20, 20));
            bani.add(new Coins(refLink, 864, 32, 32, 32));
            bani.add(new Coins(refLink, 12*32, 480-6*32, 32, 32));
            monster.add(new Monster(refLink, 13*32, 3*32, 20, 20, 4, 64));
            monster.add(new Monster(refLink, 19*32, 3*32, 20, 20, 4, 64));
            bani.add(new Coins(refLink, 14*32, 3*32, 32, 32));
            bani.add(new Coins(refLink, 20*32, 3*32, 32, 32));
        }

    }

    public void Reset(){
        for(Integer i = 0 ;i < bani.size();i++)
           bani.clear();

        for(Integer i = 0 ;i < spike.size();i++)
            spike.clear();
        for(Integer i = 0 ; i < monster.size(); i ++)
                monster.clear();
        for(Integer i = 0 ; i < platforma.size();i++)
            platforma.clear();

    }
    public void setHeroPozition(Hero erou){
        colErou = erou.getRectangle();

    }
    public boolean Go(){
        if(Total_coins == coins_numbers)
            return true;
        else
            return false;
    }

    public static boolean GetPlatformCollision(){
        int ok = 0;
        if (platforma.size() > 0)
            for (Integer i = 0; i < platforma.size(); i++)
                if (platforma.get(i).GetCollisionPlatforma() == true)
                    ok = 1;
        if (ok == 0)
            return false;
        else
            return true;

    }
    public  static boolean GetMonsterCollision(){
        int ok = 0;

        if(monster.size() > 0)
            for (Integer i = 0; i < monster.size(); i++)
                if (monster.get(i).life > 0) {
                    return take_damage;
                }




            if (ok == 0)
                return false;
            else
                return true;

    }

    public static boolean GetSpikeCollision() {
        int ok = 0;
        if (spike.size() > 0)
            for (Integer i = 0; i < spike.size(); i++)
                if (spike.get(i).touched == true)
                    ok = 1;
        if (ok == 0)
            return false;
        else
            return true;

    }
    @Override
    public void Update(){

        for(Integer i = 0 ; i < bani.size() ; i++) {
            bani.get(i).setColisionRectangle(colErou);
            bani.get(i).Update();
            if(bani.get(i).getTouched() == true){
                bani.remove(bani.indexOf(bani.get(i)));

                coins_numbers++;
            }
        }
        for(Integer i = 0 ; i < spike.size() ; i++) {
            //System.out.println(spike.size());
            spike.get(i).setColisionRectangle(colErou);
            spike.get(i).Update();
           // System.out.println(spike.get(i).touched);

        }
        for(Integer i = 0 ; i < platforma.size(); i++){
            platforma.get(i).setColisionRectangle(colErou);
            platforma.get(i).Update();
        }
        take_damage = false;
        for(Integer i = 0 ;i < monster.size();i++) {
            monster.get(i).setColisionRectangle(colErou);
            if (monster.get(i).life > 0) {
               if(monster.get(i).col)
                   take_damage = true;
                monster.get(i).Update();

            }

        }

    }

    @Override
    public void Draw(Graphics g){


            for (Integer i = 0; i < bani.size(); i++) {
                bani.get(i).Draw(g);

            }
            for (Integer i = 0; i < spike.size(); i++) {
                spike.get(i).Draw(g);

            }

            Graphics2D g2d = (Graphics2D) g;
            g2d.draw(colErou);
            for (Integer i = 0; i < platforma.size(); i++) {
                platforma.get(i).Draw(g);

            }

            String temp = String.valueOf(coins_numbers);
            String totalCoins = String.valueOf(Total_coins);
            //System.out.println(x+"  "+y);
            Font f = new Font("Dialog", Font.BOLD, 25);
            g.setFont(f);
            g.setColor(Color.YELLOW);
            g.drawString(temp + "/" + totalCoins, 890, 20);
            for(Integer i = 0 ;i < monster.size();i++) {
                if (monster.get(i).life > 0) {
                    //System.out.println(monster.get(i).col);
                    monster.get(i).Draw(g);
                }
            }
        }


}
