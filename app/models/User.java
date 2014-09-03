package models;

import models.Member;

import org.bson.types.ObjectId;

public class User {
	
	private ObjectId id;
	private String user;
	private byte[] password;
	private Member member;
	

	public ObjectId getId() {
		return id;
	}
	public void setId(ObjectId id) {
		this.id = id;
	}
	public Member getMember() {
		return member;
	}
	public void setMember(Member _member) {
		this.member = _member;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String _user) {
		this.user = _user;
	}
	public byte[] getPassword() {
		return password;
	}
	public void setPassword(byte[] _password) {
		this.password = _password;
	}
	
	

}
