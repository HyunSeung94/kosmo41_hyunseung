package test.jitendra.android.androidchat.contactlist.ui;

import test.jitendra.android.androidchat.contactlist.entities.User;


public interface OnItemClickListener {
    void onItemClick(User user);
    void onItemLongClick(User user);
}
