package com.wideplay.crosstalk.data;

import com.googlecode.objectify.Key;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.Date;

/**
 * A single message on a room board.
 *
 * @author dhanji@gmail.com (Dhanji R. Prasanna)
 */
@Entity
public class Message {
  @Id
  private Long id;

  @JsonHide
  private Key<User> authorKey;
  @JsonHide
  private Key<Room> roomKey; // belongs to.

  private Date postedOn;
  private String text;
  private boolean isTweet;

  private Long attachmentId;

  @Transient
  private User author;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Key<User> getAuthorKey() {
    return authorKey;
  }

  public Key<Room> getRoomKey() {
    return roomKey;
  }

  public User getAuthor() {
    return author;
  }

  public Long getAttachmentId() {
    return attachmentId;
  }

  public void setAttachment(Long attachmentId) {
    this.attachmentId = attachmentId;
  }

  public void setAuthor(User author) {
    this.author = author;
    this.authorKey = new Key<User>(User.class, author.getUsername());
  }

  public void setRoom(Room room) {
    this.roomKey = new Key<Room>(Room.class, room.getId());
  }

  public Date getPostedOn() {
    return postedOn;
  }

  public void setPostedOn(Date postedOn) {
    this.postedOn = postedOn;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public boolean isTweet() {
    return isTweet;
  }

  public void setTweet(boolean tweet) {
    isTweet = tweet;
  }

  @Override
  public String toString() {
    return "Message{" +
        "id=" + id +
        ", author=" + authorKey +
        ", room=" + roomKey +
        ", postedOn=" + postedOn +
        ", text='" + text + '\'' +
        '}';
  }
}
