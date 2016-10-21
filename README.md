# easylayout 

A completely unorthodox but extremely productive API wrappers for Vaadin Layouts published at [Vaadin add-on directory](https://vaadin.com/directory#!addon/easylayout)

Currently, it only supports Horizontal and Vertical Layouts. Ideally, the unorthodoxy way of working may catch up in other layouts too :)

## Using the addon for Vertial and Horizontal layouts

You need to do this static import

```
import net.hdavid.easylayout.L.*;
```

After that you can construct (or configure) a vertical or horizontal layout using the `ve(Object ... componentsAndSettings)` and `ho(Object ... componentsAndSettings)` static methods respectivelly. Default config for the layout includes setSizeUndefined() and setSpacing(true)

To add components to the layout put them as arguments. To configure either the layout or the components you add to it,  add the static values explained below or floats (for expand rations) or regular css style strings to add styles to components.


This static values imported to configure the layout/components are these:

```
// The defaults applied to the layouts are:
layout.setMargin(false);
layout.setSpacing(true);
layout.setSizeUndefined();

_MARGIN      // setMargin(true)
_NO_SPACING  // setSpacing(false)
_FULL_SIZE   // setSizeFull()
_FULL_HEIGHT // setHeight("100%")
_FULL_WIDTH  // setWidth(100%)
_NOOP        // When you are configuring a component that `extends` a Layout. You don't want 
                to instantiate a new layout, instead you'll like to configure the created instance 
                (or in the constructor while being created) via `this`. If you want the first component
                to be part of the layout instead of configure that layout via this API, you provide
                this option.
_EXPAND      // this value sets the expandRation of the last component added to 1f
_EXPANDER    // this adds a component that grows to fill the entire available area for it (only 
                useful when your layout is not with its size undefined)
```

Simple example:

```
// lines ommited for brevity

import net.hdavid.easylayout.L.*;

TextField name = new TextField("Name");
TextField lastName = new TextField("Lastname");
Button save = new Button("Save");
Button cancel = new Button("Cancel");

VerticalLayout vertical = ve(name, lastName, ho(save, cancel)); // that is it!
```

A more complex full size view

```
Button newb = new Button("New");
Button modb = new Button("Modify");
Button delb = new Button("Delete");

Grid grid = new Grid(new BeanItemContainer<PersonDTO>(Arrays.asList(
        new PersonDTO("David Hofmann", new Date(1986, 07, 29), 30),
        new PersonDTO("Daniel Sanchez", new Date(), 20),
        new PersonDTO("Vaadin Is Awesome!", new Date(), 10)
)));
protected void init(VaadinRequest request) {

	// creating a vertical layout with full size and margin
    VerticalLayout vl = ve(_FULL_SIZE, _MARGIN,
    		// it's first component is a horizontal layout of full width
            ho(_FULL_WIDTH, 
            	    // the first horizontal layout component is an expander component
            	    _EXPANDER, 
            	    // the second one is the delete button and a css style is added to it
                    delb, ValoTheme.BUTTON_DANGER,
                    // third component is the modify button
                    modb,
                    // forth component is the new button with a css style added to it
                    newb, ValoTheme.BUTTON_PRIMARY),
            // second component of the vertical layout is the grid with its full size and expand ratio to 1f
            grid, _FULL_SIZE, _EXPAND);
    
    setContent(vl); // hard ?
}
```

Some rules apply to configure the layout.

As you can see, the API uses the configuration values in the layout itself if no other component is present yet. Otherwise, the configuration values are applied to the last component added as an argument.

Default alignment can be applied to all components of a layout if a value of `Alignment.*` is given as an argument of the `ve()` or `ho()` helpers before any component is added. After that, any value of `Alignment.*` is applied only to the last added component in the argument list.

A component can have with multiple settings. For example, you can make one component have the `ValoTheme.BUTTON_PRIMARY` style **and** have a particular alignment like `Alignment.TOP_MIDDLE`.

A layout can also have multiple settings. For example, `ve(_FULL_SIZE, "some-css", ...)`. With that the vertical layout will be of fullSize and have a css style added to it. For this to work you put the settings as arguments before any components.

CSS styles will be added to the last added component using String values.

Expand ratio of components is configured using float values after the component.

If you need to use the API in a programmatic way, instances of `Collection` will be translated by the API as if you added each component as an argument.


## FAQ

###Are you completely crazy and lost all your human traits and your faith in code hygiene and thought that Mars has no water in it?

Of course! It will take me more time to explain how much it helped me, though. But this "guide" will be updated if you don't get it yet :)

###This code is stupid! Are you aware of static evil and that your code is crappy and totally NOT OOP?

Yes!(see thanks section) For this particular case, it is safe, though, and you'll be okay using it "if" you like to write just little code for H/V Layouts.

###Are you serious?

No. 

###Pull requests?

If I could twist your mind enough to convince you then oh yeah! Please. Contributions are welcome!

## Thanks
- To [Matti Tahvonen](https://github.com/mstahv) for the [no-widgetset add-on archetype](https://github.com/viritin/archetype-vaadin-addon), although I am not sure he will be happy how I used his tool :)
- To the #Vaadin Team for such awesome framework
- To all those people doing crappy code for fixing my self-esteem.

