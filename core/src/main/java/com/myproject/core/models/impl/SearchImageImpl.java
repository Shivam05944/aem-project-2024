package com.myproject.core.models.impl;

import com.day.cq.dam.api.Asset;
import com.day.cq.dam.api.Rendition;
import com.day.cq.search.PredicateGroup;
import com.day.cq.search.Query;
import com.day.cq.search.QueryBuilder;
import com.day.cq.search.result.Hit;
import com.day.cq.search.result.SearchResult;
import com.myproject.core.models.SearchImage;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import javax.inject.Inject;
import javax.jcr.RepositoryException;
import javax.jcr.Session;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Model(adaptables = {SlingHttpServletRequest.class}, adapters = {SearchImage.class}, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)

public class SearchImageImpl implements SearchImage {
    @ValueMapValue
    public String damPath;
    @Inject
    private ResourceResolver resourceResolver;
    @Inject
    private QueryBuilder queryBuilder;

    @Override
    public List<String> getDemoImage() {
        List<String> image = new ArrayList<>();
        Session session = resourceResolver.adaptTo(Session.class);

        Map<String, String> map = new HashMap<>();
        map.put("path", damPath);
        map.put("type", "dam:Asset");
        map.put("p.limit", "-1");

        Query query = queryBuilder.createQuery(PredicateGroup.create(map), session);
        SearchResult result = query.getResult();

        for (Hit hit : result.getHits()) {
            try {
                image.add(hit.getPath());
            } catch (RepositoryException e) {
                e.printStackTrace();
            }
        }
        return image;
    }
}
