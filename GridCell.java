import java.awt.Graphics;


public class GridCell 
{
    private CellType cellType = null;
    
    public GridCell() 
    {
        this.cellType = CellType.EMPTY;
    }
    
    public CellType getCellType() 
    {
        return cellType;
    }
    
    public void setCellType(CellType t) 
    {
        cellType = t;
    }
    
    /**
     * Paint self into the given graphics object at the given coordinates.
     * @param g - Graphics object
     * @param x
     * @param y
     */
    public void paint(Graphics g, int xCoord, int yCoord) 
    {
        int x = GameProperties.PaddingPx + xCoord * GameProperties.SquareSizePx + GameProperties.BorderSizePx;
        int y = GameProperties.PaddingPx + yCoord * GameProperties.SquareSizePx + GameProperties.BorderSizePx;
        
        if (this.cellType == CellType.FENCE) 
        {
            g.setColor(GameProperties.InnerFenceColor);
            g.fillRect(x + 1, y + 1, GameProperties.SquareSizePx - 1, GameProperties.SquareSizePx - 1);
        } else if (this.cellType == CellType.MHO) 
        {
            g.fillOval(x + 1, y + 1, GameProperties.SquareSizePx - 1, GameProperties.SquareSizePx - 1);
        } else if (this.cellType == CellType.PLAYER) 
        {
            g.setColor(GameProperties.PlayerColor);
            g.fill3DRect(x + 1, y + 1, GameProperties.SquareSizePx - 1, GameProperties.SquareSizePx - 1, true);
        }
    }
}
