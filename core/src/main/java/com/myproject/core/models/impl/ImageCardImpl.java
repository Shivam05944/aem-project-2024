package com.myproject.core.models.impl;

import com.day.cq.wcm.api.Page;
import com.myproject.core.models.ImageCard;
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


@Model(adaptables = {SlingHttpServletRequest.class}, adapters = {ImageCard.class}, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class ImageCardImpl implements ImageCard {
    @Self
    private SlingHttpServletRequest request;
    @ValueMapValue
    private String pagePath;
    @Inject
    private Page currentPage;
    @Inject
    private ResourceResolver resourceResolver;

    @Override
    public List<String> getAllPageTitles() {
        List<String> pageTitles = new ArrayList<>();
        ResourceResolver resourceResolver = request.getResourceResolver();
        Resource resource = resourceResolver.getResource(pagePath);

        if (resource != null) {
            for (Resource child : resource.getChildren()) {
                Page page = child.adaptTo(Page.class);
                if (page != null) {
                    pageTitles.add(page.getTitle());
                }
            }
        }
        return pageTitles;
    }

    /* public String getFileReference() {
         PageManager pageManager = resourceResolver.adaptTo(PageManager.class);
         Page page = pageManager.getPage(pagePath);
         Resource contentResource = page.getContentResource();
         return contentResource.getValueMap().get("fileReference", String.class);
     }*/
    public List<String> getFileReference() {
        List<String> imageReferences = new ArrayList<>();
        ResourceResolver resourceResolver = request.getResourceResolver();
        Resource rootResource = resourceResolver.getResource(pagePath);

        if (rootResource != null) {
            for (Resource child : rootResource.getChildren()) {
                Page childPage = child.adaptTo(Page.class);
                if (childPage != null) {
                    Resource contentResource = childPage.getContentResource();
                    if (contentResource != null) {
                        String fileReference = contentResource.getValueMap().get("fileReference", String.class);
                        if (fileReference != null) {
                            imageReferences.add(fileReference);
                        }
                    }
                }
            }
        }
        return imageReferences;
    }

    @Override
    public List<String> getAllPageDescriptions() {
        List<String> pageDescriptions = new ArrayList<>();
        ResourceResolver resourceResolver = request.getResourceResolver();
        Resource resource = resourceResolver.getResource(pagePath);

        if (resource != null) {
            for (Resource child : resource.getChildren()) {
                Page page = child.adaptTo(Page.class);
                if (page != null) {
                    String description = page.getDescription();
                    pageDescriptions.add(description);
                }
            }
        }
        return pageDescriptions;
    }

}
