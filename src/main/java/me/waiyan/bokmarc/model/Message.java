package me.waiyan.bokmarc.model;

//this class to convert to JSON Object
// which is to inform client a message
public class Message {
	private String msgBody;
	
	public Message(){}
	
	public Message(String msgBody){
		this.msgBody=msgBody;
	}

	public String getMsgBody() {
		return msgBody;
	}

	public void setMsgBody(String msgBody) {
		this.msgBody = msgBody;
	}	
}
