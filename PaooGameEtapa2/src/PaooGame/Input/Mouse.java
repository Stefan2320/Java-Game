package PaooGame.Input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Mouse implements MouseListener,MouseMotionListener {

    private boolean click = false;
    private int x,y;


    public int getMouseX(){
        return x;
    }
    public int getMouseY(){
        return y;
    }

    public  boolean getClick(){
        return click;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }


    public void mousePressed(MouseEvent e) {

            click = true;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
             click = false;
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
                x = e.getX();
                y = e.getY();
    }
}
