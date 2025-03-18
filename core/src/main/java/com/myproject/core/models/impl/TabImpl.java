package com.myproject.core.models.impl;

import com.myproject.core.models.Tab;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import java.util.List;
@Model(adaptables = {Resource.class},
        adapters = {Tab.class},
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class TabImpl implements Tab {
    @ChildResource
    public List<MultiTab> forms;

    @ValueMapValue
    public String heading;

    @Override
    public List<MultiTab> getForm() {
        return forms;
    }

    @Override
    public String getHeading() {
        return heading;
    }
}
