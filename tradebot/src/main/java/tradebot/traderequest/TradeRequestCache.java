package tradebot.traderequest;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class TradeRequestCache {
	
	private static ArrayList<TradeRequest> tradeRequestCache = new ArrayList<TradeRequest>();
	
	public static ArrayList<TradeRequest> getTradeRequestCache() {
		return tradeRequestCache;
	}
	
	public static void addTradeRequestToCache(TradeRequest tr) {
		tradeRequestCache.add(tr);
	}
	
	public static TradeRequest getTradeRequestById(long id) throws NoSuchElementException {
		return tradeRequestCache.stream().filter(tr -> Long.compare(tr.getId(), id) == 0).findFirst().get();
	}
	
	public static boolean isEmpty() {
		return tradeRequestCache.isEmpty();
	}

}
