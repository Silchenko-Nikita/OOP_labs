package lab5.texteditor;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TextEditor extends JFrame {
    ActionDirector actionDirector = new ActionDirector();
    private JTextArea textArea = new JTextArea(20, 60);
    private JFileChooser dialog = new JFileChooser(System.getProperty("user.dir"));
    private JMenuBar menuBar = new JMenuBar();
    final private String defaultCurrentFile = "Untitled";
    private String currentFile = defaultCurrentFile;
    private String currentFileLogFile = ".currentFile";


    AbstractAction New = new AbstractAction("New") {
        public void actionPerformed(ActionEvent e) {
            textArea.setText("");
            setCurrentFile(defaultCurrentFile);
            actionDirector.clearLog();
        }
    };

    AbstractAction Open = new AbstractAction("Open") {
        public void actionPerformed(ActionEvent e) {
            openFile();
            actionDirector.clearLog();
        }
    };

    AbstractAction Save = new AbstractAction("Save") {
        public void actionPerformed(ActionEvent e) {
            if(!currentFile.equals(defaultCurrentFile))
                saveFile(currentFile);
            else
                saveFileAs();
            actionDirector.clearLog();
        }
    };

    AbstractAction SaveAs = new AbstractAction("Save as...") {
        public void actionPerformed(ActionEvent e) {
            saveFileAs();
            actionDirector.clearLog();
        }
    };

    private void saveFileAs() {
        if(dialog.showSaveDialog(null)==JFileChooser.APPROVE_OPTION)
            saveFile(dialog.getSelectedFile().getAbsolutePath());
    }

    private void readFromFile(String fileName) {
        try {
            FileReader r = new FileReader(fileName);
            textArea.read(r,null);
            r.close();
            setCurrentFile(fileName);
        }
        catch(IOException e) {
            Toolkit.getDefaultToolkit().beep();
        }
    }

    private void saveFile(String fileName) {
        try {
            FileWriter w = new FileWriter(fileName);
            textArea.write(w);
            w.close();
            setCurrentFile(fileName);
        }
        catch(IOException e) {
        }
    }

    private void setCurrentFile(String fileName){
        currentFile = fileName;
        setTitle(currentFile);
        try {
            FileWriter w = new FileWriter(currentFileLogFile);
            w.write(currentFile);
            w.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void openFile(){
        if(dialog.showOpenDialog(null)==JFileChooser.APPROVE_OPTION) {
            readFromFile(dialog.getSelectedFile().getAbsolutePath());
        }
    }

    private void openFromCurrentFileLog(){
        try {
            currentFile = new String(Files.readAllBytes(Paths.get(currentFileLogFile)));
            setTitle(currentFile);
            String text = new String(Files.readAllBytes(Paths.get(currentFile)));
            textArea.setText(actionDirector.recover(text));
        } catch (IOException e) {}
    }

    public TextEditor() {
        super("Simple Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(400, 200);

        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);

        JScrollPane scroll = new JScrollPane(textArea,
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        add(scroll, BorderLayout.CENTER);

        menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		JMenu file = new JMenu("File");
        menuBar.add(file);

//        JToolBar tool = new JToolBar();
//        add(tool,BorderLayout.NORTH);
//        tool.add(SaveAs);tool.add(Open);tool.add(Save);
//        tool.addSeparator();

        file.add(New);
        file.add(Open);
        file.add(Save);
        file.add(SaveAs);

        ActionLogger logger = new ActionLogger();
        actionDirector.setLogger(logger);

        openFromCurrentFileLog();

        textArea.getDocument().addDocumentListener(new TextAreaDocumentListener());
        setResizable(false);
        pack();
    }

    class TextAreaDocumentListener implements DocumentListener{

        @Override
        public void insertUpdate(DocumentEvent documentEvent) {
            Document doc = documentEvent.getDocument();
            try {
                int offset = documentEvent.getOffset();
                int length = documentEvent.getLength();
                String text = doc.getText(offset, length);

                actionDirector.insert(offset, text);
            } catch (BadLocationException e) {
                e.printStackTrace();
            }

        }

        @Override
        public void removeUpdate(DocumentEvent documentEvent) {
            int offset = documentEvent.getOffset();
            int length = documentEvent.getLength();

            actionDirector.remove(offset, length);
        }

        @Override
        public void changedUpdate(DocumentEvent documentEvent) {

        }
    }
}
