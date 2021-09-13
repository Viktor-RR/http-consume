package com.viktor.dto;

import lombok.Value;

import java.util.Set;

@Value
public class CourseRequestDto {
  long id;
  String name;
  Set<String> tags;
}
