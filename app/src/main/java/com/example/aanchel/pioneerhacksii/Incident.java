package com.example.aanchel.pioneerhacksii;

public class Incident implements Comparable{
	public long distance;
	public String description;
	public String type;
	public String location;
	public Incident(long distance, String description, String type, String location) {
		this.distance = distance;
		this.description = description;
		this.type = type;
		this.location = location;
	}
	public long getDistance() {
		return distance;
	}
	@Override
	public int compareTo(Object other) {
		if (this.getDistance() == ((Incident)(other)).getDistance()) {
			return 0;
		}
		if (this.getDistance() > ((Incident)(other)).getDistance()) {
			return 1;
		}
		return -1;
		
	}
	public String getType() {
		return type;
	}
	public String toString() {
		return description + " in " + location + ", " + distance + " miles away.\n\r";
	}
	
}
