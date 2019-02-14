package com.jk.bean;

import lombok.Data;

@Data
public class MimeMessageHelper {

    private String from;
    private String to;
    private String subject;
    private String content;
    private String text;
}
