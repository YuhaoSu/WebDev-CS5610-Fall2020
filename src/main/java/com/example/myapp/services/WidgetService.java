package com.example.myapp.services;
import com.example.myapp.models.Widget;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WidgetService {
    List<Widget> widgets = new ArrayList<Widget>();

    public List<Widget> findWidgetsForTopic(String topicId) {
        List<Widget> ws = new ArrayList<Widget>();
        for(Widget w: widgets) {
            if(w.getTopicId().equals(topicId)) {
                ws.add(w);
            }
        }
        return ws;
    }

    public List<Widget> findAllWidgets() {
        return widgets;
    }

    public Widget findWidgetById(String widgetId) {
        for(Widget w: widgets) {
            if(w.getId().equals(widgetId))
                return w;
        }
        return null;
    }

    public Widget createWidget(Widget widget, String topicId) {
        widget.setId((new Date()).toString());
        widget.setTopicId(topicId);
//        widget.setSize(widget.getSize());
//        widget.setText(widget.getText());
        widgets.add(widget);
        return widget;
    }

    public Integer updateWidget(String widgetId, Widget newWidget) {
        for(Widget w: widgets) {
            if(w.getId().equals(widgetId)) {
                w.setName(newWidget.getName());
                w.setType(newWidget.getType());
                w.setText(newWidget.getText());
                return 1;
            }
        }
        return 0;
    }

    public Integer deleteWidgets(String widgetId){
        for(Widget w: widgets) {
            if(w.getId().equals(widgetId)){
                widgets.remove(w);
                return 1;
        }}
        return 0;
    }
//
//    public List<Widget> deleteWidgets(String widgetId){
//        for(Widget w: widgets) {
//            if(w.getId().equals(widgetId)){
//                widgets.remove(w);
//            }}
//        return widgets;
//    }
//


    public List<Widget> saveAllWidgets(String topicId, List<Widget> newWidgets){
        List<Widget> oldWidgetList = findWidgetsForTopic(topicId);
        for(Widget oldWidget: oldWidgetList){
            deleteWidgets(oldWidget.getId());
        }

        for ( Widget newWidget: newWidgets){
            widgets.add(newWidget);
        }

//        for(Widget newWidget: newWidgets){
//            updateWidget(newWidget.getId(), newWidget);
//        }

        return newWidgets;
    }

}
