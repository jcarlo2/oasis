package com.oasys.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Announcement {
    private String id;
    private String name;
    private String title;
    private String detail;
}
