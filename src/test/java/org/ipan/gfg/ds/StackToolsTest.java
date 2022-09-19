package org.ipan.gfg.ds;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackToolsTest {

    @Test
    public void InfixToPrefix() {
        String expr = "A + B * C + D";
        StackTools.InfixToPrefix(expr);
    }
}