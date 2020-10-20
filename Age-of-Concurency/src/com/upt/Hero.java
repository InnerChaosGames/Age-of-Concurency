package com.upt;

import java.util.ArrayList;

public class Hero extends Unit implements ITileContent
{

    public Hero(int x, int y, Player player) {
        super(x, y, player);
    }

    public ArrayList<IInteractable> getAdjacentInteractables()
    {
        var interactables = new ArrayList<IInteractable>();
        var neighbours = grid.getNeighbours(grid.tileFromPosition(posX, posY));

        for (Tile t : neighbours)
        {
            if (t.tileContent instanceof Resource)
                interactables.add((IInteractable)t.tileContent);
        }

        return interactables;
    }


    public void collectResource(IInteractable interactable)
    {
        interactable.interact(this, IInteractable.ActionType.gather);
    }

    public char getSymbol() {
        return 'H';
    }

}
