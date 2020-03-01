package ru.ncedu.course.catalog_example.service;

import ru.ncedu.course.catalog_example.model.entity.UserEntity;

import javax.ejb.Stateful;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@Stateful
@SessionScoped
public class JourneyBean implements Serializable {

    private List<String> journeyList;

    private Long userId;

    public void setUser(UserEntity user) {
        this.userId = Optional.ofNullable(user).map(UserEntity::getId).orElse(null);
    }

    public Long getUserId() {
        return userId;
    }

    public void setJourneyList(List<String> journeyList) {
        this.journeyList = Optional.ofNullable(journeyList).orElse(null);
    }

    public List<String> getJourneyList() {
        return Optional.ofNullable(journeyList).orElse(null);
    }
}
