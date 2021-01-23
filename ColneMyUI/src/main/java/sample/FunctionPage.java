package sample;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;

import fr.opensagres.poi.xwpf.converter.pdf.PdfConverter;
import fr.opensagres.poi.xwpf.converter.pdf.PdfOptions;
import org.apache.poi.xwpf.usermodel.XWPFDocument;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;



public class FunctionPage implements Initializable {


    @FXML
    BorderPane funcPane;

    @FXML
    TextField pdfPathTF;

    File Files;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }


    public void gotoDevInfoPage()throws IOException {
        BorderPane pane = FXMLLoader.load(getClass().getResource("/fxml/DeveloperINFO.fxml"));
        funcPane.getChildren().setAll(pane);

    }
    public void gotoHomePage()throws IOException {
        BorderPane pane = FXMLLoader.load(getClass().getResource("/fxml/home.fxml"));
        funcPane.getChildren().setAll(pane);

    }




    private File fs; //data members
    private File pf; //data members

    public void selectFiles(){

        FileChooser fileChooser = new FileChooser();

        fileChooser.setTitle("Please select your files..");

        Files = fileChooser.showOpenDialog(funcPane.getScene().getWindow());

        fs = new File(Files.getAbsolutePath());
        System.out.println(fs);

        if( Files == null){

            System.out.println("Files not selected");
        }
/*
        for( File f : Files ){

            System.out.println(f.getAbsolutePath());

        }
*/
    }

    public void choosePDFPath(){

        //select the file path
        //show the file path in TextField
        FileChooser pdfChooser = new FileChooser();
        pdfChooser.setTitle("Select PDF file name and destination to save to..");
        File pdfFile = pdfChooser.showSaveDialog(funcPane.getScene().getWindow());

        pf = pdfFile;
        System.out.println(pf);

        if(pdfFile == null){
            System.out.println("PDF file not chosen");
            return;
        }

        pdfPathTF.setText(pdfFile.getAbsolutePath());

    }

    public void convertToPDF(){



        try{
            FileInputStream docFile = new FileInputStream(new File(String.valueOf(fs)));
            System.out.println("File Selected:" +fs);
            XWPFDocument doc = new XWPFDocument(docFile);

            PdfOptions pdfOptions = PdfOptions.create();
            OutputStream out = new FileOutputStream(new File(String.valueOf(pf)));
            System.out.println("File saved:" + pf);
            PdfConverter.getInstance().convert(doc,out,pdfOptions);
            doc.close();
            out.close();
            System.out.println("Code Successful!!");

        }catch (Exception e){
            System.out.println("ERROR");
            e.printStackTrace();
        }

    }
}
