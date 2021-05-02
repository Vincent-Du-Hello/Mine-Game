package com.duwenxi.log;

import java.util.Date;

public class StaticLog {
	public static void log(Level lv, String msg) {
		System.out.println("[ " + lv.name() + " " + new Date().toString() + " ]" + msg);
	}
}
