package org.spring.Log;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import org.spring.User.User;

import java.io.Serializable;
import java.util.Date;
@Entity
public class Log{
    @Column(name = "logid")
    String logid;
    @Column(name = "logtype")
    String logtype;
    @Column(name = "logdescription")
    String logdescription;
    @Column(name = "userid")
    String userid;
    @Column(name = "createdat")
    Date createdat;
    @OneToMany
    @Column(name="user")
    User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getLogid() {
        return logid;
    }

    public void setLogid(String logid) {
        this.logid = logid;
    }

    public String getLogtype() {
        return logtype;
    }

    public void setLogtype(String logtype) {
        this.logtype = logtype;
    }

    public String getLogdescription() {
        return logdescription;
    }

    public void setLogdescription(String logdescription) {
        this.logdescription = logdescription;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public Date getCreatedat() {
        return createdat;
    }

    public void setCreatedat(Date createdat) {
        this.createdat = createdat;
    }
}
