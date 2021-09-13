package PaooGame.Tiles;

import PaooGame.Graphics.Assets;

/*! \class public class GrassTile extends Tile
    \brief Abstractizeaza notiunea de dala de tip iarba.
 */
public class platformBlue extends Tile
{
    public platformBlue(int id)
    {
        /// Apel al constructorului clasei de baza
        super(Assets.platformBlue, id);

    }
}
