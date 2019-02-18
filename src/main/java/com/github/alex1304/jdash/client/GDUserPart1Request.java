package com.github.alex1304.jdash.client;

import java.util.HashMap;
import java.util.Map;

import com.github.alex1304.jdash.entity.GDUserPart1;
import com.github.alex1304.jdash.entity.Role;
import com.github.alex1304.jdash.util.Constants;
import com.github.alex1304.jdash.util.Routes;
import com.github.alex1304.jdash.util.Utils;

class GDUserPart1Request implements GDRequest<GDUserPart1> {
	
	private final long targetAccountID;

	GDUserPart1Request(long targetAccountID) {
		this.targetAccountID = targetAccountID;
	}

	@Override
	public String getPath() {
		return Routes.GET_USER_INFO;
	}

	@Override
	public Map<String, String> getParams() {
		Map<String, String> map = new HashMap<>();
		map.put("targetAccountID", "" + targetAccountID);
		return map;
	}

	@Override
	public GDUserPart1 parseResponse(String response) throws GDClientException {
		if (response.startsWith("-1")) {
			throw new GDClientException(-1);
		}
		
		Map<Integer, String> data = Utils.splitToMap(response, ":");
		
		String strPlayerID = Utils.defaultStringIfEmptyOrNull(data.get(Constants.INDEX_USER_PLAYER_ID), "0");
		String strAccountID = Utils.defaultStringIfEmptyOrNull(data.get(Constants.INDEX_USER_ACCOUNT_ID), "0");
		String strStars = Utils.defaultStringIfEmptyOrNull(data.get(Constants.INDEX_USER_STARS), "0");
		String strDemons = Utils.defaultStringIfEmptyOrNull(data.get(Constants.INDEX_USER_DEMONS), "0");
		String strDiamonds = Utils.defaultStringIfEmptyOrNull(data.get(Constants.INDEX_USER_DIAMONDS), "0");
		String strSecretCoins = Utils.defaultStringIfEmptyOrNull(data.get(Constants.INDEX_USER_SECRET_COINS), "0");
		String strUserCoins = Utils.defaultStringIfEmptyOrNull(data.get(Constants.INDEX_USER_USER_COINS), "0");
		String strCreatorPoints = Utils.defaultStringIfEmptyOrNull(data.get(Constants.INDEX_USER_CREATOR_POINTS), "0");
		String strGlobalRank = Utils.defaultStringIfEmptyOrNull(data.get(Constants.INDEX_USER_GLOBAL_RANK), "0");
		String strCube = Utils.defaultStringIfEmptyOrNull(data.get(Constants.INDEX_USER_ICON_CUBE), "0");
		String strShip = Utils.defaultStringIfEmptyOrNull(data.get(Constants.INDEX_USER_ICON_SHIP), "0");
		String strUfo = Utils.defaultStringIfEmptyOrNull(data.get(Constants.INDEX_USER_ICON_UFO), "0");
		String strBall = Utils.defaultStringIfEmptyOrNull(data.get(Constants.INDEX_USER_ICON_BALL), "0");
		String strWave = Utils.defaultStringIfEmptyOrNull(data.get(Constants.INDEX_USER_ICON_WAVE), "0");
		String strRobot = Utils.defaultStringIfEmptyOrNull(data.get(Constants.INDEX_USER_ICON_ROBOT), "0");
		String strSpider = Utils.defaultStringIfEmptyOrNull(data.get(Constants.INDEX_USER_ICON_SPIDER), "0");
		String strTrail = Utils.defaultStringIfEmptyOrNull(data.get(Constants.INDEX_USER_TRAIL), "0");
		String strDeathEffect = Utils.defaultStringIfEmptyOrNull(data.get(Constants.INDEX_USER_DEATH_EFFECT), "0");
		String strColor1 = Utils.defaultStringIfEmptyOrNull(data.get(Constants.INDEX_USER_COLOR_1), "0");
		String strColor2 = Utils.defaultStringIfEmptyOrNull(data.get(Constants.INDEX_USER_COLOR_2), "0");
		String strRole = Utils.defaultStringIfEmptyOrNull(data.get(Constants.INDEX_USER_ROLE), "0");
		String strYoutube = Utils.defaultStringIfEmptyOrNull(data.get(Constants.INDEX_USER_YOUTUBE), "");
		String strTwitter = Utils.defaultStringIfEmptyOrNull(data.get(Constants.INDEX_USER_TWITTER), "");
		String strTwitch = Utils.defaultStringIfEmptyOrNull(data.get(Constants.INDEX_USER_TWITCH), "");
		
		return new GDUserPart1(
				Long.parseLong(strPlayerID),
				Integer.parseInt(strSecretCoins),
				Integer.parseInt(strUserCoins),
				Integer.parseInt(strColor1),
				Integer.parseInt(strColor2),
				Long.parseLong(strAccountID),
				Integer.parseInt(strStars),
				Integer.parseInt(strCreatorPoints),
				Integer.parseInt(strDemons),
				Integer.parseInt(strDiamonds),
				Integer.parseInt(strGlobalRank),
				Integer.parseInt(strCube),
				Integer.parseInt(strShip),
				Integer.parseInt(strUfo),
				Integer.parseInt(strBall),
				Integer.parseInt(strWave),
				Integer.parseInt(strRobot),
				Integer.parseInt(strSpider),
				Integer.parseInt(strTrail),
				Integer.parseInt(strDeathEffect),
				strYoutube,
				strTwitter,
				strTwitch,
				Role.values()[Integer.parseInt(strRole)]);
	}
	
	@Override
	public boolean equals(Object obj) {
		return obj instanceof GDUserPart1Request && ((GDUserPart1Request) obj).targetAccountID == targetAccountID;
	}
	
	@Override
	public int hashCode() {
		return Long.hashCode(targetAccountID);
	}
}