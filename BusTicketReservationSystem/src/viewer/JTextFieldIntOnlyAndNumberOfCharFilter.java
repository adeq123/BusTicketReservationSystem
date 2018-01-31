package viewer;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
/**
 * This class allows to filter the input to JTextField using .setDocument() (put object of this type as an argument) method. 
 * As a result it is only possible to write numbers and only of length given by the limit parameter
 * @author ADRO
 * @see JTextFieldIntOnlyFilter
 * @see JTextFieldCharLimit
 */
public class JTextFieldIntOnlyAndNumberOfCharFilter extends PlainDocument{
    String numbers="1234567890-";

 private int limit;
    
    public JTextFieldIntOnlyAndNumberOfCharFilter(int limit){
	this.limit = limit;
    }
    
    public void insertString(int offset, String str, AttributeSet set) throws BadLocationException{
	
	if(str == null || !numbers.contains(str)){
	    return;
	}else if((getLength() + str.length() <= limit)){
	    str = str.toUpperCase();
	    super.insertString(offset, str, set);
	}
    }
    

}
