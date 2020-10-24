<?xml version="1.0" encoding="UTF-8"?>

<?import javafx.scene.Cursor?>
<?import javafx.scene.control.Button?>
<?import javafx.scene.control.Label?>
<?import javafx.scene.control.TextArea?>
<?import javafx.scene.control.ToggleButton?>
<?import javafx.scene.image.Image?>
<?import javafx.scene.image.ImageView?>
<?import javafx.scene.layout.AnchorPane?>
<?import javafx.scene.shape.Line?>
<?import javafx.scene.text.Font?>

<AnchorPane id="root" fx:id="status_container" maxHeight="-Infinity" maxWidth="-Infinity" minHeight="-Infinity" minWidth="-Infinity" prefHeight="470.0" prefWidth="464.0" xmlns="http://javafx.com/javafx/11.0.1" xmlns:fx="http://javafx.com/fxml/1" fx:controller="Application.Controller">
   <children>
      <TextArea fx:id="res" editable="false" layoutX="21.0" layoutY="60.0" prefHeight="40.0" prefWidth="427.0" styleClass="t_area">
         <cursor>
            <Cursor fx:constant="TEXT" />
         </cursor>
         <font>
            <Font size="16.0" />
         </font>
      </TextArea>
      <TextArea fx:id="in" layoutX="21.0" layoutY="125.0" onKeyPressed="#enterd" prefHeight="56.0" prefWidth="368.0" styleClass="t_area">
         <cursor>
            <Cursor fx:constant="TEXT" />
         </cursor>
         <font>
            <Font size="16.0" />
         </font>
      </TextArea>
      <AnchorPane id="container_2" layoutY="195.0" prefHeight="277.0" prefWidth="464.0">
         <children>
            <Button fx:id="b1" layoutX="18.0" layoutY="133.0" mnemonicParsing="false" onAction="#clicked" prefHeight="49.0" prefWidth="61.0" styleClass="num_btn" text="1">
               <font>
                  <Font size="19.0" />
               </font>
            </Button>
            <Button fx:id="b2" layoutX="87.0" layoutY="133.0" mnemonicParsing="false" onAction="#clicked" prefHeight="49.0" prefWidth="61.0" styleClass="num_btn" text="2">
               <font>
                  <Font size="19.0" />
               </font>
            </Button>
            <Button fx:id="b3" layoutX="156.0" layoutY="133.0" mnemonicParsing="false" onAction="#clicked" prefHeight="49.0" prefWidth="61.0" styleClass="num_btn" text="3">
               <font>
                  <Font size="19.0" />
               </font>
            </Button>
            <Button fx:id="b4" layoutX="18.0" layoutY="76.0" mnemonicParsing="false" onAction="#clicked" prefHeight="49.0" prefWidth="61.0" styleClass="num_btn" text="4">
               <font>
                  <Font size="19.0" />
               </font>
            </Button>
            <Button fx:id="b5" layoutX="87.0" layoutY="76.0" mnemonicParsing="false" onAction="#clicked" prefHeight="49.0" prefWidth="61.0" styleClass="num_btn" text="5">
               <font>
                  <Font size="19.0" />
               </font>
            </Button>
            <Button fx:id="b6" layoutX="156.0" layoutY="76.0" mnemonicParsing="false" onAction="#clicked" prefHeight="49.0" prefWidth="61.0" styleClass="num_btn" text="6">
               <font>
                  <Font size="19.0" />
               </font>
            </Button>
            <Button fx:id="b7" layoutX="18.0" layoutY="19.0" mnemonicParsing="false" onAction="#clicked" prefHeight="49.0" prefWidth="61.0" styleClass="num_btn" text="7">
               <font>
                  <Font size="19.0" />
               </font>
            </Button>
            <Button fx:id="b8" layoutX="87.0" layoutY="19.0" mnemonicParsing="false" onAction="#clicked" prefHeight="49.0" prefWidth="61.0" styleClass="num_btn" text="8">
               <font>
                  <Font size="19.0" />
               </font>
            </Button>
            <Button fx:id="b9" layoutX="156.0" layoutY="19.0" mnemonicParsing="false" onAction="#clicked" prefHeight="49.0" prefWidth="61.0" styleClass="num_btn" text="9">
               <font>
                  <Font size="19.0" />
               </font>
            </Button>
            <Button fx:id="b0" layoutX="87.0" layoutY="192.0" mnemonicParsing="false" onAction="#clicked" prefHeight="49.0" prefWidth="61.0" styleClass="num_btn" text="0">
               <font>
                  <Font size="19.0" />
               </font>
            </Button>
            <Button fx:id="dot" layoutX="156.0" layoutY="192.0" mnemonicParsing="false" onAction="#clicked" prefHeight="49.0" prefWidth="61.0" styleClass="num_btn" text=".">
               <font>
                  <Font size="22.0" />
               </font>
            </Button>
            <Button fx:id="raise" layoutX="382.0" layoutY="76.0" mnemonicParsing="false" onAction="#clicked" prefHeight="49.0" prefWidth="61.0" styleClass="num_btn" text="^">
               <font>
                  <Font size="19.0" />
               </font>
            </Button>
            <Button fx:id="pi" layoutX="243.0" layoutY="132.0" mnemonicParsing="false" onAction="#PI" prefHeight="49.0" prefWidth="61.0" styleClass="num_btn" text="𝜋 ">
               <font>
                  <Font size="19.0" />
               </font>
            </Button>
            <Button fx:id="opar" layoutX="243.0" layoutY="20.0" mnemonicParsing="false" onAction="#clicked" prefHeight="49.0" prefWidth="61.0" styleClass="num_btn" text="(">
               <font>
                  <Font size="19.0" />
               </font>
            </Button>
            <Button fx:id="clpar" layoutX="243.0" layoutY="76.0" mnemonicParsing="false" onAction="#clicked" prefHeight="49.0" prefWidth="61.0" styleClass="num_btn" text=")">
               <font>
                  <Font size="19.0" />
               </font>
            </Button>
            <Button fx:id="add" layoutX="313.0" layoutY="19.0" mnemonicParsing="false" onAction="#clicked" prefHeight="49.0" prefWidth="61.0" styleClass="num_btn" text="+">
               <font>
                  <Font size="19.0" />
               </font>
            </Button>
            <Button fx:id="sub" layoutX="383.0" layoutY="19.0" mnemonicParsing="false" onAction="#clicked" prefHeight="49.0" prefWidth="61.0" styleClass="num_btn" text="-">
               <font>
                  <Font size="19.0" />
               </font>
            </Button>
            <Button fx:id="div" layoutX="313.0" layoutY="76.0" mnemonicParsing="false" onAction="#clicked" prefHeight="49.0" prefWidth="61.0" styleClass="num_btn" text="/">
               <font>
                  <Font size="19.0" />
               </font>
            </Button>
            <Button fx:id="eq" layoutX="238.0" layoutY="192.0" mnemonicParsing="false" onAction="#clicked" prefHeight="49.0" prefWidth="141.0" styleClass="num_btn" text="=">
               <font>
                  <Font size="19.0" />
               </font>
            </Button>
            <Button fx:id="ce" layoutX="382.0" layoutY="132.0" mnemonicParsing="false" onAction="#CE" prefHeight="49.0" prefWidth="61.0" styleClass="num_btn" text="CE">
               <font>
                  <Font size="19.0" />
               </font>
            </Button>
            <Button fx:id="mult" layoutX="313.0" layoutY="132.0" mnemonicParsing="false" onAction="#clicked" prefHeight="49.0" prefWidth="61.0" style="" styleClass="num_btn" text="*">
               <font>
                  <Font size="19.0" />
               </font>
            </Button>
            <ImageView fx:id="catPane" fitHeight="82.0" fitWidth="82.0" layoutX="4.0" layoutY="186.0" pickOnBounds="true" preserveRatio="true">
               <image>
                  <Image url="@images/cat_heart.gif" />
               </image>
            </ImageView>
            <ImageView fx:id="catPane2" fitHeight="86.0" fitWidth="82.0" layoutX="381.0" layoutY="184.0" pickOnBounds="true" preserveRatio="true">
               <image>
                  <Image url="@images/cat_roling.gif" />
               </image>
            </ImageView>
         </children></AnchorPane>
      <Button id="del_btn" fx:id="del" layoutX="397.0" layoutY="128.0" mnemonicParsing="false" onAction="#delBtn" prefHeight="40.0" prefWidth="51.0" styleClass="num_btn" text="X" />
      <Label id="history_lbl" layoutX="21.0" layoutY="18.0" text="History" />
      <ToggleButton id="theme_btn" fx:id="toggle_btn" layoutX="373.0" layoutY="7.0" mnemonicParsing="false" onAction="#changeStyle" prefHeight="26.0" prefWidth="82.0" styleClass="num_btn" text="Light" />
      <Line endX="249.0" layoutX="131.0" layoutY="163.0" startX="-100.0" styleClass="line" />
      <Line endX="249.0" layoutX="131.0" layoutY="110.0" startX="-100.0" styleClass="line" />
      <ImageView fx:id="catPane1" fitHeight="173.0" fitWidth="141.0" layoutX="172.0" layoutY="-10.0" pickOnBounds="true" preserveRatio="true">
         <image>
            <Image url="@images/car_run_circle.gif" />
         </image>
      </ImageView>
   </children>
</AnchorPane>
