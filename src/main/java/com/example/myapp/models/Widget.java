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
    private boolean ordered;

    public Widget(
            String id,
            String name,
            String type,
            String topicId,
            Integer widgetOrder,
            String text,
            Integer size,
            Integer width,
            Integer height,
            String cssClass,
            String style,
            String value,
            boolean ordered) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.topicId = topicId;
        this.widgetOrder = widgetOrder;
        this.text = text;
        this.size = size;
        this.width = width;
        this.height = height;
        this.cssClass =cssClass;
        this.style = style;
        this.value = value;
        this.ordered = ordered;
    }

    public Widget() {
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public String getTopicId() {
        return topicId;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getCssClass() {
        return cssClass;
    }

    public void setCssClass(String cssClass) {
        this.cssClass = cssClass;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getWidgetOrder() {
        return widgetOrder;
    }

    public void setWidgetOrder(Integer widgetOrder) {
        this.widgetOrder = widgetOrder;
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

    public boolean isOrdered() {
        return ordered;
    }

    public void setOrdered(boolean ordered) {
        this.ordered = ordered;
    }



}

