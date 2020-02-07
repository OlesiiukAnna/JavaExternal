package com.game.model;

import com.game.model.impl.NumberGame;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

class NumberGameTest {

    private static NumberGame testedInstance;

    @BeforeEach
    public void setUp() {
        testedInstance = new NumberGame();
    }

    @Test
    public void shouldReturnNumberInRange() {

        int actual = testedInstance.getTargetNumber();

        assertTrue(actual < testedInstance.getMax() && actual > testedInstance.getMin());
    }

    @Test
    public void shouldThrowExceptionWhenMinMoreThanMax() {

        final Executable executable = () -> testedInstance.setMin(testedInstance.getMax() * 2);

        assertThrows(IllegalArgumentException.class, executable, "max must be greater than min");
    }

    @Test
    public void shouldThrowExceptionWhenMaxLessThanMin() {

        final Executable executable = () -> testedInstance.setMax(testedInstance.getMin() * 2);

        assertThrows(IllegalArgumentException.class, executable, "max must be greater than min");
    }

    @Test
    public void shouldThrowExceptionWhenMaxEqualsMin() {

        final Executable executable = () -> testedInstance.setMax(testedInstance.getMin());

        assertThrows(IllegalArgumentException.class, executable, "max must be greater than min");
    }

}
