package org.ipan.gfg.ds;

import java.util.*;

public class StackTools {
    // TODO:
    //  1) determine the priority of operations: (), */, +-
    //  2) Tokenize the expression
    //  3)
    public static String InfixToPrefix(String expression){
        StringBuilder postfixExpr = new StringBuilder();
        Deque<String> stack = new ArrayDeque<>();
        StringTokenizer stringTokenizer = new StringTokenizer(expression, "()*/+-", true);
        List<String> tokens = new ArrayList<>();
        while (stringTokenizer.hasMoreTokens()) tokens.add(stringTokenizer.nextToken().trim());

        return postfixExpr.toString();
    }

}
