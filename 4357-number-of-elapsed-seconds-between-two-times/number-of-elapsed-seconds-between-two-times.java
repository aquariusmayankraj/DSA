class Solution {
    public int secondsBetweenTimes(String startTime, String endTime) {
        return sec(endTime) - sec(startTime);
    }

    public int sec(String t) {
        return Integer.parseInt(t.substring(0, 2)) * 3600
             + Integer.parseInt(t.substring(3, 5)) * 60
             + Integer.parseInt(t.substring(6, 8));
    }
}