package com.miner.chars;

import java.util.HashMap;


public class EntityManager {
    private static EntityManager instance=null;
    private HashMap<String, Entity> map;

    private EntityManager(){
        map=new HashMap<String, Entity>();
    }

    public void newEntityRegister(Entity entity){
        map.put(entity.getName(), entity);
    }

    public Entity getEntity(String entityName){
        Entity entity=map.get(entityName);
        return entity;
    }
    
    public static EntityManager getInstance(){
        if(instance==null){
            instance=new EntityManager();
        }
        return instance;
    }

}
