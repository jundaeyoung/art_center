package com.bclass.arts_center.utils;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class TimestampUtil {

	private static SimpleDateFormat sdf;

	public static String timestampByDate(Timestamp timestamp) {
		sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(timestamp);
	}

//	public static String timestampToString(Timestamp timestamp) {
//
//		sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
//
//		return sdf.format(timestamp);
//	}
//
//	public static String datestampToString(Timestamp timestamp) {
//
//		if (timestamp.getMonth() > 9) {
//			if (timestamp.getDay() > 9) {
//				sdf = new SimpleDateFormat("yyyy년 MM월 dd일");
//			} else {
//				sdf = new SimpleDateFormat("yyyy년 MM월 d일");
//			}
//		} else {
//			if (timestamp.getDay() > 9) {
//				sdf = new SimpleDateFormat("yyyy년 M월 dd일");
//			} else {
//				sdf = new SimpleDateFormat("yyyy년 M월 d일");
//			}
//		}
//
//		return sdf.format(timestamp);
//	}
//
//	public static String birthdateToString(Date date) {
//
//		if (date.getMonth() > 9) {
//			if (date.getDay() > 9) {
//				sdf = new SimpleDateFormat("yyyy년 MM월 dd일");
//			} else {
//				sdf = new SimpleDateFormat("yyyy년 MM월 d일");
//			}
//		} else {
//			if (date.getDay() > 9) {
//				sdf = new SimpleDateFormat("yyyy년 M월 dd일");
//			} else {
//				sdf = new SimpleDateFormat("yyyy년 M월 d일");
//			}
//		}
//		return sdf.format(date);
//	}

}
