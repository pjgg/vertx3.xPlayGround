package org.pablo.dto;

public class PingPongDto {
	
	private String ping;
	
	private String pong;
	
	public PingPongDto(){
		this.ping = "";
		this.pong = "";
	}
	
	public PingPongDto(String ping, String pong){
		this.ping = ping;
		this.pong = pong;
	}

	public String getPing() {
		return ping;
	}

	public String getPong() {
		return pong;
	}

	public void setPing(String ping) {
		this.ping = ping;
	}

	public void setPong(String pong) {
		this.pong = pong;
	}
	
}
