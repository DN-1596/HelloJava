package algorithms.searching.linear_search;

// PROBLEM
// https://www.hackerearth.com/practice/algorithms/searching/linear-search/practice-problems/algorithm/attendance-72-5c241efb/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Attendance {

    private static class TimeRange {
        final int startTime;
        final int endTime;

        public TimeRange(String startTime, String endTime) {
            this.startTime = getTimeInSeconds(startTime);
            this.endTime = getTimeInSeconds(endTime);
        }


        private static int getTimeInSeconds(String timeString) {
            List<Integer> time = Arrays.stream(timeString.split(":"))
                    .map(data -> Integer.parseInt(data))
                    .toList();

            return time.get(0)*3600 + time.get(1)*60 + time.get(2);
        }

    }

    public static void main(String args []) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Integer n = Integer.parseInt(bf.readLine());

        List<String> classTimings = Arrays.stream(bf.readLine().split(" ")).toList();
        TimeRange classTimeRange = new TimeRange(classTimings.get(0),classTimings.get(1));
        Map<Integer,List<TimeRange>> attendanceData  = new HashMap<>();

        while (n>0) {
            List<TimeRange> studentAttendanceRange = new ArrayList<>();
            List<String> studentData = Arrays.stream(bf.readLine().split(" ")).toList();
            Integer sId = Integer.parseInt(studentData.get(0));
            Integer noOfVisits = Integer.parseInt(studentData.get(1));
            for (int i=1;i<=noOfVisits;i++) {
                TimeRange timeRange = new TimeRange(studentData.get(i*2), studentData.get(i*2+1));
                studentAttendanceRange.add(timeRange);
            }
            attendanceData.put(sId,studentAttendanceRange);
            n--;
        }

        calculateAttendanceProbabilityOfStudent(1,classTimeRange,attendanceData);

    }

    public static void calculateAttendanceProbabilityOfStudent(
            int sId,
            TimeRange classTimeRange,
            Map<Integer,List<TimeRange>> attendanceData ) {

        int[] eventInfo = new int[classTimeRange.endTime+1];


        attendanceData.forEach((_sId,value) -> {
            for (TimeRange timeRange : value) {
                for (int i=timeRange.startTime;i< timeRange.endTime;i++) {
                    eventInfo[i]++;
                }
            }
        });

        int minStudents = attendanceData.size()+1;
        for (int i=classTimeRange.startTime;i<classTimeRange.endTime;i++) {
            int studentCount = eventInfo[i];
            if (minStudents > studentCount) {
                minStudents = studentCount;
            }
        }

        int attendanceSeconds = 0;
        for (int i=classTimeRange.startTime;i<classTimeRange.endTime;i++) {
            int studentCount = eventInfo[i];
            if (minStudents == studentCount) {
                attendanceSeconds++;
            }
        }

        int secondsInClass = 0;
        for (TimeRange inClassRange : attendanceData.get(sId)) {
            for (int i=inClassRange.startTime;i<inClassRange.endTime;i++) {
                int studentCount = eventInfo[i];
                if (minStudents == studentCount) {
                    secondsInClass++;
                }
            }
        }



        if (secondsInClass == 0) {
            System.out.println(secondsInClass);
        } else {
            int gcd = getGCD(secondsInClass,attendanceSeconds);
            System.out.println((secondsInClass/gcd)+"/"+(attendanceSeconds/gcd));
        }



    }

    private  static  int getGCD(int x,int y) {
        int gcd = 1;
        for(int i = 1; i <= x && i <= y; i++)
        {
            if(x%i==0 && y%i==0)
                gcd = i;
        }
        return  gcd;
    }




}
