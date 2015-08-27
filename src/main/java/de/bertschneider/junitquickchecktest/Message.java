package de.bertschneider.junitquickchecktest;

import java.util.List;

public class Message {
	
	private String id;
	private String code;
	private List<Data> data;
	
	public Message(String id, String code, List<Data> data) {
		this.id = id;
		this.code = code;
		this.data = data;
	}

	public String getId() {
		return id;
	}

	public String getCode() {
		return code;
	}

	public List<Data> getData() {
		return data;
	}

	@Override
	public String toString() {
		return "Message [id=" + id + ", code=" + code + ", data=" + data
				+ "]";
	}
	
}
