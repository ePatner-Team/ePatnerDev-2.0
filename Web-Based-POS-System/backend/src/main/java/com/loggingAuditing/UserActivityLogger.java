package com.loggingAuditing;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

// User activity record class to hold individual user activity entries
class UserActivityRecord {
    private String username;
    private String activity;
    private LocalDateTime timestamp;

    public UserActivityRecord(String username, String activity) {
        this.username = username;
        this.activity = activity;
        this.timestamp = LocalDateTime.now();
    }

    public String getUsername() {
        return username;
    }

    public String getActivity() {
        return activity;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return "User ActivityRecord{" +
                "username='" + username + '\'' +
                ", activity='" + activity + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}

// User Activity Logger class to manage user activity records
public class UserActivityLogger {
    // Instance variable to hold a list of user activity records
    private List<UserActivityRecord> userActivityRecords; // List to store all logged user activities

    // Constructor to initialize the UserActivityLogger
    public UserActivityLogger() {
        this.userActivityRecords = new ArrayList<>(); // Instantiate the list for storing activity records
    }

    // Method to log a user activity
    public void logActivity(String username, String activity) {
        // Create a new UserActivityRecord with the provided username and activity
        UserActivityRecord record = new UserActivityRecord(username, activity);
        userActivityRecords.add(record); // Add the new record to the list of user activity records
        System.out.println("Logged activity: " + record); // Print a message indicating the activity has been logged
    }

    // Method to retrieve all user activity records
    public List<UserActivityRecord> getUserActivityRecords() {
        return new ArrayList<>(userActivityRecords); // Return a new list containing all user activity records
    }

    // Method to clear user activity records (if needed)
    public void clearUserActivityRecords() {
        userActivityRecords.clear(); // Clear all records from the list
        System.out.println("User  activity records cleared."); // Print a message indicating records have been cleared
    }
}