package com.example.random_project;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class AttendanceManager {
    // ********    ----- password generator --------- ***********
    private String currentKey;
    private static AttendanceManager instance;
    private Map<String, Boolean> attendanceMap;

    public AttendanceManager() {
        attendanceMap = new HashMap<>();
    }

    public static synchronized AttendanceManager getInstance() {
        if (instance == null) {
            instance = new AttendanceManager();
        }
        return instance;
    }

    public void generateAndSetKey() {
        currentKey = UUID.randomUUID().toString().substring(0, 8); // Generates a random 8-character string
    }

    public String getCurrentKey() {
        return currentKey;
    }

    public boolean checkKeyAndMarkAttendance(String studentName, String inputKey) {
        boolean isPresent = inputKey.equals(currentKey);
        attendanceMap.put(studentName, isPresent);
        return isPresent;
    }

    public boolean isPresent(String studentName) {
        return attendanceMap.getOrDefault(studentName, false);
    }

    public Iterable<String> getStudents() {
        return attendanceMap.keySet();
    }
}
