package ConvertNumbers;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class JInputFieldContainer extends Container {

    JLabel label;
    TextField textField;

    JInputFieldContainer( String inputName ) {
        this.setLayout( new BoxLayout( this, BoxLayout.X_AXIS ) );

        label = new JLabel(inputName );
        textField = new TextField();
        
        this.add( label );
        this.add( textField );
    }
}

class JNumberConverterGUI extends Frame {

    private JInputFieldContainer decimalTextArea;
    private JInputFieldContainer hexTextArea;
    private JInputFieldContainer binaryTextArea;

    JNumberConverterGUI() {
        this.InitJFrame();
        this.InitTextArea();
    }

    private void InitJFrame() {
        this.setSize(250, 150);
        this.setVisible( true );
        this.setLayout( new BoxLayout( this, BoxLayout.Y_AXIS ) );
        this.setTitle("Convert Numbers");

    }

    private void InitTextArea() {

        decimalTextArea = new JInputFieldContainer("Decimal: ");
        hexTextArea = new JInputFieldContainer("Hex: ");
        binaryTextArea = new JInputFieldContainer("Binary: ");

        this.add( decimalTextArea );
        this.add( hexTextArea );
        this.add( binaryTextArea );



        decimalTextArea.textField.addKeyListener( new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {}
            @Override
            public void keyPressed(KeyEvent e) {};

            @Override
            public void keyReleased(KeyEvent e) {
                if ( e.getKeyCode() == KeyEvent.VK_ENTER ) {
                    
                    String inputDecimal = decimalTextArea.textField.getText();
                    
                    try {
                        int inputInInt = Integer.parseInt( inputDecimal );
                        hexTextArea.textField.setText( String.format( "0x%s", Integer.toHexString( inputInInt ).toUpperCase() ));
                        binaryTextArea.textField.setText( Integer.toBinaryString( inputInInt ));
                    } catch (NumberFormatException err) {
                       System.err.println(err);
                    }
                }
            }
        });
   
    }

}

public class Main {
    public static void main(String[] args) {
        JNumberConverterGUI gui = new JNumberConverterGUI();
    }
}
