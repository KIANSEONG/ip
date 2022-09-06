package sus.commands;

import sus.DukeException;
import sus.common.Messages;
import sus.storage.StorageFile;
import sus.task.Task;
import sus.task.TaskList;
import sus.ui.TextUi;

/**
 * Delete a task in the task list.
 */
public class DeleteCommand extends Command {

    public static final String COMMAND_WORD = "delete";
    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Deletes a task from the list.\n"
            + "\tEx.: " + COMMAND_WORD + " <number>";

    private final int targetIndex;

    public DeleteCommand(int targetIndex) {
        this.targetIndex = targetIndex;
    }

    @Override
    public CommandResult execute(TaskList taskList, TextUi textUi, StorageFile storage) {
        try {
            Task task = taskList.deleteTask(targetIndex);
            storage.save(taskList);
            return new CommandResult(Messages.MESSAGE_TASK_DELETED + "\n"
                    + task + "\n"
                    + String.format(Messages.MESSAGE_TASK_NUMBER, taskList.getNumberOfTasks()));
        } catch (DukeException e) {
            return new CommandResult(e.getMessage());
        }
    }
}
