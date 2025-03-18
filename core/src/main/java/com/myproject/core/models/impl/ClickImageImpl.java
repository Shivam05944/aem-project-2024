package com.myproject.core.models.impl;

import com.myproject.core.models.ClickImage;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import java.util.List;

@Model(adaptables = {SlingHttpServletRequest.class}, adapters = {ClickImage.class}, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)

public class ClickImageImpl implements ClickImage {
    @ChildResource
    public List<MultiPath> forms;

    @Override
    public List<MultiPath> getForm() {
        return forms;
    }

}
