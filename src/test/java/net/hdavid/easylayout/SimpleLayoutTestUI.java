package net.hdavid.easylayout;

import com.vaadin.annotations.Theme;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;

import java.util.Arrays;
import java.util.Date;

import static net.hdavid.easylayout.L.*;

@Theme("valo")
public class SimpleLayoutTestUI extends UI {

    Button newb = new Button("New");
    Button modb = new Button("Modify");
    Button delb = new Button("Delete");

    Grid grid = new Grid(new BeanItemContainer<PersonDTO>(Arrays.asList(
            new PersonDTO("David Hofmann", new Date(1986, 07, 29), 30),
            new PersonDTO("Daniel Sanchez", new Date(), 20),
            new PersonDTO("Vaadin Is Awesome!", new Date(), 10)
    )));

    @Override
    protected void init(VaadinRequest request) {

        VerticalLayout vl = ve(_FULL_SIZE, _MARGIN,
                ho(_FULL_WIDTH, _EXPANDER,
                        delb, ValoTheme.BUTTON_DANGER,
                        modb,
                        newb, ValoTheme.BUTTON_PRIMARY),
                grid, _FULL_SIZE, _EXPAND);

        setContent(vl);
    }
}
