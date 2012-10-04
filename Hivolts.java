import java.applet.*;
import java.awt.*;

public class Hivolts extends Applet 
{
    GameBoard gameBoard = null;
    
	public void init() 
	{
	    gameBoard = new GameBoard(GameProperties.GridSize, GameProperties.GridSize, GameProperties.NumFences, GameProperties.NumMhos, 1); //// numMhos and numPlayers
	    gameBoard.populate();
		super.setSize(GameProperties.WindowWidth, GameProperties.WindowHeight);
        super.setBackground(GameProperties.BgColor);
		repaint();
	}
	
    public void paint (Graphics g) 
    {
        gameBoard.paint(g);
	}
}