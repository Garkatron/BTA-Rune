package deus.rune.util;

public class Util {
	static final int TICKS_PER_SECOND = 20;

	/**
	 * The quenty of time (in s) to update player temperature
	 */

	public static int secondsToTicks(int seconds) {

		return seconds * TICKS_PER_SECOND;

	}


}
