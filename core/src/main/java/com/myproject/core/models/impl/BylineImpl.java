package com.myproject.core.models.impl;

import com.adobe.cq.wcm.core.components.models.Image;
import com.adobe.xfa.ModelFactory;
import com.myproject.core.models.Byline;
import org.apache.commons.lang.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.apache.sling.models.annotations.injectorspecific.Self;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Model(adaptables = {SlingHttpServletRequest.class}, adapters = {Byline.class}, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)

public class BylineImpl implements Byline {
    protected static final String RESOURCE_TYPE = "mysite/component/byline";
    @Self
    private SlingHttpServletRequest request;

    @OSGiService
    private ModelFactory modelFactory;

    @ValueMapValue
    private String imagePath;


    @ValueMapValue
    private String name;

    @ValueMapValue
    private List<String> occupations;

    @Override
    public String getImagePath() {
        return imagePath;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public List<String> getOccupations() {
        if (occupations != null) {
            Collections.sort(occupations);
            return new ArrayList<String>(occupations);
        } else return Collections.emptyList();
    }

    @Override
    public boolean isEmpty() {
        if (StringUtils.isBlank(name)) {
            return true;
        } else if (occupations == null || occupations.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}
