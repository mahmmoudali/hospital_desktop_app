
package hospital.view;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javax.jws.soap.SOAPBinding.Style;
import javax.swing.JOptionPane;


public class Hospital extends Application {
    
    @Override
    public void start(final Stage primaryStage) {
        GridPane main=new GridPane();
        main.setId("main");
        GridPane st_layer=new GridPane();
        GridPane nd_layer=new GridPane();
        
        
        
        Button btn = new Button("LOGIN");
        btn.setId("log");
        Label l_name=new Label("User Name");
        l_name.setId("name");
        Label l_pass=new Label("Password");
        l_pass.setId("pass");
        final Label action_message=new Label();
        action_message.setId("message");
        
        final TextField t_name=new TextField();
        t_name.setPromptText("Input User_name");
        final PasswordField t_pass=new PasswordField();
        t_pass.setPromptText("Input Password");
        
        
        
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            
            @Override
            public void handle(ActionEvent event) {
                try {
                    if(t_name.getText().equalsIgnoreCase("Ali") && t_pass.getText().equalsIgnoreCase("12345"))
                    { action_message.setText("Hello Ali");
                     Add o=new Add();
                    o.start(primaryStage);
                    }
                    else
                        action_message.setText("Wrong Password !");
                } catch (Exception ex) {
                    Logger.getLogger(Hospital.class.getName()).log(Level.SEVERE, null, ex);
                }
                

            }
        });
        
        st_layer.add(l_name,0,0);
        st_layer.add(l_pass,0,1);
        st_layer.add(t_name,1,0);
        st_layer.add(t_pass,1,1);
        st_layer.setAlignment(Pos.CENTER);
        st_layer.setHgap(10);
        st_layer.setVgap(5);
        
        
        nd_layer.add(btn, 0,0);
        nd_layer.add(action_message, 0,3);
        
        nd_layer.setHgap(10);
        nd_layer.setVgap(5);
        
       nd_layer.setAlignment(Pos.CENTER);
       main.setHgap(10);
        main.setVgap(5);
        main.setAlignment(Pos.CENTER);
        
        main.add(st_layer, 0, 0);
        main.add(nd_layer, 0, 1);
        
        
        Scene scene = new Scene(main, 500, 500);
        
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        scene.getStylesheets().add(Hospital.class.getResource("style.css").toExternalForm());
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
       // Frame2 o=new Frame2();
        
        
                
    }
    
}
