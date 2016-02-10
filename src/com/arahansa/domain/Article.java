package com.arahansa.domain;

public class Article {
	
	private String aLink;
	private String press;
	private String time;
	private String desc;
	
	public Article() {
	
	}

	public String getaLink() {
		return aLink;
	}

	public void setaLink(String aLink) {
		this.aLink = aLink;
	}

	public String getPress() {
		return press;
	}

	public void setPress(String press) {
		this.press = press;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Override
	public String toString() {
		return "Article [\naLink=" + aLink + "\n, press=" + press + "\n, time=" + time + "\n, desc=" + desc + "]";
	}
	

	
	
}
