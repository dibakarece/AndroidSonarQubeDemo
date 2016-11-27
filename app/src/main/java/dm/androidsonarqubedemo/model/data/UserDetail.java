package dm.androidsonarqubedemo.model.data;


import android.content.ContentValues;
import android.os.Parcel;
import android.os.Parcelable;

import dm.androidsonarqubedemo.model.dbhelper.DBConstant;

public class UserDetail implements Parcelable {
    private int id = -1;
    private String fname = "";
    private String lname = "";
    private String email = "";
    private String phone = "";
    private String password = "";

    public UserDetail() {
    }

    public UserDetail(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public UserDetail(int id, String fname, String lname, String email, String phone, String password) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.phone = phone;
        this.password = password;
    }

    protected UserDetail(Parcel in) {
        id = in.readInt();
        fname = in.readString();
        lname = in.readString();
        email = in.readString();
        phone = in.readString();
        password = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(fname);
        dest.writeString(lname);
        dest.writeString(email);
        dest.writeString(phone);
        dest.writeString(password);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<UserDetail> CREATOR = new Creator<UserDetail>() {
        @Override
        public UserDetail createFromParcel(Parcel in) {
            return new UserDetail(in);
        }

        @Override
        public UserDetail[] newArray(int size) {
            return new UserDetail[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public ContentValues getContentValue() {
        ContentValues values = new ContentValues();
        values.put(DBConstant.USER_FIELD_FNAME, fname);
        values.put(DBConstant.USER_FIELD_LNAME, lname);
        values.put(DBConstant.USER_FIELD_EMAIL, email);
        values.put(DBConstant.USER_FIELD_PHONE, phone);
        values.put(DBConstant.USER_FIELD_PASSWORD, password);
        return values;
    }
}
