package com.example.demo.entity;

import org.slf4j.LoggerFactory;
import org.springframework.data.relational.core.mapping.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.slf4j.Logger;
/**
 * MyMessageEntity
 */

@Entity
@Table
public class MyMessageEntity {
    
final static Logger logger = LoggerFactory.getLogger(Student.class);

@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private Long mid;

@Column(keyColumn = "Message Text")
private String messageText;

@Column(keyColumn = "Receiver phone Number")
private String toPhoneNumber;

@Column(keyColumn = "Receiver's Name")
private String receiverName;

/**
 * @param mid
 * @param messageText
 * @param toPhoneNumber
 * @param receiverName
 */
public MyMessageEntity(Long mid, String messageText, String toPhoneNumber, String receiverName) {
    this.mid = mid;
    this.messageText = messageText;
    this.toPhoneNumber = toPhoneNumber;
    this.receiverName = receiverName;
}

/**
 * @return the logger
 */
public static Logger getLogger() {
    return logger;
}

/**
 * @return the mid
 */
public Long getMid() {
    return mid;
}

/**
 * @param mid the mid to set
 */
public void setMid(Long mid) {
    this.mid = mid;
}

/**
 * @return the messageText
 */
public String getMessageText() {
    return messageText;
}

/**
 * @param messageText the messageText to set
 */
public void setMessageText(String messageText) {
    this.messageText = messageText;
}

/**
 * @return the toPhoneNumber
 */
public String getToPhoneNumber() {
    return toPhoneNumber;
}

/**
 * @param toPhoneNumber the toPhoneNumber to set
 */
public void setToPhoneNumber(String toPhoneNumber) {
    this.toPhoneNumber = toPhoneNumber;
}

/**
 * @return the receiverName
 */
public String getReceiverName() {
    return receiverName;
}

/**
 * @param receiverName the receiverName to set
 */
public void setReceiverName(String receiverName) {
    this.receiverName = receiverName;
}






    
}