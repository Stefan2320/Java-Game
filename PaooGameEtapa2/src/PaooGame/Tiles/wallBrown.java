package PaooGame.Tiles;

import PaooGame.Graphics.Assets;

/*! \class public class GrassTile extends Tile
    \brief Abstractizeaza notiunea de dala de tip iarba.
 */
public class wallBrown extends Tile
{
    public wallBrown(int id)
    {
        /// Apel al constructorului clasei de baza
        super(Assets.wallBrown, id);

    }

    @Override
    public boolean IsSolid(){ return true;}
}
