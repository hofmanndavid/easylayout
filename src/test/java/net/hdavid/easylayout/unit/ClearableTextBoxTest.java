package net.hdavid.easylayout.unit;

import org.junit.Test;
import net.hdavid.easylayout.ClearableTextBox;
import static org.junit.Assert.*;

public class ClearableTextBoxTest {

    @Test
    public void testGetTextField() {
        ClearableTextBox tb = new ClearableTextBox();
        assertNotNull(tb.getTextField());
        
        tb.getTextField().setValue("foo");
        assertEquals("foo", tb.getTextField().getValue());
    }
    
}
