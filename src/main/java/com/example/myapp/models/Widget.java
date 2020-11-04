package com.example.myapp.models;

public class Widget {

    private String id;
    private String name;
    private String type;
    private String topicId;
    private Integer widgetOrder;
    private String text;
    private Integer size;
    private Integer width;
    private Integer height;
    private String cssClass;
    private String style;
    private String value;


//    public Widget(String id, String name, String type) {
//        this.id = id;
//        this.name = name;
//        this.type = type;
//    }


    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public Widget(String id, String name, String type, String topicId, Integer size, String text) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.topicId = topicId;
        this.size = size;
        this.text = text;
    }

    public Widget() {
    }

    public String getTopicId() {
        return topicId;
    }

    public void setTopicId(String topicId) {
        this.topicId = topicId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getSize() {
        return size;
    }


}

