package PaooGame.Tiles;

import PaooGame.Graphics.Assets;

/*! \class public class GrassTile extends Tile
    \brief Abstractizeaza notiunea de dala de tip iarba.
 */
public class steleAlbe extends Tile
{
    public steleAlbe(int id)
    {
        /// Apel al constructorului clasei de baza
        super(Assets.steleAlbe, id);

    }
}
