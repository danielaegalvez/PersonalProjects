package com.example.tictactoegame;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;


public class TicTacToeController {


    @FXML
    private Label playerXText;
    @FXML
    private GridPane buttonpane;
    private boolean playerX = true;
    private String currentPlayer;
    private boolean winner;

    private String getTextAtNode(int row, int col) {
        for (Node node: buttonpane.getChildren()){
            //we have to get all nodes(all indexes)
            Integer r = GridPane.getRowIndex(node);
            Integer c = GridPane.getColumnIndex(node);

            //JavaFx makes node 0 = null so have to check for that
            int rowIndex = (r == null) ? 0 : r;
            int colIndex = (c == null) ? 0 : c;

            if (rowIndex == row && colIndex == col && node instanceof Button){
                String text = ((Button) node).getText();
                System.out.println(text);
                return ((Button) node).getText();
            }
        }
        return "";
    }

    private boolean checkStrings(String s1, String s2, String s3) {
        if (s1.isEmpty() || s2.isEmpty() || s3.isEmpty()) {
            return false;
        }
        return s1.equals(s2) && s2.equals(s3);
    }

   private boolean checkForWinner() {
        //check rows
        for(int i = 0; i < 3; i++){
            if(checkStrings(getTextAtNode(i, 0 ), getTextAtNode(i, 1), getTextAtNode(i, 2))){
                return true;
            }
        }

        //check column
        for(int i = 0; i < 3; i++){
            if(checkStrings(getTextAtNode(0, i), getTextAtNode(1, i), getTextAtNode(2, i))){
                return true;
            }
        }

        //check diagonal
       if(checkStrings(getTextAtNode(0, 0), getTextAtNode(1, 1), getTextAtNode(2, 2))){
           return true;
       }
       if(checkStrings(getTextAtNode(0, 2), getTextAtNode(1, 1), getTextAtNode(2, 0))){
           return true;
       }

        return false;
   }

    @FXML
    protected void onButtonXClicked(ActionEvent event) {
        Object source = event.getSource();
        if (source instanceof Button sourceButton) {
            if(!sourceButton.getText().isEmpty()){
                return;
            }
            currentPlayer = playerX ? "X" : "O";
            sourceButton.setText(currentPlayer);

            winner = checkForWinner();
            if(winner){
                playerXText.setText("Player " + currentPlayer + " wins!");
                buttonpane.setDisable(true);
            }
            else {
                playerX = !playerX;
                String nextPlayer = playerX ? "X" : "O";
                playerXText.setText("Player " + nextPlayer + "'s turn!");
            }
        }

    }
}
