/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication4;

import java.awt.Point;
import java.awt.Rectangle;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.ResourceBundle;
import java.util.Stack;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Hruteesh Raja
 */
enum Type{
    t1,t2,t3,t4,def;
}

public class SquareController implements Initializable {
    boolean triangle;
    public Button po2;
    int componentID[][];
    int filledTiles=0;
    Pane tilings[][];
    public HBox g;
    int change=0;
    final int numCols = 42 ;
    final int numRows = 32 ;
    File bim[]=new File[4];
    File im[]=new File[4];
    File bimS[]=new File[4];
    File imS[]=new File[4];
    File d=new File("default.png");
    Image dImage;
    Image bimage[]=new Image[4];
    Image image[]=new Image[4];
    Image bimageS[]=new Image[4];
    Image imageS[]=new Image[4];
    
    Image currentSelectedT;
    Image currentSelectedD;
    
    public GridPane grid;
    
    public ImageView st1;
    public ImageView st2;
    public ImageView st3;
    public ImageView st4;
    
    public ImageView st11;
    public ImageView st22;
    public ImageView st33;
    public ImageView st44;
    
    public TextField p1;
    public TextField p2;
    public TextField p4;
    public TextField p3;
    
    public TextField p11;
    public TextField p22;
    public TextField p44;
    public TextField p33;
    
    double prob[]=new double[4];
    
    Type selectedTile=Type.t1;
    
    public ImageView tiles[][];
    
    public Label L1;
    public Label L2;
    public Label L3;
    public Label L4;
    
    public Label L11;
    public Label L21;
    public Label L31;
    public Label L41;
    
    public void borderChange1(){
       L1.setVisible(true);
       L2.setVisible(false);
       L3.setVisible(false);
       L4.setVisible(false);
       selectedTile=Type.t1;
       currentSelectedT=image[0];
    } 
    public void borderChange2(){
       L1.setVisible(false);
       L2.setVisible(true);
       L3.setVisible(false);
       L4.setVisible(false);
       selectedTile=Type.t2;
       currentSelectedT=image[1];
    } 
    public void borderChange3(){
       L1.setVisible(false);
       L2.setVisible(false);
       L3.setVisible(true);
       L4.setVisible(false);
       currentSelectedT=image[2];
       selectedTile=Type.t3;
    } 
    public void borderChange4(){
       L1.setVisible(false);
       L2.setVisible(false);
       L3.setVisible(false);
       L4.setVisible(true);
       currentSelectedT=image[3];
       selectedTile=Type.t4;
    } 
    public void dotChange1(){
       L11.setVisible(true);
       L21.setVisible(false);
       L31.setVisible(false);
       L41.setVisible(false);
       selectedTile=Type.t1;
       currentSelectedD=image[0];
    } 
    public void dotChange2(){
       L11.setVisible(false);
       L21.setVisible(true);
       L31.setVisible(false);
       L41.setVisible(false);
       selectedTile=Type.t2;
       currentSelectedD=image[1];
    } 
    public void dotChange3(){
       L11.setVisible(false);
       L21.setVisible(false);
       L31.setVisible(true);
       L41.setVisible(false);
       currentSelectedD=image[2];
       selectedTile=Type.t3;
    } 
    public void dotChange4(){
       L11.setVisible(false);
       L21.setVisible(false);
       L31.setVisible(false);
       L41.setVisible(true);
       currentSelectedD=image[3];
       selectedTile=Type.t4;
    } 
    public void back(ActionEvent e) throws Exception{
        Parent Square =  FXMLLoader.load(getClass().getResource("Start.fxml"));
        Scene SquareScene = new Scene(Square);
        Stage window= (Stage)((Node)e.getSource()).getScene().getWindow();
        window.setScene(SquareScene);
        window.show();
    }
    public void resetProbabilitiesTriangle(){
        p1.setText("0.25");
        p2.setText("0.25");
        p3.setText("0.25");
        p4.setText("0.25");
    }
    public void resetProbabilitiesDotted(){
        p11.setText("0.25");
        p22.setText("0.25");
        p33.setText("0.25");
        p44.setText("0.25");

    }
    public void fillTiles(){
        double a=Double.parseDouble(p1.getText());
        double b=Double.parseDouble(p2.getText());
        double c=Double.parseDouble(p3.getText());
        double d=Double.parseDouble(p4.getText());
        if(triangle==true){
            a=Double.parseDouble(p11.getText());
            b=Double.parseDouble(p22.getText());
            c=Double.parseDouble(p33.getText());
            d=Double.parseDouble(p44.getText());
        }
        double sum=a+b+c+d;
        for(int row=0;row<32;row++){
            for(int col=0;col<42;col++){
                if(tiles[col][row].getImage()==dImage){
                    double x=Math.random();
                    if(x>=0&&x<a/sum){
                        tiles[col][row].setImage(image[0]);
                    }
                    else if(x>=a/sum&&x<(a+b)/sum){
                        tiles[col][row].setImage(image[1]);
                    }
                    else if(x>=(a+b)/sum&&x<(a+b+c)/sum){
                        tiles[col][row].setImage(image[2]);
                    }
                    else if(x>=(a+b+c)/sum && x<(a+b+c+d)/sum){
                        tiles[col][row].setImage(image[3]);
                    }
                    
                }
            }
        }
    }
    public void deleteTile(){
        currentSelectedT=dImage;
        currentSelectedD=dImage;
    }
    public void deleteAll(){
        for(int row=0;row<numRows;row++){
            for(int col=0;col<numCols;col++){
                tiles[col][row].setImage(dImage);
            }
        }
    }
    public boolean allFilled(){
        for(int row=0;row<32;row++){
            for(int col=0;col<42;col++){
                if(tiles[col][row].getImage()==dImage){
                    return false;
                }
            }
        }
        return true;
        
    }
    public void findMazeTriangle(){
        if(!allFilled()){
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Please fill all tiles first!");
            alert.showAndWait();
            return;
        }
        TileTriangle tile[][]=new TileTriangle[32][42];
        TileTriangle leftside=null;
        TileTriangle topside=null;
        for(int row=0;row<32;row++){
            for(int col=0;col<42;col++){
                tile[row][col]=new TileTriangle();
                if(tiles[col][row].getImage()==image[0]){
                    tile[row][col].topBottom=false;
                    tile[row][col].leftRight=true;
                }
                else if(tiles[col][row].getImage()==image[1]){
                    tile[row][col].topBottom=true;
                    tile[row][col].leftRight=true;
                }
                else if(tiles[col][row].getImage()==image[2]){
                    tile[row][col].topBottom=true;
                    tile[row][col].leftRight=false;
                }
                else{
                    tile[row][col].topBottom=false;
                    tile[row][col].leftRight=false;
                }
                
                if(row>0){
                    if(!tile[row][col].topBottom && tile[row-1][col].topBottom){
                        tile[row][col].top=tile[row-1][col];
                        tile[row-1][col].bottom=tile[row][col];
                    }
                }
                if(col>0){
                    if(!tile[row][col].leftRight && tile[row][col-1].leftRight){
                        tile[row][col].left=tile[row][col-1];
                        tile[row][col-1].right=tile[row][col];
                    }
                }
                
                
            }
        }
        Stack<TileTriangle> traversalStack =new Stack<>();
        Stack<Integer> I=new Stack<>();
        Stack<Integer> J=new Stack<>();
        traversalStack.push(tile[0][0]);
        I.push(0);
        J.push(0);
        componentID=new int[32][42];
        int maxComponent=1;
        TileTriangle temp;
        for(int row=0;row<32;row++){
            for(int col=0;col<42;col++){
                if(componentID[row][col]==0){
                    int t,l;
                    if(tile[row][col].top==null && tile[row][col].left==null){
                        componentID[row][col]=maxComponent;
                        maxComponent++;
                    }
                    else if(tile[row][col].top==null){
                        componentID[row][col]=componentID[row][col-1];
                        
                    }
                    else if(tile[row][col].left==null){
                        componentID[row][col]=componentID[row-1][col];
                    }
                    else{
                        t=componentID[row-1][col];
                        l=componentID[row][col-1];
                        if(t==l){
                            componentID[row][col]=t;
                        }
                        else if(t<l){
                            componentID[row][col]=t;
                            traversalStack.push(tile[row][col].left);
                            I.push(row);
                            J.push(col-1);
                            componentID[row][col-1]=componentID[row][col];
                        }
                        else{
                            componentID[row][col]=l;
                            traversalStack.push(tile[row][col].top);
                            I.push(row-1);
                            J.push(col);
                            componentID[row-1][col]=componentID[row][col];
                        }
                    }
                    
                }
                while(!traversalStack.isEmpty()){
                    temp=traversalStack.pop();
                    int i=I.pop(),j=J.pop();
                    int cur=componentID[i][j];
                    if(temp.top!=null){
                        if(componentID[i-1][j]>cur){
                           componentID[i-1][j]=cur;
                           traversalStack.push(temp.top);
                           I.push(i-1);
                           J.push(j);
                        }
                    }
                    if(temp.bottom!=null){
                        if(componentID[i+1][j]>cur){
                           componentID[i+1][j]=cur;
                           traversalStack.push(temp.bottom);
                           I.push(i+1);
                           J.push(j);
                        }
                    }
                    if(temp.left!=null){
                        if(componentID[i][j-1]>cur){
                           componentID[i][j-1]=cur;
                           traversalStack.push(temp.left);
                           I.push(i);
                           J.push(j-1);
                        }
                    }
                    if(temp.right!=null){
                        if(componentID[i][j+1]>cur){
                           componentID[i][j+1]=cur;
                           traversalStack.push(temp.right);
                           I.push(i);
                           J.push(j+1);
                        }
                    }
                }
                
            }
        }
        for(int i=0;i<32;i++){
            for(int j=0;j<42;j++){
                System.out.print("\t"+componentID[i][j]);
            }
            System.out.println();
        }
        HashSet<Integer> firstRow=new HashSet<>();
        HashSet<Integer> firstColumn=new HashSet<>();
        HashSet<Integer> lastColumn=new HashSet<>();
        HashSet<Integer> lastRow=new HashSet<>();
        ArrayList<Integer> mazesComp=new ArrayList<Integer>();
        for(int i=1;i<41;i++){
            if(!tile[0][i].topBottom)
                firstRow.add(componentID[0][i]);
            if(tile[31][i].topBottom)
                lastRow.add(componentID[31][i]);
            if(i<31){
                if(!tile[i][0].leftRight)
                    firstColumn.add(componentID[i][0]);
                if(tile[i][41].leftRight)
                    lastColumn.add(componentID[i][41]);
            }
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
        //Painiting maze
        for(int i=0;i<32;i++){
            for(int j=0;j<42;j++){
                if(mazesComp.contains(componentID[i][j])){
                    if(tiles[j][i].getImage()==image[0]){
                            tiles[j][i].setImage(imageS[0]);
                    }
                    else if(tiles[j][i].getImage()==image[1]){
                            tiles[j][i].setImage(imageS[1]);
                    }
                    else if(tiles[j][i].getImage()==image[2]){
                            tiles[j][i].setImage(imageS[2]);
                    }
                    else{
                        tiles[j][i].setImage(imageS[3]);
                    }
                }
            }
        }
        
        
        
    }
    public void findMazeDotted(){
        if(!allFilled()){
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Please fill all tiles first!");
            alert.showAndWait();
            return;
        }
        TileDotted tile[][]=new TileDotted[32][42];
        TileDotted leftside=null;
        TileDotted topside=null;
        for(int row=0;row<32;row++){
            for(int col=0;col<42;col++){
                tile[row][col]=new TileDotted();
                if(tiles[col][row].getImage()==image[0]){
                    tile[row][col].tile[0][0]=1;
                    tile[row][col].tile[1][1]=1;
                    tile[row][col].center=1;
                    
                }
                else if(tiles[col][row].getImage()==image[1]){
                    tile[row][col].tile[0][1]=1;
                    tile[row][col].tile[1][0]=1;
                    tile[row][col].center=1;
                }
                else if(tiles[col][row].getImage()==image[2]){
                    tile[row][col].tile[0][0]=1;
                    tile[row][col].tile[1][1]=1;
                    tile[row][col].center=0;
                    
                }
                else{
                    tile[row][col].tile[0][1]=1;
                    tile[row][col].tile[1][0]=1;
                    tile[row][col].center=0;
                }
                
                if(row>0){
                    if(tile[row-1][col].tile[1][0] == tile[row][col].tile[0][0]){
                        tile[row][col].top=tile[row-1][col];
                        tile[row-1][col].bottom=tile[row][col];
                    }
                }
                if(col>0){
                    if(tile[row][col-1].tile[0][1] == tile[row][col].tile[0][0]){
                        tile[row][col].left=tile[row][col-1];
                        tile[row][col-1].right=tile[row][col];
                    }
                }
            }
        }
        
        Stack<TileDotted> traversalStack =new Stack<>();
        Stack<Integer> I=new Stack<>();
        Stack<Integer> J=new Stack<>();
        traversalStack.push(tile[0][0]);
        I.push(0);
        J.push(0);
        int maxComponent=2;
        TileDotted temp;
        for(int row=0;row<32;row++){
            for(int col=0;col<42;col++){
                temp=tile[row][col];
                
                
                if(temp.tile[0][0]==1){
                    if(temp.left==null && temp.top==null){
                        temp.tile[0][0]=maxComponent;
                        
                        if(temp.center==1){
                            temp.center=  temp.tile[0][0];
                            temp.tile[1][1]=temp.tile[0][0];
                        }
                        else{
                            temp.tile[1][1]=maxComponent+1;
                            maxComponent++;
                        }
                        maxComponent++;
                    }
                    
                    else if(temp.top==null){
                        temp.tile[0][0]=temp.left.tile[0][1];
                        if(temp.center==1){
                            temp.center=  temp.tile[0][0];
                            temp.tile[1][1]=temp.tile[0][0];
                        }
                        else{
                            temp.tile[1][1]=maxComponent+1;
                            maxComponent++;
                        }
                        maxComponent++;
                        
                    }
                    else if(temp.left==null){
                        temp.tile[0][0]=temp.top.tile[1][0];
                        if(temp.center==1){
                            temp.center=  temp.tile[0][0];
                            temp.tile[1][1]=temp.tile[0][0];
                        }
                        else{
                            temp.tile[1][1]=maxComponent+1;
                            maxComponent++;
                        }
                        maxComponent++;
                    }
                    else{
                        int t=temp.top.tile[1][0],l=temp.left.tile[0][1];
                        if(t==l){
                            temp.tile[0][0]=temp.top.tile[1][0];
                            if(temp.center==1){
                                temp.center=  temp.tile[0][0];
                                temp.tile[1][1]=temp.tile[0][0];
                            }
                            else{
                                temp.tile[1][1]=maxComponent+1;
                                maxComponent++;
                            }
                            maxComponent++;
                        }
                        else if(t<l){
                            temp.tile[0][0]=temp.top.tile[1][0];
                            if(temp.center==1){
                                temp.center=  temp.tile[0][0];
                                temp.tile[1][1]=temp.tile[0][0];
                            }
                            else{
                                temp.tile[1][1]=maxComponent+1;
                                maxComponent++;
                            }
                            maxComponent++;
                            temp.left.tile[0][1]=temp.tile[0][0];
                            if(temp.left.center!=0){
                                temp.left.center=temp.left.tile[0][1];
                                temp.left.tile[1][0]=temp.left.center;
                            }
                            traversalStack.push(temp.left);
                            I.push(row);
                            J.push(col);
                        }
                        else{
                            temp.tile[0][0]=temp.left.tile[0][1];
                            if(temp.center==1){
                                temp.center=  temp.tile[0][0];
                                temp.tile[1][1]=temp.tile[0][0];
                            }
                            else{
                                temp.tile[1][1]=maxComponent+1;
                                maxComponent++;
                            }
                            maxComponent++;
                            temp.top.tile[1][0]=temp.tile[0][0];
                            if(temp.top.center!=0){
                                temp.top.center=temp.top.tile[1][0];
                                temp.top.tile[0][1]=temp.top.center;
                            }
                            
                            traversalStack.push(temp.top);
                            I.push(row);
                            J.push(col);
                        }
                    }
                }
                else if(temp.tile[1][0]==1){
                    if(temp.center==0){
                        if(temp.top==null){
                            temp.tile[0][1]=maxComponent;
                            maxComponent++;
                            
                        }
                        else{
                            temp.tile[0][1]=temp.top.tile[1][1];
                        }
                        if(temp.left==null){
                            temp.tile[1][0]=maxComponent;
                            maxComponent++;
                        }
                        else{
                            temp.tile[1][0]=temp.left.tile[1][1];
                        }
                    }
                    else{
                        if(temp.top==null&&temp.left==null){
                            temp.tile[0][1]=maxComponent;
                            temp.center=maxComponent;
                            temp.tile[1][0]=maxComponent;
                            maxComponent++;
                        }
                        else if(temp.top==null){
                            temp.tile[0][1]=temp.left.tile[1][1];
                            temp.center=temp.left.tile[1][1];
                            temp.tile[1][0]=temp.left.tile[1][1];
                            
                        }
                        else if(temp.left==null){
                            temp.tile[0][1]=temp.top.tile[1][1];
                            temp.center=temp.top.tile[1][1];
                            temp.tile[1][0]=temp.top.tile[1][1];
                            
                        }
                        else{
                             int t=temp.top.tile[1][1],l=temp.left.tile[1][1];
                             if(t==l){
                                 temp.tile[0][1]=temp.center=temp.tile[1][0]=t;
                             }
                             else if(t<l){
                                 temp.tile[0][1]=temp.center=temp.tile[1][0]=t;
                                 temp.left.tile[1][1]=t;
                                 if(temp.left.center>0){
                                     temp.left.center=t;
                                     temp.left.tile[0][0]=t;
                                 }
                                 traversalStack.push(temp.left);
                                         
                             }
                             else{
                                 temp.tile[0][1]=temp.center=temp.tile[1][0]=l;
                                 temp.top.tile[1][1]=l;
                                 if(temp.top.center>0){
                                     temp.top.center=l;
                                     temp.top.tile[0][0]=l;
                                 }
                                 traversalStack.push(temp.top);
                                 
                             }
                        }
                    }
                }
                while(!traversalStack.isEmpty()){
                    temp=traversalStack.pop();
                    if(temp.tile[0][0]>1){
                        if(temp.top!=null){
                            if(temp.top.tile[1][0]>temp.tile[0][0]){
                                 temp.top.tile[1][0]=temp.tile[0][0];
                                 if(temp.top.center>0){
                                     temp.top.center=temp.tile[0][0];
                                     temp.top.tile[0][1]=temp.tile[0][0];
                                 }
                                 traversalStack.push(temp.top);
                            }
                        }
                        if(temp.left!=null){
                            if(temp.left.tile[0][1]>temp.tile[0][0]){
                                temp.left.tile[0][1]=temp.tile[0][0];
                                if(temp.left.center>0){
                                    temp.left.center=temp.tile[0][0];
                                    temp.left.tile[1][0]=temp.tile[0][0];
                                }
                                traversalStack.push(temp.left);
                            }
                        }
                        if(temp.right!=null){
                            if(temp.right.tile[1][0]>temp.tile[1][1]){
                                temp.right.tile[1][0]=temp.tile[1][1];
                                if(temp.right.center>0){
                                    temp.right.center=temp.tile[1][1];
                                    temp.right.tile[0][1]=temp.tile[1][1];
                                }
                                traversalStack.push(temp.right);
                            }
                        }
                        if(temp.bottom!=null){
                            if(temp.bottom.tile[0][1]>temp.tile[1][1]){
                                temp.bottom.tile[0][1]=temp.tile[1][1];
                                if(temp.bottom.center>0){
                                    temp.bottom.center=temp.tile[1][1];
                                    temp.bottom.tile[1][0]=temp.tile[1][1];
                                }
                                traversalStack.push(temp.bottom);
                            }
                        }
                    }
                    else{
                        if(temp.top!=null){
                            if(temp.top.tile[1][1]>temp.tile[0][1]){
                                 temp.top.tile[1][1]=temp.tile[0][1];
                                 if(temp.top.center>0){
                                     temp.top.center=temp.tile[0][1];
                                     temp.top.tile[0][0]=temp.tile[0][1];
                                 }
                                 traversalStack.push(temp.top);
                            }
                        }
                        if(temp.left!=null){
                            if(temp.left.tile[1][1]>temp.tile[1][0]){
                                temp.left.tile[1][1]=temp.tile[1][0];
                                if(temp.left.center>0){
                                    temp.left.center=temp.tile[1][0];
                                    temp.left.tile[0][0]=temp.tile[1][0];
                                }
                                traversalStack.push(temp.left);
                            }
                        }
                        if(temp.right!=null){
                            if(temp.right.tile[0][0]>temp.tile[0][1]){
                                temp.right.tile[0][0]=temp.tile[0][1];
                                if(temp.right.center>0){
                                    temp.right.center=temp.tile[0][1];
                                    temp.right.tile[1][1]=temp.tile[0][1];
                                }
                                traversalStack.push(temp.right);
                            }
                        }
                        if(temp.bottom!=null){
                            if(temp.bottom.tile[0][0]>temp.tile[1][0]){
                                temp.bottom.tile[0][0]=temp.tile[1][0];
                                if(temp.bottom.center>0){
                                    temp.bottom.center=temp.tile[1][0];
                                    temp.bottom.tile[1][1]=temp.tile[1][0];
                                }
                                traversalStack.push(temp.bottom);
                            }
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
        for(int j=1;j<41;j++){
                firstRow.add(tile[0][j].tile[0][0]);
                firstRow.add(tile[0][j].tile[0][1]);
                lastRow.add(tile[31][j].tile[1][1]);
                lastRow.add(tile[31][j].tile[1][0]);
                
        }
        for(int j=1;j<31;j++){
                firstColumn.add(tile[j][0].tile[0][0]);
                firstColumn.add(tile[j][0].tile[1][0]);
                lastColumn.add(tile[j][41].tile[0][1]);
                lastColumn.add(tile[j][41].tile[1][1]);
                
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
        mazesComp.remove((Integer)0);
        for(int i:mazesComp){
            System.out.println(i);
        }
        //Painiting maze
        for(int i=0;i<32;i++){
            for(int j=0;j<42;j++){
                if(tileContains(tile[i][j],mazesComp)){
                    if(tiles[j][i].getImage()==image[0]){
                            tiles[j][i].setImage(imageS[0]);
                    }
                    else if(tiles[j][i].getImage()==image[1]){
                            tiles[j][i].setImage(imageS[1]);
                    }
                    else if(tiles[j][i].getImage()==image[2]){
                            tiles[j][i].setImage(imageS[2]);
                    }
                    else{
                        tiles[j][i].setImage(imageS[3]);
                    }
                }
            }
        }
        
    }
    public boolean tileContains(TileDotted t, ArrayList m){
        if(m.contains(t.tile[0][0])&&t.tile[0][0]!=0){
            return true;
        }
        if(m.contains(t.tile[0][1])&&t.tile[0][1]!=0){
            return true;
        }if(m.contains(t.tile[1][0])&&t.tile[1][0]!=0){
            return true;
        }if(m.contains(t.tile[1][1])&&t.tile[1][1]!=0){
            return true;
        }
        return false;
        
    }
    public void changeImages(){
       
        if(triangle){
            for(int i=1;i<=4;i++){
                bim[i-1]=new File("st"+Integer.toString(i)+".png");
                im[i-1]=new File("sst"+Integer.toString(i)+".png");
                imS[i-1]=new File("sst"+Integer.toString(i)+"S.png");
            }
            borderChange1();
            for(int i=0;i<4;i++){
                image[i]=new Image(im[i].toURI().toString());
                bimage[i]=new Image(bim[i].toURI().toString());
                imageS[i]=new Image(imS[i].toURI().toString());
            }
            st1.setImage(bimage[0]);
            st2.setImage(bimage[1]);
            st3.setImage(bimage[2]);
            st4.setImage(bimage[3]);
            triangle=false;
        }
        else{
            for(int i=1;i<=4;i++){
                bim[i-1]=new File("st"+Integer.toString(i)+Integer.toString(i)+".png");
                im[i-1]=new File("sst"+Integer.toString(i)+Integer.toString(i)+".png");
                imS[i-1]=new File("sst"+Integer.toString(i)+Integer.toString(i)+"S.png");
            }
            
            for(int i=0;i<4;i++){
                image[i]=new Image(im[i].toURI().toString());
                bimage[i]=new Image(bim[i].toURI().toString());
                imageS[i]=new Image(imS[i].toURI().toString());
            }
            dotChange1();
            st11.setImage(bimage[0]);
            st22.setImage(bimage[1]);
            st33.setImage(bimage[2]);
            st44.setImage(bimage[3]);
            triangle=true;
        }
        
       
        
        System.out.println(triangle);
    }
    Button b;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        triangle=true;
        grid=new GridPane();
        b=new Button();
        //grid.setGridLinesVisible(true);
        
        dImage=new Image(d.toURI().toString());
        changeImages();
        
        
        for(int i=0;i<4;i++)
            prob[i]=25;
        tiles=new ImageView[42][32];
        tilings=new Pane[42][32];
        //Adding anchor panes to each grid space
        for(int row=0;row<numRows;row++){
            for(int col=0;col<numCols;col++){
                tiles[col][row]=new ImageView();
                tiles[col][row].setImage(dImage);
                
                tilings[col][row]=new Pane();
                tilings[col][row].getChildren().add(tiles[col][row]);
                final int c=col,r=row;
                tilings[col][row].setOnMouseClicked(e -> {
                    System.out.printf("Mouse click on cell [%d, %d]%n", c, r);
                    tiles[c][r].setImage(!triangle?currentSelectedT:currentSelectedD);
                    
                });
                
                GridPane.setRowIndex(tilings[col][row], row);
                GridPane.setColumnIndex(tilings[col][row], col);
                grid.add(tilings[col][row],col,row);
            }
        }
        g.getChildren().add(grid);
        borderChange1();
        
    }  
    
}

class TileTriangle{
    boolean topBottom,leftRight;
    TileTriangle top,right,bottom,left;
    
    
    
}
class TileDotted{
    int tile[][]=new int[2][2];
    int center;
    TileDotted top,right,bottom,left;
}
