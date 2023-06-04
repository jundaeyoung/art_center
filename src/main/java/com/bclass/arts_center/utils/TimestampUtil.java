package com.bclass.arts_center.utils;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class TimestampUtil {

	private static SimpleDateFormat sdf;

	public static String timestampByDate(Timestamp timestamp) {
		sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(timestamp);
	}

}
