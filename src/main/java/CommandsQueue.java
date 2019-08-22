import java.util.Queue;
import java.util.LinkedList;

public class CommandsQueue {
	private static CommandsQueue singleton;
	private Queue<Command> queue;

	private CommandsQueue() {
		queue = new LinkedList<Command>();
	}
	public static synchronized CommandsQueue getInstance() {
		if (singleton == null) {
			singleton = new CommandsQueue();
		}
		return singleton;
	}
	public Queue<Command> getQueue() {
		return queue;
	}
	public String getResults() {
		String results = "";
		for (Command command : queue)
			results += command.getStatus() + "\n";
		return results;
	}
	public void setQueueNull() {
		singleton = null;
	}
}