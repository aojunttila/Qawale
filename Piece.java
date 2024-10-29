import java.util.Random;

public class Piece {

    public static final int TAN = 0;
    public static final int RED = 1;
    public static final int YELLOW = 2;

    private int pieceColor;

    public Piece(int color){
        if(color<3 && color>-1){
            pieceColor = color;
        }else{
            pieceColor = 0;
        }
    }

    public Piece(){
        Random rand = new Random();
        pieceColor = rand.nextInt(3);
    }

    public int getColor(){
        return pieceColor;
    }

    public String getColorName(){
        if(pieceColor == TAN){
            return "Tan";
        }else if(pieceColor == RED){
            return "Red";
        }else if(pieceColor == YELLOW){
            return "Yellow";
        }
        return null;
    }

    public String toString(){
        return getColorName();
    }
}
