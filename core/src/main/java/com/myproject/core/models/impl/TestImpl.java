package com.myproject.core.models.impl;

import com.myproject.core.models.Box;
import com.myproject.core.models.Test;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.Self;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = {SlingHttpServletRequest.class}, adapters = {Test.class}, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)

public class TestImpl implements Test {
    @Self
    private SlingHttpServletRequest request;
    @ValueMapValue
    public String name;
    @ValueMapValue
    public String section;
    @ValueMapValue
    public String books;
    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getSection() {
        return section;
    }

    @Override
    public String getBooks() {
        return books;
    }
}
