package com.myproject.core.models.impl;

import com.myproject.core.models.Compartment;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import java.util.List;

@Model(adaptables = {Resource.class},
        adapters = {Compartment.class},
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class CompartmentImpl implements Compartment {
    @ChildResource
    public List<MultiCompartment> forms;
    @ValueMapValue
    public String heading;

    @ValueMapValue
    public String subHeading;

    @ValueMapValue
    public String button;

    @ValueMapValue
    public String buttonLabel;

    @Override
    public String getHeading() {
        return heading;
    }

    @Override
    public String getSubHeading() {
        return subHeading;
    }

    @Override
    public String getButton() {
        return button;
    }

    @Override
    public String getButtonLabel() {
        return buttonLabel;
    }

    @Override
    public List<MultiCompartment> getForm() {
        return forms;
    }
}
