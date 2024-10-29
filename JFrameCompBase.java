import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.awt.image.BufferedImage;
import java.util.Random;


public class JFrameCompBase extends JComponent{
    JPanel panel;
    int sidething=0;
    JFrameImage img;
    Graphics2D g2;
    BufferedImage image,image2;
    BufferedImage bufferImage;
    Graphics2D bufferG;
    int width;
    boolean imageOver;
    JFramePolygon testpoly;
    int height;int h2;
    Random rand=new Random();
    JFrameImage[]elementList=new JFrameImage[2000];
    JFramePolygon[]polyList=new JFramePolygon[2000];
    JFrameParticleImage testEmitter;
    JFrameParticlePolygon testEmitter2;
    Board board;
    public JFrameCompBase(JPanel panel2,int w,int h){
        width=w;height=h;
        bufferImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        bufferG = (Graphics2D) bufferImage.createGraphics();
        //bufferG.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0f));
        h2=bufferImage.getHeight();
        panel = panel2;
        g2=(Graphics2D)panel.getGraphics();
        //System.out.println(""""hi"""");
        BufferedImage[]imageList = new BufferedImage[4];
        try {
            imageList[0] = ImageIO.read(new File("apple.jpg"));
            imageList[1] = ImageIO.read(new File("tan.png"));
            imageList[2] = ImageIO.read(new File("red.png"));
            imageList[3] = ImageIO.read(new File("yellow.png"));
        } catch (Exception e) {}
        
        board = new Board(imageList);
        refreshBoard();
        //for(int i=0;i<elementList.length;i++){
            //if(rand.nextInt(2)==0){
            //elementList[i]=new JFrameImage(rand.nextInt(3000)-750,rand.nextInt(2000)-500,1+(int)Math.pow((double)i,2)/80000,1+(int)Math.pow((double)i,2)/80000,0,image); 
            //int thingx=rand.nextInt(width+100);int thingy=rand.nextInt(height);
            //polyList[i]=new JFramePolygon(new int[]{thingx,thingx+rand.nextInt(100),thingx+rand.nextInt(100)},new int[]{thingy,thingy+rand.nextInt(50)+25,thingy+rand.nextInt(50)+25},new Color(0,0,0),new Color(rand.nextInt(150),rand.nextInt(150),rand.nextInt(150)),(float)3); 
            //}else{elementList[i]=new JFrameImage(rand.nextInt(1500),rand.nextInt(1000),rand.nextInt(100)+1,rand.nextInt(100)+1,rand.nextInt(200),image2); }
            //elementList[i]=new JFrameImage(500, 500, 100, 100, 10, image); 
        //}
        //testEmitter=new JFrameParticleImage(new int[]{200,700,900,0,180,10,5,2,30,30,99,120,100},false,image2);
        //testEmitter2=new JFrameParticlePolygon(new int[]{500,500,0,1000,90,360,20,10,98,120,300},new int[]{0,10,10},new int[]{0,-30,20},Color.RED,Color.BLUE,true,image2);
        //testpoly=new JFramePolygon(new int[]{20,200,400},new int[]{-30,500,100},new Color(105,0,150),new Color(10,10,50),(float)10);
        //testpoly=new JFrameImgQuad(new int[]{20,200,400,300},new int[]{30,500,100,100},new Color(105,0,150),(float)10,image);


        for(int i=0;i<elementList.length;i++){
            if(elementList[i]!=null){panel.add(elementList[i]);}}
        
    }
    
    public void refreshBoard(){
        System.out.println("1");
        JFrameImage[]boardImages = board.getImages();
        System.out.println("2");
        System.out.println(boardImages.length);
        for(int i=0;i<boardImages.length;i++){
            System.out.println("3");
            elementList[i]=boardImages[i];
            //panel.add(boardImages[i]);
        }
    }


   @Override
   public void paintComponent(Graphics g)
   {
    bufferG.clearRect(0,0,width, height);
    Graphics g3 = g; 
        g3.setColor(Color.black);
        g3.fillRect(0,0,width,height);  
        bufferG.clearRect(0,0,width, height);
        render((Graphics2D)g);
                 
            
        g3.drawImage(bufferImage, 0, 0, null);
        g3.dispose(); 
   }

   public void render(Graphics2D gb){
    //bufferG.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    //testEmitter.draw(bufferG);
    //testpoly.draw(bufferG);
    //testEmitter2.draw(bufferG);
    //Toolkit.getDefaultToolkit().sync();
    for(int i=0;i<elementList.length;i++){
        if(elementList[i]!=null){
            elementList[i].draw(bufferG);
            //Toolkit.getDefaultToolkit().sync(); 
            
            //polyList[i].draw(bufferG);
        }
        
    }
    
    
   }


   boolean click = false;
   public void nextFrame(int mouseX,int mouseY,boolean mouseDown){
    //System.out.println(mouseDown);
    if(mouseDown == true){
        
        if(click == false){
            System.out.println("called mousepos");
            Stack temp = board.mousePosToStack(mouseX, mouseY);
            if(temp != null){
                temp.addPieceBottom(new Piece(Piece.RED));
                
                refreshBoard();
                //elementList[2].changePos(10, 10);
            }
            click = true;
        }
    }else{
        click = false;
    }
    //int x;int y;
    //testpoly.setPoint(2,mouseX,mouseY);
    for(int i=0;i<elementList.length;i++){
        if(elementList[i]!=null){
            //x=elementList[i].getXPos();y=elementList[i].getYPos();
            //polyList[i].movePos(rand.nextInt(5),0);
            //if(polyList[i].getX()>width){polyList[i].setPos(-100,polyList[i].getY());}
            //elementList[i].setPos((int)(elementList[i].ogX+(mouseX-(width/2))/(1+(float)elementList[i].getXScale()/20)),(int)(elementList[i].ogY+(mouseY-(height/2))/(1+(float)elementList[i].getYScale()/20)));
            //elementList[i].changePos(rand.nextInt(3)-1,rand.nextInt(3)-1);
            //if(mouseDown){elementList[i].changePos(mouseX>x?1:-1,mouseY>y?1:-1);}
            //if(elementList[i].getYPos()>h2){elementList[i].setPos(-1,0);}
            //elementList[i].changeScale(rand.nextInt(3)-1,rand.nextInt(3)-1);
        
        }
        }
   }

}