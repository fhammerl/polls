package com.fhammerl.polls.models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name = "poll")
public class Poll {
    @Id
    @Column(name = "id")
    private String id;
    @Column(name = "latest_change")
    private Date latestChange;
    private Date initiated;
    private boolean hidden;
    private String preferencesType;
    private String state;
    private String title;

    @OneToMany(mappedBy = "poll", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Participant> participants;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getLatestChange() {
        return this.latestChange;
    }

    public void setLatestChange(Date latestChange) {
        this.latestChange = latestChange;
    }

    public Date getInitiated() {
        return this.initiated;
    }

    public void setInitiated(Date initiated) {
        this.initiated = initiated;
    }

    public boolean getHidden() {
        return this.hidden;
    }

    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }

    public String getPreferencesType() {
        return this.preferencesType;
    }

    public void setPreferencesType(String preferencesType) {
        this.preferencesType = preferencesType;
    }

    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Participant> getParticipants() {
        return this.participants;
    }

    public void setParticipants(List<Participant> participant) {
        this.participants = participant;
    }

}