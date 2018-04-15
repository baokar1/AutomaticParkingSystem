

package com.console.consoledrawing.model;

public interface Canvas {

    void addEntity(Entity entity) throws InvalidEntityException;

    String render();
}
