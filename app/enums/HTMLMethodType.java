package enums;

public enum HTMLMethodType {
	/**
	 *requests data from a specified resource 
	 */
GET,
/**
 * submits data to be processed to a specified resource
 */
POST,
/**
 * Same as GET but returns only the http headers and no document body
 */
HEAD,
/**
 * uploads a representation of the specified URI
 */
PUT,
/**
 *deletes the specified resource 
 */
DELETE,
/**
 * RETURNS the http methods that server supports
 */
OPTIONS,
/**
 * Converts the request connections to a transparent TCP/IP tunnel
 */
CONNECT
}
