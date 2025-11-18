package it.unibo.mvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import static java.lang.System.out;

/**
 * implementation of the interface controller.
 */
public final class SimpleController implements Controller {

    private String nextString;
    private final List<String> history = new ArrayList<>();

    /**
     * {@inheritDoc}
     */
    @Override
    public void setNextString(final String s) {
        Objects.requireNonNull(s);
        this.nextString = s;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getNextString() {
        return this.nextString;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<String> getHistory() {
        return new ArrayList<>(this.history);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void printString() {
        if (this.nextString == null || "".equals(this.nextString)) {
            throw new IllegalStateException("the string to be printed was unset");
        }
        out.println(this.nextString);
        history.addLast(this.nextString);
    }

}
