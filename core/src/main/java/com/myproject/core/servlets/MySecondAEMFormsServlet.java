package com.myproject.core.servlets;

import com.day.cq.tagging.Tag;
import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;

import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;

import org.osgi.service.component.annotations.Component;

import javax.servlet.Servlet;
import java.io.IOException;
import java.util.Arrays;
import java.util.Calendar;


@Component(service = {Servlet.class}, property = {"sling.servlet.method=GET", "sling.servlet.paths=/bin/Showdata"})
public class MySecondAEMFormsServlet extends SlingAllMethodsServlet {

    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws IOException {
        /* response.getWriter().print("Hello I Am Second Servlet");*/

        String path = "/content/myproject/us/en/my-first-page";

        ResourceResolver resourceResolver = request.getResourceResolver();
        PageManager pageManager = resourceResolver.adaptTo(PageManager.class);

        Page page = pageManager.getPage(path);

        String title = page.getTitle();
        String properties = page.getProperties().toString();
        Tag[] tag = page.getTags();
        Calendar time = page.getLastModified();
        String language = String.valueOf(page.getLanguage());
        String name = page.getName();
        String template = String.valueOf(page.getTemplate());
        String navigationTitle = page.getNavigationTitle();

        response.getWriter().print("Title : " + title);
        response.getWriter().print("Properties : " + properties);
        response.getWriter().print("Tag : " + Arrays.toString(tag));
        response.getWriter().print("Time : " + time);
        response.getWriter().print("Language : " + language);
        response.getWriter().print("Name : " + name);
        response.getWriter().print("Template : " + template);
        response.getWriter().print("Navigation Title : " + navigationTitle);
    }
}
