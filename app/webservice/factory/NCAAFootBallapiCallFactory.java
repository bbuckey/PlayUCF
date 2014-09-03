package webservice.factory;

import webservice.factory.BaseAPICallFactory;
import webservice.factory.BaseAPICallFactory.CallType;

public class NCAAFootBallapiCallFactory extends BaseAPICallFactory{
	
	  
/*	Weekly Schedule
 *  http(s)://api.sportsdatallc.org/ncaafb-[access_level][version]/[year]/[ncaafb_season]/[ncaafb_season_week]/schedule.[format]?api_key=[your_api_key]
 * 	Weekly Schedule Schema
 * 	http(s)://api.sportsdatallc.org/ncaafb-[access_level][version]/schema/schedule-v1.0.xsd?api_key=[your_api_key] 
 *	
 *	Season Schedule
 *	http(s)://api.sportsdatallc.org/ncaafb-[access_level][version]/[year]/[ncaafb_season]/schedule.[format]?api_key=[your_api_key]
 *	Season Schedule Schema
 *	http(s)://api.sportsdatallc.org/ncaafb-[access_level][version]/schema/schedule-v1.0.xsd?api_key=[your_api_key]
 *
 *	Game Statistics
 *  http(s)://api.sportsdatallc.org/ncaafb-[access_level][version]/[year]/[ncaafb_season]/[ncaafb_season_week]/[away_team]/[home_team]/statistics.[format]?api_key=[your_api_key]
 *	Game Statistics Schema
 *	http(s)://api.sportsdatallc.org/ncaafb-[access_level][version]/schema/statistics-v1.0.xsd?api_key=[your_api_key]
 *
 *	Play-By-Play
 *  http(s)://api.sportsdatallc.org/ncaafb-[access_level][version]/[year]/[ncaafb_season]/[ncaafb_season_week]/[away_team]/[home_team]/pbp.[format]?api_key=[your_api_key]
 *	Play-By-Play Schema
 *  http(s)://api.sportsdatallc.org/ncaafb-[access_level][version]/schema/pbp-v1.0.xsd?api_key=[your_api_key]
 *
 *	Play Summary
 *	http(s)://api.sportsdatallc.org/ncaafb-[access_level][version]/[year]/[ncaafb_season]/[ncaafb_season_week]/[away_team]/[home_team]/plays/[play_id].[format]?api_key=[your_api_key]
 *  Play Summary Schema
 *  http(s)://api.sportsdatallc.org/ncaafb-[access_level][version]/schema/extended-play-v1.0.xsd?api_key=[your_api_key]
 *
 *	Game Summary
 *	http(s)://api.sportsdatallc.org/ncaafb-[access_level][version]/[year]/[ncaafb_season]/[ncaafb_season_week]/[away_team]/[home_team]/summary.[format]?api_key=[your_api_key]
 *	Game Summary Schema
 *  http(s)://api.sportsdatallc.org/ncaafb-[access_level][version]/schema/summary-v1.0.xsd?api_key=[your_api_key]	 
 *	
 *	Boxscore
 *  http(s)://api.sportsdatallc.org/ncaafb-[access_level][version]/[year]/[ncaafb_season]/[ncaafb_season_week]/[away_team]/[home_team]/boxscore.[format]?api_key=[your_api_key]
 *  Boxscore Schema 
 *	http(s)://api.sportsdatallc.org/ncaafb-[access_level][version]/schema/boxscore-v1.0.xsd?api_key=[your_api_key]
 *
 *	Extended Boxscore	
 *	http(s)://api.sportsdatallc.org/ncaafb-[access_level][version]/[year]/[ncaafb_season]/[ncaafb_season_week]/[away_team]/[home_team]/extended-boxscore.[format]?api_key=[your_api_key]
 *	Extended Boxscore Schema 
 *	http(s)://api.sportsdatallc.org/ncaafb-[access_level][version]/schema/extended-boxscore-v1.0.xsd?api_key=[your_api_key]
 *
 *	Rankings
 *  http(s)://api.sportsdatallc.org/ncaafb-[access_level][version]/schema/rankings-v1.0.xsd?api_key=[your_api_key]
 * 	Rankings Schema
 *  http(s)://api.sportsdatallc.org/ncaafb-[access_level][version]/polls/[poll_name]/[year]/[ncaafb_season_week]/rankings.[format]?api_key=[your_api_key]
 * 
 * 	Game Roster
 *  http(s)://api.sportsdatallc.org/ncaafb-[access_level][version]/[year]/[ncaafb_season]/[ncaafb_season_week]/[away_team]/[home_team]/roster.[format]?api_key=[your_api_key]
 *  Game Roster Schema
 *  http(s)://api.sportsdatallc.org/ncaafb-[access_level][version]/schema/roster-v1.0.xsd?api_key=[your_api_key]
 * 
 * 	Team Hierarchy
 *  http(s)://api.sportsdatallc.org/ncaafb-[access_level][version]/teams/[division]/hierarchy.[format]?api_key=[your_api_key]
 * 	Team Hierarchy Schema
 * 	http(s)://api.sportsdatallc.org/ncaafb-[access_level][version]/schema/hierarchy-v1.0.xsd?api_key=[your_api_key]
 * 
 * 	Team Roster
 * 	http(s)://api.sportsdatallc.org/ncaafb-[access_level][version]/teams/[team]/roster.[format]?api_key=[your_api_key]
 * 	Team Roster Schema
 * 	http(s)://api.sportsdatallc.org/ncaafb-[access_level][version]/schema/roster-v1.0.xsd?api_key=[your_api_key]
 * 
 * 	Standings
 *  http(s)://api.sportsdatallc.org/ncaafb-[access_level][version]/teams/[division]/[year]/[ncaafb_season]/standings.[format]?api_key=[your_api_key]
 * 	Standings Schema
 * 	http(s)://api.sportsdatallc.org/ncaafb-[access_level][version]/schema/standings-v1.0.xsd?api_key=[your_api_key]
 * 
 * 	Seasonal Statistics
 *  http(s)://api.sportsdatallc.org/ncaafb-[access_level][version]/teams/[team]/[year]/[ncaafb_season]/statistics.[format]?api_key=[your_api_key]
 * 	Seasonal Statistics Schema
 * 	http(s)://api.sportsdatallc.org/ncaafb-[access_level][version]/schema/statistics-v1.0.xsd?api_key=[your_api_key]
 * 
 * 	Weekly Division Leaders
 *  http(s)://api.sportsdatallc.org/ncaafb-[access_level][version]/[year]/[ncaafb_season]/[ncaafb_season_week]/[division]/leaders.[format]?api_key=[your_api_key]
 * 	Weekly Division Leaders Schema
 * 	http(s)://api.sportsdatallc.org/ncaafb-[access_level][version]/schema/statistics-v1.0.xsd?api_key=[your_api_key]
 *
 *	[year] = yyyy
 *	[ncaafb_season] = Preseason (PRE), Regular Season (REG), Postseason (PST) - Note: PST used for seasons 2012 and prior
 *	[ncaafb_season_week] = whole number (sequential, starting with the number 1)
 *	[home_team], [away_team] = <see schedule feed>
 *	[team] = see schedule feed
 *  [division] = FBS, FCS, D2, D3,  NAIA or USCAA
 *
 */
	private final String version = "1";
	private final String apiwspath = "ncaafb";
	
	String getVersion() {
		return version;
	}
	
	private String division;
	void setDivision(String _devision){
		this.division = _devision;
	}
	
	String getDivision() {
		return division;
	}
	
	private String year;
	void setYear(String _year){
		this.year=_year;
	}
	
	String getYear() {
		return year;
	}
	
	private String format;
	void setFormat(String _format){
		this.format = _format;
	}
	
	String getFormat() {
		return format;
	}
	
	private String homeTeam;
	
	void setHomeTeam(String _homeTeam){
		this.homeTeam = _homeTeam;
	}
	
	
	String getHomeTeam() {
		return homeTeam;
	}
	
	private String awayTeam;
	
	void setAwayTeam(String _awayTeam){
		this.awayTeam = _awayTeam;
	}
	
	String getAwayTeam() {
		// TODO Auto-generated method stub
		return awayTeam;
	}
	
	private String seasonWeek;
	
	void setSeasonWeek(String _seasonWeek){
		this.seasonWeek = _seasonWeek;
	}
	
	String getSeasonWeek() {
		// TODO Auto-generated method stub
		return seasonWeek;
	}
	@Override
	String getAPICall(CallType callType) throws APICallExecption {
		String apiString ="";
		
		apiString = String.format("%s/%s-%s-%s/",getDomain(),apiwspath,getAccessLevel(),getVersion());

		switch(callType){
		case BOXSCORE:
			apiString = String.format(apiString+"%s/%s/%s/%s/%s/boxscore.%s?api_key=%s",getYear(),getSeason(),getSeasonWeek(),getAwayTeam(),getHomeTeam(),getFormat(),getAPIKey());
			break;
		case EXTENDEDBOXSCORE:
			apiString = String.format(apiString+"%s/%s/%s/%s/%s/extended-boxscore.%s?api_key=%s",getYear(),getSeason(),getSeasonWeek(),getAwayTeam(),getHomeTeam(),getFormat(),getAPIKey());
		break;
		case EXTENDEDPLAY:
			apiString = String.format(apiString+"%s/%s/%s/%s/%s/%s/plays/%s.%s?api_key=%s",getYear(),getSeason(),getSeasonWeek(),getAwayTeam(),getHomeTeam(),getPlayID(),getFormat(),getAPIKey());
			
			break;
		case GAMEROSTER:
			apiString = String.format(apiString+"%s/%s/%s/%s/%s/%s/roster.%s?api_key=%s",getYear(),getSeason(),getSeasonWeek(),getAwayTeam(),getHomeTeam(),getFormat(),getAPIKey());
			
			break;
		case PBP:
			apiString = String.format(apiString+"%s/%s/%s/%s/%s/%s/pbp.%s?api_key=%s",getYear(),getSeason(),getSeasonWeek(),getAwayTeam(),getHomeTeam(),getFormat(),getAPIKey());
			
			break;
		case RANKINGS:
			apiString = String.format(apiString+"polls/%s/%s/%s/rankings.%s?api_key=%s",getPollName(),getYear(),getSeasonWeek(),getFormat(),getAPIKey());
			break;
		case SCHEDULE:
			apiString = String.format(apiString+"%s/%s/schedule.%s?api_key=%s",getYear(),getSeason(),getFormat(),getAPIKey());
			break;
		case SEASONALSTATISTICS:
			apiString = String.format(apiString+"teams/%s/%s/%s/statistics.%s?api_key=%s",getTeam(),getYear(),getSeason(),getFormat(),getAPIKey());
			break;
		case STANDINGS:
			apiString = String.format(apiString+"teams/%s/%s/%s/standings.%s?api_key=%s",getDivision(),getYear(),getSeason(),getFormat(),getAPIKey());
			
			break;
		case STATISTICS:
			apiString = String.format(apiString+"%s/%s/%s/%s/%s/statistics.%s?api_key=%s",getYear(),getSeason(),getSeasonWeek(),getAwayTeam(),getHomeTeam(),getFormat(),getAPIKey());
			
			break;
		case SUMMARY:
			apiString = String.format(apiString+"%s/%s/%s/%s/%s/summary.%s?api_key=%s",getYear(),getSeason(),getSeasonWeek(),getAwayTeam(),getHomeTeam(),getFormat(),getAPIKey());
			
			break;
		case TEAMHIERARCHY:
			apiString = String.format(apiString+"teams/%s/hierarchy.%s?api_key=%s",getDivision(),getFormat(),getAPIKey());
			
			break;
		case TEAMROSTER:
			apiString = String.format(apiString+"teams/%s/roster.%s?api_key=%s",getTeam(),getFormat(),getAPIKey());
			break;
		case WEEKLYDIVISIONLEADERS:
			apiString = String.format(apiString+"%s/%s/%s/%s/leaders.%s?api_key=%s",getYear(),getSeason(),getSeasonWeek(),getDivision(),getFormat(),getAPIKey());
			
			break;
		case WEEKSCHEDULE:
			apiString = String.format(apiString+"%s/%s/%s/schedule.%s?api_key=%s",getYear(),getSeason(),getSeasonWeek(),getFormat(),getAPIKey());
			break;
		default:
			throw new APICallExecption();
		}
		
		return apiString;
	}
	
	private String season;
	
	void setSeason(String _season){
		this.season = _season;
	}
	
	
	String getSeason() {
		return season;
	}
	
	private String playID;
	
	void setPlayID(String id){
		this.playID = id;
	}
	
	
	String getPlayID() {
		return playID;
	}
	
	private String pollName;
	
	void setPollName(String _pollName){
		this.pollName = _pollName;
	}
	
	String getPollName(){
		return pollName;
	}
	
	private String team;
	void setTeam(String _team){
		this.team = _team;
	}
	String getTeam(){
		return team;
	}
	
	@Override
	Class<?> getSchemaClass() {
		// TODO Auto-generated method stub
		return getClass();
	} 

}
