package PaooGame.Tiles;

import PaooGame.Graphics.Assets;

/*! \class public class GrassTile extends Tile
    \brief Abstractizeaza notiunea de dala de tip iarba.
 */
public class platformWall extends Tile
{
    public platformWall(int id)
    {
        /// Apel al constructorului clasei de baza
        super(Assets.platformWall, id);

    }

    @Override
    public boolean IsSolid(){ return true;}
}
