package io.zhile.crack.atlassian.agent;

import java.lang.instrument.Instrumentation;

/**
 * @author pengzhile
 * @version 1.0
 * @link https://zhile.io
 */
public class Agent {
    public static void premain(String args, Instrumentation inst) {
        try {
            inst.addTransformer(new KeyTransformer());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
