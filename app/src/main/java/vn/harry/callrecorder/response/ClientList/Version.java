package vn.harry.callrecorder.response.ClientList;

import com.google.gson.annotations.SerializedName;

public class Version {

    @SerializedName("_Build")
    private int build;

    @SerializedName("_Minor")
    private int minor;

    @SerializedName("_Major")
    private int major;

    @SerializedName("_Revision")
    private int revision;

    public void setBuild(int build) {
        this.build = build;
    }

    public int getBuild() {
        return build;
    }

    public void setMinor(int minor) {
        this.minor = minor;
    }

    public int getMinor() {
        return minor;
    }

    public void setMajor(int major) {
        this.major = major;
    }

    public int getMajor() {
        return major;
    }

    public void setRevision(int revision) {
        this.revision = revision;
    }

    public int getRevision() {
        return revision;
    }

    @Override
    public String toString() {
        return
                "Version{" +
                        "_Build = '" + build + '\'' +
                        ",_Minor = '" + minor + '\'' +
                        ",_Major = '" + major + '\'' +
                        ",_Revision = '" + revision + '\'' +
                        "}";
    }
}