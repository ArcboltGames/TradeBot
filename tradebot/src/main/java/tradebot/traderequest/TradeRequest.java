package tradebot.traderequest;

import java.util.ArrayList;
import java.util.List;

import tradebot.utils.TradeUtil;

public class TradeRequest {
	private String teamAUser;
	private String teamATeamName;
	private List<String> teamAOffer;
	
	private String teamBUser;
	private String teamBTeamName;
	private List<String> teamBOffer;
	
	private long id;
	private boolean agreed;

	public TradeRequest() {
		setId(TradeUtil.generateNewTradeRequestId());
		setAgreed(false);
	}

	public String getTeamATeamName() {
		return teamATeamName;
	}

	public void setTeamATeamName(String teamATeamName) {
		this.teamATeamName = teamATeamName;
	}

	public List<String> getTeamAOffer() {
		return teamAOffer;
	}

	public void setTeamAOffer(List<String> teamAOffer) {
		this.teamAOffer = teamAOffer;
	}

	public String getTeamBTeamName() {
		return teamBTeamName;
	}

	public void setTeamBTeamName(String teamBTeamName) {
		this.teamBTeamName = teamBTeamName;
	}

	public List<String> getTeamBOffer() {
		return teamBOffer;
	}

	public void setTeamBOffer(List<String> teamBOffer) {
		this.teamBOffer = teamBOffer;
	}

	public boolean isAgreed() {
		return agreed;
	}

	public void setAgreed(boolean agreed) {
		this.agreed = agreed;
	}

	public long getId() {
		return id;
	}

	public void setId(long tradeId) {
		this.id = tradeId;
	}

	public String getTeamAUser() {
		return teamAUser;
	}

	public void setTeamAUser(String teamAUser) {
		this.teamAUser = teamAUser;
	}

	public String getTeamBUser() {
		return teamBUser;
	}

	public void setTeamBUser(String teamBUser) {
		this.teamBUser = teamBUser;
	}

	public void populateTeamADetails(String[] teamDetails) {
		setTeamAUser(teamDetails[0]);
		setTeamAOffer(createOfferListFromArray(teamDetails));
	}

	public void poplateTeamBDetails(String[] teamDetails) {
		setTeamBUser(teamDetails[0]);
		setTeamBOffer(createOfferListFromArray(teamDetails));
	}
	
	private List<String> createOfferListFromArray(String[] offers) {
		List<String> offerList = new ArrayList<String>();
		for (int i = 1; i < offers.length; i++) {
			offerList.add(offers[i]);
		}
		return offerList;
	}
	
	
	public enum Team {
		TEAMA("TEAM A"),
		TEAMB("TEAM B")
		;
		private String desc;
		Team(String desc) {
			this.desc = desc;
		}
		public String getDescription() {
			return desc;
		}
	}

}
