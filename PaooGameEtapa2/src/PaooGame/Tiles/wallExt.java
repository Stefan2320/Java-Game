package PaooGame.Tiles;

import PaooGame.Graphics.Assets;

/*! \class public class GrassTile extends Tile
    \brief Abstractizeaza notiunea de dala de tip iarba.
 */
public class wallExt extends Tile
{
    public wallExt(int id)
    {
        /// Apel al constructorului clasei de baza
        super(Assets.wallExt, id);

    }

    @Override
    public boolean IsSolid(){ return true;}
}
