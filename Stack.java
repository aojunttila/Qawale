import java.util.ArrayList;
import java.util.Random;

public class Stack {

    private int xPos;
    private int yPos;

    private ArrayList<Piece> pieces = new ArrayList<>();

    public Stack(int x, int y){
        Random rand = new Random();
        xPos = x;
        yPos = y;
        for(int i=0;i<rand.nextInt(6)+2;i++){
            pieces.add(new Piece());
        }
    }

    public void addPieceTop(Piece p){
        pieces.add(0, p);
    }

    public void addPieceBottom(Piece p){
        pieces.add(p);
    }

    public int getX(){
        return xPos;
    }

    public int getY(){
        return yPos;
    }

    public int getPieceCount(){
        return pieces.size();
    }

    public ArrayList<Piece> getPieces() {
        return pieces;
    }

    public String toString(){
        String s = "";
        if(pieces.size()==0){return "Empty Stack";}
        for(int i=0;i<pieces.size();i++){
            s = s + " " + pieces.get(i);
        }
        return s;
    }

}
