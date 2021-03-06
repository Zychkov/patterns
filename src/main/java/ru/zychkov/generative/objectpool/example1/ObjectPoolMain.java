package ru.zychkov.generative.objectpool.example1;

import java.util.LinkedList;
import java.util.List;

public class ObjectPoolMain {

    public static void main(String[] args) {
        ObjectPool objectPool = new ObjectPool();

        PooledObject pooledObject = objectPool.getPooledObject();
        objectPool.releasePooledObject(pooledObject);
    }
}

class PooledObject {}

class ObjectPool {

    List<PooledObject> free = new LinkedList<>();
    List<PooledObject> used = new LinkedList<>();

    public PooledObject getPooledObject() {
        if (free.isEmpty()) {
            PooledObject pooledObject = new PooledObject();
            free.add(pooledObject);

            return pooledObject;
        } else {
            PooledObject pooledObject = free.iterator().next();
            used.add(pooledObject);
            free.remove(pooledObject);

            return pooledObject;
        }

    }

    public void releasePooledObject(PooledObject pooledObject) {
        used.remove(pooledObject);
    }
}