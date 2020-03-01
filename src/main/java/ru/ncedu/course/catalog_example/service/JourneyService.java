package ru.ncedu.course.catalog_example.service;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class JourneyService {

    @Inject
    private JourneyBean journeyBean;

    public void createJourneyList(){
        journeyBean.setJourneyList(new ArrayList<>());
        journeyBean.getJourneyList().add(journeyBean.getUserId()+"'s journey started");
    }

    public List<String> getJourneyList(){
        return journeyBean.getJourneyList();
    }

    public void addLine(String str){
        journeyBean.getJourneyList().add(str);
    }

    public void cleanList(){
        journeyBean.getJourneyList().clear();
        journeyBean.getJourneyList().add(journeyBean.getUserId()+"'s journey started");
    }

    public void closeSession(){
        journeyBean.setUser(null);
        journeyBean.setJourneyList(null);
    }

}
