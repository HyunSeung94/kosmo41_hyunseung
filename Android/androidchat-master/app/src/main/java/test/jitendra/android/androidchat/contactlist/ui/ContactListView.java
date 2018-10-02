package test.jitendra.android.androidchat.contactlist.ui;

import test.jitendra.android.androidchat.contactlist.entities.User;


public interface ContactListView {
    void onContactAdded(User user);
    void onContactChanged(User user);
    void onContactRemoved(User user);
}
