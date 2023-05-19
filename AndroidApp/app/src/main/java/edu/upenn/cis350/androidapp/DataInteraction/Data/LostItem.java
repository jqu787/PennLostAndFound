package edu.upenn.cis350.androidapp.DataInteraction.Data;

import java.util.Date;

public class LostItem extends Item {

    String description;
    String additionalInfo;
    String attachmentLoc;

    public LostItem(long id, long posterId, String category, Date date, double latitude, double longitude,
                    String around, String attachmentLoc, String description, String additionalInfo) {
        super(id, posterId, category, date, latitude, longitude, around);
        this.attachmentLoc = attachmentLoc;
        this.description = description;
        this.additionalInfo = additionalInfo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    public String getAttachmentLoc() {
        return attachmentLoc;
    }

    public void setAttachmentLoc(String attachmentLoc) {
        this.attachmentLoc = attachmentLoc;
    }

    public String toString() {
        String s = "id " + id + ", posterId " + posterId + ", category " + category + ", date " + date.toString() +
                ", latitude " + latitude + ", longitude " + longitude + ", around " +
                around + ", attachmentLoc " + attachmentLoc + ", description " + description +
                ", additionalInfo " + additionalInfo;
        return s;
    }

}

