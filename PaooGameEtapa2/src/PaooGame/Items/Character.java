package PaooGame.Items;

import PaooGame.Graphics.Assets;
import PaooGame.RefLinks;

import java.awt.*;

/*! \class public abstract class Character extends Item
    \brief Defineste notiunea abstracta de caracter/individ/fiinta din joc.

    Notiunea este definita doar de viata, viteza de deplasare si distanta cu care trebuie sa se
    miste/deplaseze in urma calculelor.
 */
public abstract class Character extends Item
{
    public static final int DEFAULT_LIFE            = 100;   /*!< Valoarea implicita a vietii unui caracter.*/
    public static final float DEFAULT_SPEED         = 3.0f; /*!< Viteza implicita a unu caracter.*/
    public static final int DEFAULT_CREATURE_WIDTH  = 32;   /*!< Latimea implicita a imaginii caracterului.*/
    public static final int DEFAULT_CREATURE_HEIGHT = 32;   /*!< Inaltimea implicita a imaginii caracterului.*/

    protected int life;     /*!< Retine viata caracterului.*/
    protected float xspeed;  /*!< Retine viteza de deplasare caracterului.*/
    protected float yspeed;  /*!< Retine viteza de deplasare caracterului.*/
    protected float xMove;  /*!< Retine noua pozitie a caracterului pe axa X.*/
    protected float yMove;  /*!< Retine noua pozitie a caracterului pe axa Y.*/

    /*! \fn public Character(RefLinks refLink, float x, float y, int width, int height)
        \brief Constructor de initializare al clasei Character

        \param refLink Referinta catre obiectul shortcut (care retine alte referinte utile/necesare in joc).
        \param x Pozitia de start pa axa X a caracterului.
        \param y Pozitia de start pa axa Y a caracterului.
        \param width Latimea imaginii caracterului.
        \param height Inaltimea imaginii caracterului.
     */

    public Character(RefLinks refLink, float x, float y, int width, int height)
    {
            ///Apel constructor la clasei de baza
        super(refLink, x,y, width, height);
            //Seteaza pe valorile implicite pentru viata, viteza si distantele de deplasare
        life    = DEFAULT_LIFE;
        xspeed   = DEFAULT_SPEED;
        yspeed = 4;
        xMove   = 0;
        yMove   = 0;
    }

    /*! \fn public void Move()
        \brief Modifica pozitia caracterului
     */
    public void Move()
    {
            ///Modifica pozitia caracterului pe axa X.
            ///Modifica pozitia caracterului pe axa Y.
        MoveX();
        MoveY();

    }

    /*! \fn public void MoveX()
        \brief Modifica pozitia caracterului pe axa X.
     */

    public void MoveX()
    {
        x += xMove;
    }
    public void MoveY()
    {

        y += yMove;
    }

    public int GetLife()
    {
        return life;
    }
    public float GetXSpeed()
    {
        return xspeed;
    }
    public void SetLife(int life)
    {
        this.life = life;
    }
    public void SetXSpeed(float speed) {
        this.xspeed = speed;
    }
    public float GetXMove()
    {
        return xMove;
    }
    public float GetYMove()
    {
        return yMove;
    }
    public void SetXMove(float xMove)
    {
        this.xMove = xMove;
    }
    public void SetYMove(float yMove)
    {
        this.yMove = yMove;
    }
}

