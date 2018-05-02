package com.dao;

import java.util.List;

import com.model.Notification;

public interface NotificationDao {
public List<Notification>getNotificationsNotViewed(String email);

public Notification getNotification(int id);

public void updateNotification(int id);
}
