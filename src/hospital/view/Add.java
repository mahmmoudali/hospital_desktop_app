/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital.view;

import hospital.controller.UserControl;
import hospital.model.User;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.w3c.dom.events.Event;

/**
 *
 * @author Mahmo
 */
public class Add extends Application {

    static User use = new User();
    UserControl us = new UserControl();

    int tempId;

    @Override
    public void start(Stage primaryStage) {

        // Add x = new Add();
        final TableView<User> table = new TableView();

        TableColumn<User, Integer> columnID = new TableColumn<>("ID");
        TableColumn<User, String> columnFname = new TableColumn<>("Fname");
        TableColumn<User, String> columnLname = new TableColumn<>("Lname");
        TableColumn<User, Integer> columnAge = new TableColumn<>("Age");

        columnID.setCellValueFactory(new PropertyValueFactory<User, Integer>("id"));
        columnFname.setCellValueFactory(new PropertyValueFactory<User, String>("fname"));
        columnLname.setCellValueFactory(new PropertyValueFactory<User, String>("lname"));
        columnAge.setCellValueFactory(new PropertyValueFactory<User, Integer>("age"));

        table.getColumns().addAll(columnID, columnFname, columnLname, columnAge);

        table.setItems(us.getData());

        final UserControl control = new UserControl();

        

        final TextField t_Fname = new TextField();
        t_Fname.setPromptText("Input First_name");
        final TextField t_Lname = new TextField();
        t_Lname.setPromptText("Input Last_name");
        final TextField t_mail = new TextField();
        t_mail.setPromptText("Input E-mail");
        final TextField t_phone = new TextField();
        t_phone.setPromptText("Input Phone Number");
        final TextField t_age = new TextField();
        t_age.setPromptText("Input Age");
        final TextField t_jop = new TextField();
        t_jop.setPromptText("Input Jop");
        final TextField t_relation = new TextField();
        t_relation.setPromptText("Input Relationship Status");

        Button b_add = new Button("Add");
        b_add.setId("button");
        Button b_update = new Button("Update");
        b_update.setId("button");
        Button b_delete = new Button("Delete");
        b_delete.setId("button");
        Button b_search = new Button("Search");
        b_search.setId("button");
        Button b_show = new Button("Show list");
        b_show.setId("back");
        Button b_reset = new Button("Reset");
        b_reset.setId("reset");
        

        VBox labels = new VBox(11);

        
        VBox TextFields = new VBox(10);
        TextFields.setPrefWidth(220);
        Label add = new Label("Add");
        add.setAlignment(Pos.CENTER);
        add.setId("add");
        TextFields.getChildren().add(add);
        TextFields.getChildren().add(t_Fname);
        TextFields.getChildren().add(t_Lname);
        
        TextFields.getChildren().add(t_age);
        
        TextFields.getChildren().add(b_add);
        TextFields.getChildren().add(b_update);
        TextFields.getChildren().add(b_delete);
        TextFields.getChildren().add(b_reset);
        
        HBox hb = new HBox(6);
        hb.getChildren().addAll(b_add, b_update, b_delete,b_reset);
        TextFields.getChildren().add(hb);
        TextFields.getChildren().add(b_show);
       
        HBox main = new HBox(10);
        HBox search_bar = new HBox(7);
        Button search = new Button("Search");
        search.setId("search");
        final TextField search_key = new TextField();
        search_key.setPromptText("Enter the search");
        t_jop.setPromptText("Input name to Search On");
        search_bar.setAlignment(Pos.CENTER);
        
        search_bar.getChildren().addAll(search_key, search);

        VBox right_pane = new VBox(10);
        right_pane.getChildren().addAll(search_bar, table);
        

        main.setId("main");
        labels.setAlignment(Pos.CENTER);

        main.setAlignment(Pos.CENTER);

        main.getChildren().addAll(TextFields, right_pane);

        main.setPadding(new Insets(15));

        
        Scene scene = new Scene(main, 500, 350);

        primaryStage.setTitle("Hello Ali_programmer!");
        primaryStage.setScene(scene);
        scene.getStylesheets().add(Add.class.getResource("style.css").toExternalForm());
        primaryStage.show();

        b_add.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent t) {
                User us = new User();
                us.setFname(t_Fname.getText());
                us.setLname(t_Lname.getText());
                us.setAge(Integer.parseInt(t_age.getText()));

                control.insert(us);
                
                t_Fname.setText("");
                t_Lname.setText("");
                t_age.setText("");

            }

        });
        b_show.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent t) {
               
                table.setItems(control.getData());
                
            }

        });
        b_reset.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent t) {
               User user = table.getSelectionModel().getSelectedItem();
                t_Fname.setText("");
                t_Lname.setText("");
                t_age.setText("");
                
            }

        });
        
        b_delete.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent t) {
                us.Delete(tempId);
                table.setItems(us.getData());

            }

        });
        search.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent t) {

                table.setItems(us.search(search_key.getText()));

            }

        });

        table.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent t) {
                User user = table.getSelectionModel().getSelectedItem();

                tempId = user.getId();
                t_Fname.setText(user.getFname());
                t_Lname.setText(user.getLname());
                t_age.setText(user.getAge() + "");

            }

        });

        b_update.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent t) {
                use.setId(tempId);
                use.setFname(t_Fname.getText());
                use.setLname(t_Lname.getText());
                use.setAge(Integer.parseInt(t_age.getText()));

                us.Update(use);
                table.setItems(us.getData());

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
