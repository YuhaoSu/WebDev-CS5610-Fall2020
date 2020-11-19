package com.example.myapp.services;
import com.example.myapp.models.Widget;
import com.example.myapp.repositories.WidgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class WidgetService {

    @Autowired
    WidgetRepository widgetRepository;

    public List<Widget> findWidgetsForTopic(String topicId) {
        return widgetRepository.findWidgetsForTopic(topicId);
    }
    public List<Widget> findAllWidgets() {
        return (List<Widget>) widgetRepository.findAll();
    }

    public Widget findWidgetById(Integer widgetId) {
        return widgetRepository.findById(widgetId).get();
    }
    public Widget createWidget(Widget widget) {
        return widgetRepository.save(widget);
    }

    public Widget updateWidget(
            Integer widgetId,
            Widget newWidget) {
        Optional widgetO = widgetRepository.findById((widgetId));
        if(widgetO.isPresent()){
            Widget widget = (Widget) widgetO.get();
            widget.setTopicId(newWidget.getTopicId());
            widget.setName(newWidget.getName());
            widget.setType(newWidget.getType());
            widget.setText(newWidget.getText());
            widget.setSrc(newWidget.getSrc());
            widget.setItems(newWidget.getItems());
            widget.setWidgetOrder(newWidget.getWidgetOrder());
            widget.setSize(newWidget.getSize());
            widget.setWidth(newWidget.getWidth());
            widget.setHeight(newWidget.getHeight());
            widget.setCssClass(newWidget.getCssClass());
            widget.setStyle(newWidget.getStyle());
            widget.setValue(newWidget.getValue());
            widget.setOrdered(newWidget.getOrdered());
            return widgetRepository.save(widget);
        }
        else {
            return null;
        }
    }

    public List<Widget> deleteWidgets(Integer widgetId){
        widgetRepository.deleteById(widgetId);
        return (List<Widget>) widgetRepository.findAll();
    }

    public List<Widget> saveAllWidgets(String topicId, List<Widget> newWidgets) {
        List<Widget> oldWidgetList = findWidgetsForTopic(topicId);

        for (Widget oldWidget : oldWidgetList) {
            deleteWidgets(oldWidget.getId());
        }
        for (Widget newWidget : newWidgets) {
            widgetRepository.save(newWidget);

        }
        return widgetRepository.findWidgetsForTopic(topicId);
    }

}
