package com.example.demo.dao;

import com.example.demo.models.User;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Component
public class GenericDAO<T> {
    private final List<T> entities = new ArrayList<>();
    public int NEXT_ID = 1;
    public void clearId() {
        NEXT_ID = 1;
    }
    public List<T> getAll() {
        return entities;
    }
    public Optional<T> getById(int id) {
        return entities.stream()
                .filter(e -> getId(e) == id)
                .findFirst();
    }
    public T show(int id) {
        return entities.stream().filter(entity -> getId(entity) == id).findAny().orElse(null);
    }
    public void create(T entity) {
        setId(entity, NEXT_ID++);
        entities.add(entity);
    }
    public void update(int id, T updatedEntity) {
        T existingEntity = show(id);
        if (existingEntity != null) {
            copyFields(existingEntity, updatedEntity);
        }
    }
    public void delete(int id) {
        entities.removeIf(entity -> getId(entity) == id);
    }
    protected int getId(T entity) {
        try {
            Method getIdMethod = entity.getClass().getMethod("getId");
            Object idValue = getIdMethod.invoke(entity);
            if (idValue instanceof Integer) {
                return (Integer) idValue;
            }
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return -1;
    }
    protected void setId(T entity, int id) {
        try {
            Method setIdMethod = entity.getClass().getMethod("setId", int.class);
            setIdMethod.invoke(entity, id);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
    protected void copyFields(T existingEntity, T updatedEntity) {
        try {
            Field[] fields = existingEntity.getClass().getDeclaredFields();
            for (Field field : fields) {
                String fieldName = field.getName();
                String getterName = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
                String setterName = "set" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);

                Method getter = existingEntity.getClass().getMethod(getterName);
                Method setter = existingEntity.getClass().getMethod(setterName, field.getType());

                Object value = getter.invoke(updatedEntity);
                setter.invoke(existingEntity, value);
            }
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
