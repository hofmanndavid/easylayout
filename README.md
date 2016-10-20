# easylayout 

A completely unorthodox but extremely productive API wrappers for Vaadin Layouts published at [Vaadin add-on directory](https://vaadin.com/directory#!addon/easylayout)

Currently it only supports Horizontal and Vertical Layouts. Idealy the unhortodox-y way of working may catch up in other layouts too :)

## Using the addon for Vertial and Horizontal layouts

You need to do static import

```
import net.hdavid.easylayout.L.*;
```

After that you can construct (or configure) a vertical or horizontal layout using the `ve(Object ... componentsAndSettings)` and `ho(Object ... componentsAndSettings)` static methods respectivelly. 

To add components to the layout, simply put the components as arguments. To configure either the layout or the components you add to it just add the static values explained below or floats (for expand rations) or regular css style strings to add styles to components.

This static values imported to configure the layout/components are the next

```
_MARGIN      // by default layout.setMargin(false), this value configures the layout to have margin
_NO_SPACING  // by default layout.setSpacing(true), this value configures the layout to use no spacing
_FULL_SIZE   // by default layout.setSizeUndefined(), This value sets the layout to have full size
_FULL_HEIGHT // by default layout.setSizeUndefined(), This value sets the layout to have full height
_FULL_WIDTH  // by default layout.setSizeUndefined(), This value sets the layout to have full width
_NOOP        // If you are configuring a component that `extends` a Layout then you don't want 
                to instantiate a new layout, instead you'll like to configure the created instance 
                (or in the constructor while being created) via `this`. If you want the first component
                to be part of the layout you are configuring and not allow the API to asume you want to
                configure the provided layout you add the _NOOP option. 
_EXPAND      // by adding this value after a component argument, it sets its expand ratio to 1f
_EXPANDER    // by adding this value it adds a css layout component that contains a css property to
                expand itself to fill the entire available area to it (only useful when your layout is
                not with its size undefined)
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

Some rules apply for the configuration of the layout.

As you can see, the layout uses the configuration values in itself if no other component has been added yet, otherwise the configuration values are applied to last component added as argument.

Default alignment can be aplied to all components of a layout if a value of `Alignment.*` is given as an argument of the `ve()` or `ho()` helpers before any component is added. After that, any value of `Alignment.*` is applied only to the last added component in the argument list.

Multiple settings can be applied to a component added. For example you can make one component have the `ValoTheme.BUTTON_PRIMARY` style **and** have a specific alignment like `Alignment.TOP_MIDDLE`.

Multiple settings can also be applied to the layout before any component is added to it. For example, `ve(_FULL_SIZE, "some-css", ...)`. This makes the vertical layout be of full size and have a css style added to it before you add any components as arguments.

Any String (for now) will be interpretted as CSS styles that have to be added either to the layout or the last added component of the layout.

Any Float value will be interpreted as the expand ratio that a component must have inside a Layout. Hence, this value can only be added after component arguments and not before any components are added to the layout.

If you need to use the api in a programatic way instances of `Collection` will be translated internally as if you added each component as an argument.


## FAQ

####1. Are you completely crazy and lost all your humane traits and your faith in code higiene and think that mars really has no watter in it?

Of course! It will take me more time to explain how much it helped me though. But this "guide" will be updated if you don't get it yet :)

####2. This is stupid! Are you aware of static evil and that your code is crap and totally NOT OOP?

Yes! For this particular case it is safe though, and you'll be fine using it "if" you like to have really short code for H/V Layouts.

####3. Are you serious?

No. 

####4. Pull requests?

I could twist your mind enough and you got convinced then hell yeah! Please. Contributions are welcome!

## Thanks

- To [Matti Tahvonen](https://github.com/mstahv) for the [no-widgetset add-on archetype](https://github.com/viritin/archetype-vaadin-addon), although I am not sure he will be happy how I used his tool :)
- To the #Vaadin Team for such awesome framework
- To all those people doing crap code for fixing my self-steem.



