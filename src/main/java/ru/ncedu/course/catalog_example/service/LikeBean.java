package ru.ncedu.course.catalog_example.service;

import ru.ncedu.course.catalog_example.model.entity.UserEntity;

import javax.ejb.Stateful;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@Stateful
@SessionScoped
public class LikeBean implements Serializable {

    private Long userId;

    private List<Long> offerings;

    public void setUser(UserEntity user) {
        this.userId = Optional.ofNullable(user).map(UserEntity::getId).orElse(null);
    }

    public Long getUserId() {
        return userId;
    }

    public void setOfferingsList(List<Long> List) {
        this.offerings = Optional.ofNullable(List).orElse(null);
    }

    public List<Long> getOfferingsList() {
        return Optional.ofNullable(offerings).orElse(null);
    }


}
