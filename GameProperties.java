import java.awt.Color;

public class GameProperties {
    
    // Core Grid Properties
    static int PaddingPx =        30;                       // Padding around the grid in pixels
    static int GridSize =         10;                       // Grid Rows & Columns
    static int SquareSizePx =     60;                       // Square Size in pixels
    static int NumFences =        15;                       // Number of fences (excluding border)
    static int NumMhos = 		  10;
    static int BorderSizePx =     SquareSizePx;             // Between padding and grid
    
    // Dependent Properties
    static int Width =          (GridSize * SquareSizePx) + PaddingPx;
    static int Height =         (GridSize * SquareSizePx) + PaddingPx;
    static int WindowWidth =    (GridSize * SquareSizePx) + (2 * PaddingPx) + (2 * BorderSizePx);
    static int WindowHeight =   (GridSize * SquareSizePx) + (2 * PaddingPx) + (2 * BorderSizePx);
    
    // Good Colours
//    static Color LineColor =            Color.blue;
//    static Color BgColor =              Color.white;
//    static Color OuterFenceColor =      Color.gray;
//    static Color InnerFenceColor =      Color.lightGray;
    
    static Color RegMhoColor =          Color.yellow; 
    static Color ProMhoColor =          Color.magenta;
    static Color PlayerColor =          Color.cyan;
    
    // Evil Colours
    static Color LineColor =            Color.red;
    static Color BgColor =              Color.black;
    static Color OuterFenceColor =      Color.darkGray;
    static Color InnerFenceColor =      Color.lightGray;
}
