package com.myproject.core.models.impl;

import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;
import com.myproject.core.models.Custom;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.Self;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@Model(adaptables = {SlingHttpServletRequest.class}, adapters = {Custom.class}, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)

public class CustomImpl implements Custom {
    @ValueMapValue
    private String pagePath;
    @Inject
    private ResourceResolver resourceResolver;
    @Self
    private SlingHttpServletRequest request;

    public String getFileReference() {
        PageManager pageManager = resourceResolver.adaptTo(PageManager.class);
        Page page = pageManager.getPage(pagePath);
        Resource contentResource = page.getContentResource();
        return contentResource.getValueMap().get("fileReference", String.class);
    }

    @Override
    public String getPageTitle() {
        Resource resource = resourceResolver.getResource(pagePath);
            Page page = resource.adaptTo(Page.class);
                return page.getTitle();
            }


    @Override
    public String getPageDiscription() {
        Resource resource = resourceResolver.getResource(pagePath);
        Page page = resource.adaptTo(Page.class);
        return page.getDescription();
    }
}

