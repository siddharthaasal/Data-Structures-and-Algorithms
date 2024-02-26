import java.util.*;

class ActivitySelection {
    public static void main(String[] args) {
        int start[] = { 1, 3, 0, 5, 8, 5 };
        int end[] = { 2, 4, 6, 7, 9, 9 };

        // cols -> index start end
        int activities[][] = new int[start.length][3];
        for (int i = 0; i < start.length; i++) {
            activities[i][0] = i;
            activities[i][1] = start[i];
            activities[i][2] = end[i];
        }

        // sort by end time
        Arrays.sort(activities, Comparator.comparingDouble(o -> o[2]));

        int maxActivities = 0;
        ArrayList<Integer> listOfActivities = new ArrayList<>();

        maxActivities++;
        // add the index 0th activity
        listOfActivities.add(activities[0][0]);
        int lastEndingTime = activities[0][2];

        for (int i = 1; i < end.length; i++) {
            if (activities[i][1] >= lastEndingTime) {
                maxActivities++;
                listOfActivities.add(activities[i][0]);
                lastEndingTime = activities[i][2];
            }
        }

        System.out.println("Maximum activities: " + maxActivities);
        for (int i=0; i<listOfActivities.size(); i++) {
            System.out.print("Activity-" + listOfActivities.get(i) + " ");
        }
    }
}