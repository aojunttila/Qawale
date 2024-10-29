import java.awt.image.BufferedImage;
import java.util.ArrayList;
public class Board {

    private Stack[][] stackList; 
    private BufferedImage[] imageList;
    private boolean refresh = true;

    private double scaleFactor = 0.8;
    private int scale = 150;
    private int xSpacing = 20;
    private int ySpacing = 20;
    private int xOffset = 100;
    private int yOffset = 100;
    private int count = 1;

    public Board(BufferedImage[] imgList){
        imageList = imgList;
        stackList = new Stack[4][4];
        for(int x=0;x<4;x++){
            for(int y=0;y<4;y++){
                stackList[x][y] = new Stack(x, y);
            }
        }

    }

    public JFrameImage[] getImages(){
        System.out.println("h1");
        JFrameImage[] tempImageList = new JFrameImage[1+getPieceCount()+30];
        System.out.println("h2");
        for(int x=0;x<4;x++){
            System.out.println("h3");
            for(int y=0;y<4;y++){
                System.out.println("h4");
                ArrayList<Piece> tempPieceList = stackList[x][y].getPieces();
                for(int i=0;i<tempPieceList.size();i++){
                    System.out.println("h5");
                    double tempScale = Math.pow(scaleFactor,i);
                    tempImageList[count] = new JFrameImage(
                        stackList[x][y].getX()*scale + xOffset + x*xSpacing + (scale-(int)(scale*tempScale))/2, 
                        stackList[x][y].getY()*scale + yOffset + y*ySpacing + (scale-(int)(scale*tempScale))/2, 
                        (int)(scale*tempScale), (int)(scale*tempScale), 0, 
                        imageList[tempPieceList.get(i).getColor()+1]);
                    count++;
                }
            }
        }
        System.out.println("hf");

        return tempImageList;
    }

    public Stack mousePosToStack(int x, int y){
        x-=xOffset;
        y-=yOffset;
        x-=(Math.floor(x/(scale+xSpacing))*xSpacing);
        y-=(Math.floor(y/(scale+ySpacing))*ySpacing);
        x = x/scale;
        y = y/scale;
        if(x>-1 && x<5 && y>-1 && y<5){
            return stackList[x][y];
        }else{
            System.out.println("misfire at "+x+" "+y);
            return null;
        }
        
    }

    public int getPieceCount(){
        int count = 0;
        for(int x=0;x<4;x++){
            for(int y=0;y<4;y++){
                count += stackList[x][y].getPieceCount();
            }
        }
        return count;
    }

    public boolean getRefresh(){
        return refresh;
    }

    public void needsRefresh(){
        refresh = true;
    }

    public void refreshed(){
        refresh = false;
    }
}
