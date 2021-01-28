/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication4;

import java.awt.Polygon;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.Stack;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Hruteesh Raja
 */
public class HexagonController implements Initializable {
    public TextField p1;
    public TextField p2;
    public TextField p3;
    public TextField p4;
    ImageView tileToBeChanged;
    public final int xDiff=80,yDiff=48;
    public AnchorPane tilingAnchor;
    public ImageView hexDef;
    public Image hexDefImage;
    public ImageView hexDisplay1;
    public ImageView hexDisplay2;
    public ImageView hexDisplay3;
    public ImageView hexDisplay4;
    public Image hexDisplayImage1;
    public Image hexDisplayImage2;
    public Image hexDisplayImage3;
    public Image hexDisplayImage4;
    
    public Canvas tilingCanvas;
    
    public ImageView hexTile1;
    public ImageView hexTile2;
    public ImageView hexTile3;
    public ImageView hexTile4;
    public Image hexTileImage1;
    public Image hexTileImage2;
    public Image hexTileImage3;
    public Image hexTileImage4;
    public Image hexS1;
    public Image hexS2;
    public Image hexS3;
    public Image hexS4;
    
    public Label L1;
    public Label L2;
    public Label L3;
    public Label L4;
    
    public ImageView tiling1[][];
    public ImageView tiling2[][];
    public Image selectedTile;
    
    
    public void resetProbabilities(){
        p1.setText("0.25");
        p2.setText("0.25");
        p3.setText("0.25");
        p4.setText("0.25");
    }
    public void fillTiles(){
        double a=Double.parseDouble(p1.getText());
        double b=Double.parseDouble(p2.getText());
        double c=Double.parseDouble(p3.getText());
        double d=Double.parseDouble(p4.getText());
        double sum=a+b+c+d;
        for(int row=0;row<16;row++){
            for(int col=0;col<13;col++){
                if(tiling1[row][col].getImage()==hexDefImage){
                    double x=Math.random();
                    if(x>=0&&x<a/sum){
                        tiling1[row][col].setImage(hexTileImage1);
                    }
                    else if(x>=a/sum&&x<(a+b)/sum){
                        tiling1[row][col].setImage(hexTileImage2);
                    }
                    else if(x>=(a+b)/sum&&x<(a+b+c)/sum){
                        tiling1[row][col].setImage(hexTileImage3);
                    }
                    else if(x>=(a+b+c)/sum && x<(a+b+c+d)/sum){
                        tiling1[row][col].setImage(hexTileImage4);
                    }
                    
                }
            }
            
        }
        for(int row=0;row<16;row++){
            for(int col=0;col<13;col++){
                if(tiling2[row][col].getImage()==hexDefImage){
                    double x=Math.random();
                    if(x>=0&&x<a/sum){
                        tiling2[row][col].setImage(hexTileImage1);
                    }
                    else if(x>=a/sum&&x<(a+b)/sum){
                        tiling2[row][col].setImage(hexTileImage2);
                    }
                    else if(x>=(a+b)/sum&&x<(a+b+c)/sum){
                        tiling2[row][col].setImage(hexTileImage3);
                    }
                    else if(x>=(a+b+c)/sum && x<(a+b+c+d)/sum){
                        tiling2[row][col].setImage(hexTileImage4);
                    }
                    
                }
            }
            
        }
    }
    public void deleteTile(){
        selectedTile=hexDefImage;
    }
    public void deleteAll(){
        for(int i=0;i<16;i++){
            for(int j=0;j<13;j++){
                tiling1[i][j].setImage(hexDefImage);
                tiling2[i][j].setImage(hexDefImage);
            }
        }
    }
    public void back(ActionEvent e) throws Exception{
        Parent Square =  FXMLLoader.load(getClass().getResource("Start.fxml"));
        Scene SquareScene = new Scene(Square);
        Stage window= (Stage)((Node)e.getSource()).getScene().getWindow();
        window.setScene(SquareScene);
        window.show();
    }
    public void findMaze(){
        int [][]Maze = new int[102][78];
        
        for(int row=0;row<16;row++){
            for(int col=0;col<13;col++){
                if(tiling1[row][col].getImage()==hexTileImage1){
                    int x=0;
                    Maze[row*6+3][col*6+x]=1;
                    Maze[row*6+4][col*6+x]=1;
                    Maze[row*6+5][col*6+x]=0;
                    Maze[row*6+6][col*6+x]=0;
                    Maze[row*6+7][col*6+x]=1;
                    Maze[row*6+8][col*6+x]=1;
                    x++;
                    Maze[row*6+3][col*6+x]=0;
                    Maze[row*6+4][col*6+x]=0;
                    Maze[row*6+5][col*6+x]=0;
                    Maze[row*6+6][col*6+x]=0;
                    Maze[row*6+7][col*6+x]=0;
                    Maze[row*6+8][col*6+x]=0;
                    x++;
                    Maze[row*6+3][col*6+x]=0;
                    Maze[row*6+4][col*6+x]=0;
                    Maze[row*6+5][col*6+x]=1;
                    Maze[row*6+6][col*6+x]=1;
                    Maze[row*6+7][col*6+x]=0;
                    Maze[row*6+8][col*6+x]=0;
                    x++;
                }
                else if(tiling1[row][col].getImage()==hexTileImage2){
                    int x=0;
                    Maze[row*6+3][col*6+x]=0;
                    Maze[row*6+4][col*6+x]=0;
                    Maze[row*6+5][col*6+x]=1;
                    Maze[row*6+6][col*6+x]=1;
                    Maze[row*6+7][col*6+x]=0;
                    Maze[row*6+8][col*6+x]=0;
                    x++;
                    Maze[row*6+3][col*6+x]=0;
                    Maze[row*6+4][col*6+x]=0;
                    Maze[row*6+5][col*6+x]=0;
                    Maze[row*6+6][col*6+x]=0;
                    Maze[row*6+7][col*6+x]=0;
                    Maze[row*6+8][col*6+x]=0;
                    x++;
                    Maze[row*6+3][col*6+x]=1;
                    Maze[row*6+4][col*6+x]=1;
                    Maze[row*6+5][col*6+x]=0;
                    Maze[row*6+6][col*6+x]=0;
                    Maze[row*6+7][col*6+x]=1;
                    Maze[row*6+8][col*6+x]=1;
                    x++;
                }
                else if(tiling1[row][col].getImage()==hexTileImage3){
                    int x=0;
                    Maze[row*6+3][col*6+x]=0;
                    Maze[row*6+4][col*6+x]=0;
                    Maze[row*6+5][col*6+x]=1;
                    Maze[row*6+6][col*6+x]=1;
                    Maze[row*6+7][col*6+x]=0;
                    Maze[row*6+8][col*6+x]=0;
                    x++;
                    Maze[row*6+3][col*6+x]=0;
                    Maze[row*6+4][col*6+x]=1;
                    Maze[row*6+5][col*6+x]=1;
                    Maze[row*6+6][col*6+x]=1;
                    Maze[row*6+7][col*6+x]=1;
                    Maze[row*6+8][col*6+x]=0;
                    x++;
                    Maze[row*6+3][col*6+x]=1;
                    Maze[row*6+4][col*6+x]=1;
                    Maze[row*6+5][col*6+x]=0;
                    Maze[row*6+6][col*6+x]=0;
                    Maze[row*6+7][col*6+x]=1;
                    Maze[row*6+8][col*6+x]=1;
                    x++;
                }
                else{
                    int x=0;
                    Maze[row*6+3][col*6+x]=1;
                    Maze[row*6+4][col*6+x]=1;
                    Maze[row*6+5][col*6+x]=0;
                    Maze[row*6+6][col*6+x]=0;
                    Maze[row*6+7][col*6+x]=1;
                    Maze[row*6+8][col*6+x]=1;
                    x++;
                    Maze[row*6+3][col*6+x]=0;
                    Maze[row*6+4][col*6+x]=1;
                    Maze[row*6+5][col*6+x]=1;
                    Maze[row*6+6][col*6+x]=1;
                    Maze[row*6+7][col*6+x]=1;
                    Maze[row*6+8][col*6+x]=0;
                    x++;
                    Maze[row*6+3][col*6+x]=0;
                    Maze[row*6+4][col*6+x]=0;
                    Maze[row*6+5][col*6+x]=1;
                    Maze[row*6+6][col*6+x]=1;
                    Maze[row*6+7][col*6+x]=0;
                    Maze[row*6+8][col*6+x]=0;
                    x++;
                }
            }
                
        }
        for(int row=0;row<16;row++){
            for(int col=0;col<13;col++){
                if(tiling2[row][col].getImage()==hexTileImage1){
                    int x=3,y=3;
                    Maze[row*6+3-y][col*6+x]=1;
                    Maze[row*6+4-y][col*6+x]=1;
                    Maze[row*6+5-y][col*6+x]=0;
                    Maze[row*6+6-y][col*6+x]=0;
                    Maze[row*6+7-y][col*6+x]=1;
                    Maze[row*6+8-y][col*6+x]=1;
                    x++;
                    Maze[row*6+3-y][col*6+x]=0;
                    Maze[row*6+4-y][col*6+x]=0;
                    Maze[row*6+5-y][col*6+x]=0;
                    Maze[row*6+6-y][col*6+x]=0;
                    Maze[row*6+7-y][col*6+x]=0;
                    Maze[row*6+8-y][col*6+x]=0;
                    x++;
                    Maze[row*6+3-y][col*6+x]=0;
                    Maze[row*6+4-y][col*6+x]=0;
                    Maze[row*6+5-y][col*6+x]=1;
                    Maze[row*6+6-y][col*6+x]=1;
                    Maze[row*6+7-y][col*6+x]=0;
                    Maze[row*6+8-y][col*6+x]=0;
                    x++;
                }
                else if(tiling2[row][col].getImage()==hexTileImage2){
                    int x=3,y=3;
                    Maze[row*6+3-y][col*6+x]=0;
                    Maze[row*6+4-y][col*6+x]=0;
                    Maze[row*6+5-y][col*6+x]=1;
                    Maze[row*6+6-y][col*6+x]=1;
                    Maze[row*6+7-y][col*6+x]=0;
                    Maze[row*6+8-y][col*6+x]=0;
                    x++;
                    Maze[row*6+3-y][col*6+x]=0;
                    Maze[row*6+4-y][col*6+x]=0;
                    Maze[row*6+5-y][col*6+x]=0;
                    Maze[row*6+6-y][col*6+x]=0;
                    Maze[row*6+7-y][col*6+x]=0;
                    Maze[row*6+8-y][col*6+x]=0;
                    x++;
                    Maze[row*6+3-y][col*6+x]=1;
                    Maze[row*6+4-y][col*6+x]=1;
                    Maze[row*6+5-y][col*6+x]=0;
                    Maze[row*6+6-y][col*6+x]=0;
                    Maze[row*6+7-y][col*6+x]=1;
                    Maze[row*6+8-y][col*6+x]=1;
                    x++;
                }
                else if(tiling2[row][col].getImage()==hexTileImage3){
                    int x=3,y=3;
                    Maze[row*6+3-y][col*6+x]=0;
                    Maze[row*6+4-y][col*6+x]=0;
                    Maze[row*6+5-y][col*6+x]=1;
                    Maze[row*6+6-y][col*6+x]=1;
                    Maze[row*6+7-y][col*6+x]=0;
                    Maze[row*6+8-y][col*6+x]=0;
                    x++;
                    Maze[row*6+3-y][col*6+x]=0;
                    Maze[row*6+4-y][col*6+x]=1;
                    Maze[row*6+5-y][col*6+x]=1;
                    Maze[row*6+6-y][col*6+x]=1;
                    Maze[row*6+7-y][col*6+x]=1;
                    Maze[row*6+8-y][col*6+x]=0;
                    x++;
                    Maze[row*6+3-y][col*6+x]=1;
                    Maze[row*6+4-y][col*6+x]=1;
                    Maze[row*6+5-y][col*6+x]=0;
                    Maze[row*6+6-y][col*6+x]=0;
                    Maze[row*6+7-y][col*6+x]=1;
                    Maze[row*6+8-y][col*6+x]=1;
                    x++;
                }
                else{
                    int x=3,y=3;
                    Maze[row*6+3-y][col*6+x]=1;
                    Maze[row*6+4-y][col*6+x]=1;
                    Maze[row*6+5-y][col*6+x]=0;
                    Maze[row*6+6-y][col*6+x]=0;
                    Maze[row*6+7-y][col*6+x]=1;
                    Maze[row*6+8-y][col*6+x]=1;
                    x++;
                    Maze[row*6+3-y][col*6+x]=0;
                    Maze[row*6+4-y][col*6+x]=1;
                    Maze[row*6+5-y][col*6+x]=1;
                    Maze[row*6+6-y][col*6+x]=1;
                    Maze[row*6+7-y][col*6+x]=1;
                    Maze[row*6+8-y][col*6+x]=0;
                    x++;
                    Maze[row*6+3-y][col*6+x]=0;
                    Maze[row*6+4-y][col*6+x]=0;
                    Maze[row*6+5-y][col*6+x]=1;
                    Maze[row*6+6-y][col*6+x]=1;
                    Maze[row*6+7-y][col*6+x]=0;
                    Maze[row*6+8-y][col*6+x]=0;
                    x++;
                }
            }
                
        }
        
        int maxComponent=2;
        Stack<Integer> c=new Stack();
        Stack<Integer> I=new Stack<>();
        Stack<Integer> J=new Stack<>();
        for(int i=0;i<102;i++){
            for(int j=0;j<78;j++){
                if(Maze[i][j]==1){
                    Maze[i][j]=maxComponent;
                    maxComponent++;
                    if(i<101){
                        if(Maze[i+1][j]==1){
                            c.push(Maze[i][j]);
                            I.push(i+1);
                            J.push(j);
                        }
                    }
                    if(j<77){
                        if(Maze[i][j+1]==1){
                            c.push(Maze[i][j]);
                            I.push(i);
                            J.push(j+1);
                        }
                    }
                }
                while(!I.isEmpty()){
                    int cur=c.pop();
                    int row=I.pop();
                    int col=J.pop();
                    Maze[row][col]=cur;
                    if(row>0){
                        if(Maze[row-1][col]==1){
                            c.push(Maze[row][col]);
                            I.push(row-1);
                            J.push(col);
                        }
                    }
                    if(col>0){
                        if(Maze[row][col-1]==1){
                            c.push(Maze[row][col]);
                            I.push(row);
                            J.push(col-1);
                        }
                    }
                    if(row<101){
                        if(Maze[row+1][col]==1){
                            c.push(Maze[row][col]);
                            I.push(row+1);
                            J.push(col);
                        }
                    }
                    if(col<77){
                        if(Maze[row][col+1]==1){
                            c.push(Maze[row][col]);
                            I.push(row);
                            J.push(col+1);
                        }
                    }
                }
            }
        }
        HashSet<Integer> firstRow=new HashSet<>();
        HashSet<Integer> firstColumn=new HashSet<>();
        HashSet<Integer> lastColumn=new HashSet<>();
        HashSet<Integer> lastRow=new HashSet<>();
        ArrayList<Integer> mazesComp=new ArrayList<Integer>();
        for(int i=1;i<101;i++){
            firstColumn.add(Maze[i][0]);
            lastColumn.add(Maze[i][77]);
        }
        for(int i=1;i<77;i++){
            firstRow.add(Maze[0][i]);
            firstRow.add(Maze[1][i]);
            firstRow.add(Maze[2][i]);
            lastRow.add(Maze[67][i]);
            lastRow.add(Maze[65][i]);
            lastRow.add(Maze[66][i]);
        }
         Object comp[]=firstRow.toArray();
        for(Object o:comp){
            int i=Integer.parseInt(o.toString());
            if(lastRow.contains(i) || firstColumn.contains(i) || lastColumn.contains(i) && !mazesComp.contains(i)){
                mazesComp.add(i);
                
            }
        }
        comp=lastRow.toArray();
        for(Object o:comp){
            int i=Integer.parseInt(o.toString());
            if(firstColumn.contains(i) || lastColumn.contains(i) && !mazesComp.contains(i)){
                mazesComp.add(i);
                
            }
        }
        comp=firstColumn.toArray();
        for(Object o:comp){
            int i=Integer.parseInt(o.toString());
            if(lastColumn.contains(i) && !mazesComp.contains(i)){
                mazesComp.add(i);
                
            }
        }
        for(int i:mazesComp){
            System.out.println(i);
        }
       for(int i=0;i<99;i++){
           for(int j=0;j<78;j++){
       //        System.out.print(Maze[i][j]+"\t");
           }
     //      System.out.println();
       }
       
       for(int i=0;i<93;i++){
           for(int j=0;j<78;j++){
               int rowOffset=0;
                   if(j%6<3)
                       rowOffset=3;
               if(mazesComp.contains(Maze[i+rowOffset][j])&&Maze[i+rowOffset][j]!=0){
                   
                   int originalRow=(i+rowOffset)/6;
                   int originalCol=j/3;
                   if(rowOffset==3){
                        if(tiling1[originalRow][originalCol/2].getImage()==hexTileImage1)
                            tiling1[originalRow][originalCol/2].setImage(hexS1);
                        else if(tiling1[originalRow][originalCol/2].getImage()==hexTileImage2)
                            tiling1[originalRow][originalCol/2].setImage(hexS2);
                        else if(tiling1[originalRow][originalCol/2].getImage()==hexTileImage3)
                            tiling1[originalRow][originalCol/2].setImage(hexS3);
                        else if(tiling1[originalRow][originalCol/2].getImage()==hexTileImage4)
                            tiling1[originalRow][originalCol/2].setImage(hexS4);
                       
                   }
                   else{
                        if(tiling2[originalRow][originalCol/2].getImage()==hexTileImage1)
                            tiling2[originalRow][originalCol/2].setImage(hexS1);
                        else if(tiling2[originalRow][originalCol/2].getImage()==hexTileImage2)
                            tiling2[originalRow][originalCol/2].setImage(hexS2);
                        else if(tiling2[originalRow][originalCol/2].getImage()==hexTileImage3)
                            tiling2[originalRow][originalCol/2].setImage(hexS3);
                        else if(tiling2[originalRow][originalCol/2].getImage()==hexTileImage4)
                            tiling2[originalRow][originalCol/2].setImage(hexS4);
                       
                   }
                   
               }
           }
       }
       
    }
    public void selected1(){
        L1.setVisible(true);
        L2.setVisible(false);
        L3.setVisible(false);
        L4.setVisible(false);
        selectedTile=hexTileImage1;
        
    }
    public void selected2(){
        L2.setVisible(true);
        L1.setVisible(false);
        L3.setVisible(false);
        L4.setVisible(false);
        selectedTile=hexTileImage2;
    }
    public void selected3(){
        L3.setVisible(true);
        L2.setVisible(false);
        L1.setVisible(false);
        L4.setVisible(false);
        selectedTile=hexTileImage3;
    }
    public void selected4(){
        L4.setVisible(true);
        L2.setVisible(false);
        L3.setVisible(false);
        L1.setVisible(false);
        selectedTile=hexTileImage4;
    }

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tiling1=new ImageView[16][13];
        tiling2=new ImageView[16][13];
        
       
        hexDisplayImage1=new Image(new File("Bhex"+Integer.toString(1)+".png").toURI().toString());
        hexDisplayImage2=new Image(new File("Bhex"+Integer.toString(2)+".png").toURI().toString());
        hexDisplayImage3=new Image(new File("Bhex"+Integer.toString(3)+".png").toURI().toString());
        hexDisplayImage4=new Image(new File("Bhex"+Integer.toString(4)+".png").toURI().toString());
        hexDisplay1.setImage(hexDisplayImage1);
        hexDisplay2.setImage(hexDisplayImage2);
        hexDisplay3.setImage(hexDisplayImage3);
        hexDisplay4.setImage(hexDisplayImage4);
        
        hexTile1=new ImageView();hexTile2=new ImageView();hexTile3=new ImageView();hexTile4=new ImageView();hexDef=new ImageView();
        
        hexTileImage1=new Image(new File("hex"+Integer.toString(1)+".png").toURI().toString());
        hexTileImage2=new Image(new File("hex"+Integer.toString(2)+".png").toURI().toString());
        hexTileImage3=new Image(new File("hex"+Integer.toString(3)+".png").toURI().toString());
        hexTileImage4=new Image(new File("hex"+Integer.toString(4)+".png").toURI().toString());
        hexS1=new Image(new File("hex"+Integer.toString(1)+"S.png").toURI().toString());
        hexS2=new Image(new File("hex"+Integer.toString(2)+"S.png").toURI().toString());
        hexS3=new Image(new File("hex"+Integer.toString(3)+"S.png").toURI().toString());
        hexS4=new Image(new File("hex"+Integer.toString(4)+"S.png").toURI().toString());
        
        hexTile1.setImage(hexTileImage1);
        hexTile2.setImage(hexTileImage2);
        hexTile3.setImage(hexTileImage3);
        hexTile4.setImage(hexTileImage4);
        
        hexDefImage =new Image(new File("hexDef.png").toURI().toString());
        hexDef.setImage(hexDefImage);
        
        selected1();
        int inX1=14,inX2=54,inY1=26,inY2=2;
        for(int row=0;row<16;row++){
            for(int col=0;col<13;col++){
                tiling1[row][col]=new ImageView();
                tiling1[row][col].setImage(hexDefImage);
                tiling2[row][col]=new ImageView();
                tiling2[row][col].setImage(hexDefImage);
                tilingAnchor.getChildren().add(tiling1[row][col]);
                tilingAnchor.getChildren().add(tiling2[row][col]);
                final int r=row,c=col;
                tiling1[row][col].setX(inX1+col*xDiff);
                tiling1[row][col].setY(inY1+row*yDiff);
                tiling2[row][col].setX(inX2+col*xDiff);
                tiling2[row][col].setY(inY2+row*yDiff);
                tiling1[row][col].addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
                    System.out.println("Tile pressed "+"" +r+" "+c);
                    tiling1[r][c].setImage(selectedTile);
                });
                tiling2[row][col].addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
                    System.out.println("Tile pressed "+r+" "+c);
                    tiling2[r][c].setImage(selectedTile);
                });
            }
        }
        
    }    
    
    
}
class TileHexagon{
    int tile[][]=new int[3][2];
    int center;
    TileHexagon topR,topL,top,bot,botR,botL;
}
