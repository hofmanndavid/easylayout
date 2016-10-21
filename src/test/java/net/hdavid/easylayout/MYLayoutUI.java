package net.hdavid.easylayout;

import com.vaadin.annotations.Theme;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.*;

import java.util.Arrays;
import java.util.Date;

import static net.hdavid.easylayout.L.*;

@Theme("valo")
public class MYLayoutUI extends UI {

    static class MyLayout extends VerticalLayout {

        TextField search = new TextField("Search");
        Grid grid = new Grid(new BeanItemContainer<PersonDTO>(Arrays.asList(
                new PersonDTO("David Hofmann", new Date(1986, 07, 29), 30),
                new PersonDTO("Vaadin Is Awesome!", new Date(), 10)
        )));

        public MyLayout () {
            ve(this, _MARGIN, _FULL_SIZE,
                    search, Alignment.TOP_LEFT,
                    grid, _FULL_SIZE, _EXPAND);
        }
    }

    @Override
    protected void init(VaadinRequest request) {
        setContent(new MyLayout());
    }
}
