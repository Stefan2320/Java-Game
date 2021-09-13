package PaooGame.Tiles;

import PaooGame.Graphics.Assets;

/*! \class public class GrassTile extends Tile
    \brief Abstractizeaza notiunea de dala de tip iarba.
 */
public class portal extends Tile
{
    public portal(int id)
    {
        /// Apel al constructorului clasei de baza
        super(Assets.portal, id);

    }

    @Override
    public boolean IsPortal(){ return true;}
}
