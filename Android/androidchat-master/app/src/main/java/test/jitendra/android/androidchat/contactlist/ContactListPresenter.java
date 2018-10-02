package test.jitendra.android.androidchat.contactlist;

import test.jitendra.android.androidchat.contactlist.events.ContactListEvent;


public interface ContactListPresenter {
    void onPause();
    void onResume();
    void onCreate();
    void onDestroy();

    void signOff();
    String getCurrentUserEmail();
    void removeContact(String email);
    void onEventMainThread(ContactListEvent event);
}
