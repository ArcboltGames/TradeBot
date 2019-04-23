package tradebot.utils;

import java.util.Comparator;
import java.util.List;
import tradebot.enums.Command;
import tradebot.traderequest.TradeRequest;
import tradebot.traderequest.TradeRequestCache;

public class TradeUtil {
	private static long seed = 0;
	
	/**
	 * Updates current TradeRequest Id seeding for generation of future IDs.
	 */
	public static void updateCurrentSeed() {
		if (TradeRequestCache.isEmpty())
			seed = 0;
		else
			seed = TradeRequestCache.getTradeRequestCache().stream().max(Comparator.comparingLong(TradeRequest::getId)).get().getId();
	}
	
	/**
	 * Increments seed by 1 and returns new id for use.
	 * @return long id, for use as TradeRequest ID
	 */
	public static long generateNewTradeRequestId() {
		seed += 1;
		return seed;
	}
	
	/**
	 * Create a TradeRequest object from a discord message.
	 * Message format: !traderequest @Team sends 2022-1,link,2022-4 @Team2 sends 2022-4,link
	 * @param the discord message content
	 * @return a TradeRequest representing the submitted trade
	 */
	public static TradeRequest createRequestFromMessage(String content) {
		TradeRequest tr = new TradeRequest();
		
		String[] teamSplit = content.replace(Command.TRADE_REQUEST.getCommand(), "").trim().split("@");
		tr.populateTeamADetails(teamSplit[1].split("\n"));
		tr.poplateTeamBDetails(teamSplit[2].split("\n"));
		
		return tr;
	}
	
	public static String getOfferListAsString(List<String> offerList) {
		StringBuilder sb = new StringBuilder();
		for(String offer : offerList)
			sb.append(offer + "\n");
		
		return sb.toString();
	}

}
