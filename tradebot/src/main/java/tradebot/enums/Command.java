package tradebot.enums;

public enum Command {
	TRADE_REQUEST("!traderequest"),
	TRADE_AGREEMENT("!agree"),
	;
	
	private String command;
	Command(String command) { this.command = command; }
	public String getCommand() { return command; }
}
