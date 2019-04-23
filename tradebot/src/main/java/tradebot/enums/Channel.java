package tradebot.enums;

public enum Channel {
	TRADE_REQUEST("trade-request", "508677092850925581"),
	TRADE_VOTE("trade-vote", "569806634852024320"),
	BOT_TEST("bot-test-channel", "531906360875417600"),
	TRADE_DECISION("trade-decision", "508677990142443530")
	;
	
	private String channelName;
	private String channelId;
	Channel(String channelName, String channelId) {
		this.channelName = channelName;
		this.channelId = channelId;
	}
	public String getChannel() { return channelName; }
	public String getChannelId() {return channelId; }
}
