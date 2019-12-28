package com.andrew6000.JAMM;

import com.andrew6000.JAMM.song.*;
import com.andrew6000.JAMM.song.chord.*;
import com.andrew6000.JAMM.song.event.EventChordChange;
import org.lwjgl.glfw.*;
import org.lwjgl.opengl.*;
import org.lwjgl.system.*;

import java.nio.*;

import static org.lwjgl.glfw.Callbacks.*;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryStack.*;
import static org.lwjgl.system.MemoryUtil.*;

public class Main {
    // The window handle
    private long window;

    public static Jamm jamm;
    public static Song song;

    public void run() {

        song = new Song(32, 20, new SongKey ( new Note (NoteVals.A_SHARP)) );
        song.getSongEvents().put(0f , new EventChordChange( new ChordMajorSeven   (1 )));
        song.getSongEvents().put(2f , new EventChordChange( new ChordMinorSeven   (6 )));
        song.getSongEvents().put(4f , new EventChordChange( new ChordMinorSeven   (2 )));
        song.getSongEvents().put(6f , new EventChordChange( new ChordDominantSeven(5 )));

        song.getSongEvents().put(8f , new EventChordChange( new ChordMajorSeven   (1 )));
        song.getSongEvents().put(10f, new EventChordChange( new ChordMinorSeven   (6 )));
        song.getSongEvents().put(12f, new EventChordChange( new ChordMinorSeven   (2 )));
        song.getSongEvents().put(14f, new EventChordChange( new ChordDominantSeven(5 )));

        song.getSongEvents().put(16f, new EventChordChange( new ChordMajorSeven   (1 )));
        song.getSongEvents().put(18f, new EventChordChange( new ChordDominantSeven(1 )));
        song.getSongEvents().put(20f, new EventChordChange( new ChordMajorSeven   (4 )));
        song.getSongEvents().put(22f, new EventChordChange( new ChordMinor        (4 )));

        song.getSongEvents().put(24f, new EventChordChange( new ChordMajorSeven   (1 )));
        song.getSongEvents().put(26f, new EventChordChange( new ChordMinorSeven   (6 )));
        song.getSongEvents().put(28f, new EventChordChange( new ChordMinorSeven   (2 )));
        song.getSongEvents().put(30f, new EventChordChange( new ChordDominantSeven(5 )));

        jamm = new Jamm();
        jamm.setSong( song );

        init();
        loop();

        // Free the window callbacks and destroy the window
        glfwFreeCallbacks(window);
        glfwDestroyWindow(window);

        // Terminate GLFW and free the error callback
        glfwTerminate();
        glfwSetErrorCallback(null).free();
    }

    private void init() {
        // Setup an error callback. The default implementation
        // will print the error message in System.err.
        GLFWErrorCallback.createPrint(System.err).set();

        // Initialize GLFW. Most GLFW functions will not work before doing this.
        if ( !glfwInit() )
            throw new IllegalStateException("Unable to initialize GLFW");

        // Configure GLFW
        glfwDefaultWindowHints(); // optional, the current window hints are already the default
        glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE); // the window will stay hidden after creation
        glfwWindowHint(GLFW_RESIZABLE, GLFW_TRUE); // the window will be resizable

        // Create the window
        window = glfwCreateWindow(300, 300, "JAMM", NULL, NULL);
        if ( window == NULL )
            throw new RuntimeException("Failed to create the GLFW window");

        // Setup a key callback. It will be called every time a key is pressed, repeated or released.
        glfwSetKeyCallback(window, (window, key, scancode, action, mods) -> {
            if ( key == GLFW_KEY_ESCAPE && action == GLFW_RELEASE )
                glfwSetWindowShouldClose(window, true); // We will detect this in the rendering loop
        });

        // Get the thread stack and push a new frame
        try ( MemoryStack stack = stackPush() ) {
            IntBuffer pWidth = stack.mallocInt(1); // int*
            IntBuffer pHeight = stack.mallocInt(1); // int*

            // Get the window size passed to glfwCreateWindow
            glfwGetWindowSize(window, pWidth, pHeight);

            // Get the resolution of the primary monitor
            GLFWVidMode vidmode = glfwGetVideoMode(glfwGetPrimaryMonitor());

            // Center the window
            glfwSetWindowPos(
                    window,
                    (vidmode.width() - pWidth.get(0)) / 2,
                    (vidmode.height() - pHeight.get(0)) / 2
            );
        } // the stack frame is popped automatically

        // Make the OpenGL context current
        glfwMakeContextCurrent(window);
        // Enable v-sync
        glfwSwapInterval(1);

        // Make the window visible
        glfwShowWindow(window);
    }

    private void loop() {
        // This line is critical for LWJGL's interoperation with GLFW's
        // OpenGL context, or any context that is managed externally.
        // LWJGL detects the context that is current in the current thread,
        // creates the GLCapabilities instance and makes the OpenGL
        // bindings available for use.
        GL.createCapabilities();

        // Set the clear color
        glClearColor(0.0f, 0.0f, 0.0f, 0.0f);

        // Run the rendering loop until the user has attempted to close
        // the window or has pressed the ESCAPE key.
        while ( !glfwWindowShouldClose(window) ) {
            glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
            glfwSwapBuffers(window);

            jamm.update();

            glfwPollEvents();
        }
    }

    public static void main(String[] args) {
        new Main().run();
    }
}
