package PaooGame.Tiles;

import PaooGame.Graphics.Assets;

/*! \class public class GrassTile extends Tile
    \brief Abstractizeaza notiunea de dala de tip iarba.
 */
public class wall1Int extends Tile
{
    public wall1Int(int id)
    {
        /// Apel al constructorului clasei de baza
        super(Assets.wall1Int, id);

    }

    @Override
    public boolean IsSolid(){ return true;}

}
