package main.shot;

import main.TWInfo;

public class Effect {
	public static double linear(
			TWInfo tInfo, long duration, double start, double end)
	{
		long t = tInfo.currentTime_withoutMenu % duration;
		double td = (double)t / (double)duration;
		return (end - start)*td + start;
	}
}
