package ghosts;

import java.util.HashMap;

import pacman.GhostPlayer;

public class EntityManager {

    private static EntityManager instance=null;
    private HashMap<String, GhostPlayer> map;

    private EntityManager(){
        map=new HashMap<String, GhostPlayer>();
    }

    public void newEntityRegister(GhostPlayer entity){
        map.put(entity.getName(), entity);
    }

    public GhostPlayer getEntity(String entityName){
        GhostPlayer entity=map.get(entityName);
        return entity;
    }
    
    public static EntityManager getInstance(){
        if(instance==null){
            instance=new EntityManager();
        }
        return instance;
    }

}
