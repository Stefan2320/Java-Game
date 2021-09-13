package PaooGame.Tiles;

import PaooGame.Graphics.Assets;

/*! \class public class GrassTile extends Tile
    \brief Abstractizeaza notiunea de dala de tip iarba.
 */
public class coin extends Tile
{
    public coin(int id)
    {
        /// Apel al constructorului clasei de baza
        super(Assets.coin, id);

    }
}
