package com.console.consoledrawing.model;

import com.console.consoledrawing.command.BucketFillCommand;
import com.console.consoledrawing.command.DrawLineCommand;
import com.console.consoledrawing.command.DrawRectangleCommand;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EntityFactoryTest {

    private EntityFactory entityFactory;

    @Before
    public void setUp() throws Exception {
        entityFactory = new EntityFactory();
    }


    @Test
    public void getEntity_DrawLineCommand() throws Exception {
        DrawLineCommand drawLineCommand = new DrawLineCommand( "1", "2", "1", "4");
        assertEquals(entityFactory.getEntity(drawLineCommand), new Line(1, 2, 1, 4));
    }

    @Test
    public void getEntity_DrawRectangleCommand() throws Exception {
        DrawRectangleCommand drawLineCommand = new DrawRectangleCommand( "1", "2", "3", "4");
        assertEquals(entityFactory.getEntity(drawLineCommand), new Rectangle(1, 2, 3, 4));
    }

    @Test
    public void getEntity_BucketFillCommand() throws Exception {
        BucketFillCommand drawLineCommand = new BucketFillCommand( "2", "3", "o");
        assertEquals(entityFactory.getEntity(drawLineCommand), new BucketFill(2, 3, 'o'));
    }

    @Test
    public void getEntity_null() throws Exception {
        assertEquals(entityFactory.getEntity(null), null);
    }
}