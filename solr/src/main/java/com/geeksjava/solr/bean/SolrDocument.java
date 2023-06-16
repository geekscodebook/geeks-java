package com.geeksjava.solr.bean;

public class SolrDocument {
    private final String id;
    private final String name;
    private final String title;
    private final String description;

    public SolrDocument(String id, String name, String title, String description){
        this.id=id;
        this.name=name;
        this.title=title;
        this.description=description;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
}
