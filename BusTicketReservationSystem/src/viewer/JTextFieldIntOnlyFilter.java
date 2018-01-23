package viewer;

import java.awt.Toolkit;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.text.PlainDocument;

public class JTextFieldIntOnlyFilter extends PlainDocument{
    
	    String numbers="1234567890-";
	    @Override
	    public void insertString(int offs, String str, AttributeSet a)
	            throws BadLocationException {
	        if(!numbers.contains(str));
	        else    super.insertString(offs, str, a);
	    }

}
