import java.awt.Graphics;


public class GameBoard 
{
    private int numRows;
    private int numCols;
    
    private int numFences;
    private int numMhos;
    private int numPlayers;
    
    private GridCell[][] gridCells;
    
    public GameBoard(int rows, int cols, int fences, int mhos, int players)  
    {
        this.numRows = rows;
        this.numCols = cols;
        this.numFences = fences;
        this.numMhos = mhos;
        this.numPlayers = players;
        this.gridCells = new GridCell[cols][rows];
    }
    
    /**
     * Populate will populate the grid with its contents, like Fences, Mhos, and the Player. 
     */
   public void populate() 
   {
       // Initializes each cell to the default value of empty
       for (int i = 0; i < this.numCols; i++) 
       {
           for (int j = 0; j < this.numRows; j++) 
           {
               this.gridCells[i][j] = new GridCell();
           }
       }
       
        int remainingFences = this.numFences;
        while (remainingFences > 0) 
        {
            int ranXCoord = (int) (GameProperties.GridSize * Math.random());  // TODO Change to height
            int ranYCoord = (int) (GameProperties.GridSize * Math.random());  // TODO Change to width
            
            if (gridCells[ranXCoord][ranYCoord].getCellType() == CellType.EMPTY) 
            {
                gridCells[ranXCoord][ranYCoord].setCellType(CellType.FENCE);
                remainingFences--;
            }
        }
        
        int remainingMhos = this.numMhos;
        while (remainingMhos > 0) 
        {
            int ranXCoord = (int) (GameProperties.GridSize * Math.random());  // TODO Change to height
            int ranYCoord = (int) (GameProperties.GridSize * Math.random());  // TODO Change to width
            
            if (gridCells[ranXCoord][ranYCoord].getCellType() == CellType.EMPTY) 
            {
                gridCells[ranXCoord][ranYCoord].setCellType(CellType.MHO);
                remainingMhos--;
            }
        }
    }
   
   private void drawBorder(Graphics g) 
   {
       g.setColor(GameProperties.OuterFenceColor);
//       g.fillRect(GameProperties.PaddingPx, GameProperties.PaddingPx, width, height)       
       for (int i = 0; i <= GameProperties.GridSize + 1; i++) 
       {
         int y = GameProperties.PaddingPx + i*GameProperties.SquareSizePx + 1;
         int x = GameProperties.PaddingPx + i*GameProperties.SquareSizePx + 1;
         
//         g.drawLine(GameProperties.PaddingPx, y1, x2, y2)
         
//         g.fillRect(GameProperties.PaddingPx + 1, y, GameProperties.SquareSizePx - 1, GameProperties.SquareSizePx - 1);
//         g.fillRect(x, GameProperties.PaddingPx + 1, GameProperties.SquareSizePx - 1, GameProperties.SquareSizePx - 1);
//         g.fillRect(GameProperties.Width + GameProperties.BorderSizePx + 1, y, GameProperties.SquareSizePx - 1, GameProperties.SquareSizePx - 1);
//         g.fillRect(x, GameProperties.Width + GameProperties.BorderSizePx + 1, GameProperties.SquareSizePx - 1, GameProperties.SquareSizePx - 1);
       }

   }
   
   private void drawGrid(Graphics g) 
   {
       g.setColor(GameProperties.LineColor);
       
       for (int i = 0; i <= GameProperties.GridSize; i++) 
       {
           int x1 = GameProperties.PaddingPx + GameProperties.BorderSizePx;
           int x2 = GameProperties.Width + GameProperties.BorderSizePx;
           int y = GameProperties.PaddingPx + i*GameProperties.SquareSizePx + GameProperties.BorderSizePx;
           g.drawLine(x1, y, x2, y);
       }
       
       for (int i = 0; i <= GameProperties.GridSize; i++) 
       {
           int y1 = GameProperties.PaddingPx + GameProperties.BorderSizePx;
           int y2 = GameProperties.Width + GameProperties.BorderSizePx;
           int x = GameProperties.PaddingPx + i*GameProperties.SquareSizePx + GameProperties.BorderSizePx;
           g.drawLine(x, y1, x, y2);      
       }
   }
   
   private void drawEntities(Graphics g) 
   {
	   g.setColor(GameProperties.RegMhoColor);
       for (int i = 0; i < this.numCols; i++) 
       {
           for (int j = 0; j < this.numRows; j++) 
           {
               gridCells[i][j].paint(g, i, j);
           }
       }
   }
   
   
   public void paint(Graphics g) 
   {
       this.drawBorder(g);
       this.drawGrid(g);
       this.drawEntities(g);
   }
}
