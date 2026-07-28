class Solution {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        if(start>destination){
            int temp = start;
            start = destination;
            destination = temp;
        }
        int totalDistance = 0;
        int currentDistance = 0;
        for(int i=0;i<distance.length;i++){
            totalDistance +=distance[i];
            if(i>=start && i<destination){
                currentDistance += distance[i];
            }
        }
        int otherDistance = totalDistance - currentDistance;
        return Math.min(currentDistance, otherDistance);
    }
}