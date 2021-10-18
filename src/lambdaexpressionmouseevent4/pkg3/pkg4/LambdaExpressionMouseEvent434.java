/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lambdaexpressionmouseevent4.pkg3.pkg4;

import javafx.application.Application;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Luis
 */
public class LambdaExpressionMouseEvent434 extends Application {
   
    /* 
    private static class position{
        
        double x;
        double y;
    }
    */
    
    
    @Override
    public void start(Stage primaryStage) {
        
        HBox root = new HBox();
        Pane pane = new Pane();
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Lambda Expression Mouse Event");
        primaryStage.setScene(scene);
        
        //para la alternativa un tipo label en vez de un tipo text
        Text text = new Text("Hola, Mueveme!");
        root.getChildren().add(pane);
        pane.getChildren().add(text);
        
        //seteamos coordenadas para que el text no aparzca fuera de la ventana
        text.setX(13);
        text.setY(14);
        
        ArrastrarNodo(text);
        
        
        
        primaryStage.show();
        
        
     
    }
    
    
    //la alternativa comentada hay que hacerla pasandloe un paramentro de tipo nodo
    private void ArrastrarNodo(Text text){
        
        //position pos = new position();
        
        //Solicitamos al usuario que haga click en el nodo
        //Cambia el cursor para determinar que esta siendo pulsado, realmente no es necesario es solo estetica
        text.addEventHandler(MouseEvent.MOUSE_ENTERED, event -> text.setCursor(Cursor.HAND)); 
        text.addEventHandler(MouseEvent.MOUSE_EXITED, event -> text.setCursor(Cursor.DEFAULT));
        
        //Arrastramos el nodo
        //Cambia el cursor para determinar que esta siendo arrastrado
        /*nodo.addEventHandler(MouseEvent.MOUSE_PRESSED, event -> {
            
                    nodo.setCursor(Cursor.MOVE);
                    
                    //se guardan las posiciones del nodo cuando ha sido pulsado
                    pos.x = event.getX();
                    pos.y = event.getY();
                    
                });
        */
        
        text.addEventHandler(MouseEvent.MOUSE_RELEASED, event -> text.setCursor(Cursor.DEFAULT));
        
        //Implementamos la funcion de arrastrar
        text.setOnMouseDragged(event -> {
            
            /*
            double distanciaX = event.getX() - pos.x;
            double distanciaY = event.getY() - pos.y;
            
            double x = nodo.getLayoutX() + distanciaX;
            double y = nodo.getLayoutY() + distanciaY;
            
            */
            double x = event.getX();
            double y = event.getY();
            
            if(x > 189 || y > 226 || x < 0 || y < 0){
                
                //nodo.relocate(nodo.getLayoutX(), nodo.getLayoutY());
                text.setX(text.getX());
                text.setY(text.getY());
            }
            
            else{
                
                 //recolocamos el nodo en su nueva posicion
                 //nodo.relocate(x, y);
                 text.setX(x);
                 text.setY(y);
                 System.out.println("x: " + x);
                 System.out.println("y: " + y);
                 
            }
           
            
        });
        
        
        
    }
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
