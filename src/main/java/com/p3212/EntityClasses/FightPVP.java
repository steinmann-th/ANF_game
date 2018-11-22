package com.p3212.EntityClasses;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "pvp_fights")
public class FightPVP extends Fight {

    public FightPVP() {
        pvpId = id;
        fightDate = new Date();
    }


    @Id
    private int pvpId;

    @ManyToOne
    @JoinColumn(name = "firstFighter")
    private Character firstFighter;

    @ManyToOne
    @JoinColumn(name = "secondFighter")
    private Character secondFighter;

    @Column(name = "fight_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fightDate;

    private boolean firstWon;

    private int ratingChange = 0;

    public boolean isFirstWon() {
        return firstWon;
    }

    public void setFirstWon(boolean firstWon) {
        this.firstWon = firstWon;
    }

    public int getRatingChange() {
        return ratingChange;
    }

    public void setRatingChange(int ratingChange) {
        this.ratingChange = ratingChange;
    }

    public void setFighters(Character char1, Character char2) {
        firstFighter = char1;
        secondFighter = char2;
    }

    public int getPvpId() {
        return pvpId;
    }

    public void setPvpId(int pvpId) {
        this.pvpId = pvpId;
    }

    public Date getFightDate() {
        return fightDate;
    }

    public Character getFirstFighter() {
        return firstFighter;
    }

    public Character getSecondFighter() {
        return secondFighter;
    }
}
