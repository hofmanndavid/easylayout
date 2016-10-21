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
public class EditTerritoryWindowUi extends UI {




    @Override
    protected void init(VaadinRequest request) {

        setContent(new Label("try to do this with regular api :D"));

        UI.getCurrent().addWindow(new MyEditWindow());

    }

    static class MyEditWindow extends Window {

        Button checkout = new Button("Checkout");
        Button viewContacts = new Button("View Contacts");
        Button download = new Button("Download");
        Button viewRecords = new Button("View Records");
        Button interested = new Button("Interested");
        Button delete = new Button("Delete");
        Button save = new Button("Save");
        TextArea textArea1 = new TextArea();
        TextArea textArea2 = new TextArea();
        OptionGroup type = new OptionGroup("", Arrays.asList("D2D", "Business", "Phone", "Letter"));
        TextField number = new TextField("");
        TextField description = new TextField("");

        MyEditWindow() {
            setModal(true);
            center();
            setCaption("Edit Territory");
            setWidth("70%");
            setHeight("80%");
//            setSizeFull();


            setContent(
                    ve(_NOOP, _FULL_SIZE, _MARGIN,
                        ho(_FULL_WIDTH, number, _FULL_WIDTH, 2f, description, _FULL_WIDTH, 8f),

                        type, ValoTheme.OPTIONGROUP_HORIZONTAL,

                        ho(_NOOP, _FULL_SIZE,
                                ve(_FULL_SIZE,
                                        textArea1,_FULL_SIZE, _EXPAND,
                                        textArea2, _FULL_SIZE, _EXPAND), 8f,
                                ve(_FULL_SIZE, //Alignment.MIDDLE_CENTER,
                                        checkout, _FULL_WIDTH, ValoTheme.BUTTON_FRIENDLY,
                                        viewContacts, _FULL_WIDTH,
                                        download, _FULL_WIDTH,
                                        viewRecords, _FULL_WIDTH,
                                        interested, _FULL_WIDTH), 2f
                        ), _EXPAND,
                        ho(_FULL_WIDTH,
                                save, _FULL_WIDTH, 8f, ValoTheme.BUTTON_PRIMARY,
                                delete, _FULL_WIDTH, 2f, ValoTheme.BUTTON_DANGER))
            );
        }
    }
}
