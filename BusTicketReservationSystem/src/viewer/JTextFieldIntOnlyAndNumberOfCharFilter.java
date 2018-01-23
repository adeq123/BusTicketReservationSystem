package viewer;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

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
