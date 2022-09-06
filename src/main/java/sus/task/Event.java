package sus.task;

import java.time.LocalDate;

import sus.common.Utils;

/**
 * Represents an Event.
 */
public class Event extends Task {

    private final LocalDate at;

    /**
     * Constructor for a new Event.
     *
     * @param description description of the event
     * @param at time frame of the event
     */
    public Event(String description, String at) {
        super(description);
        this.at = Utils.parseDate(at);
    }

    @Override
    public String encodeToString() {
        String taskStatus = isDone ? "1" : "0";
        return String.format("E | %s | %s | %s", taskStatus, description, at);
    }

    @Override
    public String toString() {
        return String.format("[E]%s %s (at: %s)", super.getStatusIcon(), description, Utils.convertLocalDate(at));
    }
}
