package task2.nuclear_submarine;

import java.lang.annotation.*;

/**
 * Created by Elizaveta Kapitonova on 12.12.15.
 * Task 6 (Inner classes) and Task 7 (Annotations)
 */
@MyDocumentedAnnotation
public class NuclearSubmarine {
    private class Engine implements Runnable {
        @Override
        public void run() {
            while(true){}
        }
    }

    private Engine engine;

    public NuclearSubmarine () {
        engine = new Engine();
    }

    public void deploy() {
        new Thread(engine).start();
    }

    public static void main(String[] args) {
        NuclearSubmarine ns = new NuclearSubmarine();
        ns.deploy();
    }
}


