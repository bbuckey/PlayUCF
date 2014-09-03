package webservice.factory;

public abstract class BaseAPICallFactory {
	
	protected class APICallExecption extends Exception{
		
	}
	
	public enum CallType{
		SCHEDULE,
		WEEKSCHEDULE,
		STATISTICS,
		PBP,
		EXTENDEDPLAY,
		BOXSCORE,
		SUMMARY,
		EXTENDEDBOXSCORE,
		RANKINGS,
		GAMEROSTER,
		TEAMROSTER,
		TEAMHIERARCHY,
		STANDINGS,
		SEASONALSTATISTICS,
		WEEKLYDIVISIONLEADERS
	}
	

	abstract String getAPICall(CallType callType)throws APICallExecption;
	abstract Class<?> getSchemaClass();
	
	
	private final String apiKey = "ycnjhp4edzhwfam5bbcpm8kr";
	private final String accesLevel = "t";
	private final String domain = "api.sportsdatallc.org";
	/*
	 *	[version] = whole number (sequential, starting with the number 1)
	 *	[format] = xml, json
	 *  [your_api_key] = key assgined
	 *	[access_level] = Real-Time (rt), Premium (p), Standard (s), Basic (b), Trial (t)
	 */
	protected String getAccessLevel(){
		return accesLevel;
	}
	protected String getAPIKey(){
		return apiKey;
	}
	
	protected String getDomain(){
		return domain;
	}
	
}
