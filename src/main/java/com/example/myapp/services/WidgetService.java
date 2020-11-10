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

    public Widget updateWidget(Integer widgetId, Widget newWidget) {

        Optional widdgetO = widgetRepository.findById((widgetId));
        if(widdgetO.isPresent()){
            Widget widget = (Widget) widdgetO.get();
            widget.setName(newWidget.getName());
            widget.setType(newWidget.getType());
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

}
