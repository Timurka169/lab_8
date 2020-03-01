package ru.ncedu.course.catalog_example.service;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class LikeService {

    @Inject
    private LikeBean likeBean;

    public void createLikeList(){
        likeBean.setOfferingsList(new ArrayList<>());
    }

    public List<Long> getLikeList(){
        return likeBean.getOfferingsList();
    }

    public void addOffering(long id){
        likeBean.getOfferingsList().add(id);
    }

    public void closeSession(){
        likeBean.setUser(null);
        likeBean.setOfferingsList(null);
    }
}
