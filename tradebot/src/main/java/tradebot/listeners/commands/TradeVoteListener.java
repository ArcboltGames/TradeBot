package tradebot.listeners.commands;

import org.javacord.api.entity.message.Message;
import org.javacord.api.event.message.reaction.ReactionAddEvent;
import org.javacord.api.listener.message.reaction.ReactionAddListener;

public class TradeVoteListener implements ReactionAddListener {

	@Override
	public void onReactionAdd(ReactionAddEvent event) {
		Message message = event.getMessage().get();
		if (message.getReactions().size() >= 6) {
			//if max votes then take highest count as decision
			if (message.getReactions().size() == 8) {
			
				return;
			}
			
			//otherwise, check for win condition (count = 4)
			
		}
	}

}
