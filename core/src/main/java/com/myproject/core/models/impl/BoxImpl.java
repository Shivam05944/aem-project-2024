package com.myproject.core.models.impl;

import com.myproject.core.models.Box;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.Self;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = {SlingHttpServletRequest.class}, adapters = {Box.class}, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)

public class BoxImpl implements Box {
    protected static final String RESOURCE_TYPE = "mysite/component/box";
    @Self
    private SlingHttpServletRequest request;
    @ValueMapValue
    public String video;
    @ValueMapValue
    public String title;
    @ValueMapValue
    public String subtitle;
    @ValueMapValue
    public String description;
    @ValueMapValue
    public String learnMoreLink;


    @Override
    public String getVideo() {
        return video;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getSubtitle() {
        return subtitle;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public String getRegisterlink() {
        return learnMoreLink;
    }

}
