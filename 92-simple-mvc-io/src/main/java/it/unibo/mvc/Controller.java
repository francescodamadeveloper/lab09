package it.unibo.mvc;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

import static java.lang.System.out;

/**
 * Application controller. Performs the I/O.
 */
public final class Controller {

    private static final String FILE_NAME = "output";
    private static final String SEP = System.getProperty("file.separator");
    private File currentFile = new File(System.getProperty("user.home") + SEP + FILE_NAME + ".txt");

    /**
     * Sets the file associated with this controller.
     * 
     * @param file the file to be set
     */
    public void setCurrentFile(final File file) {
        this.currentFile = file;
    }

    /**
     * Provides the current file associated to this controller.
     * 
     * @return the current file
     */
    public File getCurrentFile() {
        return this.currentFile;
    }

    /**
     * Provides the absolute path of the file associated to this controller.
     * 
     * @return the path of the file
     */
    public String getPath() {
        return this.currentFile.getAbsolutePath();
    }

    /**
     * Saves a string on the file associated to this controller.
     * 
     * @param s the string to be written
     */
    public void saveString(final String s) {
        try (PrintStream ps = new PrintStream(currentFile, StandardCharsets.UTF_8)) {
            ps.print(s);
        } catch (final IOException e) {
            out.println(e.getMessage());
        }
    }
}
