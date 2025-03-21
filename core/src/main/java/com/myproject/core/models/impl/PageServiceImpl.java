package com.myproject.core.models.impl;

import com.day.cq.search.PredicateGroup;
import com.day.cq.search.Query;
import com.day.cq.search.QueryBuilder;
import com.day.cq.search.result.Hit;
import com.day.cq.search.result.SearchResult;
import com.myproject.core.models.PageService;
import org.apache.sling.api.resource.ResourceResolver;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.jcr.RepositoryException;
import javax.jcr.Session;
import java.util.*;

@Component(service = PageService.class)
public class PageServiceImpl implements PageService {

    @Reference
    private QueryBuilder builder;

    @Override
    public List<String> getPages(String pagePath, String value, String value1,String[] tags, ResourceResolver resourceResolver) throws RepositoryException {
        List<String> pageList = new ArrayList<>();

        Map<String, String> map = new HashMap<>();
        map.put("path", pagePath);
        map.put("type", "cq:Page");

        map.put("group.property", "jcr:content/jcr:title");
        map.put("group.property.1_value", value);
        map.put("group.property.2_value", value1);
        map.put("group.1_property", "jcr:content/cq:tags");
        map.put("group.1_property.1_value", tags[0]);
        map.put("group.1_property.2_value", tags[1]);

        map.put("group.p.or", "true");
        map.put("orderby", "@jcr:content/cq:lastModified");
        map.put("orderby.sort", "desc");
        map.put("p.limit", "-1");

        Query query = builder.createQuery(PredicateGroup.create(map), resourceResolver.adaptTo(Session.class));
        query.setStart(0);
        query.setHitsPerPage(20);

        SearchResult result = query.getResult();
        for (Hit hit : result.getHits()) {
            pageList.add(hit.getPath());
        }

        return pageList;
    }
}
