package com.example.aanchel.pioneerhacksii;

import java.util.ArrayList;

public class PioneerHacksDos {
	public static ArrayList<Incident> types = new ArrayList<Incident>();
	public static ArrayList<Incident> robbery = new ArrayList<Incident>();
	public static ArrayList<Incident> assault_battery = new ArrayList<Incident>();
	public static ArrayList<Incident> kidnapping = new ArrayList<Incident>();
	public static ArrayList<Incident> homicide = new ArrayList<Incident>();
	public static void main(String[] argz) {
		Incident a = new Incident(5, "Prius broken into", "robbery", "Cupertino, California");
		types.add(a);
		Incident b = new Incident(10, "Apartment broken into", "robbery", "Sunnyvale, California");
		types.add(b);
		Incident c = new Incident(15,"TV stolen", "robbery", "Fremont California");
		types.add(c);
		Incident d = new Incident(20, "Locked bike stolen", "robbery", "San Jose, California");
		types.add(d);
		Incident e = new Incident(35, "Apple Watch stolen", "robbery", "San Francisco, California");
		types.add(e);
		Incident f = new Incident(5, "Man punched in bar", "assault_battery", "Cupertino, California");
		types.add(f);
		Incident g = new Incident(10, "Man attacked with baseball bat", "assault_battery", "Sunnyvale, California");
		types.add(g);
		Incident h = new Incident(15,"Woman hit sister during family reunion", "assault_battery", "Fremont California");
		types.add(h);
		Incident i2 = new Incident(20, "Local man hit with shovel during bar fight", "assault_battery", "San Jose, California");
		types.add(i2);
		Incident j = new Incident(35, "Local Student attacks classmate with textbook", "assault_battery", "San Francisco, California");
		types.add(j);
		Incident k = new Incident(5, "Child abducted", "kidnapping", "Cupertino, California");
		types.add(k);
		Incident l = new Incident(10, "Child stolen from rightful parent in divorce case", "kidnapping", "Sunnyvale, California");
		types.add(l);
		Incident m = new Incident(15,"5 year old child gone missing", "kidnapping", "Fremont California");
		types.add(m);
		Incident n = new Incident(20, "10 year old boy missing for 2 days", "kidnapping", "San Jose, California");
		types.add(n);
		Incident o = new Incident(35, "Small girl kidnapped at park", "kidnapping", "San Francisco, California");
		types.add(o);
		Incident p = new Incident(5, "Man shot and killed", "homicide", "Cupertino, California");
		types.add(p);
		Incident q = new Incident(10, "Woman murdered in her apartment", "homicide", "Sunnyvale, California");
		types.add(q);
		Incident r = new Incident(15, "Man stabbed and murdered", "homicide", "Fremont California");
		types.add(r);
		Incident s = new Incident(20, "Woman stabbed by ex-boyfriend", "homicide", "San Jose, California");
		types.add(s);
		Incident t = new Incident(35, "Child found dead", "homicide", "San Francisco, California");
		types.add(t);
		
		sortIntoTypes(types);
		sortHeap(robbery);
		System.out.println("Robberies near you: \n");
		for (int i = 0; i < robbery.size(); i++) {
			System.out.print("\t" + robbery.get(i).toString());
		}
		System.out.println("Assaults/Battery Incidents near you: \n");
		for (int i = 0; i < assault_battery.size(); i++) {
			System.out.print("\t" + assault_battery.get(i).toString());
		}
		System.out.println("Kidnapping Incidents near you: \n");
		for (int i = 0; i < kidnapping.size(); i++) {
			System.out.print("\t" + kidnapping.get(i).toString());
		}
		System.out.println("Homicide Incidents near you: \n");
		for (int i = 0; i < homicide.size(); i++) {
			System.out.print("\t" + homicide.get(i).toString());
		}
	}
	public static void sortIntoTypes(ArrayList<Incident> types) {
		for (int i = 0; i < types.size(); i++) {
			if (types.get(i).getType().equals("robbery")) {
				robbery.add(types.get(i));
			}
			if (types.get(i).getType().equals("assault_battery")) {
				assault_battery.add(types.get(i));
			}
			if (types.get(i).getType().equals("kidnapping")) {
				kidnapping.add(types.get(i));
			}
			if (types.get(i).getType().equals("homicide")) {
				homicide.add(types.get(i));
			}
		}
	}
	

	public static void sortHeap(ArrayList<Incident> arr) {
		for (int i = arr.size() - 1; i >= 0; i--) {
			buildMaxHeap(arr, 0, i);
			swap(arr, 0, i);
		}
	}

	private static void buildMaxHeap(ArrayList<Incident> arr, int startIndex, int endIndex) {
		boolean isMaxHeap = false;
		while (!isMaxHeap) {
			isMaxHeap = true;
			int startRow = (int)(Math.log(endIndex+1)/Math.log(2));
			for (int i = startRow; i > 0; i--) {
				int rowStartIndex = (int)((Math.pow(2,  i - 1)) - 1);
				int rowEndIndex = (int)((Math.pow(2, i))-2);
				for (int j = rowStartIndex; j <= rowEndIndex; j++) {
					int biggest = j;
					int leftChildNodeIndex = 2*j + 1;
					int rightChildNodeIndex = 2*j + 2;
					if ((leftChildNodeIndex <= endIndex) && (arr.get(biggest).compareTo(arr.get(leftChildNodeIndex)) < 0)) {
						biggest = leftChildNodeIndex;
					}
					if ((rightChildNodeIndex <= endIndex) && (arr.get(biggest).compareTo(arr.get(rightChildNodeIndex)) < 0 ) ) {
						biggest = rightChildNodeIndex;
					}
					if (biggest != j) {
						swap(arr, j, biggest);
						isMaxHeap = false;
					}
				}
			}
		}
	}
	public static void swap(ArrayList <Incident> arr, int a, int b){
		  Incident temp = arr.get(a);
		  arr.set(a, arr.get(b));
		  arr.set(b, temp);
	  }
}