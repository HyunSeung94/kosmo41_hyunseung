package test.jitendra.android.androidchat.addcontact;

import test.jitendra.android.androidchat.addcontact.events.AddContactEvent;


public interface AddContactPresenter {
    void onShow();
    void onDestroy();

    void addContact(String email);
    void onEventMainThread(AddContactEvent event);
}

